package com.example.demologin.view.base.tabbar

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CollectionPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private var fragments: List<Fragment> = emptyList()

    fun setUpFragment(fragments: List<Fragment>) {
        this.fragments = fragments
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = fragments.count()

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}