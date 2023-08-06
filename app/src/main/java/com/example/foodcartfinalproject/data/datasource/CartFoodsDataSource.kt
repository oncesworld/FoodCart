package com.example.foodcartfinalproject.data.datasource

import android.util.Log
import com.example.foodcartfinalproject.data.entity.CartFoods
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.retrofit.CartFoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartFoodsDataSource {

    suspend fun addToCartFromDetail(yemek_adi:String,yemek_resim_ad:String,yemek_fiyat:Int,
                                    yemek_siparis_adet:Int,kullanici_adi:String){
        Log.e("yemek kaydet","$yemek_adi,$yemek_resim_ad,$yemek_fiyat,$yemek_siparis_adet,$kullanici_adi")
    }

    suspend fun deleteFood(yemek_id: Int,kullanici_adi: String){
        Log.e("yemek sil", yemek_id.toString())
    }

    suspend fun increaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id increased----$quantity")
    }

    suspend fun decreaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id decreased----$quantity")
    }

    suspend fun loadFoodsToCart() : List<CartFoods> =
        withContext(Dispatchers.IO){
            val foodCartList = ArrayList<CartFoods>()
            val y1 = CartFoods(1,"sepet1","sepetresim1",11,1,"eat_big")
            val y2 = CartFoods(2,"sepet2","sepetresim2",22,2,"eat_big")
            val y3 = CartFoods(3,"sepet3","sepetresim3",33,3,"eat_big")

            foodCartList.add(y1)
            foodCartList.add(y2)
            foodCartList.add(y3)
            return@withContext foodCartList
        }

}