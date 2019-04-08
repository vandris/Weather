package com.example.andris.weather.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.andris.weather.R;
import com.example.andris.weather.ui.info.InfoActivity;
import com.example.andris.weather.ui.modify.ModifyActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static final String KEY_CITIES = "KEY_CITIES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    public void sendButton(View view){
        Intent intent;
        switch(view.getId()) {
            case R.id.searchButton:
                intent = new Intent(this, InfoActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
            case R.id.infoButton:
                intent = new Intent(this, InfoActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
            case R.id.modifyButton:
                intent = new Intent(this, ModifyActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showCities(String citiesSearchTerm){
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra(KEY_CITIES, citiesSearchTerm);
        startActivity(intent);
    }
}
