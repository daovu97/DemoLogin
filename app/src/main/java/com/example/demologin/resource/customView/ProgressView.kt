package com.example.demologin.resource.customView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demologin.databinding.CustomDialogFragmentBinding
import com.example.demologin.view.base.BaseDialogFragment
import javax.inject.Inject

class ProgressView @Inject constructor() : BaseDialogFragment<CustomDialogFragmentBinding>() {

    override fun setupView() {
        super.setupView()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): CustomDialogFragmentBinding {
        return  CustomDialogFragmentBinding.inflate(inflater, container, false)
    }
}