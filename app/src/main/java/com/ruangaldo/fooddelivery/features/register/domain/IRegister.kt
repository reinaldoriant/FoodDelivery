package com.ruangaldo.myfood.features.register.domain

import com.ruangaldo.myfood.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface IRegister {
    fun get(request: RegisterRequestEntity): Flow<ViewResource<RegisterEntity>>
}
