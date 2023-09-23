package com.ruangaldo.fooddelivery.features.register.data.remote.repository

import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteResponse
import com.ruangaldo.fooddelivery.shared.data.ConnectivityException
import com.ruangaldo.fooddelivery.shared.data.DataResource
import com.ruangaldo.fooddelivery.shared.data.InvalidDataException
import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteRequest
import com.ruangaldo.fooddelivery.features.register.data.remote.service.RegisterRemoteService
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
            emit(DataResource.Success(service.post(request)))
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
