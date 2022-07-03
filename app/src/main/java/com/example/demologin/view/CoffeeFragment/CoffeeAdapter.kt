package com.example.demologin.view.CoffeeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demologin.data.response.Coffee
import com.example.demologin.databinding.ItemCoffeBinding
import com.example.demologin.application.base.BaseSingleAdapter
import javax.inject.Inject

class CoffeeAdapter @Inject constructor() :
    BaseSingleAdapter<CoffeeAdapter.CoffeeViewHolder, Coffee, ItemCoffeBinding>() {

    class CoffeeViewHolder(itemView: ItemCoffeBinding) : RecyclerView.ViewHolder(itemView.root) {
        val binding = itemView
    }

    override fun createViewBinding(parent: ViewGroup, viewType: Int): ItemCoffeBinding {
        return ItemCoffeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun createViewHolder(binding: ItemCoffeBinding): CoffeeViewHolder {
        return CoffeeViewHolder(binding)
    }

    override fun bindingViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.binding.txtCoffee.text = listItem[position]?.title
    }

}