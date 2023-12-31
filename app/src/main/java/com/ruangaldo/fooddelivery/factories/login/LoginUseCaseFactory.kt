package com.ruangaldo.fooddelivery.factories.login

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginUseCaseFactory {
    companion object {
        fun createLoginUseCase(): com.ruangaldo.remote.usecase.LoginRemoteUseCase {
            return com.ruangaldo.remote.usecase.LoginRemoteUseCase(
                LoginRemoteRepositoryFactory.createLoginRemoteRepository()
            )
        }
    }
}
