package com.example.pgkram

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdpterDemo(fm: Fragment): FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return 3
    }// Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return AgeAndGender()
            1 -> return Location()
            2-> return DeviceType()
            else -> return AgeAndGender()
        }

    }
}