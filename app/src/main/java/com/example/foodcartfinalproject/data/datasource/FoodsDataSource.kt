package com.example.foodcartfinalproject.data.datasource

import android.util.Log
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource(var fdao:FoodsDao) {

    suspend fun addToCartFromMain(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        Log.e("sepetemaindenekle","$yemek_adi")
    }

    suspend fun loadFoodsToMain() : List<Foods> =
        withContext(Dispatchers.IO){
            return@withContext fdao.loadFoods().yemekler

        }

}