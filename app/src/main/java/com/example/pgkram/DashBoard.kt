package com.example.pgkram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.pgkram.databinding.FragmentDashBoardBinding
import com.example.pgkram.databinding.FragmentDemographicsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics

class DashBoard : Fragment() {

    lateinit var _binding: FragmentDashBoardBinding
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      // return inflater.inflate(R.layout.fragment_dash_board, container, false)

        _binding= FragmentDashBoardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.v2
        val adapter = FragmentAdpterDashBoard(this)
        viewPager.adapter = adapter

        // Setup TabLayout
        TabLayoutMediator(binding.t1,viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            val tabNames = listOf("Retention rate", "Traffic source",)
            tab.text = tabNames[position]
        }).attach()
    }
}