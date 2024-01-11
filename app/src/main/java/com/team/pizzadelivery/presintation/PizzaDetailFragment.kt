package com.team.pizzadelivery.presintation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.team.pizzadelivery.R
import com.team.pizzadelivery.databinding.FragmentPizzaDetailBinding
import com.team.pizzadelivery.domain.entity.Topping

class PizzaDetailFragment : Fragment() {

    private var _buinding: FragmentPizzaDetailBinding? = null
    private val binding: FragmentPizzaDetailBinding
        get() = _buinding ?: throw RuntimeException("FragmentPizzaDetailBinding = null")

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory
                .getInstance(requireActivity().application)
        )[PizzaDetailViewModel::class.java]
    }

    private var pizzaId: Int = UNDEFINED_PIZZA_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _buinding = FragmentPizzaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPizza(pizzaId)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.pizzaItem.observe(viewLifecycleOwner) {
            binding.pizzaName.text = it.name
            binding.pizzaDescription.text = it.description
            binding.pizzaPrice.text = formatterIntToText(
                binding.pizzaPrice.text,
                it.price
            )
            binding.pizzaToppings.text = formatterListToText(
                binding.pizzaToppings.text, it.toppings
            )
        }
    }

    private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(ID_PIZZA)) {
            throw RuntimeException("No args - pizza_id")
        }
        pizzaId = args.getInt(ID_PIZZA)
    }

    private fun formatterIntToText(value: CharSequence, newValue: Int) = String.format(
        value.toString(), newValue.toString()
    )

    private fun formatterListToText(value: CharSequence, newValue: List<Topping>) = String.format(
        value.toString(), newValue.joinToString{ "${it.name} " }
    )

    companion object {

        private const val ID_PIZZA = "pizza_id"
        private const val UNDEFINED_PIZZA_ID = -1

        fun newIntent(pizzaId: Int): PizzaDetailFragment {
            return PizzaDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID_PIZZA, pizzaId)
                }
            }
        }
    }
}