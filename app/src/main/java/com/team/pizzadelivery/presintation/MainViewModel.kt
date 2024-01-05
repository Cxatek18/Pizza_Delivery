package com.team.pizzadelivery.presintation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.team.pizzadelivery.data.PizzaRepositoryImpl
import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.usecases.DeletePizzaUseCase
import com.team.pizzadelivery.domain.usecases.GetListPizzaUseCase
import com.team.pizzadelivery.domain.usecases.UpdatePizzaUseCase

class MainViewModel: ViewModel() {
    private val repository = PizzaRepositoryImpl

    private val getListPizzaUseCase = GetListPizzaUseCase(repository)
    private val deletePizzaUseCase = DeletePizzaUseCase(repository)
    private val updatePizzaUseCase = UpdatePizzaUseCase(repository)

    val pizzaList: LiveData<List<Pizza>> = getListPizzaUseCase.getListRepository()
    fun updatePizza(
        pizza: Pizza,
        name: String,
        description: String,
        price: Int,
        dough: String
    ): Unit {
        val newPizza = pizza.copy(name=name, description=description, price=price, dough=dough)
        updatePizzaUseCase.updatePizza(newPizza)
    }
    fun deletePizza(pizza: Pizza): Unit {
        deletePizzaUseCase.deletePizza(pizza)
    }
}