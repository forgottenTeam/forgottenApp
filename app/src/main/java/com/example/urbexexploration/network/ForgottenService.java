package com.example.urbexexploration.network;

import com.example.urbexexploration.data.Place;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Interfejs zapytań do API, oparty na bibliotece Retrofit, w którym zdefiniowane zostały metody HTTP (GET, POST).
 * @author Jędrzej Mańczak
 */
public interface ForgottenService {
    @GET("/places/all")
    Call<List<Place>> getPlaces();

    @GET("/places/one")
    Call<Place> getOnePlace(@Query("id") int id);

    @Multipart
    @POST("/places/addd")
    Call<ResponseBody> addPlace(
            @Part MultipartBody.Part image,
            @Part ("name") RequestBody name,
            @Part("category") RequestBody category,
            @Part("description") RequestBody description,
            @Part("city") RequestBody city,
            @Part("province") RequestBody province,
            @Part("longitude") Double longitude,
            @Part("latitude") Double latitude
    );
}
