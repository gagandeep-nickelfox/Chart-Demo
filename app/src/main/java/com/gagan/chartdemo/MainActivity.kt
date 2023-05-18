package com.gagan.chartdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gagan.chartdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fillColor = Color.argb(150, 51, 161, 51)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val yValues = (1..50).mapIndexed { index, i -> Entry(index.toFloat(), i.toFloat()) }

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
        b.fillFormatter = MyFillFormatter(a)*/


        binding.lineChart.apply {
            this.setBackgroundColor(Color.GRAY)
            setTouchEnabled(false)
            setPinchZoom(false)
            description.isEnabled = false
            legend.isEnabled = false
            setDrawGridBackground(false)
            axisRight.isEnabled = false
            this.data = getLineData(
                listOf(
                    Pair(1.0f, 30.0f),
                    Pair(2.0f, 36.0f),
                    Pair(3.0f, 42.0f),
                    Pair(4.0f, 38.0f),
                    Pair(5.0f, 48.0f),
                    Pair(6.0f, 50.0f)
                ),
                listOf(
                    Pair(1.0f, 20.0f),
                    Pair(2.0f, 23.0f),
                    Pair(3.0f, 33.0f),
                    Pair(4.0f, 46.0f),
                    Pair(5.0f, 35.0f),
                    Pair(6.0f, 55.0f)
                ),
                -250f,
                900f
            ).apply {
                this.setDrawValues(true)
            }
            renderer = MyLineLegendRenderer(this, this.animator, this.viewPortHandler)

            //This is grid background
            /*setBackgroundColor(Color.WHITE)
            setGridBackgroundColor(fillColor)
            setDrawGridBackground(true)

            setDrawBorders(true)

            // no description text

            // no description text
            description.isEnabled = false

            // if disabled, scaling can be done on x- and y-axis separately

            // if disabled, scaling can be done on x- and y-axis separately
            setPinchZoom(false)

            val l: Legend = legend
            l.isEnabled = false

            val xAxis: XAxis = xAxis
            xAxis.isEnabled = false

            val leftAxis: YAxis = axisLeft
            leftAxis.axisMaximum = 900f
            leftAxis.axisMinimum = -250f
            leftAxis.setDrawAxisLine(false)
            leftAxis.setDrawZeroLine(false)
            leftAxis.setDrawGridLines(false)

            axisRight.isEnabled = false

            // add data
            setData(100, 60f)

            invalidate()*/
        }
    }

    private fun setData(count: Int, range: Float) = binding.apply {
        /*val values1 = ArrayList<Entry>()
        for (i in 0 until count) {
            val `val` = (Math.random() * range).toFloat() + 50
            values1.add(Entry(i.toFloat(), `val`))
        }
        val values2 = ArrayList<Entry>()
        for (i in 0 until count) {
            val `val` = (Math.random() * range).toFloat() + 450
            values2.add(Entry(i.toFloat(), `val`))
        }*/
        val values1 = listOf(
            Pair(1.0f, 30.0f),
            Pair(2.0f, 36.0f),
            Pair(3.0f, 42.0f),
            Pair(4.0f, 38.0f),
            Pair(5.0f, 48.0f),
            Pair(6.0f, 50.0f)
        )
        val values2 = listOf(
            Pair(1.0f, 20.0f),
            Pair(2.0f, 23.0f),
            Pair(3.0f, 33.0f),
            Pair(4.0f, 46.0f),
            Pair(5.0f, 35.0f),
            Pair(6.0f, 55.0f)
        )
        val axisLeftMax = lineChart.axisLeft.mAxisMaximum
        val axisLeftMin = lineChart.axisLeft.mAxisMinimum
        /*if (lineChart.data != null &&
            lineChart.data.dataSetCount > 0
        ) {
            set1 = lineChart.data.getDataSetByIndex(0) as LineDataSet
            set2 = lineChart.data.getDataSetByIndex(1) as LineDataSet
            set1.values = values1
            set2.values = values2
            lineChart.data.notifyDataChanged()
            lineChart.notifyDataSetChanged()
        } else {*/
        // create a dataset and give it a type
        /*val set1 = LineDataSet(values1, "DataSet 1")
            set1.axisDependency = YAxis.AxisDependency.LEFT
            set1.color = Color.rgb(255, 241, 46)
            set1.setDrawCircles(false)
            set1.lineWidth = 2f
            set1.circleRadius = 3f
            set1.fillAlpha = 255
            set1.setDrawFilled(true)
            set1.fillColor = Color.WHITE
            set1.highLightColor = Color.rgb(244, 117, 117)
            set1.setDrawCircleHole(false)
            set1.fillFormatter =
                IFillFormatter { _, _ -> // change the return value here to better understand the effect
                    // return 0;
                    lineChart.axisLeft.axisMinimum
                }

            // create a dataset and give it a type
        val set2 = LineDataSet(values2, "DataSet 2")
            set2.axisDependency = YAxis.AxisDependency.LEFT
            set2.color = Color.rgb(255, 241, 46)
            set2.setDrawCircles(false)
            set2.lineWidth = 2f
            set2.circleRadius = 3f
            set2.fillAlpha = 255
            set2.setDrawFilled(true)
            set2.fillColor = Color.WHITE
            set2.setDrawCircleHole(false)
            set2.highLightColor = Color.rgb(244, 117, 117)
            set2.fillFormatter =
                IFillFormatter { _, _ -> // change the return value here to better understand the effect
                    // return 600;
                    lineChart.axisLeft.axisMaximum
                }
            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(set1) // add the data sets
            dataSets.add(set2)

            // create a data object with the data sets
            val data = LineData(dataSets)*/
        //data.setDrawValues(true)

        // set data
        lineChart.data = getLineData(values1, values2, axisLeftMin, axisLeftMax)
        //}
    }
}