package com.readboy.mydmeoforlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.readboy.radarview.RadarData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RadarData data = new RadarData(values,getResources().getColor(R.color.color_4d29ceff));
    }
}