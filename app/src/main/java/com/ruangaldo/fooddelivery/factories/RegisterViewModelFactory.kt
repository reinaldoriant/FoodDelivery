package com.ruangaldo.fooddelivery.factories

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ruangaldo.fooddelivery.features.register.presentation.RegisterViewModel

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterViewModelFactory {
    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                RegisterViewModel(
                    RegisterUseCaseFactory.createRegisterUseCase()
                )
            }
        }
    }
}
