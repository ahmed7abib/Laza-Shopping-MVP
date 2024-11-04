package com.example.laza.home.ui


import android.os.Bundle
import android.view.View
import com.example.laza.R
import com.example.laza.databinding.FragmentHomeBinding
import com.example.laza.home.BrandRVAdapter
import com.example.laza.home.NewArrivalRVAdapter
import com.example.laza.home.models.Brand
import com.example.laza.home.models.Product


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val brandsRVAdapter: BrandRVAdapter by lazy { BrandRVAdapter() }
    private val newArrivalRVAdapter: NewArrivalRVAdapter by lazy { NewArrivalRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        setupRV()
    }

    private fun onClick() {
        newArrivalRVAdapter.listener = { _, _, _ ->
            navigateTo(R.id.action_homeFragment_to_productDetailsFragment)
        }
    }

    private fun setupRV() {
        binding.newArrivalRV.adapter = newArrivalRVAdapter
        newArrivalRVAdapter.submitList(getNewArrivalList())

        binding.brandsRV.adapter = brandsRVAdapter
        brandsRVAdapter.submitList(getBrandList())
    }

    private fun getBrandList(): List<Brand> {
        return listOf(
            Brand(1, R.drawable.brand_nike, "Nike"),
            Brand(2, R.drawable.brand_adidas, "Adidas"),
            Brand(3, R.drawable.brand_nike, "Nike"),
            Brand(4, R.drawable.brand_adidas, "Adidas")
        )
    }

    private fun getNewArrivalList(): List<Product> {
        return listOf(
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
            )
        )
    }
}