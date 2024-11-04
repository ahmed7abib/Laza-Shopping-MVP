package com.example.laza.features.productDetails.models

import com.example.laza.features.home.models.Brand
import com.example.laza.features.home.models.Product
import com.example.laza.features.reviews.models.Review


data class ProductDetails(
    val fullDescription: String,
    val product: Product,
    val brand: Brand,
    val cuts: List<Int>,
    val sizes: List<String>,
    val reviews: List<Review>
)