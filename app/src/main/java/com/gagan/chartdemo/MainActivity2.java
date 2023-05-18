/*
package com.gagan.chartdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;

import com.gagan.chartdemo.databinding.ActivityMainBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

*/
/* compiled from: MainActivity.kt *//*

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/gagan/chartdemo/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/gagan/chartdemo/databinding/ActivityMainBinding;", "onCreate", com.github.mikephil.charting.BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
*/
/* loaded from: classes3.dex *//*

public final class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    */
/* JADX INFO: Access modifiers changed from: protected *//*

    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        Iterable $this$mapIndexed$iv = CollectionsKt.listOf((Object[]) new Integer[]{20, 23, 33, 46});
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int v = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(new Entry(index$iv$iv + 1, v));
            index$iv$iv = index$iv$iv2;
        }
        List employeeEntries1 = (List) destination$iv$iv;
        Iterable $this$mapIndexed$iv2 = CollectionsKt.listOf((Object[]) new Integer[]{46, 55, 60});
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
        int index$iv$iv3 = 0;
        for (Object item$iv$iv2 : $this$mapIndexed$iv2) {
            int index$iv$iv4 = index$iv$iv3 + 1;
            if (index$iv$iv3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int v2 = ((Number) item$iv$iv2).intValue();
            destination$iv$iv2.add(new Entry(index$iv$iv3 + 4, v2));
            index$iv$iv3 = index$iv$iv4;
        }
        List employeeEntries2 = (List) destination$iv$iv2;
        Iterable $this$mapIndexed$iv3 = CollectionsKt.listOf((Object[]) new Integer[]{30, 36, 42, 46});
        boolean z = false;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv3, 10));
        int index$iv$iv5 = 0;
        for (Object item$iv$iv3 : $this$mapIndexed$iv3) {
            int index$iv$iv6 = index$iv$iv5 + 1;
            if (index$iv$iv5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int v3 = ((Number) item$iv$iv3).intValue();
            destination$iv$iv3.add(new Entry(index$iv$iv5 + 1, v3));
            index$iv$iv5 = index$iv$iv6;
            $this$mapIndexed$iv3 = $this$mapIndexed$iv3;
            z = z;
        }
        List baseEntries1 = (List) destination$iv$iv3;
        Iterable $this$mapIndexed$iv4 = CollectionsKt.listOf((Object[]) new Integer[]{46, 48, 50});
        boolean z2 = false;
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv4, 10));
        Iterable $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv4;
        int index$iv$iv7 = 0;
        for (Object item$iv$iv4 : $this$mapIndexedTo$iv$iv) {
            int index$iv$iv8 = index$iv$iv7 + 1;
            if (index$iv$iv7 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int v4 = ((Number) item$iv$iv4).intValue();
            boolean z3 = z2;
            int $i$f$mapIndexed = index$iv$iv7 + 4;
            destination$iv$iv4.add(new Entry($i$f$mapIndexed, v4));
            index$iv$iv7 = index$iv$iv8;
            $this$mapIndexed$iv4 = $this$mapIndexed$iv4;
            z2 = z3;
            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
        }
        List baseEntries2 = (List) destination$iv$iv4;
        LineDataSet $this$onCreate_u24lambda_u2d4 = new LineDataSet(baseEntries1, "Baseline");
        $this$onCreate_u24lambda_u2d4.setLineWidth(3.0f);
        $this$onCreate_u24lambda_u2d4.setColor(InputDeviceCompat.SOURCE_ANY);
        $this$onCreate_u24lambda_u2d4.setCircleColor(InputDeviceCompat.SOURCE_ANY);
        $this$onCreate_u24lambda_u2d4.setDrawCircles(true);
        LineDataSet $this$onCreate_u24lambda_u2d5 = new LineDataSet(baseEntries2, "Baseline");
        $this$onCreate_u24lambda_u2d5.setLineWidth(3.0f);
        $this$onCreate_u24lambda_u2d5.setColor(InputDeviceCompat.SOURCE_ANY);
        $this$onCreate_u24lambda_u2d5.setCircleColor(InputDeviceCompat.SOURCE_ANY);
        $this$onCreate_u24lambda_u2d5.setDrawCircles(true);
        LineDataSet b1 = new LineDataSet(employeeEntries1, "Employee Progress");
        b1.setLineWidth(3.0f);
        b1.setColor(-1);
        b1.setCircleColor(-1);
        b1.setDrawCircles(true);
        b1.setDrawFilled(true);
        LineDataSet $this$onCreate_u24lambda_u2d7 = new LineDataSet(employeeEntries2, "Employee Progress");
        $this$onCreate_u24lambda_u2d7.setLineWidth(3.0f);
        $this$onCreate_u24lambda_u2d7.setColor(-1);
        $this$onCreate_u24lambda_u2d7.setCircleColor(-1);
        $this$onCreate_u24lambda_u2d7.setDrawCircles(true);
        $this$onCreate_u24lambda_u2d7.setDrawFilled(true);
        b1.setFillColor(SupportMenu.CATEGORY_MASK);
        b1.setFillFormatter(new MyFillFormatter($this$onCreate_u24lambda_u2d4));
        $this$onCreate_u24lambda_u2d7.setFillColor(-16711936);
        $this$onCreate_u24lambda_u2d7.setFillFormatter(new MyFillFormatter($this$onCreate_u24lambda_u2d5));
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        LineChart $this$onCreate_u24lambda_u2d8 = activityMainBinding.lineChart;
        $this$onCreate_u24lambda_u2d8.setBackgroundColor(-7829368);
        $this$onCreate_u24lambda_u2d8.setData(UtilKt.getLineData(CollectionsKt.listOf(new Pair[]{new Pair(1.0f, 30.0f), new Pair(2.0f, 36.0f), new Pair(3.0f, 42.0f), new Pair(4.0f, 38.0f), new Pair(5.0f, 48.0f), new Pair(6.0f, 50.0f)}),
                CollectionsKt.listOf( new Pair[]{new Pair(1.0f, 20.0f), new Pair(2.0f, 23.0f), new Pair(3.0f, 33.0f), new Pair(4.0f, 46.0f), new Pair(5.0f, 35.0f), new Pair(6.0f, 55.0f)})));
        $this$onCreate_u24lambda_u2d8.setRenderer(new MyLineLegendRenderer($this$onCreate_u24lambda_u2d8, $this$onCreate_u24lambda_u2d8.getAnimator(), $this$onCreate_u24lambda_u2d8.getViewPortHandler()));
    }
}

*/
