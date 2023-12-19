package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue

// TODO: Rename parameter arguments, choose names that match

class Location : Fragment() {


    lateinit var _binding: FragmentLocationBinding
    private val binding get() = _binding!!

    private val database = FirebaseDatabase.getInstance()
    private val genderRef = database.getReference("Location")
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

    override fun onResume() {
        super.onResume()
        graph1()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        graph1()

    }
    fun graph1(){

        genderRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val snapshot = task.result
                var amritsar = snapshot.child("Amritsar").getValue<Int>()?.toFloat() ?: 0.0f
                var jalandhar = snapshot.child("Jalandar").getValue<Int>()?.toFloat() ?: 0.0f
                var bathinda = snapshot.child("Bhatinda").getValue<Int>()?.toFloat() ?: 0.0f
                var kapulthas = snapshot.child("Kapulthas").getValue<Int>()?.toFloat() ?: 0.0f
                Log.e("Firebase", "Error getting data1", task.exception)

                val chartData = ArrayList<BarEntry>()
                chartData.add(BarEntry(3f, bathinda))
                chartData.add(BarEntry(2f, jalandhar))
                chartData.add(BarEntry(4f, kapulthas))
                chartData.add(BarEntry(1f, amritsar))

                val barDataSet = BarDataSet(chartData, "LOCATION")
                barDataSet.color = Color.parseColor("#994329EA")
                barDataSet.isHighlightEnabled
                barDataSet.highLightColor = Color.parseColor("#4329EA")
                barDataSet.valueTextSize = 0.0f

                val barData = BarData(barDataSet)
                barData.barWidth = 0.2f

                val chartView = binding.chartView

                chartView.setFitBars(true)
                chartView.invalidate()

                val xAxis: XAxis = chartView.xAxis
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.textSize = 15f
                xAxis.labelCount = 4
                xAxis.textColor = Color.BLACK
                xAxis.setDrawAxisLine(false)
                xAxis.setDrawGridLines(false)
                xAxis.valueFormatter = MyXAxis4Formatter()

                val left: YAxis = chartView.getAxisLeft()
                val rightAxis: YAxis = chartView.axisRight
                left.axisMinimum = -2000f
                rightAxis.isEnabled = false
                left.isEnabled = false

                chartView.description.text = ""
                chartView.data = barData
                chartView.isScaleXEnabled = false
                chartView.isScaleYEnabled = false
                chartView.animateXY(1000, 1000)



            } else {
                Log.e("Firebase", "Error getting data", task.exception)
            }

        }
    }

}