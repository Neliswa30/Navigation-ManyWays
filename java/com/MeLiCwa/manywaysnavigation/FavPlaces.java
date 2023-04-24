package com.MeLiCwa.manywaysnavigation;

public class FavPlaces
{
    private String txt;
    private String pName;
    private String address;

    // Constructor
    public FavPlaces(String text, String placeName, String address, String id, double latitude, double longitude) {
        this.txt = text;
        this.pName = placeName;
        this.address = address;
    }

    // Default Constructor
    public FavPlaces() {

    }

    public String getText() {
        return txt;
    }

    public String getPlaceName() {
        return pName;
    }

    public String getAddress() {
        return address;
    }

    public void setText(String text) {
        this.txt = text;
    }

    public void setPlaceName(String placeName) {
        this.pName = placeName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return txt;
    }
}

