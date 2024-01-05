package com.team.pizzadelivery.domain.repository

import androidx.lifecycle.LiveData
import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.entity.Topping

interface PizzaRepository {
    fun createPizza(pizza: Pizza): Unit
    fun getPizza(idPizza: Int): Pizza
    fun getListPizza(): LiveData<List<Pizza>>
    fun updatePizza(pizza: Pizza): Unit
    fun deletePizza(pizza: Pizza): Unit
    fun getListToppings(pizza: Pizza): List<Topping>
}