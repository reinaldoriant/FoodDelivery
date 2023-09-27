package com.ruangaldo.fooddelivery.decorator

import com.ruangaldo.domain.RegisterEntity
import com.ruangaldo.local.toUserInfoEntity
import com.ruangaldo.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterCacheDecorator(
    private val decorator: com.ruangaldo.domain.IRegister,
    private val cache: com.ruangaldo.domain.ISaveUserInfo
) : com.ruangaldo.domain.IRegister {
    override fun post(request: com.ruangaldo.domain.RegisterRequestEntity):
        Flow<ViewResource<RegisterEntity>> =
        flow {
            decorator.post(request).collect { response ->
                if (response is ViewResource.Success) {
                    cache.save(response.data.toUserInfoEntity())
                }
                emit(response)
            }
        }
}
