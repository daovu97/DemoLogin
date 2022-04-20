package com.example.demologin.resource.customView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.demologin.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

class ProgressView @Inject constructor() : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDialog()
    }

    private fun setupDialog() {
        if (dialog != null) {
            dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog?.setCancelable(false)
            dialog?.setCanceledOnTouchOutside(false)
        }
    }
}