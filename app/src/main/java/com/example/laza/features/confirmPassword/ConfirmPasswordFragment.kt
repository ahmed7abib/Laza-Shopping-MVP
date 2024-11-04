package com.example.laza.features.confirmPassword


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentConfirmPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmPasswordFragment :
    BaseFragment<FragmentConfirmPasswordBinding>(FragmentConfirmPasswordBinding::inflate) {

    override val viewModel = BaseViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        observer()
    }

    private fun observer() {
        binding.digit1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) binding.digit2.requestFocus()
            }
        })

        binding.digit2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) binding.digit3.requestFocus()
            }
        })

        binding.digit3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) binding.digit4.requestFocus()
            }
        })
    }

    private fun onClick() {
        binding.confirmCodeBTN.setOnClickListener {
            findNavController().navigate(R.id.action_confirmPasswordFragment_to_changePasswordFragment)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}