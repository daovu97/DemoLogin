package com.example.demologin.application.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.demologin.resource.customView.ProgressView
import com.example.demologin.resource.setComplete
import javax.inject.Inject

abstract class BaseActivity<V : BaseViewModel, B : ViewBinding> : AppCompatActivity() {

    abstract val viewModel: V

    @Inject
    lateinit var progress: ProgressView

    lateinit var binding: B

    var navigation: Navigation? = null

    var tabbar: View? = null

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
    }

    fun showTabbar(isShow: Boolean) {
        tabbar?.animate()
            ?.setDuration(400)?.translationY(if (isShow) 0f else 200f)
            ?.alpha(if (isShow) 1f else 0.0f)
            ?.setComplete {
                tabbar?.visibility = if (isShow) View.VISIBLE else View.GONE
            }?.start()
    }

    fun showProgress(isShow: Boolean) {
        if (isShow) {
            progress.show(supportFragmentManager, "")
        } else {
            progress.dismiss()
        }
    }
}
