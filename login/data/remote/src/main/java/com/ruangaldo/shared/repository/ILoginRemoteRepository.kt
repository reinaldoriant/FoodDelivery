package com.ruangaldo.shared.repository

import com.ruangaldo.shared.model.LoginRemoteRequest
import com.ruangaldo.shared.model.LoginRemoteResponse
import com.ruangaldo.fooddelivery.shared.data.DataResource
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface ILoginRemoteRepository {
    fun post(request: LoginRemoteRequest): Flow<DataResource<LoginRemoteResponse>>
}
