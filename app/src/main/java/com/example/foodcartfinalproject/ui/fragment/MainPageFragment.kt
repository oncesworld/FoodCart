package com.example.foodcartfinalproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.databinding.FragmentMainPageBinding
import com.example.foodcartfinalproject.ui.adapter.FoodMainAdapter

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page,container,false)

        binding.mainPageFragment = this
        binding.toolbarMainPageData = "Foods"


        val foodList = ArrayList<Foods>()

        val y1 = Foods(1,"Yemek1","resim1",11)
        val y2 = Foods(2,"Yemek2","resim2",22)
        val y3 = Foods(3,"Yemek3","resim3",33)

        foodList.add(y1)
        foodList.add(y2)
        foodList.add(y3)

        val adapter = FoodMainAdapter(requireContext(),foodList)
        binding.foodMainAdapter = adapter

        return binding.root
    }

    fun goToCart(it: View){
        Navigation.findNavController(it).navigate(R.id.mainToCart)
    }

    fun addToCart(yemek_ad:String){
        Log.e("saas","$yemek_ad")
    }
}