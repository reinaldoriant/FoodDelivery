package com.ruangaldo.remote.service

import com.ruangaldo.remote.model.LoginRemoteRequest
import com.ruangaldo.remote.model.LoginRemoteResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface LoginRemoteService {
    @POST("api/login")
    suspend fun post(
        @Body request: LoginRemoteRequest
    ): LoginRemoteResponse
}
