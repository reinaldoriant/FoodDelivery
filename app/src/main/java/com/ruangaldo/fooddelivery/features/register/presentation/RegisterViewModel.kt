package com.ruangaldo.fooddelivery.features.register.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruangaldo.fooddelivery.features.register.domain.IRegister
import com.ruangaldo.fooddelivery.features.register.domain.RegisterEntity
import com.ruangaldo.fooddelivery.features.register.domain.RegisterRequestEntity
import com.ruangaldo.fooddelivery.shared.domain.ViewResource
import kotlinx.coroutines.launch

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterViewModel constructor(private val register: IRegister) : ViewModel() {
    val registerUi: LiveData<ViewResource<RegisterEntity>> get() = _registerUi
    private val _registerUi = MutableLiveData<ViewResource<RegisterEntity>>()

    fun post(request: RegisterRequestEntity) {
        viewModelScope.launch {
            register.post(
                request
            ).collect {
                _registerUi.value = it
            }
        }
    }
}
