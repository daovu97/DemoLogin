package com.example.demologin.view.base.tabbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demologin.databinding.CollectionDemoBinding
import com.example.demologin.view.base.BaseFragment
import com.example.demologin.view.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TabbarFragment @Inject constructor(private val fragments: List<Fragment>) : BaseFragment<BaseViewModel, CollectionDemoBinding>() {

    private lateinit var collectionAdapter: CollectionPagerAdapter

    override fun makeViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        super.makeViewBinding(inflater, container, savedInstanceState)
        binding = CollectionDemoBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        super.setupView()
        collectionAdapter = CollectionPagerAdapter(this)
        binding.pager.isSaveEnabled = false
        binding.pager.adapter = collectionAdapter
        collectionAdapter.setUpFragment(fragments = fragments)
    }

    fun setCurrentItem(index: Int, scrollEnable: Boolean = true) {
        binding.pager.setCurrentItem(index, scrollEnable)
    }

}