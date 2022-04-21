package com.example.demologin.view.base.tabbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.demologin.R
import com.example.demologin.view.base.NavigationWithTabbar
import com.example.demologin.view.base.OnTabChangeListener

class Tabbar(context: Context, attrs : AttributeSet?, defStyleAttr: Int, defStyleRes: Int): View(context, attrs, defStyleAttr, defStyleRes) {

}

class MainNavigationWithTabbar(
    private val activity: AppCompatActivity,
    @IdRes var containerID: Int,
    private val tabs: List<Fragment>,
    private var tabbar: Tabbar
): NavigationWithTabbar {

    fun isFragmentTab() : Boolean {
        return currentFragment.tag.contentEquals("TAB")
    }

    private var fragmentManager: FragmentManager

    init {
        fragmentManager = activity.supportFragmentManager
    }

    private  var onTabChangeListener: OnTabChangeListener? = null

    override var fragments: MutableList<Fragment> = mutableListOf()

    override var currentSelectedPosition: Int = 0

    var currentFragment: Fragment = tabs[0]

    override fun switchTab(index: Int) {
       push(tabs[index], tag = "TAB_${index}")
        currentSelectedPosition = index
        currentFragment = tabs[index]
        onTabChangeListener?.onChange(index)
    }

    override fun setTabChange(onChangeListener: OnTabChangeListener) {
       this.onTabChangeListener = onChangeListener
    }

    override fun push(
        fragment: Fragment,
        tag: String?,
        withAnimation: Boolean,
        hideTabbar: Boolean
    ) {
       push(fragment, tag, withAnimation)
        currentFragment = fragment
        setTabbarVisible(if (hideTabbar) View.GONE else View.VISIBLE)
    }

    override fun pop(tag: String?) {
        activity.onBackPressed()
        setTabbarVisible(if (!isFragmentTab()) View.GONE else View.VISIBLE)
    }

    fun setTabbarVisible(visible: Int) {
        tabbar.visibility = visible
    }


    fun push(fragment: Fragment, tag: String?, withAnimation: Boolean) {
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
}