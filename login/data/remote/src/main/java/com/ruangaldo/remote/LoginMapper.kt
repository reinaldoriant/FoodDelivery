package com.ruangaldo.remote

import com.ruangaldo.remote.model.LoginData
import com.ruangaldo.remote.model.LoginRemoteRequest

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

fun LoginData?.toLoginEntity(): com.ruangaldo.domain.LoginEntity =
    this.let {
        com.ruangaldo.domain.LoginEntity(
            token = it?.accessToken.orEmpty(),
            name = it?.user?.name.orEmpty(),
            address = it?.user?.address.orEmpty(),
            houseNumber = it?.user?.houseNumber.orEmpty(),
            phoneNumber = it?.user?.phoneNumber.orEmpty(),
            city = it?.user?.city.orEmpty(),
            email = it?.user?.email.orEmpty()
        )
    }

fun com.ruangaldo.domain.LoginRequestEntity.toLoginRemoteRequest(): LoginRemoteRequest =
    this.let {
        LoginRemoteRequest(
            password = it.password,
            email = it.email
        )
    }
