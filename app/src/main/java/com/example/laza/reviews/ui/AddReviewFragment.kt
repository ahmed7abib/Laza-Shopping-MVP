package com.example.laza.reviews.ui

import android.os.Bundle
import android.view.View
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentAddReviewBinding


class AddReviewFragment :
    BaseFragment<FragmentAddReviewBinding>(FragmentAddReviewBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.submitReviewBtn.setOnClickListener {
            navigateTo(R.id.action_addReviewFragment_to_homeFragment)
        }
    }
}