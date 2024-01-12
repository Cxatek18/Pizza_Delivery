package com.team.pizzadelivery.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.pizzadelivery.domain.entity.Order
import com.team.pizzadelivery.domain.repository.OrderRepository

object OrderRepositoryImpl: OrderRepository {

    const val ERROR_MSG_NO_ORDER: String = "Order is not"

    private val orderList = sortedSetOf<Order>({o1, o2, -> o1.id.compareTo(o2.id)})
    private val orderListLD = MutableLiveData<List<Order>>()

    override fun getListOrder(): LiveData<List<Order>> {
        return orderListLD
    }

    override fun getOrder(orderId: Int): Order {
        return orderList.find {
            it.id == orderId
        } ?: throw RuntimeException(ERROR_MSG_NO_ORDER)
    }

    override fun createOrder(order: Order) {
        orderList.add(order)
        updateList()
    }

    override fun deleteOrder(order: Order) {
        orderList.remove(order)
        updateList()
    }

    private fun updateList(){
        orderListLD.value = orderList.toList()
    }
}