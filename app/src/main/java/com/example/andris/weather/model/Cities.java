package com.example.andris.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cities {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lonCoord")
    @Expose
    private String lonCoord;
    @SerializedName("latCoord")
    @Expose
    private String latCoord;
    @SerializedName("temp")
    @Expose
    private String temp;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("humidity")
    @Expose
    private String humidity;


    public String getName(){ return name; }

    public void setName(String iname){ name = iname; }

    public String getLonCoord(){ return lonCoord; }

    public void setLonCoord(String ilonCoord){ lonCoord = ilonCoord; }

    public String getLatCoordatCoord(){ return latCoord; }

    public void setLatCoordatCoord(String ilatCoord){ latCoord = ilatCoord; }

    public String getTemp(){ return temp; }

    public void setTemp(String itemp){ temp = itemp; }

    public String getPressure(){ return pressure; }

    public void setPressure(String ipressure){ pressure = ipressure; }

    public String getHumidity(){ return humidity; }

    public void setHumidity(String ihumidity){ humidity = ihumidity; }

}
