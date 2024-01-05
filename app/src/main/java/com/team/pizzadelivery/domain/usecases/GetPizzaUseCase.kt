package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.repository.PizzaRepository

class GetPizzaUseCase(private val repository: PizzaRepository) {

    fun getPizza(idPizza: Int): Pizza {
        return repository.getPizza(idPizza)
    }
}