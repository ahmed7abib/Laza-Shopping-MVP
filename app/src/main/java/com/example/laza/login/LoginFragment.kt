package com.example.laza.login

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
    }

    private fun onClick() {
        binding.loginBTN.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_dashboard_nav_graph)
        }

        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
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
    }
}