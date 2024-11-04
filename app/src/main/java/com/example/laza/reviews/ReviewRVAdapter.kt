package com.example.laza.reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.laza.databinding.ItemListReviewsBinding
import com.example.laza.reviews.models.Review

class ReviewRVAdapter : BaseRVAdapter<Review, ItemListReviewsBinding>(ReviewCallback()) {

    override fun getLayoutInflater(parent: ViewGroup): ItemListReviewsBinding {
        return ItemListReviewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemListReviewsBinding>, position: Int) {
        val item = getItem(position)

        holder.binding.dateId.text = item.date
        holder.binding.nameId.text = item.reviewerName
        holder.binding.reviewContentTVID.text = item.review
        holder.binding.ratingValueTVID.text = item.rating.toString()
        holder.binding.ratingBarId.rating = item.rating.toFloat()
        holder.binding.personImgId.setImageResource(item.reviewerImage)
    }

    class ReviewCallback : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }
    }
}