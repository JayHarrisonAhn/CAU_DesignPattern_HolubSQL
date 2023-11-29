package com.holub.rentcar;

import com.holub.database.Cursor;
import com.holub.database.Selector;
import com.holub.database.Table;
import com.holub.database.TableFactory;

import java.util.ArrayList;
import java.util.List;

public class RentcarDB {
    private RentcarDB() {
        createScheme();
    }
    public static RentcarDB orm = new RentcarDB();
    Table spot;
    Table carTypes;
    Table car;
    Table reservation;
    Table user;

    void createScheme() {
        this.spot = TableFactory.create("spot", new String[] { "spotId", "spotName", "address" });
        this.spot.insert(new Object[] { "sadang", "사당점", "" });
        this.spot.insert(new Object[] { "seoulstation", "서울역점", "" });
        this.spot.insert(new Object[] { "seoulip", "서울대입구역점", "" });
        this.spot.insert(new Object[] { "sangdo", "상도점", "" });

        this.carTypes = TableFactory.create("carTypes", new String[] { "carTypeId", "name" });
        this.carTypes.insert(new Object[] { "avante", "아반떼" });
        this.carTypes.insert(new Object[] { "sonata", "쏘나타" });
        this.carTypes.insert(new Object[] { "grandeur", "그랜저" });
        this.carTypes.insert(new Object[] { "cona", "코나" });
        this.carTypes.insert(new Object[] { "pony", "포니" });

        this.car = TableFactory.create("car", new String[] { "carId", "carType", "spotId" });
        this.car.insert(new Object[] { "134허3831", "avante", "sangdo" });
        this.car.insert(new Object[] { "134허3832", "avante", "sadang" });
        this.car.insert(new Object[] { "134허3833", "avante", "sangdo" });
        this.car.insert(new Object[] { "134허3834", "avante", "sangdo" });
        this.car.insert(new Object[] { "134허3835", "avante", "sadang" });
        this.car.insert(new Object[] { "134허3836", "avante", "sangdo" });
        this.car.insert(new Object[] { "134허3837", "grandeur", "sangdo" });
        this.car.insert(new Object[] { "134허3838", "grandeur", "seoulip" });

        this.reservation = TableFactory.create("reservation", new String[] { "carId", "date", "userId" });
        this.reservation.insert(new Object[] { "134허3835", "20231101", "gd" });
        this.reservation.insert(new Object[] { "134허3835", "20231102", "gd" });

        this.user = TableFactory.create("user", new String[] { "userId", "userName" });
        this.user.insert(new Object[] { "gd", "홍길동" });
        this.user.insert(new Object[] { "jg", "정국" });
        this.user.insert(new Object[] { "hmson", "손흥민" });
        this.user.insert(new Object[] { "bjh", "봉준호" });
        this.user.insert(new Object[] { "jpark", "박재범" });
    }

    public static void main(String[] args) {
        // Test Code
        RentcarDB.orm.createScheme();

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
