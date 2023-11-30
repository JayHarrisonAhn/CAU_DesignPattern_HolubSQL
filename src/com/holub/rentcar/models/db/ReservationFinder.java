package com.holub.rentcar.models.db;

import com.holub.database.Cursor;
import com.holub.database.OrderByHandler;
import com.holub.database.Selector;
import com.holub.database.Table;

public class ReservationFinder {
    private Table result;
    public ReservationFinder(String userId) {
        this.result = RentcarDB.orm.reservation.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return tables[0].column("userId").equals(userId);
            }
        }, new String[] { "date", "carId" });

        this.result = this.result.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return tables[0].column("carId").equals(tables[1].column("carId"));
            }
        }, new String[] { "date", "carId", "carType", "spotId" }, new Table[] { RentcarDB.orm.car });

        this.result = this.result.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return tables[0].column("spotId").equals(tables[1].column("spotId"));
            }
        }, new String[] { "date", "carId", "carType", "spotName" }, new Table[] { RentcarDB.orm.spot });

        this.result = this.result.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return tables[0].column("carType").equals(tables[1].column("carTypeId"));
            }
        }, new String[] { "date", "carId", "carTypeName", "spotName" }, new Table[] { RentcarDB.orm.carTypes });
    }

    public ReservationFinder orderByDateDesc() {
        OrderByHandler orderByHandler = new OrderByHandler("date", "desc");
        this.result = orderByHandler.handleRequest(this.result);
        return this;
    }

    public Table getResult() {
        return this.result;
    }
}
