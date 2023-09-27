package com.ruangaldo.local

import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class GetUserInfoPrefUseCase(private val repository: IUserInfoPrefRepository) :
    com.ruangaldo.domain.IGetUserInfo {
    override fun get(): Flow<com.ruangaldo.domain.UserInfoEntity> = repository.get()
}
