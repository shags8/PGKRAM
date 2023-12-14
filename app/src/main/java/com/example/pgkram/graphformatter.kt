package com.example.pgkram

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class MyXAxisFormatter : ValueFormatter() {

    private val days = listOf("18-23", "24-29", "30-35", "36-41", "42-47", "48-55")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {

        return when (value) {
            1.0f -> days[0]
            2.0f -> days[1]
            3.0f -> days[2]
            4.0f -> days[3]
            5.0f -> days[4]
            6.0f -> days[5]
            else -> days.getOrNull(value.toInt()) ?: value.toString()
        }
       // return days.getOrNull(value.toInt()) ?: value.toString()
    }
}

class MyXAxis2Formatter : ValueFormatter() {

    private val days = listOf("BOYS", "GIRLS")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {

        return when (value) {
            1.0f -> days[0]
            2.0f -> days[1]
            else -> days.getOrNull(value.toInt()) ?: value.toString()
        }
        // return days.getOrNull(value.toInt()) ?: value.toString()
    }
}

class MyYAxisFormatter : ValueFormatter() {

    private val days = listOf("0%", "25%", "50%", "100%")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String? {
        return String.format("%d%%", (value * 100).toInt())
    }
}

class MyChartListener : OnChartValueSelectedListener {
    override fun onValueSelected(e: Entry?, h: Highlight?) {

    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

}