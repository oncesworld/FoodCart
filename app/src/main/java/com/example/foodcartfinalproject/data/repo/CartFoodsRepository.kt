package com.example.foodcartfinalproject.data.repo

import android.util.Log
import com.example.foodcartfinalproject.data.datasource.CartFoodsDataSource
import com.example.foodcartfinalproject.data.entity.CartFoods

class CartFoodsRepository(var cfds : CartFoodsDataSource) {

    suspend fun addToCartFromDetail(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                                    yemek_siparis_adet:Int,kullanici_adi:String){
        cfds.addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        Log.e("sepete ekle çalıştı","sepete ekle Repository")
    }

    suspend fun deleteFood(yemek_id: Int,kullanici_adi: String){
        cfds.deleteFood(yemek_id,kullanici_adi)
    }

    suspend fun increaseQuantity(yemek_id: Int,quantity : Int){
        cfds.increaseQuantity(yemek_id,quantity)
    }

    suspend fun decreaseQuantity(yemek_id: Int,quantity : Int){
        cfds.decreaseQuantity(yemek_id,quantity)
    }

    suspend fun loadFoodsToCart() : List<CartFoods> = cfds.loadFoodsToCart()
}