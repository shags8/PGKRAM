package com.example.pgkram

import android.R
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.pgkram.databinding.FragmentSalaryInsightsBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

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
        val options = listOf("Data Science & Analytics", "Mobile App Developer", "UX/UI Designer")
        val dataMap = mapOf(
            "Data Science & Analytics" to listOf(Entry(1f, 10f), Entry(2f, 20f), Entry(3f, 25f),Entry(4f, 40f),Entry(5f, 38f)),
            "Mobile App Developer" to listOf(Entry(1f, 5f), Entry(2f, 15f), Entry(3f, 12f), Entry(4f, 18f),Entry(5f, 20f)),
            "UX/UI Designer" to listOf(Entry(1f, 8f), Entry(2f, 18f), Entry(3f, 15f), Entry(4f, 25f),Entry(5f, 20f))
        )
        val adapter = context?.let { ArrayAdapter(it, R.layout.simple_spinner_item, options) }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedOption = options[position]
                val selectedData = dataMap[selectedOption] ?: return

                // Create LineDataSet with new data
                val lineDataSet = LineDataSet(selectedData, selectedOption)
                // Customize line style (optional)
                lineDataSet.color = Color.BLUE
                lineDataSet.lineWidth = 2.5f
                lineDataSet.setDrawCircles(false)
                lineDataSet.color = Color.parseColor("#4285F4")
                lineDataSet.valueTextSize = 0.0f
                lineDataSet.valueTextColor = Color.BLACK

                // Create LineChartData with updated data
                val lineChartData = LineData(listOf(lineDataSet))

                // Set data and redraw chart
                binding.chart.data = lineChartData
                binding.chart.invalidate()
                binding.chart.isScaleXEnabled = false
                binding.chart.axisRight.isEnabled = false

                val xAxis: XAxis = binding.chart.xAxis
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.textSize = 9f
                xAxis.textColor = Color.BLACK
                xAxis.labelRotationAngle = 50F
                xAxis.labelCount=5
                xAxis.isForceLabelsEnabled
                xAxis.setDrawAxisLine(true)
                xAxis.setDrawGridLines(false)
                xAxis.valueFormatter = LineFormatter()

                val left: YAxis = binding.chart.axisLeft
                val rightAxis: YAxis = binding.chart.axisRight
                rightAxis.isEnabled = false
                left.setDrawGridLines(false)
                binding.chart.animateY(1000)
                binding.chart.description.isEnabled = false
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection
            }
        }

    }



}