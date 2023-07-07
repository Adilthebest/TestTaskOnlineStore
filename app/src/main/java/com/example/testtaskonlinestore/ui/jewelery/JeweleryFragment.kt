package com.example.testtaskonlinestore.ui.jewelery

import android.view.LayoutInflater
import com.example.testtaskonlinestore.databinding.FragmentJeweleryBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class JeweleryFragment : BaseFragment<FragmentJeweleryBinding>() {
    private val vm: MainViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentJeweleryBinding {
        return FragmentJeweleryBinding.inflate(layoutInflater)
    }


    override fun initView() {

        vm.getJewelery("")
        vm.stateJewelery.collectState({}, {}, {
            adapter.setContentList(it)
            binding.recycle.adapter = adapter

        })
    }
}