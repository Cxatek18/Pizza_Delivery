package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.repository.PizzaRepository

class DeletePizzaUseCase(private val repository: PizzaRepository) {

    fun deletePizza(pizza: Pizza): Unit {
        repository.deletePizza(pizza)
    }
}