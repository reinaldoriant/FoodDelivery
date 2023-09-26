package com.ruangaldo.remote.repository

import com.ruangaldo.remote.model.RegisterRemoteRequest
import com.ruangaldo.remote.model.RegisterRemoteResponse
import com.ruangaldo.remote.service.RegisterRemoteService
import com.ruangaldo.shared.data.ConnectivityException
import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.shared.data.InvalidDataException
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

class RegisterRemoteRepository constructor(private val service: RegisterRemoteService) :
    IRegisterRemoteRepository {
    override fun post(request: RegisterRemoteRequest):
        Flow<DataResource<RegisterRemoteResponse>> = flow {
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
                        throwable = InvalidDataException()
                    )
                )
            }
            emit(DataResource.Error(throwable = InvalidDataException()))
        }
    }.flowOn(Dispatchers.IO)
}
