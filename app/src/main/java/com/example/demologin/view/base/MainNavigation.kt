package com.example.demologin.view.base

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.demologin.R
import com.example.demologin.view.main.TabbarFragment
import javax.inject.Inject

class MainNavigation constructor(
    val activity: AppCompatActivity,
    @IdRes var containerID: Int,
    root: MyFragment
) : Navigation {

    private val ROOT_TAG = "${this::class.java.simpleName}_Root"
    private var fragmentManager: FragmentManager
    override var fragments: MutableList<MyFragment> = mutableListOf()

    init {
        fragmentManager = activity.supportFragmentManager
        fragments = mutableListOf()
        setRoot(root)
    }

    override fun push(fragment: MyFragment, tag: String?, withAnimation: Boolean) {
        tag?.let { fragment.myTag = it }
        fragments.add(fragment)
        val transaction = fragmentManager.beginTransaction()
        if (withAnimation) {
            transaction
                .setCustomAnimations(
                    R.anim.from_right, R.anim.to_left,
                    R.anim.from_left, R.anim.to_right
                )
        }
        transaction
            .replace(containerID, fragment)
            .addToBackStack(tag)
            .commit()
    }

    override fun pop(tag: String?) {
        if (tag != null) {
            val index = fragments.indexOfFirst { it.myTag == tag }
            if (fragments[index] is TabbarFragment) {
                (activity as? BaseActivity<*, *>)?.tabbar?.visibility = View.VISIBLE
            }
            fragments.removeAll(fragments.subList(index + 1, fragments.size - 1))
            fragmentManager.popBackStack(tag, 0)

            return
        }
        activity.onBackPressed()
    }

    override fun setRoot(fragment: MyFragment) {
        fragments.clear()
        fragmentManager.popBackStackImmediate(0, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        push(fragment, ROOT_TAG, false)
        if (fragment is TabbarFragment) {
            (activity as? BaseActivity<*, *>)?.tabbar?.visibility = View.VISIBLE
        } else {
            (activity as? BaseActivity<*, *>)?.tabbar?.visibility = View.GONE
        }
    }

    override fun popToRoot() {
        pop(ROOT_TAG)
    }
}