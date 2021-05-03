package com.example.urbexexploration.places;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;

import java.util.List;

public class PlaceListViewModel extends ViewModel {
    private PlacesRepository repository;

    public PlaceListViewModel () {
        repository = new PlacesRepository();
        repository.queryPlaces();
    }

    public LiveData<List<Place>> getPlacesLiveData() {
        return repository.getPlacesLiveData();
    }
}
