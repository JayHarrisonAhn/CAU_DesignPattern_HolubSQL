package com.holub.rentcar.models;

import com.holub.rentcar.models.row.Car;

import java.util.Iterator;

public class CarsFactory extends RowsFactory<Car> {
    Car create(Iterator column) {
        String carId = column.next().toString();
        String carType = column.next().toString();
        String carTypeName = column.next().toString();
        String place = column.next().toString();
        return new Car(carId, carType, carTypeName, place);
    }
}
