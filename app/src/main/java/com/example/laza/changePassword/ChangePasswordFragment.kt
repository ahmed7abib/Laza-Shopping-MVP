package com.example.laza.changePassword


import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.LazaSharedViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentChangePasswordBinding

class ChangePasswordFragment :
    BaseFragment<FragmentChangePasswordBinding>(FragmentChangePasswordBinding::inflate) {

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
        binding.confirmPassBtn.setOnClickListener {
            findNavController().navigate(R.id.action_changePasswordFragment_to_loginFragment)
        }
    }
}