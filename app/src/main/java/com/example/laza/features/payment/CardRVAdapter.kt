package com.example.laza.features.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common.BaseRVAdapter
import com.example.laza.R
import com.example.laza.databinding.ItemListPaymentCardBinding
import com.example.laza.features.payment.models.CARD_TYPE
import com.example.laza.features.payment.models.Card

class CardRVAdapter : BaseRVAdapter<Card, ItemListPaymentCardBinding>(CardCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ItemListPaymentCardBinding {
        return ItemListPaymentCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemListPaymentCardBinding>,
        position: Int
    ) {
        val currentItem = getItem(position)

        holder.binding.apply {
            holderNameId.text = currentItem.cardHolderName
            firstFourDigits.text = currentItem.cardNumber.take(4)
            lastFourDigits.text = currentItem.cardNumber.takeLast(4)
            currentBalanceTVId.text = currentItem.currentBalance

            if (currentItem.cardType == CARD_TYPE.VISA) {
                cardTypeId.setBackgroundResource(R.drawable.visa_icon)
                visaClassicTvId.text = holder.itemView.context.getString(R.string.visa_classic)
            } else {
                cardTypeId.setBackgroundResource(R.drawable.master_card_icon)
                visaClassicTvId.text =
                    holder.itemView.context.getString(R.string.master_card_classic)
            }
        }
    }

    class CardCallback : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem == newItem
        }
    }
}