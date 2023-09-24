package com.ruangaldo.fooddelivery.features.user.data.local

import com.ruangaldo.fooddelivery.features.user.domain.ISaveUserInfo
import com.ruangaldo.fooddelivery.features.user.domain.UserInfoEntity

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class InsertUserInfoPrefUseCase constructor(private val repository: IUserInfoPrefRepository) :
    ISaveUserInfo {
    override suspend fun save(userInfo: UserInfoEntity) {
        repository.save(userInfo)
    }
}
