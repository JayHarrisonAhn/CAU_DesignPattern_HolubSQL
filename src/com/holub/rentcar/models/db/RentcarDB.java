package com.holub.rentcar.models.db;

import com.holub.database.*;
import com.holub.rentcar.models.db.file.RentcarDBFileInitializer;
import com.holub.rentcar.models.db.file.RentcarDBInitializer;
import com.holub.rentcar.models.db.file.iemodule.XMLIEModule;

import java.util.ArrayList;
import java.util.List;

public class RentcarDB {
    private RentcarDB() {
        this.tables = new Table[] { spot, carTypes, car, reservation, user };
    }
    public static RentcarDB orm = new RentcarDB();

//    private final RentcarDBInitializer initializer = new RentcarDBTestInitializer();
    private final RentcarDBInitializer initializer = new RentcarDBFileInitializer(new XMLIEModule());

    public Table spot = initializer.spot();
    public Table carTypes = initializer.carTypes();
    public Table car = initializer.car();
    public Table reservation = initializer.reservation();
    public Table user = initializer.user();
    private Table[] tables;
    public void save() {
        initializer.save(spot, carTypes, car, reservation, user);
    }

}
