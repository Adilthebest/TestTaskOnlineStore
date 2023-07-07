package com.example.testtaskonlinestore.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testtaskonlinestore.data.model.ProductsItem
import com.example.testtaskonlinestore.databinding.ItemBinding

class Adapter(val onClickItem:(ProductsItem)->Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list = listOf<ProductsItem>()

  inner  class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productsItem: ProductsItem) = with(binding) {
            img.load(productsItem.image)
            text.text = productsItem.title
            price.text = "$${productsItem.price}"
            itemView.setOnClickListener {
                onClickItem(productsItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setContentList(list: List<ProductsItem>) {
        this.list = list
        notifyDataSetChanged()
    }
}