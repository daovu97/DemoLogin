package com.example.demologin.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.demologin.R
import com.example.demologin.databinding.ActivityMainBinding
import com.example.demologin.databinding.ActivityMainTabbarBinding
import com.example.demologin.databinding.CollectionDemoBinding
import com.example.demologin.databinding.FragmentCoffeeBinding
import com.example.demologin.view.CoffeeFragment.CoffeeFragment
import com.example.demologin.view.FragmentB.FragmentB
import com.example.demologin.view.base.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainTabbarBinding>() {

    override fun setupView(savedInstanceState: Bundle?) {
        super.setupView(savedInstanceState)
        navigation = MainNavigation(this, R.id.rootView,
            TabbarFragment(listOf(CoffeeFragment(), FragmentB())))
        tabbar = binding.linearLayout
    }

    override fun makeViewBinding() {
        super.makeViewBinding()
        binding = ActivityMainTabbarBinding.inflate(layoutInflater)
    }
}

@AndroidEntryPoint
class TabbarFragment @Inject constructor(private val fragments: List<Fragment>) : BaseFragment<BaseViewModel, CollectionDemoBinding>() {

    private lateinit var collectionAdapter: CollectionPagerAdapter

    override fun makeViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        super.makeViewBinding(inflater, container, savedInstanceState)
        binding = CollectionDemoBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        super.setupView()
        collectionAdapter = CollectionPagerAdapter(this)
        binding.pager.isSaveEnabled = false
        binding.pager.adapter = collectionAdapter
        collectionAdapter.setUpFragment(fragments = fragments)
    }

    fun setCurrentItem(index: Int, scrollEnable: Boolean = true) {
        binding.pager.setCurrentItem(index, scrollEnable)
    }

}

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
