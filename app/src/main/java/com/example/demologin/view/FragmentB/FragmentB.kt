package com.example.demologin.view.FragmentB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demologin.databinding.FragmentBBinding
import com.example.demologin.databinding.FragmentCoffeeBinding
import com.example.demologin.view.base.BaseFragment
import com.example.demologin.view.base.BaseViewModel

class FragmentB: BaseFragment<BaseViewModel, FragmentBBinding>() {
    override fun makeViewBinding(inflater: LayoutInflater,
                                 container: ViewGroup?,
                                 savedInstanceState: Bundle?) {
        super.makeViewBinding(inflater, container, savedInstanceState)
        binding = FragmentBBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        super.setupView()
        binding.root.setOnClickListener {  navigation?.pop() }

        binding.button.setOnClickListener {
            navigation?.push(FragmentB(), "C")
        }
        binding.button2.setOnClickListener {
            navigation?.pop("A")
        }
    }
}