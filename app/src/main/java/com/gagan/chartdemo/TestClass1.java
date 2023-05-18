/*
package com.gagan.chartdemo;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
*/
/* compiled from: Util.kt *//*

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\u001aV\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001a:\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u000b\u001aV\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001ab\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001aB\u0010\u0014\u001a\u00020\u00012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001aB\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u001a"}, d2 = {"doIntersect", com.github.mikephil.charting.BuildConfig.FLAVOR, "p1", "Lkotlin/Pair;", com.github.mikephil.charting.BuildConfig.FLAVOR, "q1", "p2", "q2", "getLineData", "Lcom/github/mikephil/charting/data/LineData;", "server", com.github.mikephil.charting.BuildConfig.FLAVOR, "yourPair", "intersectOrNot", com.github.mikephil.charting.BuildConfig.FLAVOR, "lineLineIntersection", "A", "B", "C", "D", "onSegment", "p", "q", "r", "orientation", com.github.mikephil.charting.BuildConfig.FLAVOR, "app_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
*/
/* loaded from: classes3.dex *//*

public final class UtilKt {
    */
/* JADX WARN: Type inference failed for: r4v1, types: [java.util.List, T] *//*

    */
/* JADX WARN: Type inference failed for: r5v1, types: [java.util.List, T] *//*

    */
/* JADX WARN: Type inference failed for: r6v17, types: [java.util.List, T] *//*

    */
