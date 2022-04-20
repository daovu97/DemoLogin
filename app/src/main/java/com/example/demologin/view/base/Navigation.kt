package com.example.demologin.view.base

import androidx.fragment.app.Fragment

interface Navigation {
    var fragments: MutableList<Fragment>
    fun push(fragment: Fragment, tag: String? = null)
    fun pop(tag: String? = null)
}