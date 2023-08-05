package com.example.foodcartfinalproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.databinding.FragmentFoodCartBinding
import com.example.foodcartfinalproject.databinding.FragmentMainPageBinding
import com.example.foodcartfinalproject.ui.adapter.FoodCartAdapter
import com.example.foodcartfinalproject.ui.viewmodel.FoodCartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodCartFragment : Fragment() {
    private lateinit var binding: FragmentFoodCartBinding
    private lateinit var viewModel: FoodCartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food_cart,container,false)
        binding.cartPageFragment = this
        binding.toolbarCartPageData = "My Cart"

        viewModel.foodList.observe(viewLifecycleOwner){

            val adapter = FoodCartAdapter(requireContext(),it,viewModel)
            binding.foodCartAdapter = adapter
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:FoodCartViewModel by viewModels()
        viewModel = tempViewModel
    }
}