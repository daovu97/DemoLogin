package com.example.demologin.view.CoffeeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demologin.databinding.FragmentCoffeeBinding
import com.example.demologin.view.FragmentB.FragmentB
import com.example.demologin.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoffeeFragment: BaseFragment<CoffeeViewModel, FragmentCoffeeBinding>() {

    override fun makeViewBinding(inflater: LayoutInflater,
                                 container: ViewGroup?,
                                 savedInstanceState: Bundle?) {
        super.makeViewBinding(inflater, container, savedInstanceState)
        binding = FragmentCoffeeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        super.setupView()

        binding.root.setOnClickListener {
            navigation?.push(FragmentB())
        }
    }
}