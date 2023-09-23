package com.ruangaldo.myfood.features.register.domain

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

data class RegisterRequestEntity(
    var name: String,
    var email: String,
    var password: String,
    var passwordConfirmation: String,
    var address: String,
    var city: String,
    var houseNumber: String,
    var phoneNumber: String
)
