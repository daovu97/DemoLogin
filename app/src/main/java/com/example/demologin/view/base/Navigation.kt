package com.example.demologin.view.base

import androidx.fragment.app.Fragment
import com.google.android.material.slider.BaseOnChangeListener

interface Navigation {
    var fragments: MutableList<Fragment>
    fun push(fragment: Fragment, tag: String? = null, withAnimation: Boolean = true)
    fun pop(tag: String? = null)
    fun setRoot(fragment: Fragment)
    fun popToRoot()
}

interface  NavigationWithTabbar {
    var currentSelectedPosition: Int
    var fragments: MutableList<Fragment>

    fun switchTab(index: Int)
    fun setTabChange(onChangeListener: OnTabChangeListener)
    fun push(fragment: Fragment, tag: String? = null, withAnimation: Boolean = true, hideTabbar: Boolean = false)
    fun pop(tag: String? = null)

}

interface OnTabChangeListener {
    fun onChange(index: Int)
}