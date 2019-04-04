package com.example.andris.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExternalUrls {

    @SerializedName("weather")
    @Expose
    private String weather;

    /**
     *
     * @return
     * The weather
     */
    public String getWeather() {
        return weather;
    }

    /**
     *
     * @param weather
     * The weather
     */
    public void setSpotify(String weather) {
        this.weather = weather;
    }

}
