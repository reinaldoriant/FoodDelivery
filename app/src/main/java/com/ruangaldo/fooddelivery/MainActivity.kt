package com.ruangaldo.fooddelivery

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.fooddelivery.factories.RegisterViewModelFactory
import com.ruangaldo.fooddelivery.features.register.presentation.RegisterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var _viewModelRegister: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        _viewModelRegister.post()
        _viewModelRegister.registerUi.observe(this) {
            Log.d("Check", "$it")
        }
    }

    private fun initViewModel() {
        _viewModelRegister = ViewModelProvider(
            this,
            RegisterViewModelFactory.FACTORY
        )[RegisterViewModel::class.java]
    }
}
