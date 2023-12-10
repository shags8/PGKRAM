package com.example.pgkram

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdpterDashBoard(fm: Fragment): FragmentStateAdapter(fm) {


    override fun getItemCount(): Int {
        return 2
    }// Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return RetentionRate()
            1 -> return Traffic()
            else -> return RetentionRate()
        }

    }
}
