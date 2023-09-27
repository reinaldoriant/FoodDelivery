package com.ruangaldo.fooddelivery.factories.user

import android.content.Context
import com.ruangaldo.local.GetUserInfoPrefUseCase

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class GetUserInfoPrefUseCaseFactory {
    companion object {
        fun get(context: Context): GetUserInfoPrefUseCase {
            return GetUserInfoPrefUseCase(
                UserInfoPrefRepositoryFactory.create(context)
            )
        }
    }
}
