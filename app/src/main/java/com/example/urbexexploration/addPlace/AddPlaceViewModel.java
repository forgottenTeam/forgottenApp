package com.example.urbexexploration.addPlace;

import androidx.lifecycle.ViewModel;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;
import com.example.urbexexploration.upload.UriRequestBody;

public class AddPlaceViewModel extends ViewModel {
    private PlacesRepository repository;

    private String uriImage;

    public AddPlaceViewModel() {
        repository = new PlacesRepository();
    }

    public void upload(UriRequestBody uri, Place place) {
        repository.upload(uri, place);
    }

    public void saveUri(String uri) {
        uriImage = uri;
    }

    public String getUriImage() {
        return uriImage;
    }
}