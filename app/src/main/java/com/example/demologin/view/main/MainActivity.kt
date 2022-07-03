package com.example.demologin.view.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.demologin.R
import com.example.demologin.databinding.ActivityMainTabbarBinding
import com.example.demologin.view.CoffeeFragment.CoffeeFragment
import com.example.demologin.view.FragmentB.FragmentB
import com.example.demologin.application.base.*
import com.example.demologin.application.base.tabbar.TabbarFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainTabbarBinding>() {
    
    private lateinit var  tabbarFragment: TabbarFragment

    override val viewModel: MainViewModel by viewModels()

    override fun setupView(savedInstanceState: Bundle?) {
        super.setupView(savedInstanceState)
        tabbarFragment = TabbarFragment(listOf(CoffeeFragment(), FragmentB()))
        navigation = MainNavigation(this, R.id.rootView,
            tabbarFragment
        )
        tabbar = binding.linearLayout
    }

    override fun makeViewBinding() {
        super.makeViewBinding()
        binding = ActivityMainTabbarBinding.inflate(layoutInflater)

        binding.btn1.setOnClickListener {
            tabbarFragment.setCurrentItem(0)
        }
        binding.btn2.setOnClickListener {
            tabbarFragment.setCurrentItem(1)
        }
    }
}




