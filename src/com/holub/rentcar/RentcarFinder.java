package com.holub.rentcar;

import com.holub.database.*;

import java.util.*;
import java.util.logging.Handler;

public class RentcarFinder {
    private Table result = RentcarDB.orm.car.select(new Selector.Adapter() {
        public boolean approve(Cursor[] tables) {
            return true;
        }
    });

    public RentcarFinder date(String date) {
        Table unavailableCarTable = RentcarDB.orm.reservation.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return tables[0].column("date").equals(date);
            }
        }, new String[] { "carId" });
        Set<String> unavailableCars = new HashSet<>();
        for (Cursor i = unavailableCarTable.rows(); i.advance();) {
            unavailableCars.add(i.columns().next().toString());
        }
        this.result = result.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return !unavailableCars.contains(tables[0].column("carId"));
            }
        });
        return this;
    }

    public RentcarFinder spot(String spot) {
        this.result = result.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return tables[0].column("spotId").equals(spot);
            }
        });
        return this;
    }

    @Override
    public String toString() {
        return this.result.toString();
    }

    public static void main(String[] args) {
        RentcarDB.orm.createScheme();

        RentcarFinder finder = new RentcarFinder()
                .date("20231101")
                .spot("sadang")
                ;
        System.out.println(finder.toString());
    }
}