package com.ruangaldo.domain

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

data class RegisterEntity(
    val token: String,
    val name: String,
    val email: String,
    val address: String,
    val houseNumber: String,
    val phoneNumber: String,
    val city: String
)
