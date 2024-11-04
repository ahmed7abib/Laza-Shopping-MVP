package com.example.laza.features.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common.BaseRVAdapter
import com.example.laza.databinding.ProductItemBinding
import com.example.laza.home.models.Product

class CartRVAdapter : BaseRVAdapter<Product, ProductItemBinding>(CartCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ProductItemBinding {
        return ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ProductItemBinding>, position: Int) {
        val item = getItem(position)

        holder.binding.apply {
            tvItemTitle.text = item.productTitle
            tvItemPrice.text = item.productPrice
            tvCounter.text = item.productCount.toString()
            ivItemImg.setImageResource(item.image)
        }
    }

    class CartCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}