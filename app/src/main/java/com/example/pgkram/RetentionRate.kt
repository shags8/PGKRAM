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

    private val database = FirebaseDatabase.getInstance()
    private val new = database.getReference("Retention/NewGraph/2023")
    private val old = database.getReference("Retention/ReturningGraph/2023")

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


                val yValues = ArrayList<Entry>()
                yValues.add(Entry(1f, jan))
                yValues.add(Entry(2f, feb))
                yValues.add(Entry(3f, mar))
                yValues.add(Entry(4f, apr))
                yValues.add(Entry(5f, may))
                yValues.add(Entry(6f, jun))
                yValues.add(Entry(7f, jul))
                yValues.add(Entry(8f, aug))
                yValues.add(Entry(9f, sep))
                yValues.add(Entry(10f, oct))
                yValues.add(Entry(11f, nov))
                yValues.add(Entry(12f, dec))

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
                xAxis.labelCount=6
                binding.chart5.setVisibleXRangeMaximum(6f)
                binding.chart5.setVisibleXRangeMinimum(0f)
                xAxis.isForceLabelsEnabled
                xAxis.setDrawAxisLine(true)
                xAxis.setDrawGridLines(false)
                xAxis.valueFormatter = MyXAxis3Formatter()

                val left: YAxis = binding.chart5.axisLeft
                val rightAxis: YAxis = binding.chart5.axisRight
                rightAxis.isEnabled = false
                left.setDrawGridLines(false)
                left.valueFormatter = MyYAxis2Formatter()
                binding.chart5.animateY(1000)
                binding.chart5.description.isEnabled = false

            }
            else {
                Log.e("Firebase", "Error getting data", task.exception)
            }
        }


    }

    fun graph2(){

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


                val yValues = ArrayList<Entry>()
                yValues.add(Entry(1f, jan))
                yValues.add(Entry(2f, feb))
                yValues.add(Entry(3f, mar))
                yValues.add(Entry(4f, apr))
                yValues.add(Entry(5f, may))
                yValues.add(Entry(6f, jun))
                yValues.add(Entry(7f, jul))
                yValues.add(Entry(8f, aug))
                yValues.add(Entry(9f, sep))
                yValues.add(Entry(10f, oct))
                yValues.add(Entry(11f, nov))
                yValues.add(Entry(12f, dec))

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
                xAxis.labelCount=6
                binding.chart6.setVisibleXRangeMaximum(6f)
                binding.chart6.setVisibleXRangeMinimum(0f)
                xAxis.isForceLabelsEnabled
                xAxis.setDrawAxisLine(true)
                xAxis.setDrawGridLines(false)
                xAxis.valueFormatter = MyXAxis3Formatter()

                val left: YAxis = binding.chart6.axisLeft
                val rightAxis: YAxis = binding.chart6.axisRight
                rightAxis.isEnabled = false
                left.setDrawGridLines(false)
                left.valueFormatter = MyYAxis2Formatter()
                binding.chart6.animateY(1000)
                binding.chart6.description.isEnabled = false

            }
            else {
                Log.e("Firebase", "Error getting data", task.exception)
            }
        }

    }

}
