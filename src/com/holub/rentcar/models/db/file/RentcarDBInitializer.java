package com.holub.rentcar.models.db.file;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public abstract class RentcarDBInitializer {
    public Table spot() {
        Table table = TableFactory.create("spot", new String[] { "spotId", "spotName", "address" });
        table.insert(new Object[] { "sadang", "사당점", "" });
        table.insert(new Object[] { "sangdo", "상도점", "" });
        table.insert(new Object[] { "heukseok", "흑석점", "" });
        return table;
    };
    public Table carTypes() {
        Table table = TableFactory.create("carTypes", new String[] { "carTypeId", "carTypeName" });
        table.insert(new Object[] { "casper", "캐스퍼" });
        table.insert(new Object[] { "morning", "모닝" });
        table.insert(new Object[] { "avante", "아반떼" });
        table.insert(new Object[] { "sonata", "쏘나타" });
        table.insert(new Object[] { "grandeur", "그랜저" });
        table.insert(new Object[] { "k3", "K3" });
        table.insert(new Object[] { "k5", "K5" });
        table.insert(new Object[] { "k9", "K9" });
        table.insert(new Object[] { "venu", "베뉴" });
        table.insert(new Object[] { "cona", "코나" });
        table.insert(new Object[] { "niro", "니로" });
        table.insert(new Object[] { "tuecson", "투싼" });
        table.insert(new Object[] { "santafe", "싼타페" });
        table.insert(new Object[] { "ioniq5", "아이오닉5" });
        table.insert(new Object[] { "ev6", "EV6" });
        return table;
    };
    public Table car() {
        Table table = TableFactory.create("car", new String[] { "carId", "carType", "spotId" });
        table.insert(new Object[] { "134허1047", "avante", "sangdo" });
        table.insert(new Object[] { "132허2384", "niro", "sangdo" });
        table.insert(new Object[] { "137허3384", "niro", "sangdo" });
        table.insert(new Object[] { "135허9284", "k3", "sangdo" });
        table.insert(new Object[] { "133허4482", "ioniq5", "sangdo" });
        table.insert(new Object[] { "132허9866", "ev6", "sangdo" });

        table.insert(new Object[] { "183하4506", "k3", "sadang" });
        table.insert(new Object[] { "164허9826", "k5", "sadang" });
        table.insert(new Object[] { "487허2990", "casper", "sadang" });
        table.insert(new Object[] { "294호7392", "morning", "sadang" });
        table.insert(new Object[] { "18호3050", "venu", "sadang" });
        table.insert(new Object[] { "453하9783", "kona", "sadang" });

        table.insert(new Object[] { "239허4582", "grandeur", "heukseok" });
        table.insert(new Object[] { "134하9752", "grandeur", "heukseok" });
        table.insert(new Object[] { "965호8456", "grandeur", "heukseok" });
        table.insert(new Object[] { "239하8475", "ev6", "heukseok" });
        table.insert(new Object[] { "209허4380", "santafe", "heukseok" });
        return table;
    };
    public Table reservation() {
        return TableFactory.create("reservation", new String[] { "carId", "date", "userId" });
    };
    public Table user() {
        Table table = TableFactory.create("user", new String[] { "userId", "userName" });
        table.insert(new Object[] { "admin", "초기관리자" });
        table.insert(new Object[] { "btsjm", "박지민" });
        table.insert(new Object[] { "hmson", "손흥민" });
        table.insert(new Object[] { "bjh", "봉준호" });
        table.insert(new Object[] { "jpark", "박재범" });
        return table;
    };
    public void save(Table spot, Table carTypes, Table car, Table reservation, Table user) { };
}
