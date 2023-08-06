package com.example.foodcartfinalproject.retrofit

import com.example.foodcartfinalproject.data.entity.CRUDResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CartFoodsDao {

    //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php
    //http://kasimadalan.pe.hu/
    //yemekler/sepeteYemekEkle.php

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addToCartFromDetail(@Field("yemek_adi")yemek_adi : String,
                                        @Field("yemek_resim_adi")yemek_resim_adi : String,
                                        @Field("yemek_fiyat")yemek_fiyat : Int,
                                        @Field("yemek_siparis_adet")yemek_siparis_adet : Int,
                                        @Field("kullanici_adi")kullanici_adi: String) : CRUDResponse


}