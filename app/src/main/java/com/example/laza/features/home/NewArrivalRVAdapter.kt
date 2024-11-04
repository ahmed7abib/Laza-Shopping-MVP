package com.example.laza.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common.BaseRVAdapter
import com.example.laza.databinding.ItemListNewArrivalBinding
import com.example.laza.home.models.Product

class NewArrivalRVAdapter : BaseRVAdapter<Product, ItemListNewArrivalBinding>(DiffCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ItemListNewArrivalBinding {
        return ItemListNewArrivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemListNewArrivalBinding>,
        position: Int
    ) {
        val currentItem = getItem(position)

        holder.binding.image.setBackgroundResource(currentItem.image)
        holder.binding.nameId.text = currentItem.productTitle
        holder.binding.descId.text = currentItem.productSubDes
        holder.binding.priceId.text = currentItem.productPrice

        holder.binding.root.setOnClickListener {
            listener?.invoke(it, currentItem, position)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
