package com.example.demologin.view.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {

    val isShowProgress = MutableLiveData<Boolean>()

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
}