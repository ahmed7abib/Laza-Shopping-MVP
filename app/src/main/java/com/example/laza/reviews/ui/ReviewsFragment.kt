package com.example.laza.reviews.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentReviewsBinding
import com.example.laza.reviews.ReviewRVAdapter
import com.example.laza.reviews.models.Review

class ReviewsFragment : BaseFragment<FragmentReviewsBinding>(FragmentReviewsBinding::inflate) {

    private val reviewRVAdapter: ReviewRVAdapter by lazy { ReviewRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
        setupRV()
    }

    private fun init() {
        val allReviews = getReviews().size
        val rating = getReviews().map { it.rating }.average()

        binding.ratingBarId.rating = rating.toFloat()
        binding.ratingValueTVID.text = rating.toString()
        binding.reviewsCountTVID.text = allReviews.toString()
    }

    private fun setupRV() {
        binding.revRV.adapter = reviewRVAdapter
        reviewRVAdapter.submitList(getReviews())
    }

    private fun onClick() {
        binding.addReviewId.setOnClickListener {
            navigateTo(R.id.action_reviewsFragment_to_addReviewFragment)
        }

        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getReviews() = listOf(
        Review(
            id = 1,
            date = "13 Sep, 2024",
            reviewerName = "Ahmed Habib",
            reviewerImage = R.drawable.test_person_img,
            rating = 4.5,
            review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque malesuada eget vitae amet..."
        ),
        Review(
            id = 1,
            date = "13 Sep, 2024",
            reviewerName = "Ahmed Habib",
            reviewerImage = R.drawable.test_person_img,
            rating = 3.5,
            review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque malesuada eget vitae amet..."
        ),
        Review(
            id = 1,
            date = "13 Sep, 2024",
            reviewerName = "Ahmed Habib",
            reviewerImage = R.drawable.test_person_img,
            rating = 1.5,
            review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque malesuada eget vitae amet..."
        ),
        Review(
            id = 1,
            date = "13 Sep, 2024",
            reviewerName = "Ahmed Habib",
            reviewerImage = R.drawable.test_person_img,
            rating = 2.1,
            review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque malesuada eget vitae amet..."
        )
    )
}