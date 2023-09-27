package com.ruangaldo.local

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class InsertUserInfoPrefUseCase constructor(private val repository: IUserInfoPrefRepository) :
    com.ruangaldo.domain.ISaveUserInfo {
    override suspend fun save(userInfo: com.ruangaldo.domain.UserInfoEntity) {
        repository.save(userInfo)
    }
}
