package com.example.laza.orderConfirmed


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.laza.R
import com.example.laza.databinding.FragmentOrderConfirmedBinding

class OrderConfirmedFragment :
    BaseFragment<FragmentOrderConfirmedBinding>(FragmentOrderConfirmedBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.confirmOrderBTN.setOnClickListener {
            navigateTo(R.id.action_orderConfirmedFragment_to_homeFragment)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}