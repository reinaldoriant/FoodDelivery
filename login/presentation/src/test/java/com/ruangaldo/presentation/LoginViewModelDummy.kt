package com.ruangaldo.presentation

import com.ruangaldo.domain.LoginEntity
import com.ruangaldo.domain.LoginRequestEntity

val loginRequestEntityDummy = LoginRequestEntity(
    "reinaldo@gmail.com",
    "12345"
)

val loginEntityDummy = LoginEntity(
    token = "dummyAccessToken",
    name = "Dummy User",
    email = "dummy@example.com",
    address = "Dummy Street",
    houseNumber = "123",
    phoneNumber = "1234567890",
    city = "Dummy City"
)
