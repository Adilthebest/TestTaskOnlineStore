package com.example.testtaskonlinestore.utils

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testtaskonlinestore.ui.electronics.ElectronicsFragment
import com.example.testtaskonlinestore.ui.jewelery.JeweleryFragment
import com.example.testtaskonlinestore.ui.mensclothing.MensClothingFragment
import com.example.testtaskonlinestore.ui.womensclothing.WomensClothingFragment


class ViewPagerAdapter(fm: Fragment) : FragmentStateAdapter(fm) {
    private val count = 4

    override fun getItemCount(): Int {
        return count
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> JeweleryFragment()
            1 -> ElectronicsFragment()
            2 -> MensClothingFragment()
            3 -> WomensClothingFragment()
            else -> JeweleryFragment()
        }
    }
}
