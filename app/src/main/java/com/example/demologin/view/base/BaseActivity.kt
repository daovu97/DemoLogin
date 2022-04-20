package com.example.demologin.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

interface NavigationWrap {
    var navigation: Navigation?
}

open class BaseActivity<V : BaseViewModel, B : ViewBinding> : AppCompatActivity(), NavigationWrap {

    @Inject
    lateinit var viewModel: V

    lateinit var binding: B

    override var navigation: Navigation? = null

    open fun makeViewBinding() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeViewBinding()
        setContentView(binding.root)
        onCreated(savedInstanceState)

    }

    open fun onCreated(savedInstanceState: Bundle?) {}
}