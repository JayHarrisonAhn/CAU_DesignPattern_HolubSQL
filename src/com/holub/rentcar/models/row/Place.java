package com.holub.rentcar.models.row;

public class Place extends Row {
    public String spotId;
    public String name;
    public String address;
    public Place(String spotId, String name, String address) {
        this.spotId = spotId;
        this.name = name;
        this.address = address;
    }
}
