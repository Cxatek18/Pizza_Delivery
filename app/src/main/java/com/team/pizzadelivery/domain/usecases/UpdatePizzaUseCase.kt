package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.repository.PizzaRepository

class UpdatePizzaUseCase(private val repository: PizzaRepository) {

    fun updatePizza(pizza: Pizza): Unit {
        repository.updatePizza(pizza)
    }
}