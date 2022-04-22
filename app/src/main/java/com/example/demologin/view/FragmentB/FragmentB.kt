package com.example.demologin.view.FragmentB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demologin.databinding.FragmentBBinding
import com.example.demologin.resource.pushAndHideTabbar
import com.example.demologin.view.base.BaseFragment
import com.example.demologin.view.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentB : BaseFragment<FragmentBViewModel, FragmentBBinding>() {
    override fun makeViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        super.makeViewBinding(inflater, container, savedInstanceState)
        binding = FragmentBBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        super.setupView()
        binding.root.setOnClickListener { navigation?.pop() }

        binding.button.setOnClickListener {
            pushAndHideTabbar(FragmentB())
        }
        binding.button2.setOnClickListener {
            navigation?.pop()
        }

        viewModel.toString()
    }
}

class FragmentBViewModel @Inject constructor() : BaseViewModel() {

}