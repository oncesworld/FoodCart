package com.example.foodcartfinalproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.databinding.FragmentFoodCartBinding
import com.example.foodcartfinalproject.databinding.FragmentMainPageBinding
import com.example.foodcartfinalproject.ui.adapter.FoodCartAdapter

class FoodCartFragment : Fragment() {
    private lateinit var binding: FragmentFoodCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food_cart,container,false)
        binding.cartPageFragment = this
        binding.toolbarCartPageData = "My Cart"

        val foodCartList = ArrayList<Foods>()
        val y1 = Foods(1,"sepet1","resim1",11)
        val y2 = Foods(2,"sepet2","resim2",22)
        val y3 = Foods(3,"sepet3","resim3",33)

        foodCartList.add(y1)
        foodCartList.add(y2)
        foodCartList.add(y3)

        val adapter = FoodCartAdapter(requireContext(),foodCartList)
        binding.foodCartAdapter = adapter

        return binding.root
    }
}