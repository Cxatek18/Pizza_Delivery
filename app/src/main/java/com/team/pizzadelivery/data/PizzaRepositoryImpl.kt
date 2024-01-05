package com.team.pizzadelivery.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.entity.Topping
import com.team.pizzadelivery.domain.repository.PizzaRepository

object PizzaRepositoryImpl : PizzaRepository {

    private val pizzaList = sortedSetOf<Pizza>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrementId: Int = 0
    private val pizzaListLD = MutableLiveData<List<Pizza>>()

    init {
        for (i in 0..20) {
            val pizza = Pizza(
                "Пицца $i",
                "Описание $i",
                i + 1000,
                listOf(Topping("сыр $1"), Topping("колбаса $i"), Topping("помидор $i")),
                "Слоёное",
            )
            createPizza(pizza)
        }
    }


    override fun createPizza(pizza: Pizza) {
        if (pizza.id == Pizza.UNDEFINED_ID) {
            pizza.id = autoIncrementId++
        }
        pizzaList.add(pizza)
        updateList()
    }

    override fun getPizza(idPizza: Int): Pizza {
        return pizzaList.find { it.id == idPizza } ?: throw RuntimeException("Такой пиццы нету")
    }

    override fun getListPizza(): LiveData<List<Pizza>> {
        return pizzaListLD
    }

    override fun updatePizza(pizza: Pizza) {
        val oldPizza = getPizza(pizza.id)
        pizzaList.remove(oldPizza)
        createPizza(pizza)
    }

    override fun deletePizza(pizza: Pizza) {
        pizzaList.remove(pizza)
        updateList()
    }

    override fun getListToppings(pizza: Pizza): List<Topping> {
        return pizza.toppings.toList()
    }

    private fun updateList() {
        pizzaListLD.value = pizzaList.toList()
    }
}