package com.example.testtaskonlinestore.ui.mensclothing

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.testtaskonlinestore.databinding.FragmentMensClothingBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.ui.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MensClothingFragment : BaseFragment<FragmentMensClothingBinding>(){
    private val vm: MainViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentMensClothingBinding {
        return FragmentMensClothingBinding.inflate(layoutInflater)
    }


    override fun initView() {

        vm.getMensClothing()
        viewLifecycleOwner.lifecycleScope.launch {
            vm.getAllProductSearch.collectLatest {
                getMensClothing()
            }
            getMensClothing()
        }
    }

    fun getMensClothing() {
        vm.stateMensClothing.collectState({}, {}, {
            adapter.setContentList(it)
            binding.recycle.adapter = adapter
        })
    }
}

