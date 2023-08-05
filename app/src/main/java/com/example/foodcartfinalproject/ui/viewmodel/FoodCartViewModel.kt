package com.example.foodcartfinalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodCartViewModel @Inject constructor(var frepo:FoodsRepository) : ViewModel() {
    var foodList = MutableLiveData<List<Foods>>()

    //Uygulama çalışır çalışmaz liste yükle kodunun çalışmasını sağlar
    init {
        loadFoodsToCart()
    }

    fun loadFoodsToCart(){
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = frepo.loadFoodsToMain()
        }
    }

    fun deleteFood(yemek_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.deleteFood(yemek_id)
        }
    }
}