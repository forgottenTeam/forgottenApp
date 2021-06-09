package com.example.urbexexploration.places;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa ViewModel dla widoku PlaceList
 */
public class PlaceListViewModel extends ViewModel {
    private PlacesRepository repository;
    private MutableLiveData<List<Place>> filteredPlacesLiveData;

    public PlaceListViewModel() {
        filteredPlacesLiveData = new MutableLiveData<>();
        repository = new PlacesRepository();
        repository.queryPlaces();
    }

    public LiveData<List<Place>> getPlacesLiveData() {
        return repository.getPlacesLiveData();
    }

    public LiveData<List<Place>> getFilteredPlacesLiveData() {
        return filteredPlacesLiveData;
    }

    /**
     * Filtrowanie listy miejsc wg wybranej kategorii
     * @param category kategoria, wg której zostanie przefiltrowana lista
     */
    public void filterListCategory(String category) {
        List<Place> list = repository.getPlacesLiveData().getValue();
        if (list != null) {
            List<Place> listCategory = new ArrayList<>();
            for (Place p : list) {
                if (p.getCategory().equalsIgnoreCase(category)) {
                    listCategory.add(p);
                }
            }
            filteredPlacesLiveData.setValue(listCategory);
        }
    }

    /**
     * Filtrowanie listy miejsc wg wybranego województwa
     * @param province województwo, wg którego zostanie przefiltrowana lista
     */
    public void filterListProvince(String province) {
        List<Place> list = repository.getPlacesLiveData().getValue();
        if (list != null) {
            List<Place> listProvince = new ArrayList<>();
            for (Place p : list) {
                if (p.getProvince().equalsIgnoreCase(province)) {
                    listProvince.add(p);
                }
            }
            filteredPlacesLiveData.setValue(listProvince);
        }
    }

    /**
     * Filtrowanie listy miejsc wg wpisanego łańcucha znaków
     * @param txt wpisany przez użytkownika tekst, wg którego zostanie przefiltrowana lista
     */
    public void filter(String txt) {
        List<Place> filteredList = new ArrayList<>();
        List<Place> list = repository.getPlacesLiveData().getValue();
        if (list != null) {
            if (txt == null || txt.isEmpty()) {
                filteredPlacesLiveData.setValue(list);
            } else {
                for (Place item : list) {
                    if (item.getName().toLowerCase().contains(txt.toLowerCase())) {
                        filteredList.add(item);
                    }
                }
                filteredPlacesLiveData.setValue(filteredList);
            }
        }
    }


}
