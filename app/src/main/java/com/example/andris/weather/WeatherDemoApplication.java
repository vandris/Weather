package com.example.andris.weather;

import android.app.Application;

import com.example.andris.weather.ui.UIModule;

public class WeatherDemoApplication extends Application {

    public static WeatherDemoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        /*injector =
                DaggerWeatherDemoApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();*/
    }

}
