package com.ruangaldo.fooddelivery.features.login.domain

import com.ruangaldo.fooddelivery.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface ILogin {
    fun post(request: LoginRequestEntity): Flow<ViewResource<LoginEntity>>
}
