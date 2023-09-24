package com.ruangaldo.fooddelivery.framework

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

object DataStoreFactory {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore("food_delivery_datastore")
}
