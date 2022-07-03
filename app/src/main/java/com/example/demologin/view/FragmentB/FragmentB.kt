package com.example.demologin.view.FragmentB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.demologin.databinding.FragmentBBinding
import com.example.demologin.resource.pushAndHideTabbar
import com.example.demologin.application.base.BaseFragment
import com.example.demologin.application.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class FragmentB : BaseFragment<FragmentBViewModel, FragmentBBinding>() {

    override val viewModel: FragmentBViewModel by viewModels()

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

@HiltViewModel
class FragmentBViewModel @Inject constructor() : BaseViewModel() {

}