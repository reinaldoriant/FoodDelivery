package com.ruangaldo.fooddelivery.features.register.data.remote.usecase

import com.ruangaldo.fooddelivery.features.register.data.remote.repository.IRegisterRemoteRepository
import com.ruangaldo.fooddelivery.features.register.data.remote.toRegisterEntity
import com.ruangaldo.fooddelivery.features.register.data.remote.toRegisterRemoteRequest
import com.ruangaldo.fooddelivery.features.register.domain.IRegister
import com.ruangaldo.fooddelivery.features.register.domain.RegisterEntity
import com.ruangaldo.fooddelivery.features.register.domain.RegisterRequestEntity
import com.ruangaldo.fooddelivery.shared.data.ConnectivityException
import com.ruangaldo.fooddelivery.shared.data.DataResource
import com.ruangaldo.fooddelivery.shared.data.InvalidDataException
import com.ruangaldo.fooddelivery.shared.domain.Connectivity
import com.ruangaldo.fooddelivery.shared.domain.InvalidData
import com.ruangaldo.fooddelivery.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterRemoteUseCase constructor(private val repository: IRegisterRemoteRepository) :
    IRegister {
    override fun post(request: RegisterRequestEntity):
        Flow<ViewResource<RegisterEntity>> = flow {
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
