package com.example.laza.signup

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.laza.R
import com.example.laza.databinding.FragmentSignUpBinding

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.signUpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_home)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}