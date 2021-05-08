package com.example.urbexexploration.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.urbexexploration.network.ForgottenService;
import com.example.urbexexploration.places.OnPlaceClickListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class PlacesRepository {
    private ForgottenService serviceForg;
    private MutableLiveData<List<Place>> placesLiveData;
    private MutableLiveData<Place> onePlaceLiveData;
    private OnPlaceClickListener listener;

    public PlacesRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.19:8080/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        serviceForg = retrofit.create(ForgottenService.class);
        placesLiveData = new MutableLiveData<>();
        onePlaceLiveData = new MutableLiveData<>();
    }

    public void queryOnePlace(int id) {
        serviceForg.getOnePlace(id).enqueue(new Callback<Place>() {
            @Override
            public void onResponse(Call<Place> call, Response<Place> response) {
                if (response.isSuccessful()) {
                    onePlaceLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Place> call, Throwable t) {
                onePlaceLiveData.setValue(new Place());                 //Toast wrzucic ?
            }
        });
    }

    public LiveData<Place> getOnePlaceLiveData() {
        return onePlaceLiveData;
    }

    public void queryPlaces() {
        serviceForg.getPlaces().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                if (response.isSuccessful()) {
                    placesLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                placesLiveData.setValue(new ArrayList<>());                 //zwraca pusta liste przy bledzie
            }
        });
    }

    public LiveData<List<Place>> getPlacesLiveData() {
        return placesLiveData;
    }

}
