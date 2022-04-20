package com.example.demologin.view.main

import android.os.Bundle
import com.example.demologin.R
import com.example.demologin.databinding.ActivityMainBinding
import com.example.demologin.view.CoffeeFragment.CoffeeFragment
import com.example.demologin.view.base.BaseActivity
import com.example.demologin.view.base.MainNavigation
import com.example.demologin.view.base.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override var navigation: Navigation? = MainNavigation(this, R.id.rootView)

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreated(savedInstanceState)

        navigation?.push(CoffeeFragment(), "A")
    }

    override fun makeViewBinding() {
        super.makeViewBinding()
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}