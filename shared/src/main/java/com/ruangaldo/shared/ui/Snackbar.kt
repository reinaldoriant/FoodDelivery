package com.ruangaldo.shared.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.behavior.SwipeDismissBehavior
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.ruangaldo.shared.R
import com.ruangaldo.shared.domain.Authorized
import com.ruangaldo.shared.domain.InvalidData

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

fun Context.showSnackbar(
    view: View,
    type: Throwable
) {
    val mSnackBar: Snackbar = Snackbar.make(
        view,
        when (type) {
            is InvalidData -> {
                "Akun anda telah terdaftar, silahkan ganti yang lain"
            }

            is Authorized -> {
                "Akun anda belum terdaftar, silahkan melanjutkan proses daftar."
            }
            else -> {
                "Periksa konektivitas anda."
            }
        },
        Snackbar.LENGTH_LONG
    )

    with(mSnackBar) {
        setBackgroundTint(ContextCompat.getColor(this@showSnackbar, R.color.red_F5))

        setAction("Tutup") {
            dismiss()
        }

        view.setPadding(16, 0, 16, 16)

        val behavior = BaseTransientBottomBar.Behavior().apply {
            setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY)
        }

        setBehavior(behavior).animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
        setTextColor(ContextCompat.getColor(this@showSnackbar, R.color.black_333))
        setActionTextColor(ContextCompat.getColor(this@showSnackbar, R.color.red_B74))
        show()
    }
}
