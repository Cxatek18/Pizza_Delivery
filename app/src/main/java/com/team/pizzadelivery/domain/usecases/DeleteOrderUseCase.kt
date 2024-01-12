package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Order
import com.team.pizzadelivery.domain.repository.OrderRepository
import com.team.pizzadelivery.domain.repository.PizzaRepository

class DeleteOrderUseCase(private val repository: OrderRepository) {

    fun deleteOrder(order: Order){
        repository.deleteOrder(order)
    }
}