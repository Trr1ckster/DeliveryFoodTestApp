package com.trr1ckster.deliveryfoodtestapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.trr1ckster.deliveryfoodtestapp.adapters.FoodAdapter
import com.trr1ckster.deliveryfoodtestapp.databinding.FragmentMainBinding
import com.trr1ckster.deliveryfoodtestapp.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerAdapter: FoodAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerAdapter = FoodAdapter()
        binding.recyclerView.adapter = recyclerAdapter

        viewModel.pizza.observe(viewLifecycleOwner) {
            recyclerAdapter.differ.submitList(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}