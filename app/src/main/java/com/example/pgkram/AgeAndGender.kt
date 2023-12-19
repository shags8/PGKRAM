package com.example.pgkram

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue
import kotlin.properties.Delegates


// TODO: Rename parameter arguments, choose names that match

class AgeAndGender : Fragment() {

    lateinit var _binding: FragmentAgeAndGenderBinding
    private val binding get() = _binding!!

    private val database = FirebaseDatabase.getInstance()
    private val genderRef = database.getReference("Gender")
    private var maleValue : Float = 0.0f
    private var femaleValue :Float = 0.0f


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_age_and_gender, container, false)

        _binding= FragmentAgeAndGenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        graph2()
        graph1()
    }

    override fun onResume() {
        super.onResume()

        graph2()
        graph1()

    }

    fun graph2(){


        genderRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val snapshot = task.result
                femaleValue = snapshot.child("Female").getValue<Int>()?.toFloat() ?: 0.0f
                maleValue = snapshot.child("Male").getValue<Int>()?.toFloat() ?: 0.0f


                val chartData = ArrayList<BarEntry>()
                chartData.add(BarEntry(1f,maleValue))
                chartData.add(BarEntry(2f,femaleValue))

                val barDataSet = BarDataSet(chartData, "GENDER")
                barDataSet.color = Color.parseColor("#994329EA")
                barDataSet.isHighlightEnabled
                barDataSet.highLightColor = Color.parseColor("#4329EA")
                barDataSet.valueTextSize = 0.0f

                val barData = BarData(barDataSet)
                barData.barWidth = 0.38f
                binding.chart2.setFitBars(true)
                binding.chart2.invalidate()


                val xAxis: XAxis = binding.chart2.xAxis
                xAxis.position = XAxisPosition.BOTTOM
                xAxis.textSize = 10f
                xAxis.labelCount =2
                xAxis.textColor = Color.BLACK
                xAxis.setDrawGridLines(false)
                xAxis.valueFormatter=MyXAxis2Formatter()

                val left: YAxis = binding.chart2.getAxisLeft()
                val rightAxis: YAxis = binding.chart2.axisRight
                rightAxis.isEnabled = false
                left.labelCount = 5
                left.isForceLabelsEnabled

                binding.chart2.description.text = ""
                binding.chart2.data = barData
                binding.chart2.isScaleXEnabled = false
                binding.chart2.animateXY(2500,2500)



            } else {
                Log.e("Firebase", "Error getting data", task.exception)
            }
        }

    }
    fun graph1()
    {
        val chartData = ArrayList<BarEntry>()
        chartData.add(BarEntry(1f, 1f))
        chartData.add(BarEntry(2f,0.33f))
        chartData.add(BarEntry(3f, 0.72f))
        chartData.add(BarEntry(4f, 0.8f))
        chartData.add(BarEntry(5f, 0.4f))
        chartData.add(BarEntry(6f, 0.25f))

        val barDataSet = BarDataSet(chartData, "AGE")
        barDataSet.color = Color.parseColor("#994329EA")
        barDataSet.isHighlightEnabled
        barDataSet.highLightColor = Color.parseColor("#4329EA")
        barDataSet.valueTextSize = 0.0f

        val barData = BarData(barDataSet)
        barData.barWidth = 0.38f
        binding.chart1.setFitBars(true)
        binding.chart1.invalidate()


        val xAxis: XAxis = binding.chart1.xAxis
        xAxis.position = XAxisPosition.BOTTOM
        xAxis.textSize = 10f
        xAxis.textColor = Color.BLACK
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter=MyXAxisFormatter()

        val left: YAxis = binding.chart1.getAxisLeft()
        val rightAxis: YAxis = binding.chart1.axisRight
        rightAxis.isEnabled = false
        left.valueFormatter = MyYAxisFormatter()
        left.labelCount = 4
        left.isForceLabelsEnabled


        binding.chart1.description.text = ""
        binding.chart1.data = barData
        binding.chart1.isScaleXEnabled = false
        binding.chart1.animateXY(1000,1000)

    }

}