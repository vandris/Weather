package com.example.andris.weather.interactor.cities.event;

import java.util.List;
import com.example.andris.weather.model.Item;

public class GetCitiesEvent {

    private int code;
    private List<Item> cities;
    private Throwable throwable;

    public GetCitiesEvent(){

    }

    public GetCitiesEvent(int code, List<Item> cities, Throwable throwable){
        this.code = code;
        this.cities = cities;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Item> getCities() {
        return cities;
    }

    public void setCities(List<Item> cities) {
        this.cities = cities;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }


}
