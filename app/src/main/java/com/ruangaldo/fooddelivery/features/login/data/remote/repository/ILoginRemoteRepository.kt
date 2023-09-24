package com.ruangaldo.fooddelivery.features.login.data.remote.repository

import com.ruangaldo.fooddelivery.features.login.data.remote.model.LoginRemoteRequest
import com.ruangaldo.fooddelivery.features.login.data.remote.model.LoginRemoteResponse
import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteResponse
import com.ruangaldo.fooddelivery.shared.data.DataResource
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface ILoginRemoteRepository {
    fun post(request: LoginRemoteRequest): Flow<DataResource<LoginRemoteResponse>>
}
