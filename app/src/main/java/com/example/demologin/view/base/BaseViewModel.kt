package com.example.demologin.view.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demologin.injection.NoConnectivityException
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {

    val isShowProgress = MutableLiveData<Boolean>()
    internal val needRetry = MutableLiveData<Boolean>()

    fun showProgress() {
        if (isShowProgress.value == true) {
            return
        }
        isShowProgress.postValue(true)
    }

    fun hideProgress() {
        if (isShowProgress.value == false) {
            return
        }
        isShowProgress.postValue(false)
    }


    internal fun handleError(t: Throwable) {
        if (t is NoConnectivityException) {
            Log.d("ABC", t.message)
            needRetry.postValue(true)
        }

        Log.d("ABC", t.localizedMessage)
    }

   open fun handleRetry() {

    }
}