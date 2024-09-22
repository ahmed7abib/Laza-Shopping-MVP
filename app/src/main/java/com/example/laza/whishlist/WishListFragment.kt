package com.example.laza.whishlist


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentWishListBinding
import com.example.laza.home.NewArrivalRVAdapter
import com.example.laza.home.models.Product

class WishListFragment : BaseFragment<FragmentWishListBinding>(FragmentWishListBinding::inflate) {

    private val wishListAdapter: NewArrivalRVAdapter by lazy { NewArrivalRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
        setupRV()
    }

    private fun onClick() {
        wishListAdapter.listener = { _, _, _ ->
            navigateTo(R.id.action_wishListFragment_to_productDetailsFragment)
        }

        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun init() {
        binding.itemsCountValueTV.text = getFvList().size.toString()
    }

    private fun setupRV() {
        binding.wishRv.adapter = wishListAdapter
        wishListAdapter.submitList(getFvList())
    }

    private fun getFvList() = listOf(
        Product(
            1,
            R.drawable.new_arrival_1,
            "NIKE Sports Wear Club",
            "Fleece",
            "99$"
        ),
        Product(
            2,
            R.drawable.new_arrival_2,
            "Trail Running Jacket Nike",
            "Wind runner",
            "99$"
        ),
        Product(
            3,
            R.drawable.new_arrival_1,
            "NIKE Sports Wear Club",
            "Fleece",
            "99$"
        ),
        Product(
            4,
            R.drawable.new_arrival_2,
            "Trail Running Jacket Nike",
            "Wind runner",
            "99$"
        ), Product(
            5,
            R.drawable.new_arrival_1,
            "NIKE Sports Wear Club",
            "Fleece",
            "99$"
        ),
        Product(
            6,
            R.drawable.new_arrival_2,
            "Trail Running Jacket Nike",
            "Wind runner",
            "99$"
        ),
        Product(
            7,
            R.drawable.new_arrival_1,
            "NIKE Sports Wear Club",
            "Fleece",
            "99$"
        ),
        Product(
            8,
            R.drawable.new_arrival_2,
            "Trail Running Jacket Nike",
            "Wind runner",
            "99$"
        )
    )
}