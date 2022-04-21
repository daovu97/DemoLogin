package com.example.demologin.view.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.demologin.resource.customView.ProgressView
import javax.inject.Inject

open class BaseActivity<V : BaseViewModel, B : ViewBinding> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: V

    @Inject
    lateinit var progress: ProgressView

    lateinit var binding: B

    var navigation: Navigation? = null

    var tabbar: View? = null

    var lastVisibleTabbar: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeViewBinding()
        setContentView(binding.root)
        setupView(savedInstanceState)
    }

    open fun makeViewBinding() {}

    open fun setupView(savedInstanceState: Bundle?) {}

    override fun onBackPressed() {
        if (navigation == null || navigation?.fragments?.size == 1) {
            finish()
        } else {
            navigation?.fragments?.removeLast()
            super.onBackPressed()
        }

        if (navigation?.fragments?.size == 1) {
            tabbar?.visibility = View.VISIBLE
        } else {
            tabbar?.visibility = if (lastVisibleTabbar) View.VISIBLE else View.GONE
        }
    }

    fun showProgress(isShow: Boolean) {
        if (isShow) {
            progress.show(supportFragmentManager, "")
        } else {
            progress.dismiss()
        }
    }
}

fun MyFragment.pushAndHideTabbar(fragment: MyFragment) {
    mActivity?.lastVisibleTabbar = mActivity?.tabbar?.visibility == View.VISIBLE
    mActivity?.navigation?.push(fragment)
    mActivity?.tabbar?.visibility = View.GONE
}