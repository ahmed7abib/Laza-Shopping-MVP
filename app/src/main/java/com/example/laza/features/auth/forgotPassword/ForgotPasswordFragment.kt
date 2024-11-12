package com.example.laza.features.auth.forgotPassword


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common.ui.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentForgotPasswordBinding
import com.example.laza.utils.AppKeys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {

    override val viewModel: ForgetPassViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        observer()
    }

    private fun observer() {
        viewModel.emailSent.observe(viewLifecycleOwner) {
            if (it) {
                val bundle = Bundle()
                bundle.putString(AppKeys.EMAIL, binding.etEmail.text.toString())
                navigateToWithBundle(
                    R.id.action_forgotPasswordFragment_to_confirmPasswordFragment,
                    bundle
                )
            }
        }
    }

    private fun onClick() {
        binding.confirmEmailBtn.setOnClickListener {
            viewModel.sendOtp(email = binding.etEmail.text.toString())
        }

        binding.buttonBack.setOnClickListener {
            popBackStack()
        }
    }
}