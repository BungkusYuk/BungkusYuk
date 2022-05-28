package com.example.segarbox.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.segarbox.R
import com.example.segarbox.data.remote.response.ProductItem
import com.example.segarbox.databinding.ItemRowMainBinding
import com.example.segarbox.helper.formatToRupiah

class AllProductAdapter: ListAdapter<ProductItem, AllProductAdapter.AllProductViewHolder>(DiffCallbackAllProduct) {
    inner class AllProductViewHolder(var binding: ItemRowMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllProductViewHolder {
        val binding = ItemRowMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllProductViewHolder, position: Int) {
        val context = holder.binding.root.context
        val item = getItem(position)

        holder.binding.apply {
            item?.let {
                Glide.with(context)
                    .load(R.drawable.cauliflowers)
                    .into(imageView)

                tvName.text = it.label
                tvPrice.text = it.price.formatToRupiah()
                tvQty.text = it.qty.toString()
            }

        }

    }
}