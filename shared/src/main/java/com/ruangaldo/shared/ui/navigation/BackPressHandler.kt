package com.ruangaldo.shared.ui.navigation

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

fun AppCompatActivity.clickBackPressed(action: () -> Unit) {
    this.onBackPressedDispatcher.addCallback(
        this,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                action()
            }
        }
    )
}
