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
import com.bumptech.glide.Glide
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.databinding.FragmentFoodDetailBinding
import com.example.foodcartfinalproject.ui.viewmodel.FoodDetailViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${foodTaken.yemek_resim_adi}"
        Glide.with(this).load(url).override(500,500).into(binding.foodImage)

        //Nesne transferi Databindingde hata aldım
        //binding.foodNameText.setText(foodTaken.yemek_adi)
        //binding.foodPriceText.setText(foodTaken.yemek_fiyat.toString())
        //binding.foodImage.setImageResource(foodTaken.yemek_resim_adi)


        // Detay ekranından Sepete ekleyen fonksiyon
        binding.addToCartDetail.setOnClickListener{
            var yemek_adi = foodTaken.yemek_adi
            var yemek_fiyat = foodTaken.yemek_fiyat
            var yemek_resim_adi = foodTaken.yemek_resim_adi
            var yemek_siparis_adet = quantity
            var kullanici_adi = "eat_big_get_big"
            if(quantity>0){
                addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
            }else{Snackbar.make(it,"You need to increase quantity",Snackbar.LENGTH_SHORT)
                .setAction("Ok"){

                }.show()

            }
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
    fun addToCartFromDetail(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                            yemek_siparis_adet:Int,kullanici_adi:String){
        viewModel.addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }

    fun increaseQuantity(yemek_id: Int,quantity : Int){
        viewModel.increaseQuantity(yemek_id,quantity)
    }

    fun decreaseQuantity(yemek_id: Int,quantity : Int){
        viewModel.decreaseQuantity(yemek_id,quantity)
    }
}