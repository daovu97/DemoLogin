package com.example.demologin.view.base

import androidx.fragment.app.Fragment

interface Navigation {
    var fragments: MutableList<Fragment>
    fun push(fragment: Fragment, tag: String? = null, withAnimation: Boolean = true)
    fun pop(tag: String? = null)
    fun setRoot(fragment: Fragment)
    fun popToRoot()
}