package com.ruangaldo.fooddelivery.factories.register

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ruangaldo.fooddelivery.factories.user.InsertUserinfoPrefUseCaseFactory
import com.ruangaldo.presentation.RegisterViewModel

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterViewModelFactory {
    companion object {
        fun createFactory(context: Context): ViewModelProvider.Factory {
            return viewModelFactory {
                initializer {
                    com.ruangaldo.presentation.RegisterViewModel(
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
