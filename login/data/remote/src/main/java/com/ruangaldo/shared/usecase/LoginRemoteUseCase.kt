package com.ruangaldo.shared.usecase

import com.ruangaldo.shared.repository.ILoginRemoteRepository
import com.ruangaldo.shared.toLoginEntity
import com.ruangaldo.shared.toLoginRemoteRequest
import com.ruangaldo.fooddelivery.shared.data.AuthorizedException
import com.ruangaldo.fooddelivery.shared.data.ConnectivityException
import com.ruangaldo.fooddelivery.shared.data.DataResource
import com.ruangaldo.fooddelivery.shared.data.InvalidDataException
import com.ruangaldo.fooddelivery.shared.domain.Authorized
import com.ruangaldo.fooddelivery.shared.domain.Connectivity
import com.ruangaldo.fooddelivery.shared.domain.InvalidData
import com.ruangaldo.fooddelivery.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginRemoteUseCase constructor(
    private val repository: ILoginRemoteRepository
) :
    com.ruangaldo.domain.ILogin {
    override fun post(request: com.ruangaldo.domain.LoginRequestEntity):
        Flow<ViewResource<com.ruangaldo.domain.LoginEntity>> = flow {
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

                        is AuthorizedException -> {
                            emit(ViewResource.Error(throwable = Authorized()))
                        }
                    }
                }
            }
        }
    }
}
