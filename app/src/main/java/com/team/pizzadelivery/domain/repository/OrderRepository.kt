package com.team.pizzadelivery.domain.repository

import androidx.lifecycle.LiveData
import com.team.pizzadelivery.domain.entity.Order

interface OrderRepository {

    fun getListOrder(): LiveData<List<Order>>
    fun getOrder(orderId: Int): Order
    fun createOrder(order: Order)
    fun deleteOrder(order: Order)
}