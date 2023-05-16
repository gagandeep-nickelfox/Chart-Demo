package com.gagan.chartdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gagan.chartdemo.databinding.ActivityMainBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val yValues = (1..50).mapIndexed { index, i -> Entry(index.toFloat(), i.toFloat()) }

        val yValues2 = (1..50).mapIndexed { index, i -> Entry(index.toFloat(), 30.toFloat()) }


            val a = LineDataSet(yValues2, "Baseline").apply {
                this.color = Color.YELLOW
                this.setCircleColor(Color.YELLOW)
                this.setDrawCircles(false)
            }
            val b = LineDataSet(yValues, "Employee Progress").apply {
                this.color = Color.CYAN
                this.setCircleColor(Color.CYAN)
                this.setDrawCircles(false)
                this.setDrawFilled(true)

            }

        b.fillColor = Color.RED
        b.fillFormatter = MyFillFormatter(a)


        binding.lineChart.apply {
            this.setBackgroundColor(Color.GRAY)
            this.data = LineData(
                listOf(a, b)
            ).apply {
                this.setDrawValues(false)
            }
            renderer = MyLineLegendRenderer(this, this.animator, this.viewPortHandler)
        }
    }
}