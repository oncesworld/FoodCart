package com.example.foodcartfinalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodcartfinalproject.data.entity.CartFoods
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.repo.CartFoodsRepository
import com.example.foodcartfinalproject.data.repo.FoodsRepository
import com.example.foodcartfinalproject.utility.UserNameStatic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodCartViewModel @Inject constructor(var crepo:CartFoodsRepository) : ViewModel() {
    var cartFoodList = MutableLiveData<List<CartFoods>?>()

    //Uygulama çalışır çalışmaz liste yükle kodunun çalışmasını sağlar
    init {
            loadFoodsToCart()
    }

    fun loadFoodsToCart(){
        CoroutineScope(Dispatchers.Main).launch {
            cartFoodList.value = crepo.loadFoodsToCart()
        }
    }
    fun deleteFood(yemek_id: Int, kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.deleteFood(yemek_id, kullanici_adi)
            // Live datayı temizliyor
            val newList = cartFoodList.value?.toMutableList()
            newList?.removeAll { it.sepet_yemek_id == yemek_id }
            cartFoodList.value = newList
        }
    }
}