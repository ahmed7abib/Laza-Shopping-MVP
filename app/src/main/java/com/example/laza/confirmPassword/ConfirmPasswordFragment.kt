package com.example.laza.confirmPassword


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.LazaSharedViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentConfirmPasswordBinding

class ConfirmPasswordFragment :
    BaseFragment<FragmentConfirmPasswordBinding>(FragmentConfirmPasswordBinding::inflate) {

    private val sharedViewModel: LazaSharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
        observer()
    }

    private fun init() {
        sharedViewModel.hideUnNecessaryView(true)
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
    }
}