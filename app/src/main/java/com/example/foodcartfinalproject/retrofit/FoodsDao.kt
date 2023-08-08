package com.example.foodcartfinalproject.retrofit

import android.widget.ImageView
import com.example.foodcartfinalproject.data.entity.CRUDResponse
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.entity.FoodsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/
    //yemekler/tumYemekleriGetir.php

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addToCartFromMain(@Field("yemek_adi")yemek_adi : String,
                                    @Field("yemek_resim_adi")yemek_resim_adi : String,
                                    @Field("yemek_fiyat")yemek_fiyat : Int,
                                    @Field("yemek_siparis_adet")yemek_siparis_adet : Int,
                                    @Field("kullanici_adi")kullanici_adi: String) : CRUDResponse

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun loadFoods() : FoodsResponse

}