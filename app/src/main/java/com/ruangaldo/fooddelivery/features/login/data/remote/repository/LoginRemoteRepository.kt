package com.ruangaldo.fooddelivery.features.login.data.remote.repository

import com.ruangaldo.fooddelivery.features.login.data.remote.model.LoginRemoteRequest
import com.ruangaldo.fooddelivery.features.login.data.remote.model.LoginRemoteResponse
import com.ruangaldo.fooddelivery.features.login.data.remote.service.LoginRemoteService
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
            if (throwable is IOException) {
                emit(DataResource.Error(throwable = ConnectivityException()))
            }

            if (throwable is HttpException) {
                emit(
                    DataResource.Error(
                        code = throwable.code(),
                        throwable = InvalidDataException()
                    )
                )
            }
            emit(DataResource.Error(throwable = InvalidDataException()))
        }
    }.flowOn(Dispatchers.IO)
}
