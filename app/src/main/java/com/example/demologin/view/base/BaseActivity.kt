package com.example.demologin.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.demologin.resource.customView.ProgressView
import javax.inject.Inject

open class BaseActivity<V : BaseViewModel, B : ViewBinding> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: V

    lateinit var binding: B

    open var navigation: Navigation? = null

    @Inject
    lateinit var progress: ProgressView

    open fun makeViewBinding() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeViewBinding()
        setContentView(binding.root)
        onCreated(savedInstanceState)
    }

    open fun onCreated(savedInstanceState: Bundle?) {}

    override fun onBackPressed() {
        if (navigation == null || navigation?.fragments?.count() == 1) {
            finish()
        } else {
            navigation?.fragments?.removeLast()
            super.onBackPressed()
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