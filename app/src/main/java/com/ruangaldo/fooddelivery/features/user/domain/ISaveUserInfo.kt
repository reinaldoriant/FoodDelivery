package com.ruangaldo.fooddelivery.features.user.domain

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface ISaveUserInfo {
    suspend fun save(userInfo: UserInfoEntity)
}
