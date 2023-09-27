package com.ruangaldo.remote.usecase

import com.ruangaldo.remote.repository.IRegisterRemoteRepository
import com.ruangaldo.remote.toRegisterEntity
import com.ruangaldo.remote.toRegisterRemoteRequest
import com.ruangaldo.shared.data.ConnectivityException
import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.shared.data.InvalidDataException
import com.ruangaldo.shared.domain.Connectivity
import com.ruangaldo.shared.domain.InvalidData
import com.ruangaldo.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterRemoteUseCase constructor(private val repository: IRegisterRemoteRepository) :
    com.ruangaldo.domain.IRegister {
    override fun post(request: com.ruangaldo.domain.RegisterRequestEntity):
        Flow<ViewResource<com.ruangaldo.domain.RegisterEntity>> = flow {
        repository.post(request.toRegisterRemoteRequest()).collect { result ->
            when (result) {
                is DataResource.Success -> {
                    val register = result.root.data
                    emit(ViewResource.Success(register.toRegisterEntity()))
                }

                is DataResource.Error -> {
                    when (result.throwable) {
                        is ConnectivityException -> {
                            emit(ViewResource.Error(throwable = Connectivity()))
                        }

                        is InvalidDataException -> {
                            emit(ViewResource.Error(throwable = InvalidData()))
                        }
                    }
                }
            }
        }
    }
}
