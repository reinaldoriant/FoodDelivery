package com.ruangaldo.fooddelivery.factories.login

import com.ruangaldo.fooddelivery.framework.HttpFactory

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginServiceFactory {
    companion object {
        fun createLoginService(): com.ruangaldo.shared.service.LoginRemoteService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(com.ruangaldo.shared.service.LoginRemoteService::class.java)
        }
    }
}
