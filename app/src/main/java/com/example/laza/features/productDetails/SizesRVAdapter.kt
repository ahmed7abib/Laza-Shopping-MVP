package com.example.laza.features.productDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common.BaseRVAdapter
import com.example.laza.databinding.ItemListProductSizesBinding

class SizesRVAdapter : BaseRVAdapter<String, ItemListProductSizesBinding>(SizesCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ItemListProductSizesBinding {
        return ItemListProductSizesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemListProductSizesBinding>,
        position: Int
    ) {
        val size = getItem(position)
        holder.binding.sizeId.text = size
    }

    class SizesCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}