package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pgkram.databinding.FragmentRetentionRateBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ViewPortHandler
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.logEvent
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue
import java.util.Calendar


class RetentionRate : Fragment() {

    lateinit var _binding : FragmentRetentionRateBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_retention_rate, container, false)
        _binding= FragmentRetentionRateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        graph1()
        graph2()

    }

    override fun onResume() {
        super.onResume()
        graph1()
        graph2()
    }

    fun graph1(){


        val xValues = ArrayList<String>()
        xValues.add("SEP 7,2023")
        xValues.add("SEP 14,2023")
        xValues.add("SEP 21,2023")

        val yValues = ArrayList<Entry>()
        yValues.add(Entry(1f, 0.22f))
        yValues.add(Entry(2f, 0.34f))
        yValues.add(Entry(3f, 0.30f))
        yValues.add(Entry(4f, 0.42f))
        yValues.add(Entry(5f, 0.15f))

        val lineDataSet = LineDataSet(yValues, "Returning Users")

        lineDataSet.lineWidth = 2.5f
        lineDataSet.setDrawCircles(false)
        lineDataSet.color = Color.parseColor("#4285F4")
        lineDataSet.valueTextSize = 0.0f
        lineDataSet.valueTextColor = Color.BLACK

        val lineData = LineData(lineDataSet)
        binding.chart5.data = lineData
        binding.chart5.isScaleXEnabled = false


        val xAxis: XAxis = binding.chart5.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 9f
        xAxis.textColor = Color.BLACK
        xAxis.labelRotationAngle = 50F
        xAxis.labelCount=5
        xAxis.isForceLabelsEnabled
        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter = LineFormatter()

        val left: YAxis = binding.chart5.axisLeft
        val rightAxis: YAxis = binding.chart5.axisRight
        rightAxis.isEnabled = false
        left.setDrawGridLines(false)
        left.valueFormatter = MyYAxis2Formatter()
        left.axisMinimum = 0f
        left.axisMaximum = 1f
        binding.chart5.animateY(1000)
        binding.chart5.description.isEnabled = false

    }

    fun graph2(){

        val xValues = ArrayList<String>()
        xValues.add("SEP 7,2023")
        xValues.add("SEP 14,2023")
        xValues.add("SEP 21,2023")

        val yValues = ArrayList<Entry>()
        yValues.add(Entry(1f, 0.22f))
        yValues.add(Entry(2f, 0.74f))
        yValues.add(Entry(3f, 0.50f))
        yValues.add(Entry(4f, 0.82f))
        yValues.add(Entry(5f, 0.15f))

        val lineDataSet = LineDataSet(yValues, "New Users")

        lineDataSet.lineWidth = 2.5f
        lineDataSet.setDrawCircles(false)
        lineDataSet.color = Color.parseColor("#4285F4")
        lineDataSet.valueTextSize = 0.0f
        lineDataSet.valueTextColor = Color.BLACK

        val lineData = LineData(lineDataSet)
        binding.chart6.data = lineData
        binding.chart6.isScaleXEnabled = false

        val xAxis: XAxis = binding.chart6.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 9f
        xAxis.textColor = Color.BLACK
        xAxis.labelRotationAngle = 50F
        xAxis.labelCount=5
        xAxis.isForceLabelsEnabled
        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter = LineFormatter()

        val left: YAxis = binding.chart6.axisLeft
        val rightAxis: YAxis = binding.chart6.axisRight
        rightAxis.isEnabled = false
        left.setDrawGridLines(false)
        left.valueFormatter = MyYAxis2Formatter()
        left.axisMinimum = 0f
        left.axisMaximum = 1f
        binding.chart6.animateY(1000)
        binding.chart6.description.text = ""

    }

}
