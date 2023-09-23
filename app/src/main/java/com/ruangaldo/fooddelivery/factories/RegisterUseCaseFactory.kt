package com.ruangaldo.fooddelivery.factories

import com.ruangaldo.fooddelivery.features.register.data.remote.usecase.RegisterRemoteUseCase
import com.ruangaldo.mycrypto.factories.RegisterRemoteRepositoryFactory

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterUseCaseFactory {
    companion object {
        fun createRegisterUseCase(): RegisterRemoteUseCase {
            return RegisterRemoteUseCase(
                RegisterRemoteRepositoryFactory.createRegisterRemoteRepository()
            )
        }
    }
}
