package com.example.foodcartfinalproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.data.entity.utils.CartFoodList
import com.example.foodcartfinalproject.databinding.CardMainpageBinding
import com.example.foodcartfinalproject.databinding.FragmentMainPageBinding
import com.example.foodcartfinalproject.ui.fragment.MainPageFragment
import com.example.foodcartfinalproject.ui.fragment.MainPageFragmentDirections

class FoodMainAdapter(var mContext: Context, var foodList: List<Foods>)
    : RecyclerView.Adapter<FoodMainAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardMainpageBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardMainpageBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }

    //Burada verileri kartlara aktarıyoruz
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodList.get(position)
        val d = holder.design

        d.cardFoodName.text = food.yemek_adi
        d.cardFoodPrice.text = food.yemek_fiyat.toString()
        //d.cardFoodImageMain.setImageResource(food.yemek_resim_adi)



        //Butonların özelliklerini aşağıdaki gibi aktif ediyorum
        //Sepete ekliyorum
        d.addtoCartCardMainPage.setOnClickListener{
            CartFoodList.foodCartPaymentList.add(food)
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
}