package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pgkram.databinding.FragmentAgeAndGenderBinding
import com.example.pgkram.databinding.FragmentSuccessRatioBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics

class SuccessRatio : Fragment() {

    lateinit var _binding :FragmentSuccessRatioBinding
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_success_ratio, container, false)

        _binding= FragmentSuccessRatioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        graph3()
        graph4()
    }

    fun graph3()
    {
        val chartData = ArrayList<BarEntry>()
        chartData.add(BarEntry(1f, 1f))
        chartData.add(BarEntry(2f,0.33f))
        chartData.add(BarEntry(3f, 0.72f))
        chartData.add(BarEntry(4f, 0.8f))
        chartData.add(BarEntry(5f, 0.4f))
        chartData.add(BarEntry(6f, 0.25f))
        chartData.add(BarEntry(7f, 0.55f))
        chartData.add(BarEntry(8f, 0.15f))
        chartData.add(BarEntry(9f, 0.65f))
        chartData.add(BarEntry(10f, 0.55f))
        chartData.add(BarEntry(11f, 0.45f))
        chartData.add(BarEntry(12f, 0.35f))


        val barDataSet = BarDataSet(chartData, "SUCCESS")
        barDataSet.color = Color.parseColor("#994329EA")
        barDataSet.isHighlightEnabled
        barDataSet.highLightColor = Color.parseColor("#4329EA")
        barDataSet.valueTextSize = 0.0f

        val barData = BarData(barDataSet)
        barData.barWidth = 0.39f
        binding.chart3.setFitBars(false)

        val xAxis: XAxis = binding.chart3.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 10f
        xAxis.textColor = Color.BLACK
        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter=MyXAxis3Formatter()
        xAxis.labelCount = 6
        xAxis.isForceLabelsEnabled

        val left: YAxis = binding.chart3.axisLeft
        val rightAxis: YAxis = binding.chart3.axisRight
        rightAxis.isEnabled = false
        left.valueFormatter = MyYAxis2Formatter()
        left.labelCount = 4
        left.isForceLabelsEnabled

        binding.chart3.description.text = ""
        binding.chart3.data = barData
        binding.chart3.setVisibleXRangeMaximum(6f)
        binding.chart3.setVisibleXRangeMinimum(0f)
        binding.chart3.invalidate()
        binding.chart3.animateXY(1000,1000)

    }
    fun graph4()
    {

        val chartData = ArrayList<BarEntry>()
        chartData.add(BarEntry(1f, 1f))
        chartData.add(BarEntry(2f,0.33f))
        chartData.add(BarEntry(3f, 0.72f))
        chartData.add(BarEntry(4f, 0.8f))
        chartData.add(BarEntry(5f, 0.4f))
        chartData.add(BarEntry(6f, 0.25f))
        chartData.add(BarEntry(7f, 0.55f))
        chartData.add(BarEntry(8f, 0.15f))
        chartData.add(BarEntry(9f, 0.65f))
        chartData.add(BarEntry(10f, 0.55f))
        chartData.add(BarEntry(11f, 0.45f))
        chartData.add(BarEntry(12f, 0.35f))


        val barDataSet = BarDataSet(chartData, "FAILURE")
        barDataSet.color = Color.parseColor("#80ED9017")
        barDataSet.isHighlightEnabled
        barDataSet.highLightColor = Color.parseColor("#ED9017")
        barDataSet.valueTextSize = 0.0f

        val barData = BarData(barDataSet)
        barData.barWidth = 0.39f
        binding.chart4.setFitBars(false)

        val xAxis: XAxis = binding.chart4.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 10f
        xAxis.textColor = Color.BLACK
        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter=MyXAxis3Formatter()
        xAxis.labelCount = 6
        xAxis.isForceLabelsEnabled

        val left: YAxis = binding.chart4.axisLeft
        val rightAxis: YAxis = binding.chart4.axisRight
        rightAxis.isEnabled = false
        left.valueFormatter = MyYAxis2Formatter()
        left.labelCount = 4
        left.isForceLabelsEnabled

        binding.chart4.description.text = ""
        binding.chart4.data = barData
        binding.chart4.setVisibleXRangeMaximum(6f)
        binding.chart4.setVisibleXRangeMinimum(0f)
        binding.chart4.invalidate()
        binding.chart4.animateXY(1000,1000)

    }
}