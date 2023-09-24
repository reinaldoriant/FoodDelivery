package com.ruangaldo.fooddelivery.factories.login

import com.ruangaldo.fooddelivery.decorator.LoginCacheDecorator
import com.ruangaldo.fooddelivery.features.login.domain.ILogin
import com.ruangaldo.fooddelivery.features.user.domain.ISaveUserInfo

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginDecoratorFactory {
    companion object {
        fun createLoginDecorator(
            decorator: ILogin,
            cache: ISaveUserInfo
        ): ILogin {
            return LoginCacheDecorator(
                decorator,
                cache
            )
        }
    }
}
