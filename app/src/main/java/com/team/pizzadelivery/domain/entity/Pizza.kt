package com.team.pizzadelivery.domain.entity

data class Pizza(
    val name: String,
    val description: String,
    val price: Int,
    val toppings: List<Topping>,
    val dough: String,
    var id: Int = UNDEFINED_ID
) {
    companion object{
        const val UNDEFINED_ID = -1
    }
}
