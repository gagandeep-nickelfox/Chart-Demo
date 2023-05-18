package com.gagan.chartdemo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.util.Log
import androidx.core.internal.view.SupportMenu
import androidx.core.view.InputDeviceCompat
import com.github.mikephil.charting.animation.ChartAnimator
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.renderer.LineChartRenderer
import com.github.mikephil.charting.utils.Transformer
import com.github.mikephil.charting.utils.ViewPortHandler


class MyFillFormatter //Pass the dataset of other line in the Constructor
@JvmOverloads constructor(private val boundaryDataSet: ILineDataSet? = null) :
    IFillFormatter {
    override fun getFillLinePosition(dataSet: ILineDataSet, dataProvider: LineDataProvider): Float {
        return 0f
    }

    //Define a new method which is used in the LineChartRenderer
    val fillLineBoundary: MutableList<Entry>?
        get() = if (boundaryDataSet != null) {
            (boundaryDataSet as LineDataSet).values
        } else null

}

class MyLineLegendRenderer(
    chart: LineDataProvider,
    animator: ChartAnimator,
    viewPortHandler: ViewPortHandler?
) :
    LineChartRenderer(chart, animator, viewPortHandler) {
    //This method is same as it's parent implemntation
    override fun drawLinearFill(
        c: Canvas?,
        dataSet: ILineDataSet,
        trans: Transformer,
        bounds: XBounds
    ) {
        val filled: Path = mGenerateFilledPathBuffer
        val startingIndex = bounds.min
        val endingIndex = bounds.range + bounds.min
        val indexInterval = 128
        var currentStartIndex = 0
        var currentEndIndex = indexInterval
        var iterations = 0

        // Doing this iteratively in order to avoid OutOfMemory errors that can happen on large bounds sets.
        do {
            currentStartIndex = startingIndex + iterations * indexInterval
            currentEndIndex = currentStartIndex + indexInterval
            currentEndIndex = if (currentEndIndex > endingIndex) endingIndex else currentEndIndex
            if (currentStartIndex <= currentEndIndex) {
                generateFilledPath(dataSet, currentStartIndex, currentEndIndex, filled)
                trans.pathValueToPixel(filled)
                val drawable = dataSet.fillDrawable
                if (drawable != null) {
                    drawFilledPath(c, filled, drawable)
                } else {
                    drawFilledPath(c, filled, dataSet.fillColor, dataSet.fillAlpha)
                }
            }
            iterations++
        } while (currentStartIndex <= currentEndIndex)
    }

    //This is where we define the area to be filled.
    private fun generateFilledPath(
        dataSet: ILineDataSet,
        startIndex: Int,
        endIndex: Int,
        outputPath: Path
    ) {

        //Call the custom method to retrieve the dataset for other line
        val boundaryEntry: List<Entry>? =
            (dataSet.fillFormatter as MyFillFormatter).fillLineBoundary
        val phaseY = mAnimator.phaseY
        val filled: Path = outputPath
        filled.reset()
        val entry = dataSet.getEntryForIndex(startIndex)


            filled.moveTo(entry.x, boundaryEntry?.get(0)!!.y)
            filled.lineTo(entry.x, entry.y * phaseY)

            // create a new path
            var currentEntry: Entry? = null
            var previousEntry: Entry? = null
            for (x in startIndex + 1..endIndex) {
                currentEntry = dataSet.getEntryForIndex(x)
                filled.lineTo(currentEntry.x, currentEntry.y * phaseY)
            }

            // close up
            if (currentEntry != null && previousEntry != null) {
                filled.lineTo(currentEntry.x, previousEntry.y)
            }

            //Draw the path towards the other line
            for (x in endIndex downTo startIndex + 1) {
                previousEntry = boundaryEntry[x]
                filled.lineTo(previousEntry.x, previousEntry.y * phaseY)
            }

        filled.close()
    }
}

