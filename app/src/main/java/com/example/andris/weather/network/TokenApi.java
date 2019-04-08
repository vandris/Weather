package com.example.andris.weather.network;

import com.example.andris.weather.model.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TokenApi {

    @POST("token")
    @FormUrlEncoded
    Call<Token> getToken(@Field("grant_type") String grantType, @Header("Authorization") String authorisation);

}
