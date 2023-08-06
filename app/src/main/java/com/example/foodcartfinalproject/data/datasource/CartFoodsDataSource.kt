package com.example.foodcartfinalproject.data.datasource

import android.util.Log
import com.example.foodcartfinalproject.data.entity.CartFoods
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.retrofit.CartFoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartFoodsDataSource(var cdao:CartFoodsDao) {

    suspend fun addToCartFromDetail(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                                    yemek_siparis_adet:Int,kullanici_adi:String){
        cdao.addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        Log.e("sepete ekle çalıştı","sepete ekle mesajı Data source")
    }

    suspend fun deleteFood(yemek_id: Int,kullanici_adi: String){
        cdao.deleteFoods(yemek_id,kullanici_adi)
    }

    suspend fun increaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id increased----$quantity")
    }

    suspend fun decreaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id decreased----$quantity")
    }

    suspend fun loadFoodsToCart() : List<CartFoods> =
        withContext(Dispatchers.IO){
            return@withContext cdao.loadCartFoods("eat_big_get_big").sepet_yemekler
        }

}