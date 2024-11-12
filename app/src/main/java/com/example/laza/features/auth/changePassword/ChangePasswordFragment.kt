package com.example.laza.features.auth.changePassword


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common.ui.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentChangePasswordBinding
import com.example.laza.utils.AppKeys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordFragment :
    BaseFragment<FragmentChangePasswordBinding>(FragmentChangePasswordBinding::inflate) {

    override val viewModel: ResetPassViewModel by viewModels()

    private var email = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
        observer()
    }

    private fun observer() {
        viewModel.passChanged.observe(viewLifecycleOwner) {
            if (it) {
                navigateTo(R.id.action_changePasswordFragment_to_loginFragment)
            }
        }
    }

    private fun init() {
        email = arguments?.getString(AppKeys.EMAIL, "").orEmpty()
    }

    private fun onClick() {
        binding.confirmPassBtn.setOnClickListener {
            viewModel.resetPass(
                email,
                binding.etPassword.text.toString(),
                binding.etConfirmPassword.text.toString()
            )
        }

        binding.buttonBack.setOnClickListener {
            popBackStack()
        }
    }
}