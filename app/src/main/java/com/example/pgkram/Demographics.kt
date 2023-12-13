package com.example.pgkram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pgkram.databinding.FragmentDemographicsBinding
import com.google.android.material.tabs.TabLayoutMediator


class Demographics : Fragment() {

    lateinit var _binding : FragmentDemographicsBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_demographics, container, false)

        _binding= FragmentDemographicsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.v3
        val adapter = FragmentAdpterDemo(this)
        viewPager.adapter = adapter

        // Setup TabLayout
        TabLayoutMediator(binding.t2,viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            val tabNames = listOf("Age& Gender", "Location",)
            tab.text = tabNames[position]
        }).attach()
    }


}