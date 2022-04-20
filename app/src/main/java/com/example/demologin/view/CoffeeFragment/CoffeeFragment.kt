package com.example.demologin.view.CoffeeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.demologin.databinding.FragmentCoffeeBinding
import com.example.demologin.resource.setupLoadMore
import com.example.demologin.view.FragmentB.FragmentB
import com.example.demologin.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CoffeeFragment : BaseFragment<CoffeeViewModel, FragmentCoffeeBinding>() {

    @Inject
    lateinit var adapter: CoffeeAdapter

    override fun makeViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        super.makeViewBinding(inflater, container, savedInstanceState)
        binding = FragmentCoffeeBinding.inflate(inflater, container, false)
    }

    var isLoading: Boolean = false

    override fun setupView() {
        super.setupView()
        binding.rvCoffee.adapter = adapter
        binding.btnNext.setOnClickListener {
            navigation?.push(FragmentB(), "B")
        }

        viewModel.coffees.observe(this, Observer {
            isLoading = false
            if (adapter.listItem.isEmpty()) {
                adapter.setupData(it)
            } else {
                adapter.appendWhenLoadMore(it)
            }
        })

        viewModel.getCoffee()

        binding.rvCoffee.setupLoadMore {
            if (!isLoading) {
                adapter.loadMore()
                viewModel.getCoffee(true)
                isLoading = true
            }
        }
    }
}