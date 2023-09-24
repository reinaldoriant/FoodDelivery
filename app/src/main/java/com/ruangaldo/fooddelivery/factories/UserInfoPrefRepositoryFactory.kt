package com.ruangaldo.fooddelivery.factories

import android.content.Context
import com.ruangaldo.fooddelivery.features.user.data.local.UserInfoPrefRepository

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class UserInfoPrefRepositoryFactory {
    companion object {
        fun create(context: Context): UserInfoPrefRepository {
            return UserInfoPrefRepository(
                context = context
            )
        }
    }
}
