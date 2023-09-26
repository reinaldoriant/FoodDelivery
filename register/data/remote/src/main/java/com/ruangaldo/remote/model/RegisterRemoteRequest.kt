package com.ruangaldo.remote.model

import com.squareup.moshi.Json

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

data class RegisterRemoteRequest(
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String,
    @Json(name = "password_confirmation") val passwordConfirmation: String,
    @Json(name = "address") val address: String,
    @Json(name = "city") val city: String,
    @Json(name = "houseNumber") val houseNumber: String,
    @Json(name = "phoneNumber") val phoneNumber: String
)

