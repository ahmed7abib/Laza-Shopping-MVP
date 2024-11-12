package com.example.laza.features.auth.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common.ui.BaseFragment
import com.example.data.local.shared_pref.SharedPreferenceHelper
import com.example.domain.models.holders.RegisterDataHolder
import com.example.laza.R
import com.example.laza.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override val viewModel: SignupViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        observer()
    }

    private fun observer() {
        viewModel.isRegisterSuccess.observe(viewLifecycleOwner) {
            navigateTo(R.id.action_signUpFragment_to_home)
        }
    }

    private fun onClick() {
        binding.signUpBtn.setOnClickListener {
            viewModel.register(
                RegisterDataHolder(
                    username = binding.userNameEditText.text.toString(),
                    password = binding.passwordEditText.text.toString(),
                    email = binding.emailEditText.text.toString()
                )
            )
        }

        binding.buttonBack.setOnClickListener {
            popBackStack()
        }

        binding.rememberMeBTN.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                SharedPreferenceHelper.setRememberMe(true)
            } else {
                SharedPreferenceHelper.setRememberMe(false)
            }
        }
    }
}