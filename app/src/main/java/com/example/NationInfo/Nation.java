package com.example.NationInfo;

public class Nation {
    private String name, imageUrl, capital, MapUrl;
    private int population;
    private float area;

    public Nation(String name, int population, String imageUrl, float area, String capital, String MapUrl) {
        this.name = name;
        this.population = population;
        this.imageUrl = imageUrl;
        this.area = area;
        this.capital = capital;
        this.MapUrl = MapUrl;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMapUrl() {
        return MapUrl;
    }

    public void setMapUrl(String MapUrl) {
        this.MapUrl = MapUrl;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String name) {
        this.capital = capital;
    }
}
