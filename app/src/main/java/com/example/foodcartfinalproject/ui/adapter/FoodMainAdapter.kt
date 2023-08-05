package com.example.foodcartfinalproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.entity.utils.CartFoodList
import com.example.foodcartfinalproject.databinding.CardMainpageBinding
import com.example.foodcartfinalproject.databinding.FragmentMainPageBinding
import com.example.foodcartfinalproject.ui.fragment.MainPageFragment
import com.example.foodcartfinalproject.ui.fragment.MainPageFragmentDirections
import com.example.foodcartfinalproject.ui.viewmodel.MainPageViewModel

class FoodMainAdapter(var mContext: Context, var foodList: List<Foods>,var viewModel: MainPageViewModel)
    : RecyclerView.Adapter<FoodMainAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardMainpageBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding : CardMainpageBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_mainpage,parent,false)
        return CardDesignHolder(binding)
    }

    //Burada verileri kartlara aktarıyoruz
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodList.get(position)
        val d = holder.design

        d.foodVariable = food

        //d.cardFoodImageMain.setImageResource(food.yemek_resim_adi)


        //Butonların özelliklerini aşağıdaki gibi aktif ediyorum
        //Sepete ekliyorum
        d.addtoCartCardMainPage.setOnClickListener{
            var yemek_adi = food.yemek_adi
            var yemek_fiyat = food.yemek_fiyat
            var yemek_resim_ad = food.yemek_resim_adi
            addToCartFromMain(yemek_adi,yemek_fiyat,yemek_resim_ad)
        }

        //Karta tıkladığımda detaya bilgileri gönderiyorum
        d.cardViewMainPage.setOnClickListener{
            val transition = MainPageFragmentDirections.mainToDetail(food = food)
            Navigation.findNavController(it).navigate(transition)
        }

    }
    override fun getItemCount(): Int {
        return foodList.size
    }

    fun addToCartFromMain(yemek_adi:String,yemek_fiyat:Int,yemek_resim_ad:String){
        viewModel.addToCartFromMain(yemek_adi,yemek_fiyat,yemek_resim_ad)
    }
}