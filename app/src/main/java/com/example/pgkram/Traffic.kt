package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pgkram.databinding.FragmentLocationBinding
import com.example.pgkram.databinding.FragmentTrafficBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue

class Traffic : Fragment() {



    lateinit var _binding: FragmentTrafficBinding
    private val binding get() = _binding!!

    private val database = FirebaseDatabase.getInstance()
    private val genderRef = database.getReference("Platform")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_traffic, container, false)
        _binding= FragmentTrafficBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        genderRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val snapshot = task.result
                var whatsapp = snapshot.child("Whatsapp").getValue<Int>()?.toFloat() ?: 0.0f
                var google = snapshot.child("GoogleAds").getValue<Int>()?.toFloat() ?: 0.0f
                var fb = snapshot.child("Facebook").getValue<Int>()?.toFloat() ?: 0.0f
                var unknown = snapshot.child("Unknown").getValue<Int>()?.toFloat() ?: 0.0f

                val chartView = binding.chartView

                val chartData = ArrayList<BarEntry>()
                chartData.add(BarEntry(1f, whatsapp))
                chartData.add(BarEntry(2f,fb))
                chartData.add(BarEntry(3f,google))
                chartData.add(BarEntry(4f,unknown))

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
                xAxis.valueFormatter=MyXAxis5Formatter()

                val left: YAxis = chartView.getAxisLeft()
                val rightAxis: YAxis = chartView.axisRight
                left.axisMinimum = -2000f
                rightAxis.isEnabled = false
                left.isEnabled = false

                chartView.description.text = ""
                chartView.data = barData
                chartView.isScaleXEnabled = false
                chartView.isScaleYEnabled = false
                chartView.animateXY(1000,1000)



            } else {
                Log.e("Firebase", "Error getting data", task.exception)
            }
        }
    }
    fun graph1()
    {
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
        xAxis.valueFormatter=MyXAxis5Formatter()

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