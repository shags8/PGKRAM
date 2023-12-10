package com.example.pgkram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pgkram.databinding.FragmentDemographicsBinding


class Demographics : Fragment() {

    lateinit var binding : FragmentDemographicsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_demographics, container, false)

        binding= FragmentDemographicsBinding.inflate(layoutInflater)

        return binding.root

    }


}