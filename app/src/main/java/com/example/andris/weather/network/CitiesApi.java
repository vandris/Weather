package com.example.andris.weather.network;

import com.example.andris.weather.model.CitiesResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CitiesApi {

    @GET("search")
    Call<CitiesResult> getArtists(@Query("query") String artist,
                                  @Query("type") String type,
                                  @Query("offset") int offset,
                                  @Query("limit") int limit);

}
