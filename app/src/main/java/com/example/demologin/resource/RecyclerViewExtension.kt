package com.example.demologin.resource

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setupLoadMore(completion: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
            if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (adapter?.itemCount
                    ?: 2) - 2
            ) {
                completion()
            }
        }
    })
}