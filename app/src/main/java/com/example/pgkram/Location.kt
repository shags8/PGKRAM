package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pgkram.databinding.FragmentAgeAndGenderBinding
import com.example.pgkram.databinding.FragmentLocationBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

// TODO: Rename parameter arguments, choose names that match

class Location : Fragment() {


    lateinit var _binding: FragmentLocationBinding
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_location, container, false)
        _binding= FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chartView = binding.chartView

        val chartData = ArrayList<BarEntry>()
        chartData.add(BarEntry(1f, 0.125f))
        chartData.add(BarEntry(2f,0.230f))
        chartData.add(BarEntry(3f,0.300f))
        chartData.add(BarEntry(4f,0.360f))

        val barDataSet = BarDataSet(chartData, "GENDER")
        barDataSet.color = Color.parseColor("#994329EA")
        barDataSet.isHighlightEnabled
        barDataSet.highLightColor = Color.parseColor("#4329EA")
        barDataSet.valueTextSize = 0.0f

        val barData = BarData(barDataSet)
        barData.barWidth = 0.2f
        chartView.setFitBars(true)
        chartView.invalidate()

        val xAxis: XAxis = chartView.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 15f
        xAxis.labelCount =4
        xAxis.textColor = Color.BLACK
        xAxis.setDrawAxisLine(false)
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter=MyXAxis4Formatter()

        val left: YAxis = chartView.getAxisLeft()
        val rightAxis: YAxis = chartView.axisRight
        left.axisMinimum = -0.2f
        rightAxis.isEnabled = false
        left.isEnabled = false

        chartView.description.text = ""
        chartView.data = barData
        chartView.animateXY(1000,1000)

    }

}