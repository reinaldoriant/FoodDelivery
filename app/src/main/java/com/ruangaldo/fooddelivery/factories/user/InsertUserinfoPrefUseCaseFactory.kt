package com.ruangaldo.fooddelivery.factories.user

import android.content.Context
import com.ruangaldo.local.InsertUserInfoPrefUseCase

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class InsertUserinfoPrefUseCaseFactory {
    companion object {
        fun create(context: Context): InsertUserInfoPrefUseCase {
            return InsertUserInfoPrefUseCase(
                UserInfoPrefRepositoryFactory.create(context)
            )
        }
    }
}
