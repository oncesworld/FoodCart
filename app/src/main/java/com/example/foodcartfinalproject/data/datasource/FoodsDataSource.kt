package com.example.foodcartfinalproject.data.datasource

import android.util.Log
import com.example.foodcartfinalproject.data.entity.Foods
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource {

    suspend fun addToCartFromDetail(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        Log.e("Sepete ekle","$yemek_adi - $yemek_fiyat - $yemek_resim_ad")
    }

    suspend fun increaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id increased----$quantity")
    }

    suspend fun decreaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id decreased----$quantity")
    }

    suspend fun deleteFood(yemek_id: Int){
        Log.e("yemek sil", yemek_id.toString())
    }

    suspend fun addToCartFromMain(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        Log.e("sepetemaindenekle","$yemek_adi")
    }

    suspend fun loadFoodsToMain() : List<Foods> =
        withContext(Dispatchers.IO){
            val foodList = ArrayList<Foods>()

            val y1 = Foods(1,"Yemek1","resim1",11)
            val y2 = Foods(2,"Yemek2","resim2",22)
            val y3 = Foods(3,"Yemek3","resim3",33)

            foodList.add(y1)
            foodList.add(y2)
            foodList.add(y3)
            return@withContext foodList

        }

    suspend fun loadFoodsToCart() : List<Foods> =
        withContext(Dispatchers.IO){
            val foodCartList = ArrayList<Foods>()
            val y1 = Foods(1,"sepet1","resim1",11)
            val y2 = Foods(2,"sepet2","resim2",22)
            val y3 = Foods(3,"sepet3","resim3",33)

            foodCartList.add(y1)
            foodCartList.add(y2)
            foodCartList.add(y3)
            return@withContext foodCartList

        }

}