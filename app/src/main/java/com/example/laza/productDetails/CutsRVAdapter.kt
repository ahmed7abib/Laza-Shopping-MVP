package com.example.laza.productDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.laza.databinding.ItemListProductCutsBinding

class CutsRVAdapter : BaseRVAdapter<Int, ItemListProductCutsBinding>(CutsCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ItemListProductCutsBinding {
        return ItemListProductCutsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemListProductCutsBinding>,
        position: Int
    ) {
        val item = getItem(position)
        holder.binding.productImg.setImageResource(item)
    }

    class CutsCallback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }
}