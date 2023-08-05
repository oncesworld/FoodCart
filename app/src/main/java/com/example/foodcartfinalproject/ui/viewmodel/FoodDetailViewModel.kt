package com.example.foodcartfinalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.foodcartfinalproject.data.repo.FoodsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodDetailViewModel : ViewModel() {
    var frepo = FoodsRepository()

    fun addToCartFromDetail(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.addToCartFromDetail(yemek_adi,yemek_fiyat,yemek_resim_ad)
        }
    }

    fun increaseQuantity(yemek_id: Int,quantity : Int){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.increaseQuantity(yemek_id,quantity)
        }
    }

    fun decreaseQuantity(yemek_id: Int,quantity : Int){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.decreaseQuantity(yemek_id,quantity)
        }
    }
}