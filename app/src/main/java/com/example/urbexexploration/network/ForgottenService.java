package com.example.urbexexploration.network;

import com.example.urbexexploration.data.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForgottenService {
    @GET("/places/all")
    Call<List<Place>> getPlaces();

    @GET("/places/one")
    Call<Place> getOnePlace(@Query("id") int id);
}