private fun MutableList<LineDataSet>.addDataSetsToList(
    line1: List<Entry>,
    line2: List<Entry>,
    pair: Pair<Float, Float>,
    pair2: Pair<Float, Float>,
    axisLeftMin: Float,
    axisLeftMax: Float
) {
    val lineDataSet: LineDataSet
    val baseLineDataSet = LineDataSet(line1,"Baseline")
    baseLineDataSet.lineWidth = 3.0f
    baseLineDataSet.color = Color.YELLOW
    baseLineDataSet.setCircleColor(InputDeviceCompat.SOURCE_ANY);
    baseLineDataSet.setDrawCircles(true)
    add(baseLineDataSet)
    if (pair2.second > pair.second) {
        lineDataSet = LineDataSet(line2, "Employees Green")
        lineDataSet.lineWidth = 3.0f
        lineDataSet.color = Color.WHITE
        lineDataSet.setCircleColor(-1)
        lineDataSet.fillColor = Color.GREEN
        lineDataSet.fillFormatter = MyFillFormatter(baseLineDataSet)
        lineDataSet.setDrawCircles(false)
        lineDataSet.setDrawFilled(true)
    } else {
        lineDataSet = LineDataSet(line2, "Employees Red")
        lineDataSet.lineWidth = 3.0f
        lineDataSet.color = Color.WHITE
        lineDataSet.setCircleColor(-1)
        lineDataSet.fillColor = Color.RED
        lineDataSet.fillFormatter = MyFillFormatter(baseLineDataSet)
        lineDataSet.setDrawCircles(false)
        lineDataSet.setDrawFilled(true)
    }
    add(lineDataSet)
}

/*private fun MutableList<LineDataSet>.addDataSetsToList(
    line1: List<Entry>,
    line2: List<Entry>,
    pair: Pair<Float, Float>,
    pair2: Pair<Float, Float>,
    axisLeftMin: Float,
    axisLeftMax: Float,
) {
    val dataSetPair: Pair<LineDataSet,LineDataSet> = if (pair2.second > pair.second) {
        Pair(LineDataSet(line1, "Baseline").apply{
            axisDependency = YAxis.AxisDependency.LEFT
            color = Color.rgb(255, 241, 46)
            setDrawCircles(false)
            lineWidth = 2f
            circleRadius = 3f
            fillAlpha = 255
            setDrawFilled(true)
            fillColor = Color.WHITE
            setDrawCircleHole(false)
            highLightColor = Color.rgb(244, 117, 117)
            *//*fillFormatter =
                IFillFormatter { _, _ -> // change the return value here to better understand the effect
                    // return 600;
                    axisLeftMin
                }*//*
        },LineDataSet(line2, "DataSet").apply {
            axisDependency = YAxis.AxisDependency.LEFT
            color = Color.rgb(255, 241, 46)
            setDrawCircles(false)
            lineWidth = 2f
            circleRadius = 3f
            fillAlpha = 255
            setDrawFilled(true)
            fillColor = Color.WHITE
            highLightColor = Color.rgb(244, 117, 117)
            setDrawCircleHole(false)
            *//*fillFormatter =
                IFillFormatter { _, _ -> // change the return value here to better understand the effect
                    // return 0;
                    axisLeftMax
                }*//*
        })
    } else {
        Pair(LineDataSet(line1, "Baseline").apply{
            axisDependency = YAxis.AxisDependency.LEFT
            color = Color.rgb(255, 241, 46)
            setDrawCircles(false)
            lineWidth = 2f
            circleRadius = 3f
            fillAlpha = 255
            setDrawFilled(true)
            fillColor = Color.WHITE
            setDrawCircleHole(false)
            highLightColor = Color.rgb(244, 117, 117)
            *//*fillFormatter =
                IFillFormatter { _, _ -> // change the return value here to better understand the effect
                    axisLeftMax
                }*//*
        },LineDataSet(line2, "DataSet").apply {
            axisDependency = YAxis.AxisDependency.LEFT
            color = Color.rgb(255, 241, 46)
            setDrawCircles(false)
            lineWidth = 2f
            circleRadius = 3f
            fillAlpha = 255
            setDrawFilled(true)
            fillColor = Color.WHITE
            setDrawCircleHole(false)
            highLightColor = Color.rgb(244, 117, 117)
            *//*fillFormatter =
                IFillFormatter { _, _ -> // change the return value here to better understand the effect
                    axisLeftMin
                }*//*
        })
    }

    dataSetPair.first.fillFormatter = MyFillFormatter(dataSetPair.first)
    dataSetPair.second.fillFormatter = MyFillFormatter(dataSetPair.second)
    dataSetPair.first.setDrawCircles(true)
    dataSetPair.first.setDrawCircles(true)
    dataSetPair.first.setDrawFilled(true)
    dataSetPair.first.setDrawValues(true)
    dataSetPair.second.setDrawCircles(true)
    dataSetPair.second.setDrawFilled(true)
    dataSetPair.second.setDrawValues(true)
    add(dataSetPair.first)
    add(dataSetPair.second)
}*/

