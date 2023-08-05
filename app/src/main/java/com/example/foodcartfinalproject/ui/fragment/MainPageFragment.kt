package com.example.foodcartfinalproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.foodcartfinalproject.R
import com.example.foodcartfinalproject.data.entity.Foods
import com.example.foodcartfinalproject.databinding.FragmentMainPageBinding
import com.example.foodcartfinalproject.ui.adapter.FoodMainAdapter
import com.example.foodcartfinalproject.ui.viewmodel.FoodCartViewModel
import com.example.foodcartfinalproject.ui.viewmodel.MainPageViewModel

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page,container,false)

        binding.mainPageFragment = this
        binding.toolbarMainPageData = "Foods"

        //Yüklenen verinin anasayfada gösterilmesini sağlar
        viewModel.foodList.observe(viewLifecycleOwner){
            val adapter = FoodMainAdapter(requireContext(),it,viewModel)
            binding.foodMainAdapter = adapter
        }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun goToCart(it: View){
        Navigation.findNavController(it).navigate(R.id.mainToCart)
    }
}