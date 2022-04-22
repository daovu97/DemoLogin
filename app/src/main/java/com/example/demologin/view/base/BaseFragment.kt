package com.example.demologin.view.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.demologin.resource.setPaddingAsDP
import javax.inject.Inject

open class BaseFragment<V : BaseViewModel, B : ViewBinding> : Fragment() {

    var myTag: String = this::class.java.simpleName

    @Inject
    lateinit var viewModel: V

    lateinit var binding: B

    private var view: ViewBinding? = null

    var navigation: Navigation? = null

    var isVisibleTabbar: Boolean = true

    val mActivity: MyActivity? by lazy {
       return@lazy this.activity as? BaseActivity<*, *>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigation = mActivity?.navigation

        viewModel.isShowProgress.observe(this) { isShow ->
            mActivity?.showProgress(isShow)
        }

        viewModel.needRetry.observe(this) { isShow ->
           if (isShow) showRetryAlert()
        }
    }

    override fun onResume() {
        super.onResume()
        if (parentFragment == null && isVisibleTabbar) {
            binding.root.setPaddingAsDP(bottom = 60)
        } else {
            binding.root.setPaddingAsDP()
        }

        mActivity?.showTabbar(isVisibleTabbar)
    }

    open fun setupView() {}

    open fun makeViewBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (view == null) {
            makeViewBinding(inflater, container, savedInstanceState)
            view = binding
            setupView()
        }
        return this.view!!.root
    }

    private fun showRetryAlert() {
        AlertDialog.Builder(context)
            .setTitle("Network Error")
            .setMessage("Are you sure you want to retry this") // Specifying a listener allows you to take an action before dismissing the dialog.
            // The dialog is automatically dismissed when a dialog button is clicked.
            .setPositiveButton(
                "retry"
            ) { _, _ ->
                viewModel.handleRetry()
            } // A null listener allows the button to dismiss the dialog and take no further action.
            .setNegativeButton("no", null)
            .show()
    }
}