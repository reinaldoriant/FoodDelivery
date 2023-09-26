package com.ruangaldo.fooddelivery.features.register.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruangaldo.domain.IRegister
import com.ruangaldo.domain.RegisterEntity
import com.ruangaldo.domain.RegisterRequestEntity
import com.ruangaldo.shared.domain.ViewResource
import kotlinx.coroutines.launch

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

class RegisterViewModel constructor(private val register: com.ruangaldo.domain.IRegister) : ViewModel() {
    val registerUi: LiveData<ViewResource<com.ruangaldo.domain.RegisterEntity>> get() = _registerUi
    private val _registerUi = MutableLiveData<ViewResource<com.ruangaldo.domain.RegisterEntity>>()

    fun post(request: com.ruangaldo.domain.RegisterRequestEntity) {
        viewModelScope.launch {
            register.post(
                request
            ).collect {
                _registerUi.value = it
            }
        }
    }
}
