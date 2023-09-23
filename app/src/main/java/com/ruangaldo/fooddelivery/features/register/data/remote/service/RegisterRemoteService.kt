package com.ruangaldo.fooddelivery.features.register.data.remote.service

import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteResponse
import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteRequest
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface RegisterRemoteService {
    @POST("data/top/totaltoptiervolfull")
    suspend fun post(
        @Body request: RegisterRemoteRequest
    ): RegisterRemoteResponse
}
