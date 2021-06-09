package com.example.urbexexploration.addPlace;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;
import com.example.urbexexploration.upload.UriRequestBody;

/**
 * Klasa
 */
public class AddPlaceViewModel extends ViewModel {
    private PlacesRepository repository;

    private String uriImage;

    public AddPlaceViewModel() {
        repository = new PlacesRepository();
    }

    /**
     * Dodawanie nowego miejsca do repozytorium
     * @param uri ścieżka dostępu do obrazka
     * @param name nazwa pliku obrazka
     * @param place obiekt klasy {@link Place}
     */
    public void addNewPlace(UriRequestBody uri, String name, Place place) {
        repository.upload(uri, place, name);
    }

    public void saveUri(String uri) {
        uriImage = uri;
    }

    public String getUriImage() {
        return uriImage;
    }

    /**
     *
     * @return
     */
    public LiveData<AddPlaceResult> getAddPlaceResult () {
        return repository.getUploadResultLiveData();
    }
}
