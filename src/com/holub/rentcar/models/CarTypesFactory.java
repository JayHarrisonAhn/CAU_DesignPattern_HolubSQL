package com.holub.rentcar.models;

import com.holub.rentcar.models.row.CarType;

import java.util.Iterator;

public class CarTypesFactory extends RowsFactory<CarType> {
    CarType create(Iterator column) {
        String type = column.next().toString();
        String name = column.next().toString();
        return new CarType(type, name);
    }
}