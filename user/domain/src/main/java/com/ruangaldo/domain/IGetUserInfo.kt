package com.ruangaldo.domain

import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

interface IGetUserInfo {
    fun get(): Flow<UserInfoEntity>
}
