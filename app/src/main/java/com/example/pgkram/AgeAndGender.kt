package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pgkram.databinding.FragmentAgeAndGenderBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.math.BigDecimal


// TODO: Rename parameter arguments, choose names that match

class AgeAndGender : Fragment() {

    lateinit var _binding: FragmentAgeAndGenderBinding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_age_and_gender, container, false)

        _binding= FragmentAgeAndGenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chartData = ArrayList<BarEntry>()
            chartData.add(BarEntry(1f, 1f))
            chartData.add(BarEntry(2f,0.33f))
            chartData.add(BarEntry(3f, 0.7f))
            chartData.add(BarEntry(4f, 0.5f))
            chartData.add(BarEntry(5f, 0.4f))
            chartData.add(BarEntry(6f, 0.25f))


        val barDataSet = BarDataSet(chartData, "AGE")
        barDataSet.color = Color.parseColor("#994329EA")
        barDataSet.valueTextSize = 0.0f

        val barData = BarData(barDataSet)
        barData.barWidth = 0.38f
        binding.chart1.setFitBars(true)
        binding.chart1.invalidate()


        val xAxis: XAxis = binding.chart1.xAxis
        xAxis.position = XAxisPosition.BOTTOM
        xAxis.textSize = 10f
        xAxis.textColor = Color.BLACK
        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter=MyXAxisFormatter()

        val left: YAxis = binding.chart1.getAxisLeft()
        val rightAxis: YAxis = binding.chart1.axisRight
        rightAxis.isEnabled = false
        left.valueFormatter = MyYAxisFormatter()
        left.labelCount = 4
        left.isForceLabelsEnabled


        binding.chart1.data = barData
        binding.chart1.animateXY(1000,1000)


//        val chartData: MutableList<dataclassAge> = mutableListOf(
//            dataclassAge("18-24", 35.5),
//            dataclassAge("25-34", 42.1),
//            dataclassAge("35-44", 18.7),
//            dataclassAge("45-54", 3.2),
//            dataclassAge("55+", 0.5)
//        )



    }

}