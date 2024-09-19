package com.example.laza.reviews.models

data class Review(
    val id: Int,
    val reviewerName: String,
    val reviewerImage: Int,
    val rating: Double,
    val review: String,
    val date: String
)