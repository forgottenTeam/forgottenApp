package com.example.urbexexploration.data;

import java.util.List;

public class Place {
    private int id;
    private String name;
    private String category;
    private String city;
    private String description;
    private String province;
    private double latitude;
    private double longitude;
    private List<String> images;

    public Place(int id, String name, String category, String city, String description, String province, double latitude, double longitude, List<String> images) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.city = city;
        this.description = description;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
        this.images = images;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
