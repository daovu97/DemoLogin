package com.example.demologin.view.CoffeeFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.demologin.data.response.Coffee
import com.example.demologin.databinding.FragmentCoffeeBinding
import com.example.demologin.databinding.ItemCoffeBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

abstract class BaseRecyclerAdapter<T: RecyclerView.ViewHolder, E, B: ViewBinding>():  RecyclerView.Adapter<T>() {

    var listItem: List<E> = emptyList()

    fun setupData(list: List<E>) {
        listItem = list
        notifyDataSetChanged()
    }

    abstract fun createViewBinding(parent: ViewGroup, viewType: Int) : B
    abstract fun createViewHolder(binding: B): T
    abstract fun bindingViewHolder(holder: T, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        val binding = createViewBinding(parent, viewType)

        return createViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        bindingViewHolder(holder, position)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}

class CoffeeAdapter @Inject constructor(): BaseRecyclerAdapter<CoffeeAdapter.CoffeeViewHolder, Coffee, ItemCoffeBinding>() {

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
        holder.binding.txtCoffee.text = listItem[position].title
    }

}