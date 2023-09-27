package com.ruangaldo.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ruangaldo.shared.framework.DataStoreFactory.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class UserInfoPrefRepository constructor(private val context: Context) :
    IUserInfoPrefRepository {
    companion object {
        val tokenPref = stringPreferencesKey("token")
        val namePref = stringPreferencesKey("name")
        val emailPref = stringPreferencesKey("email")
        val houseNumberPref = stringPreferencesKey("houseNumber")
        val phoneNumberPref = stringPreferencesKey("phoneNumber")
        val addressPref = stringPreferencesKey("address")
        val cityPref = stringPreferencesKey("city")
    }

    override suspend fun save(userInfo: com.ruangaldo.domain.UserInfoEntity) {
        userInfo.let {
            context.dataStore.edit { preference ->
                preference[tokenPref] = it.token
                preference[namePref] = it.name
                preference[emailPref] = it.email
                preference[houseNumberPref] = it.houseNumber
                preference[phoneNumberPref] = it.phoneNumber
                preference[cityPref] = it.city
            }
        }
    }

    override fun get(): Flow<com.ruangaldo.domain.UserInfoEntity> =
        context.dataStore.data.map { preferences ->
            val token = preferences[tokenPref].orEmpty()
            val name = preferences[namePref].orEmpty()
            val email = preferences[emailPref].orEmpty()
            val houseNumber = preferences[houseNumberPref].orEmpty()
            val phoneNumber = preferences[phoneNumberPref].orEmpty()
            val address = preferences[addressPref].orEmpty()
            val city = preferences[cityPref].orEmpty()
            com.ruangaldo.domain.UserInfoEntity(
                token = token,
                name = name,
                email = email,
                houseNumber = houseNumber,
                phoneNumber = phoneNumber,
                address = address,
                city = city
            )
        }
}
