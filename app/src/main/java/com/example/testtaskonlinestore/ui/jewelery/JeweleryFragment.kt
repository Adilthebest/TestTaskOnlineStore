package com.example.testtaskonlinestore.ui.jewelery

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.testtaskonlinestore.databinding.FragmentJeweleryBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.ui.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class JeweleryFragment : BaseFragment<FragmentJeweleryBinding>() {
    private val vm: MainViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentJeweleryBinding {
        return FragmentJeweleryBinding.inflate(layoutInflater)
    }


    override fun initView() {

        vm.getJewelery()
        viewLifecycleOwner.lifecycleScope.launch {
            vm.getAllProductSearch.collectLatest {
                getJewelery()
            }
            getJewelery()
        }
    }

    fun getJewelery() {
        vm.stateJewelery.collectState({}, {}, {
            adapter.setContentList(it)
            binding.recycle.adapter = adapter
        })
    }
    }
