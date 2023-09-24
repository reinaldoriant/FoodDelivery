package com.ruangaldo.fooddelivery.features.login.data.remote.usecase

import com.ruangaldo.fooddelivery.features.login.data.remote.repository.ILoginRemoteRepository
import com.ruangaldo.fooddelivery.features.login.data.remote.toLoginEntity
import com.ruangaldo.fooddelivery.features.login.data.remote.toLoginRemoteRequest
import com.ruangaldo.fooddelivery.features.login.domain.ILogin
import com.ruangaldo.fooddelivery.features.login.domain.LoginEntity
import com.ruangaldo.fooddelivery.features.login.domain.LoginRequestEntity
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

class LoginRemoteUseCase constructor(private val repository: ILoginRemoteRepository) :
    ILogin {
    override fun post(request: LoginRequestEntity):
        Flow<ViewResource<LoginEntity>> = flow {
        repository.post(request.toLoginRemoteRequest()).collect { result ->
            when (result) {
                is DataResource.Success -> {
                    val login = result.root.data
                    emit(ViewResource.Success(login.toLoginEntity()))
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
