package com.ruangaldo.remote.repository

import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.remote.model.LoginRemoteRequest
import com.ruangaldo.remote.model.LoginRemoteResponse
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface ILoginRemoteRepository {
    fun post(request: LoginRemoteRequest): Flow<DataResource<LoginRemoteResponse>>
}
