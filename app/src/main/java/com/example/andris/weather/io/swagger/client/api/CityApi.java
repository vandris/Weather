package com.example.andris.weather.io.swagger.client.api;


import com.example.andris.weather.io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.example.andris.weather.io.swagger.client.model.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CityApi {

    /**
     * Finds Cities by name
     * You need to type the name of the city.
     * @param q The city name to search
     * @param APPID The APPI key to the authorization
     * @return Call<List<City>>
     */

    @GET("weather")
    Call<List<City>> findCitiesByName(
            @Query("q") String q, @Query("APPID") String APPID
    );


    /**
     * Update an existing city
     *
     * @param body City object that needs to be added to the list
     * @return Call<Void>
     */

    @PUT("weather")
    Call<Void> updateCity(
            @Body City body
    );


    /**
     * Add a new city to the list
     *
     * @param body City&#39;s object that needs to be added to the list
     * @return Call<Void>
     */

    @POST("weather")
    Call<Void> addCity(
            @Body City body
    );


    /**
     * Deletes a city
     *
     * @param cityName City to delete
     * @return Call<Void>
     */

    @DELETE("weather")
    Call<Void> deleteCity(
            @Path("cityName") String cityName
    );


}