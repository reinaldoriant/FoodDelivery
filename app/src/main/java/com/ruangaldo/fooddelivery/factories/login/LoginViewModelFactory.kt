package com.ruangaldo.fooddelivery.factories.login

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ruangaldo.fooddelivery.factories.user.InsertUserinfoPrefUseCaseFactory
import com.ruangaldo.presentation.LoginViewModel

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginViewModelFactory {
    companion object {
        fun createFactory(context: Context): ViewModelProvider.Factory {
            return viewModelFactory {
                initializer {
                    LoginViewModel(
                        LoginDecoratorFactory.createLoginDecorator(
                            LoginUseCaseFactory.createLoginUseCase(),
                            InsertUserinfoPrefUseCaseFactory.create(context)
                        )
                    )
                }
            }
        }
    }
}
