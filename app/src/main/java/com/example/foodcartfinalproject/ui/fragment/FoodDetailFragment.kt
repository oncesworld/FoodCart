package com.example.foodcartfinalproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.databinding.FragmentFoodDetailBinding
import com.example.foodcartfinalproject.databinding.FragmentMainPageBinding

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    var quantity = 0
    var foodCartList = ArrayList<Foods>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFoodDetailBinding.inflate(inflater,container,false)

        binding.toolbarDetailPage.title = "Food Details"

        binding.fabDetail.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.detailToCart)
        }

        // Nesneyi aktaran kod
        val bundle:FoodDetailFragmentArgs by navArgs()
        val foodTaken = bundle.food
        binding.buttonIncreaseQuantity.setOnClickListener {
            quantity++
            binding.quantityText.setText(quantity.toString())

        }
        binding.buttonDecreaseQuantity.setOnClickListener {
            quantity--
            binding.quantityText.setText(quantity.toString())

        }


        binding.foodNameText.setText(foodTaken.yemek_adi)
        binding.foodNameText.setText(foodTaken.yemek_fiyat.toString())
        //binding.foodImage.setImageResource(foodTaken.yemek_resim_adi)




        // Detay ekranından Sepete ekleyen fonksiyon
        binding.addToCartDetail.setOnClickListener{
            addToCartFromDetail(foodTaken)
        }

        return binding.root
    }

    fun addToCartFromDetail(food : Foods){
        foodCartList.add(food)
    }
}