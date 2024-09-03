package com.example.laza.accountCreationChooser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.LazaSharedViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentAccountCreationChooserBinding

class AccountCreationChooserFragment :
    BaseFragment<FragmentAccountCreationChooserBinding>(FragmentAccountCreationChooserBinding::inflate) {

    private val sharedViewModel: LazaSharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
    }

    private fun init() {
        sharedViewModel.hideUnNecessaryView.value = true
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