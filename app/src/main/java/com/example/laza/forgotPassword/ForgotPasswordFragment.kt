package com.example.laza.forgotPassword


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.confirmEmailBtn.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_confirmPasswordFragment)
        }
    }
}