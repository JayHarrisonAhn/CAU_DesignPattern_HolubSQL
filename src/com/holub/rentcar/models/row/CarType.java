package com.holub.rentcar.models.row;

public class CarType extends Row {
    public String id;
    public String name;
    public CarType(String type, String name) {
        this.id = type;
        this.name = name;
    }

    public Object[] toArray() {
        return new Object[] { id, name };
    }
}
