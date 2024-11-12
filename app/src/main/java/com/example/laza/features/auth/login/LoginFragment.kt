package com.example.laza.features.auth.login

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common.ui.BaseFragment
import com.example.data.local.shared_pref.SharedPreferenceHelper
import com.example.laza.R
import com.example.laza.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
        observer()
    }

    private fun observer() {
        viewModel.isLoginSuccess.observe(viewLifecycleOwner) {
            navigateTo(R.id.action_loginFragment_to_home)
        }
    }

    private fun onClick() {
        binding.loginBTN.setOnClickListener {
            viewModel.login(
                binding.userNameEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }

        binding.tvForgotPassword.setOnClickListener {
            navigateTo(R.id.action_loginFragment_to_forgotPasswordFragment)
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

    private fun init() {
        val string = getString(R.string.by_connecting_your_account_confirm)
        val text = SpannableString(string)
        val foregroundColor = ForegroundColorSpan(Color.BLACK)

        text.setSpan(
            foregroundColor,
            string.lastIndexOf("Terms"),
            string.length - 1,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.tvTermsAndCondition.text = text
        binding.rememberMeBTN.isChecked = SharedPreferenceHelper.isRememberMe()
    }
}