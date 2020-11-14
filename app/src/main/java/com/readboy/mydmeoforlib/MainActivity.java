package com.readboy.mydmeoforlib;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.readboy.radarview.RadarData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PieChart mPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPieChart = (PieChart) findViewById(R.id.mPieChart);

        mPieChart.setUsePercentValues(true); //设置是否使用百分值,默认不显示
        mPieChart.getDescription().setEnabled(false);
        mPieChart.setDragDecelerationFrictionCoef(0.95f);

        //是否设置中心文字
        mPieChart.setDrawCenterText(true);
        //绘制中间文字
        SpannableString sp = new SpannableString("个人剖析图");
        mPieChart.setCenterText(sp);
        mPieChart.setExtraOffsets(20.f, 0.f, 20.f, 0.f);

        //设置是否为实心图，以及空心时 中间的颜色
        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setHoleColor(Color.WHITE);

        //设置圆环信息
        mPieChart.setTransparentCircleColor(Color.WHITE);//设置透明环颜色
        mPieChart.setTransparentCircleAlpha(110);//设置透明环的透明度
        mPieChart.setHoleRadius(55f);//设置内圆的大小
        mPieChart.setTransparentCircleRadius(60f);//设置透明环的大小

        //mPieChart.setRotationAngle(0);
        // 触摸旋转
        //mPieChart.setRotationEnabled(true);
        //选中变大
        mPieChart.setHighlightPerTapEnabled(true);

        //模拟数据
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        entries.add(new PieEntry(80, "困难"));
        entries.add(new PieEntry(100, "基础"));
        entries.add(new PieEntry(50, "中等"));
        //设置数据
        setData(entries);


        //默认动画
        mPieChart.animateY(1400, Easing.EaseInCirc);

        //设置图例(底下的颜色说明)
        Legend l = mPieChart.getLegend();
        //设置显示的位置，低版本用的是setPosition();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        //设置是否显示图例
        l.setDrawInside(false);
        l.setEnabled(true);

        // 输入图例标签样式(设置饼状图周围是否显示文字， 比如 困难 中等 基础)
        mPieChart.setDrawEntryLabels(false);
       // mPieChart.setEntryLabelColor(Color.BLUE);
        //mPieChart.setEntryLabelTextSize(18f);

    }

    //设置数据
    private void setData(ArrayList<PieEntry> entries) {
        PieDataSet dataSet = new PieDataSet(entries, "");
        //设置个饼状图之间的距离
        dataSet.setSliceSpace(0f);
        //颜色的集合，按照存放的顺序显示
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        //设置折线
        //dataSet.setValueLinePart1OffsetPercentage(0f);
        //dataSet.setValueLineWidth(0f);
        //设置线的长度
        //dataSet.setValueLinePart1Length(0.3f);
        //dataSet.setValueLinePart2Length(0.3f);
        //
        dataSet.setValueLineColor(ColorTemplate.COLOR_NONE);

        //设置文字和数据图外显示
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        PieData data = new PieData(dataSet);
        //百分比设置
        data.setValueFormatter(new PercentFormatter());
        //文字的颜色
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.BLACK);
        mPieChart.setData(data);
        // 撤销所有的亮点
        mPieChart.highlightValues(null);
        mPieChart.invalidate();

    }
}