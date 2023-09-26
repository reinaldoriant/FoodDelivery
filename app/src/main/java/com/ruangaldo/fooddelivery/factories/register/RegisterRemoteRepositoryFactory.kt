package com.ruangaldo.fooddelivery.factories.register

import com.ruangaldo.remote.repository.RegisterRemoteRepository

/**
 * Written with joy and smile by Ruang Aldo on 04/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterRemoteRepositoryFactory {
    companion object {
        fun createRegisterRemoteRepository(): RegisterRemoteRepository {
            return RegisterRemoteRepository(
                RegisterServiceFactory.createRegisterService()
            )
        }
    }
}
