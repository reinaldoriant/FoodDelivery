package com.ruangaldo.fooddelivery.features.register.data.remote.repository

import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteResponse
import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteRequest
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface IRegisterRemoteRepository {
    fun post(request: RegisterRemoteRequest): Flow<DataResource<RegisterRemoteResponse>>
}
