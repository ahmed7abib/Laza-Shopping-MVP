package com.example.laza.features.changePassword


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentChangePasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordFragment :
    BaseFragment<FragmentChangePasswordBinding>(FragmentChangePasswordBinding::inflate) {

    override val viewModel = BaseViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.confirmPassBtn.setOnClickListener {
            findNavController().navigate(R.id.action_changePasswordFragment_to_loginFragment)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}