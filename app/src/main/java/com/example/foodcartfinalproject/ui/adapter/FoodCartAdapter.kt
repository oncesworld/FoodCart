package com.example.foodcartfinalproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.databinding.CardCartpageBinding
import com.example.foodcartfinalproject.databinding.CardMainpageBinding
import com.example.foodcartfinalproject.ui.viewmodel.FoodCartViewModel
import com.google.android.material.snackbar.Snackbar

class FoodCartAdapter(var mContext: Context, var foodCartList: List<Foods>, var viewModel: FoodCartViewModel)
    : RecyclerView.Adapter<FoodCartAdapter.CardDesignHolderCart>() {

    inner class CardDesignHolderCart(var design: CardCartpageBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolderCart {
        val binding : CardCartpageBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_cartpage,parent,false)
        return CardDesignHolderCart(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolderCart, position: Int) {
        val foodCart = foodCartList.get(position)
        val d = holder.design
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${foodCart.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300,300).into(d.cardCartFoodImage)

        d.foodVariable = foodCart

        //Adedi nasıl alacağız?
        //d.cardCartFoodImage.setImageResource(foodCart.yemek_resim_adi)
        //d.card.adet =


        //Yemek sil fonksiyonu aşağıdaki gibi
        d.cartCardDeleteButton.setOnClickListener{
            Snackbar.make(it,"${foodCart.yemek_adi} discard?",Snackbar.LENGTH_SHORT)
                .setAction("Yes"){
                    deleteFood(foodCart.yemek_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return foodCartList.size
    }

    fun deleteFood(yemek_id: Int){
        viewModel.deleteFood(yemek_id)
    }
}