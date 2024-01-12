package com.team.pizzadelivery.domain.usecases

import androidx.lifecycle.LiveData
import com.team.pizzadelivery.domain.entity.Order
import com.team.pizzadelivery.domain.repository.OrderRepository

class GetListOrderUseCase(private val repository: OrderRepository) {

    fun getListOrder(): LiveData<List<Order>>{
        return repository.getListOrder()
    }
}