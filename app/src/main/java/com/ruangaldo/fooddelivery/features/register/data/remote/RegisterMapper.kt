package com.ruangaldo.fooddelivery.features.register.data.remote

import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterData
import com.ruangaldo.fooddelivery.features.register.domain.RegisterEntity
import com.ruangaldo.fooddelivery.features.register.domain.RegisterRequestEntity
import com.ruangaldo.fooddelivery.features.register.data.remote.model.RegisterRemoteRequest

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

fun RegisterData?.toRegisterEntity(): RegisterEntity =
    this.let {
        RegisterEntity(
            token = it?.accessToken.orEmpty(),
            name = it?.user?.name.orEmpty(),
            address = it?.user?.address.orEmpty(),
            houseNumber = it?.user?.houseNumber.orEmpty(),
            phoneNumber = it?.user?.phoneNumber.orEmpty(),
            city = it?.user?.city.orEmpty(),
            email = it?.user?.email.orEmpty(),
        )
    }

fun RegisterRequestEntity.toRegisterRemoteRequest(): RegisterRemoteRequest =
    this.let {
        RegisterRemoteRequest(
            name = it.name,
            address = it.address,
            houseNumber = it.phoneNumber,
            password = it.password,
            city = it.passwordConfirmation,
            email = it.email,
            passwordConfirmation = it.passwordConfirmation,
            phoneNumber = it.phoneNumber,
        )
    }
