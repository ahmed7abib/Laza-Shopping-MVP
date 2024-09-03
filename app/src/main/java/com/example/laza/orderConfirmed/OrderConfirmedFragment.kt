package com.example.laza.orderConfirmed


import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.common.BaseFragment
import com.example.laza.LazaSharedViewModel
import com.example.laza.databinding.FragmentOrderConfirmedBinding

class OrderConfirmedFragment :
    BaseFragment<FragmentOrderConfirmedBinding>(FragmentOrderConfirmedBinding::inflate) {

    private val sharedViewModel: LazaSharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        sharedViewModel.hideUnNecessaryView.value = false
    }
}