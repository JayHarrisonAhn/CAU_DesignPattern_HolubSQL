package com.holub.rentcar.models.row;

public class Car extends Row {
    public CarType type;
    public String id;
    public String place;
    public Car(String id, String type, String name, String place) {
        this.id = id;
        this.place = place;
        this.type = new CarType(type, name);
    }

    public Object[] toArray() {
        return new String[] { id, type.name, place };
    }
}
