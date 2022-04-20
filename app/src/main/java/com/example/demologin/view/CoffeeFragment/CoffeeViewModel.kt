package com.example.demologin.view.CoffeeFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.demologin.data.response.Coffee
import com.example.demologin.domain.usecase.GetCoffeesUseCase
import com.example.demologin.view.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoffeeViewModel @Inject constructor(private val coffeesUseCase: GetCoffeesUseCase) : BaseViewModel() {

    val coffees = MutableLiveData<List<Coffee>>()

     fun getCoffee()  {
        viewModelScope.launch {
            val coffee = coffeesUseCase.invoke()
            coffees.postValue(coffee)
        }
    }
}