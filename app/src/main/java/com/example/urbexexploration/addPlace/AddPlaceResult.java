package com.example.urbexexploration.addPlace;

/**
 * Klasa określająca czy wysłanie nowego miejsca do serwera zakończyło się sukcesem.
 * @author Paulina Bogusz
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
