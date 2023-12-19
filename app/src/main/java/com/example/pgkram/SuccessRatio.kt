package com.example.pgkram

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue

class SuccessRatio : Fragment() {

    lateinit var _binding: FragmentSuccessRatioBinding
    private val binding get() = _binding!!

    private val database = FirebaseDatabase.getInstance()
    private val new = database.getReference("Retention/NewGraph/2023")
    private val old = database.getReference("Retention/ReturningGraph/2023")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_success_ratio, container, false)

        _binding = FragmentSuccessRatioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        graph3()
        graph4()
    }

    override fun onResume() {
        super.onResume()

        graph3()
        graph4()
    }

    fun graph3() {
        old.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val snapshot = task.result
                var jan = snapshot.child("Jan").getValue<Int>()?.toFloat() ?: 0.0f
                var feb = snapshot.child("Feb").getValue<Int>()?.toFloat() ?: 0.0f
                var mar = snapshot.child("Mar").getValue<Int>()?.toFloat() ?: 0.0f
                var apr = snapshot.child("Apr").getValue<Int>()?.toFloat() ?: 0.0f
                var may = snapshot.child("May").getValue<Int>()?.toFloat() ?: 0.0f
                var jun = snapshot.child("Jun").getValue<Int>()?.toFloat() ?: 0.0f
                var jul = snapshot.child("Jul").getValue<Int>()?.toFloat() ?: 0.0f
                var aug = snapshot.child("Aug").getValue<Int>()?.toFloat() ?: 0.0f
                var sep = snapshot.child("Sep").getValue<Int>()?.toFloat() ?: 0.0f
                var oct = snapshot.child("Oct").getValue<Int>()?.toFloat() ?: 0.0f
                var nov = snapshot.child("Nov").getValue<Int>()?.toFloat() ?: 0.0f
                var dec = snapshot.child("Dec").getValue<Int>()?.toFloat() ?: 0.0f

                Log.d("Jobapr", "$apr")

                val chartData = ArrayList<BarEntry>()
                chartData.add(BarEntry(1f, jan))
                chartData.add(BarEntry(2f, feb))
                chartData.add(BarEntry(3f, mar))
                chartData.add(BarEntry(4f, apr))
                chartData.add(BarEntry(5f, may))
                chartData.add(BarEntry(6f, jun))
                chartData.add(BarEntry(7f, jul))
                chartData.add(BarEntry(8f, aug))
                chartData.add(BarEntry(9f, sep))
                chartData.add(BarEntry(10f, oct))
                chartData.add(BarEntry(11f, nov))
                chartData.add(BarEntry(12f, dec))


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
                xAxis.valueFormatter = MyXAxis3Formatter()
                xAxis.labelCount = 6
                xAxis.isForceLabelsEnabled

                val left: YAxis = binding.chart3.axisLeft
                val rightAxis: YAxis = binding.chart3.axisRight
                rightAxis.isEnabled = false
                left.labelCount = 4
                left.isForceLabelsEnabled

                binding.chart3.description.text = ""
                binding.chart3.data = barData
                binding.chart3.setVisibleXRangeMaximum(6f)
                binding.chart3.setVisibleXRangeMinimum(0f)
                binding.chart3.isScaleXEnabled = false
                binding.chart3.invalidate()
                binding.chart3.animateXY(1000, 1000)

            } else {
                Log.e("Firebase", "Error getting data", task.exception)
            }


        }
    }

    fun graph4() {

        new.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val snapshot = task.result
                var jan = snapshot.child("Jan").getValue<Int>()?.toFloat() ?: 0.0f
                var feb = snapshot.child("Feb").getValue<Int>()?.toFloat() ?: 0.0f
                var mar = snapshot.child("Mar").getValue<Int>()?.toFloat() ?: 0.0f
                var apr = snapshot.child("Apr").getValue<Int>()?.toFloat() ?: 0.0f
                var may = snapshot.child("May").getValue<Int>()?.toFloat() ?: 0.0f
                var jun = snapshot.child("Jun").getValue<Int>()?.toFloat() ?: 0.0f
                var jul = snapshot.child("Jul").getValue<Int>()?.toFloat() ?: 0.0f
                var aug = snapshot.child("Aug").getValue<Int>()?.toFloat() ?: 0.0f
                var sep = snapshot.child("Sep").getValue<Int>()?.toFloat() ?: 0.0f
                var oct = snapshot.child("Oct").getValue<Int>()?.toFloat() ?: 0.0f
                var nov = snapshot.child("Nov").getValue<Int>()?.toFloat() ?: 0.0f
                var dec = snapshot.child("Dec").getValue<Int>()?.toFloat() ?: 0.0f


                val chartData = ArrayList<BarEntry>()
                chartData.add(BarEntry(1f, jan))
                chartData.add(BarEntry(2f, feb))
                chartData.add(BarEntry(3f, mar))
                chartData.add(BarEntry(4f, apr))
                chartData.add(BarEntry(5f, may))
                chartData.add(BarEntry(6f, jun))
                chartData.add(BarEntry(7f, jul))
                chartData.add(BarEntry(8f, aug))
                chartData.add(BarEntry(9f, sep))
                chartData.add(BarEntry(10f, oct))
                chartData.add(BarEntry(11f, nov))
                chartData.add(BarEntry(12f, dec))


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
                left.labelCount = 4
                left.isForceLabelsEnabled

                binding.chart4.description.text = ""
                binding.chart4.data = barData
                binding.chart4.setVisibleXRangeMaximum(6f)
                binding.chart4.setVisibleXRangeMinimum(0f)
                binding.chart4.isScaleXEnabled = false
                binding.chart4.invalidate()
                binding.chart4.animateXY(1000,1000)

            } else {
                Log.e("Firebase", "Error getting data", task.exception)
            }

        }
    }
}