package com.ruangaldo.fooddelivery.factories.register

import com.ruangaldo.remote.service.RegisterRemoteService
import com.ruangaldo.fooddelivery.framework.HttpFactory

/**
 * Written with joy and smile by Ruang Aldo on 04/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterServiceFactory {
    companion object {
        fun createRegisterService(): RegisterRemoteService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                ),
            ).create(RegisterRemoteService::class.java)
        }
    }
}
