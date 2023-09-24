package com.ruangaldo.fooddelivery.factories

import android.content.Context
import com.ruangaldo.fooddelivery.features.user.data.local.InsertUserInfoPrefUseCase

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
