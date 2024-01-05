package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.repository.PizzaRepository

class CreatePizzaUseCase(private val repository: PizzaRepository) {

    fun createPizza(pizza: Pizza): Unit {
    }
}