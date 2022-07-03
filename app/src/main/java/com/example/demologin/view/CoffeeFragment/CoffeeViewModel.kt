package com.example.demologin.view.CoffeeFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.demologin.data.response.Coffee
import com.example.demologin.data.RegistrationRepository
import com.example.demologin.application.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeViewModel @Inject constructor(private val coffeesUseCase: RegistrationRepository) :
    BaseViewModel() {

    val coffees = MutableLiveData<List<Coffee>>()

    fun getCoffee(isLoadmore: Boolean = false) {
        if (!isLoadmore) {
            showProgress()
        }
        viewModelScope.launch {
            delay(1000L)
            val coffee = coffeesUseCase.getCoffees()
            coffee.onSuccess {
                coffees.postValue(it)
            }

            coffee.onFailure {
               handleError(it)
            }
            hideProgress()
        }
    }

    override fun handleRetry() {
        super.handleRetry()
        getCoffee()
    }
}