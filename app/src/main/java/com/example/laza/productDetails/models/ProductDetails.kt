package com.example.laza.productDetails.models

import com.example.laza.home.models.Brand
import com.example.laza.home.models.Product
import com.example.laza.reviews.models.Review

data class ProductDetails(
    val fullDescription: String,
    val product: Product,
    val brand: Brand,
    val cuts: List<Int>,
    val sizes: List<String>,
    val reviews: List<Review>
)