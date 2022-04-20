package com.example.demologin.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

open class BaseFragment<V : BaseViewModel, B : ViewBinding> : Fragment() {

    @Inject
    lateinit var viewModel: V

    lateinit var binding: B

    private var view: ViewBinding? = null

    var navigation: Navigation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigation = (activity as? BaseActivity<*, *>)?.navigation

        viewModel.isShowProgress.observe(this, Observer { isShow ->
            (activity as? BaseActivity<*, *>)?.showProgress(isShow)
        })
    }

    open fun setupView() {}

    open fun makeViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (view == null) {
            makeViewBinding(inflater, container, savedInstanceState)
            view = binding
        }

        return this.view!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }
}