package com.team.pizzadelivery.presintation

import android.annotation.SuppressLint
import android.app.ActivityManager.RunningTaskInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.pizzadelivery.R
import com.team.pizzadelivery.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var pizzaListAdapter: PizzaListAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory
                .getInstance(requireActivity().application)
        )[MainViewModel::class.java]
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pizzaListAdapter = PizzaListAdapter()
        viewModel.pizzaList.observe(viewLifecycleOwner){
            pizzaListAdapter.submitList(it)
        }
        binding.rvShopList.adapter = pizzaListAdapter
        setUpClickListener()
    }


    private fun setUpClickListener(){
        pizzaListAdapter.pizzaOnClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container_fragment, PizzaDetailFragment.newIntent(it.id))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        fun newInstance(): MainFragment{
            return MainFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        requireActivity().finish()
    }
}