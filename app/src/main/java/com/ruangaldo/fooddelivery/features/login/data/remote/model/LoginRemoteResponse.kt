package com.ruangaldo.fooddelivery.features.register.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRemoteResponse(
    var data: RegisterData?,
    var meta: LoginMeta?
)

data class LoginData(
    @Json(name = "access_token")
    var accessToken: String?,
    @Json(name = "token_type")
    var tokenType: String?,
    @Json(name = "user")
    var user: LoginUser?
)

@JsonClass(generateAdapter = true)
data class LoginMeta(
    var code: Int?,
    var message: String?,
    var status: String?
)

data class LoginUser(
    @Json(name = "address")
    var address: String?,
    @Json(name = "city")
    var city: String?,
    @Json(name = "created_at")
    var createdAt: Long?,
    @Json(name = "current_team_id")
    var currentTeamId: Any?,
    @Json(name = "email")
    var email: String?,
    @Json(name = "email_verified_at")
    var emailVerifiedAt: Any?,
    @Json(name = "houseNumber")
    var houseNumber: String?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "phoneNumber")
    var phoneNumber: String?,
    @Json(name = "profile_photo_path")
    var profilePhotoPath: Any?,
    @Json(name = "profile_photo_url")
    var profilePhotoUrl: String?,
    @Json(name = "roles")
    var roles: String?,
    @Json(name = "updated_at")
    var updatedAt: Long?
)
