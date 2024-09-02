package com.example.laza.accountCreationChooser

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentAccountCreationChooserBinding

class AccountCreationChooserFragment :
    BaseFragment<FragmentAccountCreationChooserBinding>(FragmentAccountCreationChooserBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.loginBTN.setOnClickListener {
            findNavController().navigate(R.id.action_accountCreationChooserFragment_to_loginFragment)
        }

        binding.signUpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_accountCreationChooserFragment_to_signUpFragment)
        }
    }

}