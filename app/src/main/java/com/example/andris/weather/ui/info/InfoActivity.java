package com.example.andris.weather.ui.info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.andris.weather.R;

public class InfoActivity extends AppCompatActivity implements InfoScreen{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }
}
