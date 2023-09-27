package com.ruangaldo.local

import com.ruangaldo.domain.UserInfoEntity
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface IUserInfoPrefRepository {
    suspend fun save(userInfo: com.ruangaldo.domain.UserInfoEntity)
    fun get(): Flow<com.ruangaldo.domain.UserInfoEntity>
}
