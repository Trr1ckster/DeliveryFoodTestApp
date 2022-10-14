package com.trr1ckster.deliveryfoodtestapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trr1ckster.deliveryfoodtestapp.data.model.Pizza
import com.trr1ckster.deliveryfoodtestapp.databinding.ItemFoodBinding

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    val differ = AsyncListDiffer(this, ItemCallBack)

    object ItemCallBack : DiffUtil.ItemCallback<Pizza>() {
        override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val pizza = differ.currentList[position]
        holder.binding.apply {
            title.text = pizza.name
            description.text = pizza.dsc
            price.text = pizza.price.toInt().toString()
        }
        holder.itemView.apply {
            Glide.with(this).load(pizza.img).into(holder.binding.imageFood)
        }

    }

    override fun getItemCount() = differ.currentList.size
}
