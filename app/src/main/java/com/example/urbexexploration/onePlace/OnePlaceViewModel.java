package com.example.urbexexploration.onePlace;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;

/**
 * Klasa ViewModel dla widoku OnePlace
 */
public class OnePlaceViewModel extends ViewModel {
    private PlacesRepository repository;

    public OnePlaceViewModel() {
        repository = new PlacesRepository();
    }

    public void loadData (int id) {
        repository.queryOnePlace(id);
    }

    public LiveData<Place> getOnePlaceLiveData() {
        return repository.getOnePlaceLiveData();
    }
}
