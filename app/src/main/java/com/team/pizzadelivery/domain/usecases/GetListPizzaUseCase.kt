package com.team.pizzadelivery.domain.usecases

import androidx.lifecycle.LiveData
import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.repository.PizzaRepository

class GetListPizzaUseCase(private val repository: PizzaRepository) {

    fun getListRepository(): LiveData<List<Pizza>> {
        return repository.getListPizza()
    }
}