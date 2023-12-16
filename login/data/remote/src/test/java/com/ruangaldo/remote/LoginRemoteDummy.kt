package com.ruangaldo.remote

import com.ruangaldo.domain.LoginEntity
import com.ruangaldo.domain.LoginRequestEntity
import com.ruangaldo.remote.model.LoginData
import com.ruangaldo.remote.model.LoginMeta
import com.ruangaldo.remote.model.LoginRemoteRequest
import com.ruangaldo.remote.model.LoginRemoteResponse
import com.ruangaldo.remote.model.LoginUser

val loginRequestEntityDummy = LoginRequestEntity(
    "reinaldo@gmail.com",
    "12345"
)

val loginRemoteRequestDummy = LoginRemoteRequest(
    "reinaldo@gmail.com",
    "12345"
)

val loginRemoteResponseDummy = LoginRemoteResponse(
    data = LoginData(
        accessToken = "dummyAccessToken",
        tokenType = "Bearer",
        user = LoginUser(
            address = "Dummy Street",
            city = "Dummy City",
            createdAt = System.currentTimeMillis(),
            currentTeamId = null,
            email = "dummy@example.com",
            emailVerifiedAt = null,
            houseNumber = "123",
            id = 1,
            name = "Dummy User",
            phoneNumber = "1234567890",
            profilePhotoPath = null,
            profilePhotoUrl = "https://example.com/dummy.jpg",
            roles = "user",
            updatedAt = System.currentTimeMillis()
        )
    ),
    meta = LoginMeta(
        code = 200,
        message = "Login successful",
        status = "success"
    )
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
