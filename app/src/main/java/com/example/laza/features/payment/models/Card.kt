package com.example.laza.features.payment.models

data class Card(
    val id: Int,
    val cardHolderName: String,
    val cardNumber: String,
    val cardType: CARD_TYPE,
    val currentBalance: String
)

enum class CARD_TYPE(val type: String) {
    VISA("VISA"),
    MASTERCARD("MASTERCARD")
}