package com.example.testtaskonlinestore.ui.womensclothing

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.testtaskonlinestore.databinding.FragmentWomensClothingBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.ui.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class WomensClothingFragment : BaseFragment<FragmentWomensClothingBinding>() {
    private val vm: MainViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentWomensClothingBinding {
        return FragmentWomensClothingBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        vm.getWomensClothing()
        viewLifecycleOwner.lifecycleScope.launch {
            vm.getAllProductSearch.collectLatest {
                getWomensClothing()
            }
            getWomensClothing()
        }
    }

    fun getWomensClothing() {
        vm.stateWomensClothing.collectState({}, {}, {
            adapter.setContentList(it)
            binding.recycle.adapter = adapter

        })
    }
}