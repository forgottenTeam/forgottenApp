package com.example.urbexexploration.onePlace;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;

public class OnePlaceViewModel extends ViewModel {
    private PlacesRepository repository;
    private MutableLiveData<Place> onePlaceLiveData;

    public OnePlaceViewModel() {
        onePlaceLiveData = new MutableLiveData<>();
        repository = new PlacesRepository();
            }

    public void loadData(int id) {
        repository.queryOnePlace(id);
    }

    public LiveData<Place> getOnePlaceLiveData() {
        return repository.getOnePlaceLiveData();
    }
}