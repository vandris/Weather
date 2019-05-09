package com.example.andris.weather.utils;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

import com.example.andris.weather.AndroidTestComponent;
import com.example.andris.weather.WeatherDemoApplication;

public class AndroidTestUtils {

    public static void setTestInjector(){

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        WeatherDemoApplication app = (WeatherDemoApplication) instrumentation.getTargetContext()
                .getApplicationContext();

        //AndroidTestComponent androidTestComponent = ;

    }
}
