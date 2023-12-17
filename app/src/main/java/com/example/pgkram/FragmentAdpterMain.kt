package com.example.pgkram

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class FragmentAdpterMain(fm: FragmentActivity):FragmentStateAdapter(fm){


        override fun getItemCount(): Int {
            return 4
        }// Number of tabs

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> return DashBoard()
                1 -> return Demographics()
                2 -> return SuccessRatio()
                3 -> return SalaryInsights() // Add additional fragment for tab 4
                else -> return Demographics()
            }

        }

}