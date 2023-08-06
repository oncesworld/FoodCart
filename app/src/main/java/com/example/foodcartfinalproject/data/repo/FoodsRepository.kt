package com.example.foodcartfinalproject.data.repo

import android.util.Log
import android.widget.ImageView
import com.example.foodcartfinalproject.data.datasource.FoodsDataSource
import com.example.foodcartfinalproject.data.entity.Foods

class FoodsRepository(var fds: FoodsDataSource) {

    suspend fun addToCartFromMain(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        fds.addToCartFromMain(yemek_adi,yemek_fiyat,yemek_resim_ad)
    }

    suspend fun loadFoodsToMain() : List<Foods> = fds.loadFoodsToMain()

}