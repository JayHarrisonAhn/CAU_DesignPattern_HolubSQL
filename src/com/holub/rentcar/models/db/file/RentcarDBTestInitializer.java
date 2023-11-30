package com.holub.rentcar.models.db.file;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public class RentcarDBTestInitializer extends RentcarDBInitializer {
    public Table spot() {
        Table spot = super.spot();
        spot.insert(new Object[] { "sadang", "사당점", "" });
        spot.insert(new Object[] { "seoulstation", "서울역점", "" });
        spot.insert(new Object[] { "seoulip", "서울대입구역점", "" });
        spot.insert(new Object[] { "sangdo", "상도점", "" });
        return spot;
    }
    public Table carTypes() {
        Table carTypes = super.carTypes();
        carTypes.insert(new Object[] { "avante", "아반떼" });
        carTypes.insert(new Object[] { "sonata", "쏘나타" });
        carTypes.insert(new Object[] { "grandeur", "그랜저" });
        carTypes.insert(new Object[] { "cona", "코나" });
        carTypes.insert(new Object[] { "pony", "포니" });
        return carTypes;
    }
    public Table car() {
        Table car = super.car();
        car.insert(new Object[] { "134허3831", "avante", "sangdo" });
        car.insert(new Object[] { "134허3832", "avante", "sadang" });
        car.insert(new Object[] { "134허3833", "avante", "sangdo" });
        car.insert(new Object[] { "134허3834", "avante", "sangdo" });
        car.insert(new Object[] { "134허3835", "avante", "sadang" });
        car.insert(new Object[] { "134허3836", "avante", "sangdo" });
        car.insert(new Object[] { "134허3837", "grandeur", "sangdo" });
        car.insert(new Object[] { "134허3838", "grandeur", "seoulip" });
        return car;
    }
    public Table reservation() {
        Table reservation = super.reservation();
        reservation.insert(new Object[] { "134허3835", "20231103", "jpark" });
        reservation.insert(new Object[] { "134허3835", "20231101", "jpark" });
        reservation.insert(new Object[] { "134허3835", "20231102", "jpark" });
        reservation.insert(new Object[] { "134허3838", "20231102", "gd" });
        return reservation;
    }
    public Table user() {
        Table user = super.user();
        user.insert(new Object[] { "gd", "홍길동" });
        user.insert(new Object[] { "jg", "정국" });
        user.insert(new Object[] { "hmson", "손흥민" });
        user.insert(new Object[] { "bjh", "봉준호" });
        user.insert(new Object[] { "jpark", "박재범" });
        return user;
    }
}
