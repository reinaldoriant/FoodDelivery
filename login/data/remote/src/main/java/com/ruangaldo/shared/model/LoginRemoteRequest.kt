package com.ruangaldo.shared.model

import com.squareup.moshi.Json

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

data class LoginRemoteRequest(
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String
)

