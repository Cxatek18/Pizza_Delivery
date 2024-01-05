package com.team.pizzadelivery.domain.entity

data class Topping(
    val name: String,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
