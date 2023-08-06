package com.example.foodcartfinalproject.retrofit

import retrofit2.create

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getFoodsDao() : FoodsDao{
            return RetrofitClient.getClient(BASE_URL).create(FoodsDao::class.java)
        }

        fun getCartFoodsDao() : CartFoodsDao{
            return RetrofitClient.getClient(BASE_URL).create(CartFoodsDao::class.java)
        }
    }
}