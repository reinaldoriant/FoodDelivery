package com.ruangaldo.fooddelivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ruangaldo.fooddelivery.features.register.presentation.RegisterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var _viewModelRegister: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
