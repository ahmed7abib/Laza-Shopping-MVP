package com.example.laza.features.auth.confirmPassword


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common.ui.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentConfirmPasswordBinding
import com.example.laza.utils.AppKeys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmPasswordFragment :
    BaseFragment<FragmentConfirmPasswordBinding>(FragmentConfirmPasswordBinding::inflate) {

    override val viewModel: ConfirmPassViewModel by viewModels()

    private var email = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
        observer()
        textWatchers()
    }

    private fun init() {
        email = arguments?.getString(AppKeys.EMAIL, "").orEmpty()
    }

    private fun observer() {
        viewModel.confirmedOtp.observe(viewLifecycleOwner) {
            if (it) {
                val bundle = Bundle()
                bundle.putString(AppKeys.EMAIL, email)
                navigateToWithBundle(
                    R.id.action_confirmPasswordFragment_to_changePasswordFragment,
                    bundle
                )
            }
        }
    }

    private fun onClick() {
        binding.confirmCodeBTN.setOnClickListener {
            viewModel.confirmOtp(email, getOtp())
        }

        binding.buttonBack.setOnClickListener {
            popBackStack()
        }
    }

    private fun getOtp(): String {
        val digit1 = binding.digit1.text.toString()
        val digit2 = binding.digit2.text.toString()
        val digit3 = binding.digit3.text.toString()
        val digit4 = binding.digit4.text.toString()
        val digit5 = binding.digit5.text.toString()
        val digit6 = binding.digit6.text.toString()
        return digit1 + digit2 + digit3 + digit4 + digit5 + digit6
    }

    private fun textWatchers() {
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

        binding.digit4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) binding.digit5.requestFocus()
            }
        })

        binding.digit5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) binding.digit6.requestFocus()
            }
        })
    }
}