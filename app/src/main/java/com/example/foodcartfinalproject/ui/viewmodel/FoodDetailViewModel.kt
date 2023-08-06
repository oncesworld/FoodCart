package com.example.foodcartfinalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.foodcartfinalproject.data.repo.CartFoodsRepository
import com.example.foodcartfinalproject.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(var crepo:CartFoodsRepository) : ViewModel() {

    fun addToCartFromDetail(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                                    yemek_siparis_adet:Int,kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            crepo.addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
            Log.e("sepete ekle çalıştı","sEPETE EKLE VIEW MODEL")
        }

    }

    fun increaseQuantity(yemek_id: Int,quantity : Int){
        CoroutineScope(Dispatchers.Main).launch {
            crepo.increaseQuantity(yemek_id,quantity)
        }
    }

    fun decreaseQuantity(yemek_id: Int,quantity : Int){
        CoroutineScope(Dispatchers.Main).launch {
            crepo.decreaseQuantity(yemek_id,quantity)
        }
    }
}