package com.ruangaldo.fooddelivery.factories

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ruangaldo.fooddelivery.features.onboarding.presentation.OnBoardingViewModel

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class OnBoardingViewModelFactory {
    companion object {
        fun createFactory(context: Context): ViewModelProvider.Factory {
            return viewModelFactory {
                initializer {
                    OnBoardingViewModel(
                        GetUserInfoPrefUseCaseFactory.get(context)
                    )
                }
            }
        }
    }
}
