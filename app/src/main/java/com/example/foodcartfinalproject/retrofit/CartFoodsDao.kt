package com.example.foodcartfinalproject.retrofit

import com.example.foodcartfinalproject.data.entity.CRUDResponse
import com.example.foodcartfinalproject.data.entity.CartFoodsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CartFoodsDao {

    //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php
    //http://kasimadalan.pe.hu/
    //yemekler/sepeteYemekEkle.php
    //http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addToCartFromDetail(@Field("yemek_adi")yemek_adi : String,
                                        @Field("yemek_resim_adi")yemek_resim_adi : String,
                                        @Field("yemek_fiyat")yemek_fiyat : Int,
                                        @Field("yemek_siparis_adet")yemek_siparis_adet : Int,
                                        @Field("kullanici_adi")kullanici_adi: String) : CRUDResponse

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun loadCartFoods(@Field("kullanici_adi")kullanici_adi: String) : CartFoodsResponse

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteFoods(@Field("sepet_yemek_id")sepet_yemek_id: Int,
                                @Field("kullanici_adi")kullanici_adi: String) : CartFoodsResponse


}