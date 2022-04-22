package com.example.demologin.resource

import android.animation.Animator
import android.view.View
import android.view.ViewPropertyAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demologin.view.base.MyFragment

fun RecyclerView.setupLoadMore(completion: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
            if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (adapter?.itemCount
                    ?: 2) - 2
            ) {
                completion()
            }
        }
    })
}


fun MyFragment.pushAndHideTabbar(fragment: MyFragment) {
    fragment.isVisibleTabbar = false
    mActivity?.navigation?.push(fragment)
}

fun ViewPropertyAnimator.setComplete(completion: (Animator?) -> Unit) : ViewPropertyAnimator {
    return setListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(p0: Animator?) {

        }

        override fun onAnimationEnd(p0: Animator?) {
            completion(p0)

        }

        override fun onAnimationCancel(p0: Animator?) {

        }

        override fun onAnimationRepeat(p0: Animator?) {

        }
    })
}

fun View.setPaddingAsDP(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0) {
    setPadding(asPixels(left), asPixels(top), asPixels(right), asPixels(bottom))
}

fun View.asPixels(value: Int): Int {
    val scale = resources.displayMetrics.density
    val dpAsPixels = (value * scale + 0.5f)
    return dpAsPixels.toInt()
}