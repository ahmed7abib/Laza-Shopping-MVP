package com.example.laza.features.payment.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.R
import com.example.laza.databinding.FragmentPaymentBinding
import com.example.laza.features.payment.CardRVAdapter
import com.example.laza.features.payment.models.CARD_TYPE
import com.example.laza.features.payment.models.Card
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentFragment : BaseFragment<FragmentPaymentBinding>(FragmentPaymentBinding::inflate) {

    override val viewModel = BaseViewModel()

    private val cardRVAdapter by lazy { CardRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        setupRv()
    }

    private fun onClick() {
        binding.addNewCardBtn.setOnClickListener {
            navigateTo(R.id.action_paymentFragment_to_addNewCardFragment)
        }

        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupRv() {
        binding.cardsRV.adapter = cardRVAdapter
        cardRVAdapter.submitList(getCards())
    }

    private fun getCards() = listOf(
        Card(
            id = 1,
            cardNumber = "123456789123456",
            cardHolderName = "Ahmed Habib",
            cardType = CARD_TYPE.MASTERCARD,
            currentBalance = "50.000"
        ), Card(
            id = 2,
            cardNumber = "123456789123456",
            cardHolderName = "Ahmed Habib",
            cardType = CARD_TYPE.VISA,
            currentBalance = "50.000"
        ), Card(
            id = 3,
            cardNumber = "123456789123456",
            cardHolderName = "Ahmed Habib",
            cardType = CARD_TYPE.MASTERCARD,
            currentBalance = "50.000"
        ), Card(
            id = 4,
            cardNumber = "123456789123456",
            cardHolderName = "Ahmed Habib",
            cardType = CARD_TYPE.VISA,
            currentBalance = "50.000"
        )
    )
}