package com.example.foodcartfinalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.repo.FoodsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel : ViewModel() {
    var frepo = FoodsRepository()
    var foodList = MutableLiveData<List<Foods>>()

    //Uygulama çalışır çalışmaz liste yükle kodunun çalışmasını sağlar
    init {
        loadFoodsToMain()
    }

    fun loadFoodsToMain(){
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = frepo.loadFoodsToMain()
        }
    }

    fun addToCartFromMain(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.addToCartFromMain(yemek_adi,yemek_fiyat,yemek_resim_ad)
        }
    }
}