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
        return String.format("%d%%", (value*100).toInt())
    }
}

class MyXAxis3Formatter : ValueFormatter() {

    private val days = arrayOf("Jan", "Feb", "Mar","Apr","May","Jun", "Jul", "Aug", "Sep", "Oct","Nov","Dec")
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {

        return when (value) {
            1.0f -> days[0]
            2.0f -> days[1]
            3.0f -> days[2]
            4.0f -> days[3]
            5.0f -> days[4]
            6.0f -> days[5]
            7.0f -> days[6]
            8.0f -> days[7]
            9.0f -> days[8]
            10.0f -> days[9]
            11.0f -> days[10]
            12.0f -> days[11]
            else -> days.getOrNull(value.toInt()) ?: value.toString()
        }
    }
}
class MyYAxis2Formatter : ValueFormatter() {

    private val days = listOf("0%", "25%", "50%", "100%")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String? {
        return String.format("%.0f", value * 1000)
    }
}
class LineFormatter : ValueFormatter() {

    private val days = listOf("SEP 7,2023", "SEP 8,2023", "SEP 25,2023", "OCT 2,2023", "OCT 20,2023")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String? {
        return when (value) {
            1.0f -> days[0]
            2.0f -> days[1]
            3.0f -> days[2]
            4.0f -> days[3]
            5.0f -> days[4]
            else -> days.getOrNull(value.toInt()) ?: value.toString()
        }
    }
}

class MyXAxis4Formatter : ValueFormatter() {

    private val days = listOf("Amritsar", "Jalandhar","Bathinda","Kapulthas")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {

        return when (value) {
            1.0f -> days[0]
            2.0f -> days[1]
            3.0f -> days[2]
            4.0f -> days[3]
            else -> days.getOrNull(value.toInt()) ?: value.toString()
        }
        // return days.getOrNull(value.toInt()) ?: value.toString()
    }
}
class MyXAxis5Formatter : ValueFormatter() {

    private val days = listOf("Whatsapp", "Facebook","Google ads","Unknown")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {

        return when (value) {
            1.0f -> days[0]
            2.0f -> days[1]
            3.0f -> days[2]
            4.0f -> days[3]
            else -> days.getOrNull(value.toInt()) ?: value.toString()
        }
        // return days.getOrNull(value.toInt()) ?: value.toString()
    }
}
class MyXAxis6Formatter : ValueFormatter() {

    private val days = listOf("MOBILE", "DESKTOP")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {

        return when (value) {
            1.0f -> days[0]
            2.0f -> days[1]
            else -> days.getOrNull(value.toInt()) ?: value.toString()
        }
        // return days.getOrNull(value.toInt()) ?: value.toString()
    }
}

class MyYAxis6Formatter : ValueFormatter() {
    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        // Round value to one decimal place
        val roundedValue = String.format("%.1f", value)

        // Add "%" symbol and return formatted string
        return "$roundedValue%"
    }
}

