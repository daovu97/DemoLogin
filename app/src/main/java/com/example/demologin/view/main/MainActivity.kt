package com.example.demologin.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.demologin.R
import com.example.demologin.databinding.ActivityMainBinding
import com.example.demologin.databinding.ActivityMainTabbarBinding
import com.example.demologin.databinding.CollectionDemoBinding
import com.example.demologin.databinding.FragmentCoffeeBinding
import com.example.demologin.view.CoffeeFragment.CoffeeFragment
import com.example.demologin.view.FragmentB.FragmentB
import com.example.demologin.view.base.*
import com.example.demologin.view.base.tabbar.TabbarFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainTabbarBinding>() {

    private lateinit var  tabbarFragment: TabbarFragment
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




