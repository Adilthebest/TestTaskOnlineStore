package com.example.testtaskonlinestore.ui.detail

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.testtaskonlinestore.databinding.FragmentDetailBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    private val vm: DetailViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater)
    }

    override fun initListener()  = with(binding){
        val result= arguments?.getInt("key")
        vm.getProductId(result!!.toInt())
        vm.state.collectState({},{},{
            tvProduct.text = it.title
            tvDesc.text = it.description
            tvPrice.text = "$ " + it.price.toString()
            tvRateDetail.text = it.rating?.rate.toString()
            tvCategory.text = it.category
            ivDetails.load(it.image)
        })
        ivExit.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}