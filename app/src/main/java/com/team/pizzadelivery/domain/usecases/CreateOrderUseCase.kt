package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Order
import com.team.pizzadelivery.domain.repository.OrderRepository

class CreateOrderUseCase(private val repository: OrderRepository) {

    fun createOrder(order: Order){
        repository.createOrder(order)
    }
}