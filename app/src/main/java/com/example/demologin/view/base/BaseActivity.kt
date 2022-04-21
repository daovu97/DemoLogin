package com.example.demologin.view.base

import android.animation.Animator
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

//        if (navigation?.fragments?.size == 1) {
//            showTabbar(true)
//        } else {
//            showTabbar(lastVisibleTabbar)
//        }
    }

    fun showTabbar(isShow: Boolean) {
        tabbar?.let {
            it.animate()
                .setDuration(200)
                .translationY(if (isShow) 0f else 200f)
                .alpha(if (isShow) 1f else 0.0f)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(p0: Animator?) {

                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        tabbar?.visibility = if (isShow) View.VISIBLE else View.GONE
                    }

                    override fun onAnimationCancel(p0: Animator?) {

                    }

                    override fun onAnimationRepeat(p0: Animator?) {

                    }
                })
                .start()
        }
//        tabbar?.visibility = if (isShow) View.VISIBLE else View.GONE
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
    fragment.isVisibleTabbar = false
    mActivity?.navigation?.push(fragment)
    mActivity?.showTabbar(false)
}