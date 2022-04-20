package com.example.demologin.view.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.demologin.R
import javax.inject.Inject

class MainNavigation constructor(
    val activity: AppCompatActivity,
    @IdRes var containerID: Int
) : Navigation {

    override var fragments: MutableList<Fragment> = mutableListOf()

    private val fragmentManager: FragmentManager by lazy {
        return@lazy activity.supportFragmentManager
    }

    override fun push(fragment: Fragment, tag: String?) {
        fragments.add(fragment)
        fragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.from_right, R.anim.to_left,
                R.anim.from_left, R.anim.to_right
            )
            .replace(containerID, fragment)
            .addToBackStack(tag)
            .commit()
    }

    override fun pop(tag: String?) {
        if (tag != null) {
            val index = fragments.indexOfFirst { it.tag == tag }
            fragments.removeAll(fragments.subList(index + 1, fragments.size - 1))
            fragmentManager.popBackStack(tag, 0)
            return
        }
        activity.onBackPressed()
    }
}