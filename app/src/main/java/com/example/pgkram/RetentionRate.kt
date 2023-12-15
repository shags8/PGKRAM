package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
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
import com.github.mikephil.charting.utils.ViewPortHandler
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
    }

    fun graph1(){

        val xValues = ArrayList<String>()
        xValues.add("SEP 7,2023")
        xValues.add("SEP 14,2023")
        xValues.add("SEP 21,2023")

        val yValues = ArrayList<Entry>()
        yValues.add(Entry(0f, 5000f))
        yValues.add(Entry(1f, 4000f))
        yValues.add(Entry(2f, 3000f))

        val lineDataSet = LineDataSet(yValues, "Returning Users")

        lineDataSet.lineWidth = 4f
        lineDataSet.color = Color.parseColor("#4285F4")
        lineDataSet.circleRadius = 6f
        lineDataSet.valueTextSize = 12f
        lineDataSet.valueTextColor = Color.BLACK

        val lineData = LineData(lineDataSet)
        binding.chart5.data = lineData

        val xAxis: XAxis = binding.chart5.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 10f
        xAxis.textColor = Color.BLACK
        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(
                value: Float,
                entry: Entry?,
                dataSetIndex: Int,
                viewPortHandler: ViewPortHandler?
            ): String? {
                return xValues[value.toInt()]
            }
        }

        val left: YAxis = binding.chart5.axisLeft
        val rightAxis: YAxis = binding.chart5.axisRight
        rightAxis.isEnabled = false
        left.axisMinimum = 0f
        left.axisMaximum = 5000f
        binding.chart5.animateY(1000)


    }

}
