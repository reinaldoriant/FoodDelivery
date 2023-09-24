package com.ruangaldo.fooddelivery.factories.register

import com.ruangaldo.fooddelivery.decorator.RegisterCacheDecorator
import com.ruangaldo.fooddelivery.features.register.domain.IRegister
import com.ruangaldo.fooddelivery.features.user.domain.ISaveUserInfo

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterDecoratorFactory {
    companion object {
        fun createRegisterDecorator(
            decorator: IRegister,
            cache: ISaveUserInfo
        ): IRegister {
            return RegisterCacheDecorator(
                decorator,
                cache
            )
        }
    }
}