/* JADX WARN: Type inference failed for: r6v19, types: [java.util.List, T] *//*

    public static final LineData getLineData(List<Pair<Float, Float>> server, List<Pair<Float, Float>> yourPair) {
        Iterable $this$forEachIndexed$iv;
        boolean z;
        Iterator it;
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(yourPair, "yourPair");
        ArrayList<LineDataSet> employeesLineDataSet = new ArrayList<>();
        ArrayList<Entry> baseEntries = new ArrayList<>();
        ArrayList<Entry> tempEntries = new ArrayList<>();
        List<Pair<Float, Float>> $this$forEachIndexed$iv2 = server;
        boolean z2 = false;
        int i = 0;
        Iterator it2 = $this$forEachIndexed$iv2.iterator();
        while (it2.hasNext()) {
            Pair<Float, Float> item$iv = (Pair<Float, Float>) it2.next();
            int index$iv = i + 1;
            if (i < 0) {
                break;
            }
            Pair<Float, Float> p1 = item$iv;
            if (i < server.size() - 1) {
                Pair<Float, Float> q1 = server.get(i + 1);
                Pair<Float, Float> p2 = yourPair.get(i);
                Pair<Float, Float> q2 = yourPair.get(i + 1);
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z2;
                it = it2;
                baseEntries.add(new Entry(p1.getFirst(),p1.getSecond()));
                tempEntries.add(new Entry(p2.getFirst(), p2.getSecond()));
                if (doIntersect(p1, q1, p2, q2)) {
                    Pair<Float, Float> ip = lineLineIntersection(p1, q1, p2, q2);
                    DecimalFormat $this$getLineData_u24lambda_u2d4_u24lambda_u2d3 = new DecimalFormat("#.#");
                    $this$getLineData_u24lambda_u2d4_u24lambda_u2d3.setRoundingMode(RoundingMode.CEILING);
                    baseEntries.add(new Entry(ip.getFirst(), ip.getSecond()));
                    tempEntries.add(new Entry(ip.getFirst(), ip.getSecond()));
                    getLineData$addDataSetsToList(baseEntries, employeesLineDataSet, tempEntries, p1, p2);
                    baseEntries= new ArrayList<>();
                    tempEntries= new ArrayList<>();
                    baseEntries.add(new Entry(ip.getFirst(), ip.getSecond()));
                    tempEntries.add(new Entry(ip.getFirst(), ip.getSecond()));
                }
            } else {
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z2;
                it = it2;
                if (i == server.size() - 1) {
                    Pair<Float, Float> q12 = server.get(i);
                    Pair<Float, Float> q22 = yourPair.get(i);
                    baseEntries.add(new Entry(q12.getFirst(), q12.getSecond()));
                    tempEntries.add(new Entry(q22.getFirst(), q22.getSecond()));
                    getLineData$addDataSetsToList(baseEntries, employeesLineDataSet, tempEntries, q12, q22);
                }
            }
            i = index$iv;
            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            z2 = z;
            it2 = it;
        }
        LineData lineData = new LineData(CollectionsKt.toList(employeesLineDataSet));
        lineData.setDrawValues(true);
        Log.i("Util:getLineData()", String.valueOf(employeesLineDataSet));
        return lineData;
    }

    private static final void getLineData$addDataSetsToList(List<Entry> line1, List<LineDataSet> list, List<Entry> line2, Pair<Float, Float> pair, Pair<Float, Float> pair2) {
        LineDataSet lineDataSet;
        LineDataSet baseLineDataSet = new LineDataSet(line1.element, "Baseline");
        baseLineDataSet.setLineWidth(3.0f);
        baseLineDataSet.setColor(InputDeviceCompat.SOURCE_ANY);
        baseLineDataSet.setCircleColor(InputDeviceCompat.SOURCE_ANY);
        baseLineDataSet.setDrawCircles(true);
        list.add(baseLineDataSet);
        if (pair2.getSecond().floatValue() > pair.getSecond().floatValue()) {
            lineDataSet = new LineDataSet(CollectionsKt.toList(line2.element), "Employees Green");
            lineDataSet.setLineWidth(3.0f);
            lineDataSet.setColor(-1);
            lineDataSet.setCircleColor(-1);
            lineDataSet.setFillColor(-16711936);
            lineDataSet.setFillFormatter(new MyFillFormatter(baseLineDataSet));
            lineDataSet.setDrawCircles(false);
            lineDataSet.setDrawFilled(true);
        } else {
            lineDataSet = new LineDataSet(CollectionsKt.toList(objectRef2.element), "Employees Red");
            lineDataSet.setLineWidth(3.0f);
            lineDataSet.setColor(-1);
            lineDataSet.setCircleColor(-1);
            lineDataSet.setFillColor(SupportMenu.CATEGORY_MASK);
            lineDataSet.setFillFormatter(new MyFillFormatter(baseLineDataSet));
            lineDataSet.setDrawCircles(false);
            lineDataSet.setDrawFilled(true);
        }
        list.add(lineDataSet);
    }

    public static final void intersectOrNot(Pair<Float, Float> p1, Pair<Float, Float> q1, Pair<Float, Float> p2, Pair<Float, Float> q2) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(q1, "q1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(q2, "q2");
        boolean t = doIntersect(p1, q1, p2, q2);
        Log.i("Util:intersectOrNot()", "doIntersect: " + t);
        Pair<Float, Float> intersection = lineLineIntersection(p1, q1, p2, q2);
        Log.i("Util:intersectOrNot()", "intersection: " + intersection);
    }

    public static final int orientation(Pair<Float, Float> p, Pair<Float, Float> q, Pair<Float, Float> r) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(q, "q");
        Intrinsics.checkNotNullParameter(r, "r");
        float val = ((q.getSecond().floatValue() - p.getSecond().floatValue()) * (r.getFirst().floatValue() - q.getFirst().floatValue())) - ((q.getFirst().floatValue() - p.getFirst().floatValue()) * (r.getSecond().floatValue() - q.getSecond().floatValue()));
        if (val == 0.0f) {
            return 0;
        }
        return val > 0.0f ? 1 : 2;
    }

    public static final boolean onSegment(Pair<Float, Float> p, Pair<Float, Float> q, Pair<Float, Float> r) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(q, "q");
        Intrinsics.checkNotNullParameter(r, "r");
        return q.getFirst().floatValue() <= RangesKt.coerceAtLeast(p.getFirst().floatValue(), r.getFirst().floatValue()) && q.getFirst().floatValue() >= RangesKt.coerceAtMost(p.getFirst().floatValue(), r.getFirst().floatValue()) && q.getSecond().floatValue() <= RangesKt.coerceAtLeast(p.getSecond().floatValue(), r.getSecond().floatValue()) && q.getSecond().floatValue() >= RangesKt.coerceAtMost(p.getSecond().floatValue(), r.getSecond().floatValue());
    }

    public static final boolean doIntersect(Pair<Float, Float> p1, Pair<Float, Float> q1, Pair<Float, Float> p2, Pair<Float, Float> q2) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(q1, "q1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(q2, "q2");
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        if (o1 != o2 && o3 != o4) {
            return true;
        }
        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }
        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }
        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }
        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }
        return false;
    }

    public static final Pair<Float, Float> lineLineIntersection(Pair<Float, Float> A, Pair<Float, Float> B, Pair<Float, Float> C, Pair<Float, Float> D) {
        Intrinsics.checkNotNullParameter(A, "A");
        Intrinsics.checkNotNullParameter(B, "B");
        Intrinsics.checkNotNullParameter(C, "C");
        Intrinsics.checkNotNullParameter(D, "D");
        float a1 = B.getSecond().floatValue() - A.getSecond().floatValue();
        float b1 = A.getFirst().floatValue() - B.getFirst().floatValue();
        float c1 = (A.getFirst().floatValue() * a1) + (A.getSecond().floatValue() * b1);
        float a2 = D.getSecond().floatValue() - C.getSecond().floatValue();
        float b2 = C.getFirst().floatValue() - D.getFirst().floatValue();
        float c2 = (C.getFirst().floatValue() * a2) + (C.getSecond().floatValue() * b2);
        float determinant = (a1 * b2) - (a2 * b1);
        if (determinant == 0.0f) {
            return new Pair<>(Float.valueOf(Float.MAX_VALUE), Float.valueOf(Float.MAX_VALUE));
        }
        float x = ((b2 * c1) - (b1 * c2)) / determinant;
        float y = ((a1 * c2) - (a2 * c1)) / determinant;
        return new Pair<>(Float.valueOf(x), Float.valueOf(y));
    }
}
*/
