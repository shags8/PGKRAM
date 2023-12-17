package com.example.pgkram

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.pgkram.databinding.FragmentSalaryInsightsBinding
import com.example.pgkram.databinding.FragmentSuccessRatioBinding
import com.github.mikephil.charting.charts.BarChart

class SalaryInsights : Fragment() {

    private lateinit var chart: BarChart

    private lateinit var _binding : FragmentSalaryInsightsBinding
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_salary_insights, container, false)
        _binding= FragmentSalaryInsightsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var spinner: Spinner = binding.spinner
        val options = listOf("Option 1", "Option 2", "Option 3")
        val adapter = context?.let { ArrayAdapter(it, R.layout.simple_spinner_item, options) }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

    }

}