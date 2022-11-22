package com.netimur.effectivemobiletesttask.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

final public class DetailsResponseBody {
    @SerializedName("CPU")
    private final String cpu;
    private final String camera;
    private final List<String> capacity;
    private final List<String> color;
    private final String id;
    @SerializedName("images")
    private final List<String> pictureUrls;
    private final boolean isFavorites;
    private final int price;
    private final double rating;
    private final String sd;
    private final String ssd;
    private final String title;

    public DetailsResponseBody(String cpu, String camera, List<String> capacity, List<String> color, String id, List<String> pictureUrls, boolean isFavorites, int price, double rating, String sd, String ssd, String title) {
        this.cpu = cpu;
        this.camera = camera;
        this.capacity = capacity;
        this.color = color;
        this.id = id;
        this.pictureUrls = pictureUrls;
        this.isFavorites = isFavorites;
        this.price = price;
        this.rating = rating;
        this.sd = sd;
        this.ssd = ssd;
        this.title = title;
    }

    public String getCpu() {
        return cpu;
    }

    public String getCamera() {
        return camera;
    }

    public List<String> getCapacity() {
        return capacity;
    }

    public List<String> getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public boolean isFavorites() {
        return isFavorites;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getSd() {
        return sd;
    }

    public String getSsd() {
        return ssd;
    }

    public String getTitle() {
        return title;
    }
}
