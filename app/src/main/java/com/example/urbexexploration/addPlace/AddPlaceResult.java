package com.example.urbexexploration.addPlace;

/**
 * Klasa określająca czy dodanie nowego miejsca do bazy zakończyło się sukcesem.
 */
public class AddPlaceResult {

    private boolean success;

    public AddPlaceResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

}
