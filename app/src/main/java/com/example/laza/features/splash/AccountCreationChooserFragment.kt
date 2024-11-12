package com.example.laza.features.splash

import android.os.Bundle
import android.view.View
import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentAccountCreationChooserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountCreationChooserFragment :
    BaseFragment<FragmentAccountCreationChooserBinding>(FragmentAccountCreationChooserBinding::inflate) {

    override val viewModel = BaseViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.loginBTN.setOnClickListener {
            navigateTo(R.id.action_accountCreationChooserFragment_to_loginFragment)
        }

        binding.signUpBtn.setOnClickListener {
            navigateTo(R.id.action_accountCreationChooserFragment_to_signUpFragment)
        }

        binding.buttonBack.setOnClickListener {
            popBackStack()
        }
    }

}