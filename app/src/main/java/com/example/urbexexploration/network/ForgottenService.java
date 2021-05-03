package com.example.urbexexploration.network;

import com.example.urbexexploration.data.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ForgottenService {
    @GET("/places/all")
    Call<List<Place>> getPlaces();
}
