package com.team.pizzadelivery.domain.entity

data class Order(
    val nameOrder: String,
    val pizzaOrder: Pizza,
    val phoneOrder: String,
    val priceOrder: Int,
    val address: String,
    var id: Int = UNDEFINED_ID_ORDER
) {
    companion object {
        const val UNDEFINED_ID_ORDER: Int = -1
    }
}
