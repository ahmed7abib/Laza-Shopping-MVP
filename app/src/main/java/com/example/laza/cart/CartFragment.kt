package com.example.laza.cart

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.laza.R
import com.example.laza.databinding.FragmentCartBinding
import com.example.laza.home.models.Product

class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {

    private val cartRVAdapter by lazy { CartRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        setupRV()
    }

    private fun onClick() {
        binding.checkoutBTN.setOnClickListener {
            navigateTo(R.id.action_cartFragment_to_orderConfirmedFragment)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupRV() {
        binding.ordersRV.adapter = cartRVAdapter
        cartRVAdapter.submitList(getOrders())
    }

    private fun getOrders() = listOf(
        Product(
            1,
            R.drawable.new_arrival_1,
            "NIKE Sports Wear Club",
            "Fleece",
            "99$",
            productCount = 2
        ),
        Product(
            2,
            R.drawable.new_arrival_2,
            "NIKE Sports Wear Club",
            "Fleece",
            "99$",
            productCount = 1
        )
    )
}