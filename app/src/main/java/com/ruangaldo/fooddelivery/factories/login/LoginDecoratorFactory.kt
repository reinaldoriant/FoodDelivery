package com.ruangaldo.fooddelivery.factories.login

import com.ruangaldo.domain.ISaveUserInfo
import com.ruangaldo.fooddelivery.decorator.LoginCacheDecorator

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginDecoratorFactory {
    companion object {
        fun createLoginDecorator(
            decorator: com.ruangaldo.domain.ILogin,
            cache: ISaveUserInfo
        ): com.ruangaldo.domain.ILogin {
            return LoginCacheDecorator(
                decorator,
                cache
            )
        }
    }
}
