package com.example.urbexexploration.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.urbexexploration.addPlace.AddPlaceResult;
import com.example.urbexexploration.network.ForgottenService;
import com.example.urbexexploration.places.OnPlaceClickListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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
    private MutableLiveData<AddPlaceResult> uploadResultLiveData;
//    private OnPlaceClickListener listener;


    public PlacesRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.27:8080/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        serviceForg = retrofit.create(ForgottenService.class);
        placesLiveData = new MutableLiveData<>();
        onePlaceLiveData = new MutableLiveData<>();
        uploadResultLiveData = new MutableLiveData<>();
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

    public void upload(RequestBody requestBody, Place place, String name) {
        MultipartBody.Part multipart = MultipartBody.Part.createFormData("image", name, requestBody);

        serviceForg.addPlace(
                multipart,
                getRequestBody(place.getName()),
                getRequestBody(place.getCategory()),
                getRequestBody(place.getDescription()),
                getRequestBody(place.getCity()),
                getRequestBody(place.getProvince()),
                place.getLongitude(),
                place.getLatitude()).enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    uploadResultLiveData.setValue(new AddPlaceResult(true));
                } else {
                    uploadResultLiveData.setValue(new AddPlaceResult(false));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                uploadResultLiveData.setValue(new AddPlaceResult(false));
            }
        });
    }

    public MutableLiveData<AddPlaceResult> getUploadResultLiveData() {
        return uploadResultLiveData;
    }

    private RequestBody getRequestBody(String string) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), string);
    }
}
