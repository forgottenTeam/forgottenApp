package com.example.urbexexploration.places;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;

import java.util.ArrayList;
import java.util.List;

public class PlaceListViewModel extends ViewModel {
    private PlacesRepository repository;
    private MutableLiveData<List<Place>> filteredDataList;


    public PlaceListViewModel () {
        repository = new PlacesRepository();
        repository.queryPlaces();
    }

    public LiveData<List<Place>> getPlacesLiveData() {
        return repository.getPlacesLiveData();
    }

    public void filterList (String category) {
        List<Place> list = repository.getPlacesLiveData().getValue();
        if (list != null) {
            List<Place> listCategory = new ArrayList<>();
            for (Place p : list) {
                if (p.getCategory().equalsIgnoreCase(category)) {
                    listCategory.add(p);
                }
            }
            filteredDataList.setValue(listCategory);
        }
    }
}
