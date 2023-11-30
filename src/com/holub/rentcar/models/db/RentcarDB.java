package com.holub.rentcar.models.db;

import com.holub.database.*;
import com.holub.rentcar.models.db.file.RentcarDBInitializer;
import com.holub.rentcar.models.db.file.RentcarDBTestInitializer;

import java.util.ArrayList;
import java.util.List;

public class RentcarDB {
    private RentcarDB() {
        this.tables = new Table[] { spot, carTypes, car, reservation, user };
    }
    public static RentcarDB orm = new RentcarDB();

    private final RentcarDBInitializer initializer = new RentcarDBTestInitializer();

    public Table spot = initializer.spot();
    public Table carTypes = initializer.carTypes();
    public Table car = initializer.car();
    public Table reservation = initializer.reservation();
    public Table user = initializer.user();
    private Table[] tables;
    public void save() {
        initializer.save(spot, carTypes, car, reservation, user);
    }

    public static void main(String[] args) {
        // Test Code
        List tables = new ArrayList();
        tables.add(RentcarDB.orm.reservation);

        Table selectResult = RentcarDB.orm.car.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return tables[0].column("carId").equals("134허3833");
            }
        }, tables);
        System.out.println(selectResult.toString());
    }
}
