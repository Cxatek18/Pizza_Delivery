package com.team.pizzadelivery.presintation

import androidx.recyclerview.widget.DiffUtil
import com.team.pizzadelivery.domain.entity.Pizza

class PizzaItemDiffCallback: DiffUtil.ItemCallback<Pizza>() {

    override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
        return oldItem == newItem
    }
}