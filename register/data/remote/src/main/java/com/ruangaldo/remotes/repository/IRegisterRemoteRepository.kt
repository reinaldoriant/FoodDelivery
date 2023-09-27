package com.ruangaldo.remote.repository

import com.ruangaldo.remote.model.RegisterRemoteResponse
import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.remotes.model.RegisterRemoteRequest
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface IRegisterRemoteRepository {
    fun post(request: RegisterRemoteRequest): Flow<DataResource<RegisterRemoteResponse>>
}
