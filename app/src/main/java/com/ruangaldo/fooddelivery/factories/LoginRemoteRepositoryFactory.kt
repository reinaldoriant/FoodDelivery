package com.ruangaldo.fooddelivery.factories

import com.ruangaldo.fooddelivery.features.login.data.remote.repository.LoginRemoteRepository

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginRemoteRepositoryFactory {
    companion object {
        fun createLoginRemoteRepository(): LoginRemoteRepository {
            return LoginRemoteRepository(
                LoginServiceFactory.createLoginService()
            )
        }
    }
}
