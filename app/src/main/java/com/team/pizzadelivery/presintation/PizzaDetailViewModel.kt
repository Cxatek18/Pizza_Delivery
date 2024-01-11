package com.team.pizzadelivery.presintation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.pizzadelivery.data.PizzaRepositoryImpl
import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.usecases.GetListPizzaUseCase
import com.team.pizzadelivery.domain.usecases.GetPizzaUseCase

class PizzaDetailViewModel: ViewModel() {

    private val repository = PizzaRepositoryImpl

    private val getPizzaUseCase = GetPizzaUseCase(repository)

    private val _pizzaItem = MutableLiveData<Pizza>()
    val pizzaItem: LiveData<Pizza>
        get() = _pizzaItem

    fun getPizza(pizzaId: Int){
        val pizza = getPizzaUseCase.getPizza(pizzaId)
        _pizzaItem.value = pizza
    }
}