package com.example.foodcartfinalproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        //Yüklenen verinin sepette gösterilmesini sağlar sepet boşaldığında checkler.
        viewModel.cartFoodList.observe(viewLifecycleOwner){
            val adapter = it?.let { it1 -> FoodCartAdapter(requireContext(), it1,viewModel) }
            binding.foodCartAdapter = adapter
        }

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food_cart,container,false)
        binding.cartPageFragment = this
        binding.toolbarCartPageData = "My Cart"


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:FoodCartViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFoodsToCart()
    }
}