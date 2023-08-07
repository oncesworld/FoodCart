package com.example.foodcartfinalproject.data.datasource

import android.util.Log
import com.example.foodcartfinalproject.data.entity.CartFoods
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.retrofit.CartFoodsDao
import com.example.foodcartfinalproject.utility.UserNameStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.ArrayList

class CartFoodsDataSource(var cdao:CartFoodsDao) {

    suspend fun addToCartFromDetail(yemek_id: Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                                    yemek_siparis_adet:Int,kullanici_adi:String){
        val checkCartList = loadFoodsToCart() ?: emptyList()
        var checkFlag = false
        var checkedFoodQuantity = 0
        var checkedCartId = 0

        if (checkCartList.isNotEmpty()){
            for(x:CartFoods in checkCartList){
                if (x.yemek_adi == yemek_adi && x.yemek_resim_adi == yemek_resim_adi && x.yemek_fiyat == yemek_fiyat){
                    checkedFoodQuantity = x.yemek_siparis_adet
                    checkedCartId = x.sepet_yemek_id
                    checkFlag = true
                    break
                }
            }
        }
        if(checkFlag){
            deleteFood(checkedCartId,UserNameStatic.user_name)
            val newQuantity = yemek_siparis_adet + checkedFoodQuantity
            cdao.addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat,newQuantity,kullanici_adi)
        }else{
            cdao.addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        }
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

    suspend fun loadFoodsToCart(): List<CartFoods> {
        return try {
            withContext(Dispatchers.IO) {
                cdao.loadCartFoods(UserNameStatic.user_name).sepet_yemekler
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

}