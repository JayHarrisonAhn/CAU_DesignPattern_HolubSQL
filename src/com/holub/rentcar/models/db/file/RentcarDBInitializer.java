package com.holub.rentcar.models.db.file;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public abstract class RentcarDBInitializer {
    public Table spot() {
        return TableFactory.create("spot", new String[] { "spotId", "spotName", "address" });
    };
    public Table carTypes() {
        return TableFactory.create("carTypes", new String[] { "carTypeId", "name" });
    };
    public Table car() {
        return TableFactory.create("car", new String[] { "carId", "carType", "spotId" });
    };
    public Table reservation() {
        return TableFactory.create("reservation", new String[] { "carId", "date", "userId" });
    };
    public Table user() {
        return TableFactory.create("user", new String[] { "userId", "userName" });
    };
    public void save(Table spot, Table carTypes, Table car, Table reservation, Table user) { };
}
