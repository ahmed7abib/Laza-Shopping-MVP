package com.example.laza.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common.BaseRVAdapter
import com.example.laza.databinding.ItemListNewArrivalBinding

class NewArrivalRVAdapter : BaseRVAdapter<NewArrival, ItemListNewArrivalBinding>(DiffCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ItemListNewArrivalBinding {
        return ItemListNewArrivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemListNewArrivalBinding>,
        position: Int
    ) {
        val currentItem = getItem(position)

        holder.binding.image.setBackgroundResource(currentItem.image)
        holder.binding.nameId.text = currentItem.productName
        holder.binding.descId.text = currentItem.productDescription
        holder.binding.priceId.text = currentItem.productPrice

        holder.binding.favoriteIcon.setOnClickListener {
            listener?.invoke(it, currentItem, position)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<NewArrival>() {
    override fun areItemsTheSame(oldItem: NewArrival, newItem: NewArrival): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewArrival, newItem: NewArrival): Boolean {
        return oldItem == newItem
    }
}
