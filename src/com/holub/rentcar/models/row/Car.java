package com.holub.rentcar.models.row;

public class Car extends Row {
    CarType type;
    String id;
    Car(String id, String type, String name) {
        this.id = id;
        this.type = new CarType(type, name);
    }
}
