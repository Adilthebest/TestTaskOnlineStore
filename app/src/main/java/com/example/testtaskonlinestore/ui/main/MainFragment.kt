package com.example.testtaskonlinestore.ui.main

import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.SearchView
import android.widget.TextView
import com.example.testtaskonlinestore.R
import com.example.testtaskonlinestore.databinding.FragmentMainBinding
import com.example.testtaskonlinestore.ui.base.BaseFragment
import com.example.testtaskonlinestore.utils.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlin.math.roundToInt

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by sharedViewModel()
    private val tabTitles =
        mutableMapOf(
            "Jewelery" to R.drawable.jewelry_icon,
            "Electronics" to R.drawable.display_1,
            "Men's Clothing" to R.drawable.baseline_man_24,
            "Women's Clothing" to R.drawable.woman_logo,
        )

    override fun inflate(layoutInflater: LayoutInflater): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }


    override fun initView() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(this)
        val titles = ArrayList(tabTitles.keys)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()

        tabTitles.values.forEachIndexed { index, imageId ->
            val title =
                LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null) as TextView
            title.setCompoundDrawablesWithIntrinsicBounds(0, imageId, 0, 0)
            title.compoundDrawablePadding = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4f, resources.displayMetrics
            ).roundToInt()
            binding.tabLayout.getTabAt(index)?.customView = title
        }
    }

    override fun initListener() {
        binding.searchId.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {
                return false
            }
            override fun onQueryTextChange(p0: String?) = viewModel.getAllSearchQuery(p0).run { true }
        })
    }


}