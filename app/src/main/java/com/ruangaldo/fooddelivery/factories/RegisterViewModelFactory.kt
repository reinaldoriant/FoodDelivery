package com.ruangaldo.fooddelivery.factories

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ruangaldo.fooddelivery.features.login.presentation.LoginViewModel
import com.ruangaldo.fooddelivery.features.register.presentation.RegisterViewModel

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterViewModelFactory {
    companion object {
        fun createFactory(context: Context): ViewModelProvider.Factory {
            return viewModelFactory {
                initializer {
                    RegisterViewModel(
                        RegisterDecoratorFactory.createRegisterDecorator(
                            RegisterUseCaseFactory.createRegisterUseCase(),
                            InsertUserinfoPrefUseCaseFactory.create(context)
                        )
                    )
                }
            }
        }
    }
}