fun getLineData(
    server: List<Pair<Float, Float>>,
    yourPair: List<Pair<Float, Float>>,
    axisLeftMin: Float,
    axisLeftMax: Float,
): LineData {
    val employeesLineDataSet = ArrayList<LineDataSet>()
    var baseEntries = mutableListOf<Entry>()
    var tempEntries = mutableListOf<Entry>()

    server.forEachIndexed { i, p1 ->
        if (i < server.size - 1) {
            val q1 = server[i + 1]
            val p2 = yourPair[i]
            val q2 = yourPair[i + 1]
            baseEntries.add(Entry(p1.first, p1.second))
            tempEntries.add(Entry(p2.first, p2.second))
            if (doIntersect(p1, q1, p2, q2)) {
                val (first, second) = lineLineIntersection(
                    p1,
                    q1,
                    p2,
                    q2
                )
                baseEntries.add(Entry(first, second))
                tempEntries.add(Entry(first, second))
                employeesLineDataSet.addDataSetsToList(
                    baseEntries,
                    tempEntries,
                    p1,
                    p2,
                    axisLeftMin,
                    axisLeftMax
                )
                baseEntries = ArrayList()
                tempEntries = ArrayList()
                baseEntries.add(Entry(first, second))
                tempEntries.add(Entry(first, second))
            }
        } else {
            if (i == server.size - 1) {
                val q12 = server[i]
                val q22 = yourPair[i]
                baseEntries.add(Entry(q12.first, q12.second))
                tempEntries.add(Entry(q22.first, q22.second))
                employeesLineDataSet.addDataSetsToList(
                    baseEntries,
                    tempEntries,
                    q12,
                    q22,
                    axisLeftMin,
                    axisLeftMax
                )
            }
        }
    }
    val lineData = LineData(employeesLineDataSet.toList<ILineDataSet>())
    lineData.setDrawValues(true)
    Log.i("Util:getLineData()", employeesLineDataSet.toString())
    return lineData
}

/*fun intersectOrNot(
    p1: Pair<Float, Float>,
    q1: Pair<Float, Float>,
    p2: Pair<Float, Float>,
    q2: Pair<Float, Float>
) {
    Intrinsics.checkNotNullParameter(p1, "p1")
    Intrinsics.checkNotNullParameter(q1, "q1")
    Intrinsics.checkNotNullParameter(p2, "p2")
    Intrinsics.checkNotNullParameter(q2, "q2")
    val t = doIntersect(p1, q1, p2, q2)
    Log.i("Util:intersectOrNot()", "doIntersect: $t")
    val intersection: Pair<Float, Float> = lineLineIntersection(p1, q1, p2, q2)
    Log.i("Util:intersectOrNot()", "intersection: $intersection")
}*/

fun orientation(p: Pair<Float, Float>, q: Pair<Float, Float>, r: Pair<Float, Float>): Int {
    val value =
        (q.second - p.second) * (r.first - q.first) - (q.first - p.first) * (r.second - q.second)
    if (value == 0.0f) {
        return 0
    }
    return if (value > 0.0f) 1 else 2
}

fun onSegment(p: Pair<Float, Float>, q: Pair<Float, Float>, r: Pair<Float, Float>): Boolean {
    return q.first <= p.first.coerceAtLeast(r.first) &&
            q.first >= p.first.coerceAtMost(r.first) &&
            q.second <= p.second.coerceAtLeast(r.second) &&
            q.second >= p.second.coerceAtMost(r.second)
}

fun doIntersect(
    p1: Pair<Float, Float>,
    q1: Pair<Float, Float>,
    p2: Pair<Float, Float>,
    q2: Pair<Float, Float>
): Boolean {
    val o1 = orientation(p1, q1, p2)
    val o2 = orientation(p1, q1, q2)
    val o3 = orientation(p2, q2, p1)
    val o4 = orientation(p2, q2, q1)
    if (o1 != o2 && o3 != o4) {
        return true
    }
    if (o1 == 0 && onSegment(p1, p2, q1)) {
        return true
    }
    if (o2 == 0 && onSegment(p1, q2, q1)) {
        return true
    }
    if (o3 == 0 && onSegment(p2, p1, q2)) {
        return true
    }
    return o4 == 0 && onSegment(p2, q1, q2)
}

fun lineLineIntersection(
    A: Pair<Float, Float>,
    B: Pair<Float, Float>,
    C: Pair<Float, Float>,
    D: Pair<Float, Float>
): Pair<Float, Float> {
    val x1 = A.first
    val y1 = A.second
    val x2 = B.first
    val y2 = B.second
    val x3 = C.first
    val y3 = C.second
    val x4 = D.first
    val y4 = D.second

    val denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4)

    if (denominator == 0.0f) {
        // Lines are parallel or coincident
        return Pair(Float.MAX_VALUE, Float.MAX_VALUE)
    }

    val intersectX =
        ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator
    val intersectY =
        ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator

    return Pair(intersectX, intersectY)
}