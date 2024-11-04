package com.example.laza.features.payment.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentAddNewCardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNewCardFragment :
    BaseFragment<FragmentAddNewCardBinding>(FragmentAddNewCardBinding::inflate) {

    override val viewModel = BaseViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.addCardBtn.setOnClickListener {
            navigateTo(R.id.action_addNewCardFragment_to_homeFragment)
        }

        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}