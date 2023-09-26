package com.ruangaldo.fooddelivery.features.user.data.local

import com.ruangaldo.domain.RegisterEntity
import com.ruangaldo.fooddelivery.features.user.domain.UserInfoEntity

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

fun com.ruangaldo.domain.LoginEntity?.toUserInfoEntity(): UserInfoEntity =
    this.let {
        UserInfoEntity(
            token = it?.token.orEmpty(),
            name = it?.name.orEmpty(),
            address = it?.address.orEmpty(),
            houseNumber = it?.houseNumber.orEmpty(),
            phoneNumber = it?.phoneNumber.orEmpty(),
            city = it?.city.orEmpty(),
            email = it?.email.orEmpty()
        )
    }

fun com.ruangaldo.domain.RegisterEntity?.toUserInfoEntity(): UserInfoEntity =
    this.let {
        UserInfoEntity(
            token = it?.token.orEmpty(),
            name = it?.name.orEmpty(),
            address = it?.address.orEmpty(),
            houseNumber = it?.houseNumber.orEmpty(),
            phoneNumber = it?.phoneNumber.orEmpty(),
            city = it?.city.orEmpty(),
            email = it?.email.orEmpty()
        )
    }
