package com.example.foodcartfinalproject.retrofit

import android.widget.ImageView
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.entity.FoodsResponse
import retrofit2.http.GET

interface FoodsDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/
    //yemekler/tumYemekleriGetir.php

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun loadFoods() : FoodsResponse

}