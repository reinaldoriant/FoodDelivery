package com.ruangaldo.fooddelivery.decorator

import com.ruangaldo.domain.ILogin
import com.ruangaldo.domain.LoginEntity
import com.ruangaldo.domain.LoginRequestEntity
import com.ruangaldo.fooddelivery.features.user.data.local.toUserInfoEntity
import com.ruangaldo.fooddelivery.features.user.domain.ISaveUserInfo
import com.ruangaldo.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginCacheDecorator(
    private val decorator: com.ruangaldo.domain.ILogin,
    private val cache: ISaveUserInfo
) : com.ruangaldo.domain.ILogin {
    override fun post(request: com.ruangaldo.domain.LoginRequestEntity): Flow<ViewResource<LoginEntity>> = flow {
        decorator.post(request).collect { response ->
            if (response is ViewResource.Success) {
                cache.save(response.data.toUserInfoEntity())
            }
            emit(response)
        }
    }
}
