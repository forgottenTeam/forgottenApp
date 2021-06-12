package com.example.urbexexploration.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.urbexexploration.addPlace.AddPlaceResult;
import com.example.urbexexploration.network.ForgottenService;

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

/**
  * Repozytorium do komunikacji sieciowej aplikacji z serwerem
 */
public class PlacesRepository {
    /** Bazowy adres serwera */
    public static final String BASE_URL = "http://192.168.1.40:8080/";
    /** Relatywna ścieżka do obrazka na serwerze */
    public static final String IMAGE_PATH = "places/image/";

    /** Serwis API serwera */
    private ForgottenService serviceForg;
    /** Obserwowalny kontener danych, który zwraca listę miejsc */
    private MutableLiveData<List<Place>> placesLiveData;
    /** Obserwowalny kontener danych, który zwraca pojedyńcze miejsce */
    private MutableLiveData<Place> onePlaceLiveData;
    /** Obserwowalny kontener danych, który zwraca rezultat dodawanego miejsca */
    private MutableLiveData<AddPlaceResult> uploadResultLiveData;

    /**
     * Konstruktor repozytorium, który inicjalizuje {@link PlacesRepository#serviceForg,#placesLiveData,#onePlaceLiveData,#uploadResultLiveData}.
     * Serwis {@link PlacesRepository#serviceForg} jest tworzony przy użyciu klienta HTTP z pełnym logowaniem komunikacji z serwerem.
     * Odpowiedzi z serwera są serializowane przy użyciu konwertera Moshi.
     */
    public PlacesRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        serviceForg = retrofit.create(ForgottenService.class);
        placesLiveData = new MutableLiveData<>();
        onePlaceLiveData = new MutableLiveData<>();
        uploadResultLiveData = new MutableLiveData<>();
    }

    /**
     * Pobieranie informacji o pojedyńczym miejscu z serwera. Funkcja emituje obiekt klasy {@link Place} do {@link #onePlaceLiveData}.
     * W przypadku błędu zwracany jest pusty obiekt {@link Place}.
     * @param id identyfikator miejsca w bazie danych
     */
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
                onePlaceLiveData.setValue(new Place());
            }
        });
    }

    /**
     * Zwracanie obserwowalnego kontenera danych pojedyńczego miejsca.
     * @return {@link #onePlaceLiveData}
     */
    public LiveData<Place> getOnePlaceLiveData() {
        return onePlaceLiveData;
    }

    /**
     * Pobieranie informacji o miejscach z serwera. Funkcja emituje listę obiektów klasy {@link Place} do {@link #placesLiveData}.
     * W przypadku błędu zwracana jest pusta lista.
     */
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
                placesLiveData.setValue(new ArrayList<>());
            }
        });
    }

    /**
     * Zwracanie obserwowalnego kontenera danych listy miejsc.
     * @return {@link #placesLiveData}
     */
    public LiveData<List<Place>> getPlacesLiveData() {
        return placesLiveData;
    }

    /**
     * Funkcja dodaje nowe miejsce do bazy danych wraz z obrazkiem, jeśli nie jest on null. Rezultat operacji zwracany jest w {@link #uploadResultLiveData}.
     * @param requestBody dane do pola "image" przy zapytaniu do serwera.
     * @param place dodawane miejsce.
     * @param name nazwa wysyłanego pliku.
     */
    public void upload(RequestBody requestBody, Place place, String name) {
        MultipartBody.Part multipart = null;

        if (requestBody != null && name != null) {
            multipart = MultipartBody.Part.createFormData("image", name, requestBody);
        }

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

    /**
     * Zwracanie obserwowanego kontenera danych rezultatu operacji dodawania miejsca.
     * @return {@link #uploadResultLiveData}
     */
    public MutableLiveData<AddPlaceResult> getUploadResultLiveData() {
        return uploadResultLiveData;
    }

    /**
     * Tworzenie części zapytania do serwera o podanej wartości.
     * @param string wartość pola dla zapytania do serwera.
     * @return częściowa zawartość zapytania do serwera.
     */
    private RequestBody getRequestBody(String string) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), string);
    }
}
