package com.ruangaldo.fooddelivery.factories.login

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginRemoteRepositoryFactory {
    companion object {
        fun createLoginRemoteRepository(): com.ruangaldo.remote.repository.LoginRemoteRepository {
            return com.ruangaldo.remote.repository.LoginRemoteRepository(
                LoginServiceFactory.createLoginService()
            )
        }
    }
}
