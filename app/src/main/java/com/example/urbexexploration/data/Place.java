package com.example.urbexexploration.data;

/**
 * Klasa opisująca pojedyncze miejsce (obiekt) za pomocą parametrów
 * @author Jędrzej Mańczak
 */
public class Place {
    public static final String BASE_IMAGE_URL = PlacesRepository.BASE_URL + PlacesRepository.IMAGE_PATH;

    private int id;
    private String name;
    private String category;
    private String city;
    private String description;
    private String province;
    private double latitude;
    private double longitude;
    private String photoUri;

    /**
     * Konstruktor klasy {@link Place}
     * @param id numer id obiektu
     * @param name nazwa obiektu
     * @param category kategoria obiektu
     * @param city miejscowość
     * @param description opis obiektu
     * @param province województwo
     * @param latitude szerokość geograficzna
     * @param longitude długość geograficzna
     * @param photoUri ścieżka dostępu do pliku obrazka
     */
    public Place(int id, String name, String category, String city, String description, String province, double latitude, double longitude, String photoUri) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.city = city;
        this.description = description;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photoUri = photoUri;
    }

    public Place() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPhotoUri() {
        if (photoUri != null) {
            return BASE_IMAGE_URL + id;
        } else {
            return null;
        }
    }

    public void setPhotoUri (String photoUri) {
        this.photoUri = photoUri;
    }
}
