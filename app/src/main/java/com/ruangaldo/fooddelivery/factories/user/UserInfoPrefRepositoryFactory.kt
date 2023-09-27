package com.ruangaldo.fooddelivery.factories.user

import android.content.Context
import com.ruangaldo.local.UserInfoPrefRepository

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
