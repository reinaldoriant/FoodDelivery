package com.ruangaldo.fooddelivery.factories

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ruangaldo.fooddelivery.features.login.presentation.LoginViewModel

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginViewModelFactory {
    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                LoginViewModel(
                    LoginUseCaseFactory.createLoginUseCase()
                )
            }
        }
    }
}
