package com.example.foodcartfinalproject.data.datasource

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource(var fdao:FoodsDao) {

    suspend fun addToCartFromMain(yemek_id: Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        fdao.addToCartFromMain(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet =1,kullanici_adi)
    }

    suspend fun loadFoodsToMain() : List<Foods> =
        withContext(Dispatchers.IO){
            return@withContext fdao.loadFoods().yemekler
        }

}