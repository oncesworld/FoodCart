package com.example.foodcartfinalproject.data.repo

import android.util.Log
import com.example.foodcartfinalproject.data.datasource.FoodsDataSource
import com.example.foodcartfinalproject.data.entity.Foods

class FoodsRepository {
    var fds = FoodsDataSource()

    suspend fun addToCartFromDetail(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        fds.addToCartFromDetail(yemek_adi,yemek_fiyat,yemek_resim_ad)
    }

    suspend fun increaseQuantity(yemek_id: Int,quantity : Int){
        fds.increaseQuantity(yemek_id,quantity)
    }

    suspend fun decreaseQuantity(yemek_id: Int,quantity : Int){
        fds.decreaseQuantity(yemek_id,quantity)
    }

    suspend fun deleteFood(yemek_id: Int){
        fds.deleteFood(yemek_id)
    }

    suspend fun addToCartFromMain(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        fds.addToCartFromMain(yemek_adi,yemek_fiyat,yemek_resim_ad)
    }

    suspend fun loadFoodsToMain() : List<Foods> = fds.loadFoodsToMain()
    suspend fun loadFoodsToCart() : List<Foods> = fds.loadFoodsToCart()

}