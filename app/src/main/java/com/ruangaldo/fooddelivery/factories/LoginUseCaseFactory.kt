package com.ruangaldo.fooddelivery.factories

import com.ruangaldo.fooddelivery.features.login.data.remote.usecase.LoginRemoteUseCase

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginUseCaseFactory {
    companion object {
        fun createLoginUseCase(): LoginRemoteUseCase {
            return LoginRemoteUseCase(
                LoginRemoteRepositoryFactory.createLoginRemoteRepository()
            )
        }
    }
}
