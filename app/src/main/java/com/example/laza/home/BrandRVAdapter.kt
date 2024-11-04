package com.example.laza.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.laza.databinding.ItemListBrandsBinding
import com.example.laza.home.models.Brand

class BrandRVAdapter : BaseRVAdapter<Brand, ItemListBrandsBinding>(BrandCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ItemListBrandsBinding {
        return ItemListBrandsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemListBrandsBinding>, position: Int) {
        val currentItem = getItem(position)

        holder.binding.brandIconId.setBackgroundResource(currentItem.image)
        holder.binding.brandNameId.text = currentItem.name
    }

    class BrandCallback : DiffUtil.ItemCallback<Brand>() {
        override fun areItemsTheSame(oldItem: Brand, newItem: Brand): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Brand, newItem: Brand): Boolean {
            return oldItem == newItem
        }
    }
}