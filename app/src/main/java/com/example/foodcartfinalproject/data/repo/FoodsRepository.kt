package com.example.foodcartfinalproject.data.repo

import android.util.Log
import android.widget.ImageView
import com.example.foodcartfinalproject.data.datasource.FoodsDataSource
import com.example.foodcartfinalproject.data.entity.Foods

class FoodsRepository(var fds: FoodsDataSource) {

    suspend fun addToCartFromMain(yemek_id: Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                                  yemek_siparis_adet:Int,kullanici_adi:String){
        fds.addToCartFromMain(yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }

    suspend fun loadFoodsToMain() : List<Foods> = fds.loadFoodsToMain()

}