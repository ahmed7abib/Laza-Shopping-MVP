package com.example.laza.productDetails.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentProductDetailsBinding
import com.example.laza.home.models.Brand
import com.example.laza.home.models.Product
import com.example.laza.productDetails.CutsRVAdapter
import com.example.laza.productDetails.models.ProductDetails
import com.example.laza.productDetails.SizesRVAdapter
import com.example.laza.reviews.models.Review
import com.example.laza.reviews.ReviewRVAdapter


class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    private val cutsRVAdapter: CutsRVAdapter by lazy { CutsRVAdapter() }
    private val sizesRVAdapter: SizesRVAdapter by lazy { SizesRVAdapter() }
    private val reviewRVAdapter: ReviewRVAdapter by lazy { ReviewRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        onClick()
        setupRV()
    }

    private fun init() {
        val productDetails = getProductDetails()

        binding.fullImageId.setBackgroundResource(productDetails.product.image)
        binding.brandImgId.setBackgroundResource(productDetails.brand.image)
        binding.productName.text = productDetails.product.productTitle
        binding.productPriceValueId.text = productDetails.product.productPrice
        binding.productDescId.text = productDetails.product.productSubDes
        binding.descContentTVId.text = productDetails.fullDescription
        binding.totalPriceValueId.text = productDetails.product.productPrice
    }

    private fun setupRV() {
        binding.reviewsRV.adapter = reviewRVAdapter
        reviewRVAdapter.submitList(listOf(getProductDetails().reviews[0]))

        binding.productCutsRv.adapter = cutsRVAdapter
        cutsRVAdapter.submitList(getProductDetails().cuts)

        binding.productSizesRV.adapter = sizesRVAdapter
        sizesRVAdapter.submitList(getProductDetails().sizes)
    }

    private fun onClick() {
        binding.viewAllReviewsTVId.setOnClickListener {
            navigateTo(R.id.action_productDetailsFragment_to_reviewsFragment)
        }

        binding.addToChartBtn.setOnClickListener {
            navigateTo(R.id.action_productDetailsFragment_to_homeFragment)
        }

        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getProductDetails() = ProductDetails(
        product = Product(
            1,
            R.drawable.new_arrival_1,
            "NIKE Sports Wear Club",
            "Fleece",
            "99$"
        ),
        brand = Brand(1, R.drawable.brand_nike, "Nike"),
        cuts = listOf(
            R.drawable.new_arrival_1,
            R.drawable.new_arrival_1,
            R.drawable.new_arrival_1,
            R.drawable.new_arrival_1
        ),
        sizes = listOf("M", "L", "XL", "2XL", "3XL"),
        fullDescription = "The Nike Throwback Pullover Hoodie is made from premium French terry fabric that blends a performance feel with..",
        reviews = listOf(
            Review(
                id = 1,
                date = "13 Sep, 2024",
                reviewerName = "Ahmed Habib",
                reviewerImage = R.drawable.test_person_img,
                rating = 4.5,
                review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque malesuada eget vitae amet..."
            )
        )
    )
}