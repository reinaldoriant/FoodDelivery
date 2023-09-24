package com.ruangaldo.fooddelivery.features.onboarding.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.fooddelivery.R
import com.ruangaldo.fooddelivery.factories.onboarding.OnBoardingViewModelFactory
import com.ruangaldo.fooddelivery.features.home.ui.HomeActivity
import com.ruangaldo.fooddelivery.features.login.ui.LoginActivity
import com.ruangaldo.fooddelivery.features.onboarding.presentation.OnBoardingViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _onBoardingVM: OnBoardingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        observeViewModel()
    }

    private fun initViewModel() {
        _onBoardingVM = ViewModelProvider(
            this,
            OnBoardingViewModelFactory.createFactory(this@MainActivity)
        )[OnBoardingViewModel::class.java]
    }

    private fun observeViewModel() {
        _onBoardingVM.userInfo.observe(this) { result ->
            if (result.token.isEmpty()) {
                startActivity(
                    Intent(this@MainActivity, LoginActivity::class.java)
                )
            } else {
                startActivity(
                    Intent(this@MainActivity, HomeActivity::class.java)
                )
            }
            finish()
        }
    }
}
