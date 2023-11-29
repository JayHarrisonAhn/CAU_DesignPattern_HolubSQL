package com.holub.rentcar.models;

import com.holub.rentcar.models.row.Place;

import java.util.Iterator;

public class PlacesFactory extends RowsFactory<Place> {
    Place create(Iterator column) {
        String spotId = column.next().toString();
        String name = column.next().toString();
        String address = column.next().toString();
        return new Place(spotId, name, address);
    }
}
