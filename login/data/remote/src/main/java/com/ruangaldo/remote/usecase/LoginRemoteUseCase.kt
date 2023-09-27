package com.ruangaldo.remote.usecase

import com.ruangaldo.domain.LoginEntity
import com.ruangaldo.shared.data.AuthorizedException
import com.ruangaldo.shared.data.ConnectivityException
import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.shared.data.InvalidDataException
import com.ruangaldo.shared.domain.Authorized
import com.ruangaldo.shared.domain.Connectivity
import com.ruangaldo.shared.domain.InvalidData
import com.ruangaldo.shared.domain.ViewResource
import com.ruangaldo.remote.repository.ILoginRemoteRepository
import com.ruangaldo.remote.toLoginEntity
import com.ruangaldo.remote.toLoginRemoteRequest
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

                        is AuthorizedException -> {
                            emit(ViewResource.Error(throwable = Authorized()))
                        }
                    }
                }
            }
        }
    }
}
