package com.example.testtaskonlinestore.ui.mensclothing

import android.view.LayoutInflater
import com.example.testtaskonlinestore.databinding.FragmentMensClothingBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MensClothingFragment : BaseFragment<FragmentMensClothingBinding>(){
    private val vm: MainViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentMensClothingBinding {
        return FragmentMensClothingBinding.inflate(layoutInflater)
    }


    override fun initView() {

        vm.getMensClothing("")
        vm.stateMensClothing.collectState({}, {}, {
            adapter.setContentList(it)
            binding.recycle.adapter = adapter

        })
    }

}