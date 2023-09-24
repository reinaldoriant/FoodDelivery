package com.ruangaldo.fooddelivery.features.login.data.remote

import com.ruangaldo.fooddelivery.features.login.data.remote.model.LoginData
import com.ruangaldo.fooddelivery.features.login.data.remote.model.LoginRemoteRequest
import com.ruangaldo.fooddelivery.features.login.domain.LoginEntity
import com.ruangaldo.fooddelivery.features.login.domain.LoginRequestEntity

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

fun LoginData?.toLoginEntity(): LoginEntity =
    this.let {
        LoginEntity(
            token = it?.accessToken.orEmpty(),
            name = it?.user?.name.orEmpty(),
            address = it?.user?.address.orEmpty(),
            houseNumber = it?.user?.houseNumber.orEmpty(),
            phoneNumber = it?.user?.phoneNumber.orEmpty(),
            city = it?.user?.city.orEmpty(),
            email = it?.user?.email.orEmpty()
        )
    }

fun LoginRequestEntity.toLoginRemoteRequest(): LoginRemoteRequest =
    this.let {
        LoginRemoteRequest(
            password = it.password,
            email = it.email
        )
    }
