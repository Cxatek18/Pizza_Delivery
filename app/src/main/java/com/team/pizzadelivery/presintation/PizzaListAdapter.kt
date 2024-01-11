package com.team.pizzadelivery.presintation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.team.pizzadelivery.R
import com.team.pizzadelivery.databinding.FragmentMainBinding
import com.team.pizzadelivery.databinding.PizzaCardBinding
import com.team.pizzadelivery.domain.entity.Pizza
import com.team.pizzadelivery.domain.entity.Topping

class PizzaListAdapter : ListAdapter<Pizza, PizzaViewHolder>(PizzaItemDiffCallback()) {

    var pizzaOnClickListener: ((Pizza) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(
            PizzaCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizzaItem = getItem(position)
        holder.binding.apply {
            tvName.text = formatterStringToText(tvName.text, pizzaItem.name)
            tvDescription.text = formatterStringToText(tvDescription.text, pizzaItem.description)
            tvToppings.text = formatterListToText(tvToppings.text, pizzaItem.toppings)
            tvDough.text = formatterStringToText(tvDough.text, pizzaItem.dough)
            tvPrice.text = formatterIntToText(tvPrice.text, pizzaItem.price)
        }
        holder.binding.btnDetail.setOnClickListener {
            pizzaOnClickListener?.invoke(pizzaItem)
            true
        }
    }

    private fun formatterStringToText(value: CharSequence, newValue: String) = String.format(
        value.toString(), newValue
    )

    private fun formatterListToText(value: CharSequence, newValue: List<Topping>) = String.format(
        value.toString(), newValue.joinToString{ "${it.name} " }
    )

    private fun formatterIntToText(value: CharSequence, newValue: Int) = String.format(
        value.toString(), newValue.toString()
    )
}