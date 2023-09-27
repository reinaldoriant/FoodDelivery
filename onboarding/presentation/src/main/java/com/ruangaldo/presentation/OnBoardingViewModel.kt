package com.ruangaldo.fooddelivery.features.onboarding.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.ruangaldo.domain.IGetUserInfo
import com.ruangaldo.domain.UserInfoEntity
import kotlinx.coroutines.launch

/**
 * Written with joy and smile by Ruang Aldo on 24/09/23.
 * Github: https://github.com/reinaldoriant
 */

class OnBoardingViewModel constructor(private val preference: com.ruangaldo.domain.IGetUserInfo) : ViewModel() {
    val userInfo: LiveData<com.ruangaldo.domain.UserInfoEntity> get() = _userInfo.distinctUntilChanged()
    private val _userInfo = MutableLiveData<com.ruangaldo.domain.UserInfoEntity>()

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        viewModelScope.launch {
            preference.get().collect {
                _userInfo.value = it
            }
        }
    }
}
