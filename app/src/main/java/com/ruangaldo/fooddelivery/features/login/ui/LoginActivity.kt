package com.ruangaldo.fooddelivery.features.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.fooddelivery.features.onboarding.ui.MainActivity
import com.ruangaldo.fooddelivery.R
import com.ruangaldo.fooddelivery.databinding.ActivityLoginBinding
import com.ruangaldo.fooddelivery.factories.login.LoginViewModelFactory
import com.ruangaldo.fooddelivery.features.login.domain.LoginRequestEntity
import com.ruangaldo.fooddelivery.features.login.presentation.LoginViewModel
import com.ruangaldo.fooddelivery.features.register.ui.RegisterUserInfoActivity
import com.ruangaldo.fooddelivery.shared.domain.ViewResource
import com.ruangaldo.fooddelivery.shared.ui.navigation.clickBackPressed
import com.ruangaldo.fooddelivery.shared.ui.showSnackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    private lateinit var _loginVM: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_address)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        initViewModel()

        this@LoginActivity.clickBackPressed {
            finish()
        }

        with(_binding) {
            btCreateAccount.setOnClickListener {
                startActivity(
                    Intent(this@LoginActivity, RegisterUserInfoActivity::class.java)
                )
            }
            btLogin.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()

                if (checkInput(email, password)) {
                    _loginVM.post(
                        LoginRequestEntity(
                            email = email,
                            password = password
                        )
                    )
                }
                observeViewModel()
            }
        }
    }

    private fun checkInput(
        email: String,
        password: String
    ): Boolean {
        with(_binding) {
            tfEmail.isErrorEnabled = false
            tfPassword.isErrorEnabled = false

            if (email.isEmpty()) {
                tfEmail.error = "Email harus diisi."
                tfEmail.isErrorEnabled = true
                return false
            }

            if (password.isEmpty()) {
                tfPassword.error = "Password harus diisi."
                tfPassword.isErrorEnabled = true
                return false
            }

            return true
        }
    }

    private fun initViewModel() {
        _loginVM = ViewModelProvider(
            this,
            LoginViewModelFactory.createFactory(this@LoginActivity)
        )[LoginViewModel::class.java]
    }

    private fun observeViewModel() {
        _loginVM.loginUi.observe(this) { result ->
            when (result) {
                is ViewResource.Success -> {
                    startActivity(
                        Intent(this@LoginActivity, MainActivity::class.java)
                    )
                    finishAffinity()
                }
                is ViewResource.Error -> {
                    result.throwable?.let { showSnackbar(_binding.clSnackbar, it) }
                }
            }
        }
    }
}
