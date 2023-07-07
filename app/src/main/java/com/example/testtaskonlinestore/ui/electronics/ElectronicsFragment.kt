package com.example.testtaskonlinestore.ui.electronics

import android.view.LayoutInflater
import com.example.testtaskonlinestore.databinding.FragmentElectronicsBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ElectronicsFragment : BaseFragment<FragmentElectronicsBinding>() {
    private val vm: MainViewModel by sharedViewModel()



    override fun inflate(layoutInflater: LayoutInflater): FragmentElectronicsBinding {
        return FragmentElectronicsBinding.inflate(layoutInflater)
    }



    override fun initView() {
        vm.getElectronics("")
        vm.stateElectronics.collectState({}, {}, {
            adapter.setContentList(it)
            binding.recycle.adapter = adapter

        })


    }
}