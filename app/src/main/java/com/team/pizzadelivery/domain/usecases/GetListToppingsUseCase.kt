package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.entity.Topping
import com.team.pizzadelivery.domain.repository.PizzaRepository

class GetListToppingsUseCase(private val repository: PizzaRepository) {

    fun getListTopping(pizza: Pizza): List<Topping> {
        return repository.getListToppings(pizza)
    }
}