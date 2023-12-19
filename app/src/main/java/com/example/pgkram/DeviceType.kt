package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pgkram.databinding.FragmentAgeAndGenderBinding
import com.example.pgkram.databinding.FragmentDeviceTypeBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class DeviceType : Fragment() {

    lateinit var _binding: FragmentDeviceTypeBinding
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_device_type, container, false)

        _binding= FragmentDeviceTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        graph1()
    }

    fun graph1()
    {

        val chartData = ArrayList<BarEntry>()
        chartData.add(BarEntry(1f, 0.665f))
        chartData.add(BarEntry(2f,0.350f))
        chartData.add(BarEntry(3f,0.300f))

        val barDataSet = BarDataSet(chartData, "Device")
        barDataSet.color = Color.parseColor("#994329EA")
        barDataSet.isHighlightEnabled
        barDataSet.highLightColor = Color.parseColor("#4329EA")
        barDataSet.valueTextSize = 0.0f

        val barData = BarData(barDataSet)
        barData.barWidth = 0.38f
        binding.chart.setFitBars(true)
        binding.chart.invalidate()


        val xAxis: XAxis = binding.chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 10f
        xAxis.labelCount =3
        xAxis.textColor = Color.BLACK
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter=MyXAxis6Formatter()

        val left: YAxis = binding.chart.getAxisLeft()
        val rightAxis: YAxis = binding.chart.axisRight
        rightAxis.isEnabled = false
        left.labelCount = 3
        left.axisMaximum = 1f
        left.axisMinimum=0f
        left.granularity=0.25f
        left.isForceLabelsEnabled
        left.valueFormatter = MyYAxisFormatter()

        binding.chart.description.text = ""
        binding.chart.data = barData
        binding.chart.isScaleXEnabled = false
        binding.chart.animateXY(1000,1000)


    }
}