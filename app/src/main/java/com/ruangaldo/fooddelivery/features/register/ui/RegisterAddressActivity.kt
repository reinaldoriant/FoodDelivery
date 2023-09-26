package com.ruangaldo.fooddelivery.features.register.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.fooddelivery.R
import com.ruangaldo.fooddelivery.databinding.ActivityRegisterAddressBinding
import com.ruangaldo.fooddelivery.factories.register.RegisterViewModelFactory
import com.ruangaldo.fooddelivery.features.onboarding.ui.MainActivity
import com.ruangaldo.domain.RegisterRequestEntity
import com.ruangaldo.presentation.RegisterViewModel
import com.ruangaldo.shared.domain.ViewResource
import com.ruangaldo.shared.ui.navigation.clickBackPressed
import com.ruangaldo.shared.ui.showSnackbar

class RegisterAddressActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityRegisterAddressBinding
    private lateinit var _registerVM: com.ruangaldo.presentation.RegisterViewModel

    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String

    companion object {
        const val EXTRA_NAME_INFO = "extra_name_info"
        const val EXTRA_PASSWORD_INFO = "extra_password_info"
        const val EXTRA_EMAIL_INFO = "extra_email_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_address)
        _binding = ActivityRegisterAddressBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        initViewModel()

        if (intent != null) {
            name = intent.getStringExtra(EXTRA_NAME_INFO).toString()
            email = intent.getStringExtra(EXTRA_EMAIL_INFO).toString()
            password = intent.getStringExtra(EXTRA_PASSWORD_INFO).toString()
        }

        this@RegisterAddressActivity.clickBackPressed {
            finish()
        }

        with(_binding) {
            ivBackNavbar.setOnClickListener {
                finish()
            }

            btRegister.setOnClickListener {
                val phoneNumber = etPhoneNumber.text.toString()
                val address = etAddress.text.toString()
                val homeNumber = etHomeNumber.text.toString()
                val city = etCity.text.toString()

                if (checkInput(phoneNumber, address, homeNumber, city)) {
                    _registerVM.post(
                        com.ruangaldo.domain.RegisterRequestEntity(
                            name = name,
                            email = email,
                            password = password,
                            passwordConfirmation = password,
                            address = address,
                            city = city,
                            houseNumber = homeNumber,
                            phoneNumber = phoneNumber
                        )
                    )
                }
                observeViewModel()
            }
        }
    }

    private fun checkInput(
        phoneNumber: String,
        address: String,
        homeNumber: String,
        city: String
    ): Boolean {
        with(_binding) {
            tfPhoneNumber.isErrorEnabled = false
            tfAddress.isErrorEnabled = false
            tfHomeNumber.isErrorEnabled = false
            tfCity.isErrorEnabled = false

            if (phoneNumber.isEmpty()) {
                tfPhoneNumber.error = "Nomor HP harus diisi."
                tfPhoneNumber.isErrorEnabled = true
                return false
            }

            if (address.isEmpty()) {
                tfAddress.error = "Alamat harus diisi."
                tfAddress.isErrorEnabled = true
                return false
            }

            if (homeNumber.isEmpty()) {
                tfHomeNumber.error = "Nomer rumah harus diisi."
                tfHomeNumber.isErrorEnabled = true
                return false
            }

            if (city.isEmpty()) {
                tfCity.error = "Kota harus diisi."
                tfCity.isErrorEnabled = true
                return false
            }
            return true
        }
    }

    private fun initViewModel() {
        _registerVM = ViewModelProvider(
            this,
            RegisterViewModelFactory.createFactory(this@RegisterAddressActivity)
        )[com.ruangaldo.presentation.RegisterViewModel::class.java]
    }

    private fun observeViewModel() {
        _registerVM.registerUi.observe(this) { result ->
            when (result) {
                is ViewResource.Success -> {
                    startActivity(
                        Intent(this@RegisterAddressActivity, MainActivity::class.java)
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
