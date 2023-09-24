package com.ruangaldo.fooddelivery.features.user.data.local

import com.ruangaldo.fooddelivery.features.user.domain.IGetUserInfo
import com.ruangaldo.fooddelivery.features.user.domain.UserInfoEntity
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class GetUserInfoPrefUseCase(private val repository: IUserInfoPrefRepository) :
    IGetUserInfo {
    override fun get(): Flow<UserInfoEntity> = repository.get()
}
