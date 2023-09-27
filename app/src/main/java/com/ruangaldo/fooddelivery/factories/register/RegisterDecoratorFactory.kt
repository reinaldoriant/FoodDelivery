package com.ruangaldo.fooddelivery.factories.register

import com.ruangaldo.fooddelivery.decorator.RegisterCacheDecorator
import com.ruangaldo.domain.ISaveUserInfo

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterDecoratorFactory {
    companion object {
        fun createRegisterDecorator(
            decorator: com.ruangaldo.domain.IRegister,
            cache: com.ruangaldo.domain.ISaveUserInfo
        ): com.ruangaldo.domain.IRegister {
            return RegisterCacheDecorator(
                decorator,
                cache
            )
        }
    }
}
