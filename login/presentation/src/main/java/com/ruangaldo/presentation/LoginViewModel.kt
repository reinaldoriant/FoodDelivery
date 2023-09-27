package com.ruangaldo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.ruangaldo.domain.ILogin
import com.ruangaldo.domain.LoginEntity
import com.ruangaldo.domain.LoginRequestEntity
import com.ruangaldo.shared.domain.ViewResource
import kotlinx.coroutines.launch

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class LoginViewModel constructor(private val login: com.ruangaldo.domain.ILogin) : ViewModel() {
    val loginUi: LiveData<ViewResource<LoginEntity>> get() = _loginUi.distinctUntilChanged()
    private val _loginUi = MutableLiveData<ViewResource<LoginEntity>>()

    fun post(request: com.ruangaldo.domain.LoginRequestEntity) {
        viewModelScope.launch {
            login.post(
                request
            ).collect {
                _loginUi.value = it
            }
        }
    }
}
