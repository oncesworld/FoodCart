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
class MainPageViewModel @Inject constructor(var frepo:FoodsRepository) : ViewModel() {
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

    fun addToCartFromMain(yemek_id: Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                          yemek_siparis_adet:Int,kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.addToCartFromMain(yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        }
    }
}