package com.example.laza.home


import android.os.Bundle
import android.view.View
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val newArrivalRVAdapter: NewArrivalRVAdapter by lazy { NewArrivalRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRV()
    }

    private fun setupRV() {
        binding.newArrivalRV.adapter = newArrivalRVAdapter
        newArrivalRVAdapter.submitList(getNewArrivalList())

        newArrivalRVAdapter.listener = { view, item, position ->
            {
                when (view.id) {
                    R.id.favoriteIcon -> {
                        item.isFavorite = !item.isFavorite
                        newArrivalRVAdapter.notifyItemChanged(position)
                    }
                }
            }
        }
    }

    private fun getNewArrivalList(): List<NewArrival> {
        return listOf(
            NewArrival(1, R.drawable.test_img_1, "NIKE Sports Wear Club", "Fleece", "99$"),
            NewArrival(2, R.drawable.test_img_1, "NIKE Sports Wear Club", "Fleece", "99$"),
            NewArrival(3, R.drawable.test_img_1, "NIKE Sports Wear Club", "Fleece", "99$"),
            NewArrival(4, R.drawable.test_img_1, "NIKE Sports Wear Club", "Fleece", "99$")
        )
    }
}