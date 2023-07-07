package com.example.testtaskonlinestore.ui.electronics

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.testtaskonlinestore.databinding.FragmentElectronicsBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.ui.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ElectronicsFragment : BaseFragment<FragmentElectronicsBinding>() {
    private val vm: MainViewModel by sharedViewModel()



    override fun inflate(layoutInflater: LayoutInflater): FragmentElectronicsBinding {
        return FragmentElectronicsBinding.inflate(layoutInflater)
    }



    override fun initView() {
        vm.getElectronics()
        viewLifecycleOwner.lifecycleScope.launch {
            vm.getAllProductSearch.collectLatest {
                getElectronics()
            }
            getElectronics()
        }
    }

    fun getElectronics() {
        vm.stateElectronics.collectState({}, {}, {
            adapter.setContentList(it)
            binding.recycle.adapter = adapter
        })
    }
}