package com.example.foodcartfinalproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.entity.utils.CartFoodList
import com.example.foodcartfinalproject.databinding.FragmentFoodDetailBinding
import com.example.foodcartfinalproject.ui.viewmodel.FoodCartViewModel
import com.example.foodcartfinalproject.ui.viewmodel.FoodDetailViewModel

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private lateinit var viewModel: FoodDetailViewModel
    var quantity = 0
    var foodCartList = ArrayList<Foods>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food_detail,container,false)
        binding.detailPageFragment = this
        binding.toolbarDetailPageData = "Food Details"

        binding.fabDetail.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.detailToCart)
        }

        // Nesneyi aktaran kod
        val bundle:FoodDetailFragmentArgs by navArgs()
        val foodTaken = bundle.food
        binding.foodVariable = foodTaken

        binding.buttonIncreaseQuantity.setOnClickListener {
            quantity++
            binding.quantityText.setText(quantity.toString())
            increaseQuantity(foodTaken.yemek_id,quantity)
        }
        binding.buttonDecreaseQuantity.setOnClickListener {
            quantity--
            binding.quantityText.setText(quantity.toString())
            decreaseQuantity(foodTaken.yemek_id,quantity)
        }

        //Nesne transferi Databindingde hata aldım
        //binding.foodNameText.setText(foodTaken.yemek_adi)
        //binding.foodPriceText.setText(foodTaken.yemek_fiyat.toString())
        //binding.foodImage.setImageResource(foodTaken.yemek_resim_adi)


        // Detay ekranından Sepete ekleyen fonksiyon
        binding.addToCartDetail.setOnClickListener{
            var yemek_adi = foodTaken.yemek_adi
            var yemek_fiyat = foodTaken.yemek_fiyat
            var yemek_resim_ad = foodTaken.yemek_resim_adi
            addToCartFromDetail(yemek_adi,yemek_fiyat,yemek_resim_ad)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: FoodDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun goToCart(it: View){
        Navigation.findNavController(it).navigate(R.id.detailToCart)
    }
    fun addToCartFromDetail(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        viewModel.addToCartFromDetail(yemek_adi,yemek_fiyat,yemek_resim_ad)
    }

    fun increaseQuantity(yemek_id: Int,quantity : Int){
        viewModel.increaseQuantity(yemek_id,quantity)
    }

    fun decreaseQuantity(yemek_id: Int,quantity : Int){
        viewModel.decreaseQuantity(yemek_id,quantity)
    }
}