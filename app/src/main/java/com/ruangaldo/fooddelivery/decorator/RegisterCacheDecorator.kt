package com.ruangaldo.fooddelivery.decorator

import com.ruangaldo.fooddelivery.features.login.domain.ILogin
import com.ruangaldo.fooddelivery.features.login.domain.LoginEntity
import com.ruangaldo.fooddelivery.features.login.domain.LoginRequestEntity
import com.ruangaldo.fooddelivery.features.register.domain.IRegister
import com.ruangaldo.fooddelivery.features.register.domain.RegisterEntity
import com.ruangaldo.fooddelivery.features.register.domain.RegisterRequestEntity
import com.ruangaldo.fooddelivery.features.user.data.local.toUserInfoEntity
import com.ruangaldo.fooddelivery.features.user.domain.ISaveUserInfo
import com.ruangaldo.fooddelivery.shared.domain.ViewResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterCacheDecorator(
    private val decorator: IRegister,
    private val cache: ISaveUserInfo
) : IRegister {
    override fun post(request: RegisterRequestEntity): Flow<ViewResource<RegisterEntity>> = flow {
        decorator.post(request).collect { response ->
            if (response is ViewResource.Success) {
                cache.save(response.data.toUserInfoEntity())
            }
            emit(response)
        }
    }
}
