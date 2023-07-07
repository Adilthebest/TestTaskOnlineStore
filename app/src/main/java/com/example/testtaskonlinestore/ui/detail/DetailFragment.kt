package com.example.testtaskonlinestore.ui.detail

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.testtaskonlinestore.R
import com.example.testtaskonlinestore.databinding.FragmentDetailBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.google.android.material.button.MaterialButton
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
        btnShare.setOnClickListener {
            showAlertDialog()
        }
    }
    private fun showAlertDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alertdiaolog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val image: ImageView = dialog.findViewById(R.id.img_share_dialog)
        val btnShare: MaterialButton = dialog.findViewById(R.id.btn_share_dialog)
        val btnCancel: TextView = dialog.findViewById(R.id.tv_cancel_dialog)
        val link: TextView = dialog.findViewById(R.id.tv_link_dialog)


        vm.state.collectState({},{}, {
            image.load(it.image)
            link.text = it.image

        })
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, link.text)
            startActivity(Intent.createChooser(shareIntent, "Поделиться через"))
        }

        dialog.show()
    }
}