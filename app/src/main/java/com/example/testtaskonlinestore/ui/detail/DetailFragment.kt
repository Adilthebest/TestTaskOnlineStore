package com.example.testtaskonlinestore.ui.detail

import android.util.Log
import android.view.LayoutInflater
import com.example.testtaskonlinestore.databinding.FragmentDetailBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    private val vm: DetailViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        val result= arguments?.getInt("key")
        vm.getProductId(result!!.toInt())
        vm.state.collectState({},{},{
            Log.e("ololo", "initListener:${it} ", )
        })
    }
}