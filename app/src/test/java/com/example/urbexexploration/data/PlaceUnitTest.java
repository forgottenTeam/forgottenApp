package com.example.urbexexploration.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Testy dla klasy Place
 * @author Paulina Bogusz
 */
public class PlaceUnitTest {

    @Test
    public void ifIdIsPresent_returnPhotoUriWithId() {
        int testId = 28;
        Place newPlaceTest = new Place (testId, "", "", "", "", "", 0.0, 0.0, "");
        assertEquals(newPlaceTest.getPhotoUri(), Place.BASE_IMAGE_URL + testId);
    }

    @Test
    public void ifPhotoUriPresent_returnPhotoUriNotNull() {
        Place newPlaceTest = new Place (0, "", "", "", "", "", 0.0, 0.0, "testPhotoUri");
        assertNotNull(newPlaceTest.getPhotoUri());
    }

    @Test
    public void ifPhotoUriNotPresent_returnPhotoUriIsNull() {
        Place newPlaceTest = new Place (0, "", "", "", "", "", 0.0, 0.0, null);
        assertNull(newPlaceTest.getPhotoUri());
    }
}