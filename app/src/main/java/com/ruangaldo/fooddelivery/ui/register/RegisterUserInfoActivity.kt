package com.ruangaldo.fooddelivery.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.ruangaldo.fooddelivery.databinding.ActivityRegisterUserInfoBinding
import com.ruangaldo.shared.ui.navigation.clickBackPressed

class RegisterUserInfoActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityRegisterUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterUserInfoBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        this@RegisterUserInfoActivity.clickBackPressed {
            finish()
        }

        with(_binding) {
            ivBackNavbar.setOnClickListener {
                finish()
            }

            btContinue.setOnClickListener {
                val name = etName.text.toString()
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val passwordVerification = etPasswordVerification.text.toString()

                if (checkInput(name, email, password, passwordVerification)) {
                    navigateToRegisterAdress(name, email, password)
                }
            }
        }
    }

    private fun checkInput(
        name: String,
        email: String,
        password: String,
        passwordVerification: String
    ): Boolean {
        with(_binding) {
            tfName.isErrorEnabled = false
            tfEmail.isErrorEnabled = false
            tfPassword.isErrorEnabled = false
            tfPasswordVerification.isErrorEnabled = false

            if (name.isEmpty()) {
                tfName.error = "Nama harus diisi."
                tfName.isErrorEnabled = true
                return false
            }

            if (email.isEmpty()) {
                tfEmail.error = "Email harus diisi."
                tfEmail.isErrorEnabled = true
                return false
            }

            if (password.isEmpty()) {
                tfPassword.error = "Kata sandi harus diisi."
                tfPassword.isErrorEnabled = true
                return false
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tfEmail.error = "Masukkan format email dengan benar dan valid."
                tfEmail.isErrorEnabled = true
                return false
            }

            if (password.length < 8) {
                tfPassword.error = "Kata sandi minimal 8 karakter."
                tfPassword.isErrorEnabled = true
                etPassword.text = null
                etPasswordVerification.text = null
                return false
            }

            if (passwordVerification != password) {
                tfPasswordVerification.error = "Kata sandi tidak sama."
                tfPasswordVerification.isErrorEnabled = true
                etPassword.text = null
                etPasswordVerification.text = null
                return false
            }
            return true
        }
    }

    private fun navigateToRegisterAdress(name: String, email: String, password: String) {
        startActivity(
            Intent(this@RegisterUserInfoActivity, RegisterAddressActivity::class.java)
                .apply {
                    putExtra(RegisterAddressActivity.EXTRA_NAME_INFO, name)
                    putExtra(RegisterAddressActivity.EXTRA_EMAIL_INFO, email)
                    putExtra(RegisterAddressActivity.EXTRA_PASSWORD_INFO, password)
                }
        )
    }
}
