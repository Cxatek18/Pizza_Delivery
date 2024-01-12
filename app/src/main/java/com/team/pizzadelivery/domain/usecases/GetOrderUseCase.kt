package com.team.pizzadelivery.domain.usecases

import com.team.pizzadelivery.domain.entity.Order
import com.team.pizzadelivery.domain.repository.OrderRepository

class GetOrderUseCase(private val repository: OrderRepository) {

    fun getOrder(orderId: Int): Order {
        return repository.getOrder(orderId)
    }
}