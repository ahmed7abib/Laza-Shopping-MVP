package com.example.laza.forgotPassword


import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.LazaSharedViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {

    private val sharedViewModel: LazaSharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
    }

    private fun init() {
        sharedViewModel.hideUnNecessaryView(true)
    }

    private fun onClick() {
        binding.confirmEmailBtn.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_confirmPasswordFragment)
        }
    }
}