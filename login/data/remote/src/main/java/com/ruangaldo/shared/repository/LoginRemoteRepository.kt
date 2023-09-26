package com.ruangaldo.shared.repository

import com.ruangaldo.shared.model.LoginRemoteRequest
import com.ruangaldo.shared.model.LoginRemoteResponse
import com.ruangaldo.shared.service.LoginRemoteService
import com.ruangaldo.fooddelivery.shared.data.AuthorizedException
import com.ruangaldo.fooddelivery.shared.data.ConnectivityException
import com.ruangaldo.fooddelivery.shared.data.DataResource
import com.ruangaldo.fooddelivery.shared.data.InvalidDataException
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginRemoteRepository constructor(private val service: LoginRemoteService) :
    ILoginRemoteRepository {
    override fun post(request: LoginRemoteRequest):
        Flow<DataResource<LoginRemoteResponse>> = flow {
        try {
            val result = service.post(request)
            result.data?.let {
                emit(DataResource.Success(result))
            } ?: emit(DataResource.Error(throwable = InvalidDataException()))
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> {
                    emit(DataResource.Error(throwable = ConnectivityException()))
                }

                is HttpException -> {
                    emit(
                        DataResource.Error(
                            throwable = if (throwable.code() == 500) {
                                AuthorizedException()
                            } else {
                                InvalidDataException()
                            }
                        )
                    )
                }

                else -> {
                    emit(DataResource.Error(throwable = InvalidDataException()))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}
