package com.holub.rentcar.models.db;

import com.holub.database.*;

import java.util.*;

public class RentcarFinder {
    private Table result;

    public RentcarFinder() {
        List columns = new ArrayList();
        columns.add("carId");
        columns.add("carTypeId");
        columns.add("name");
        columns.add("spotId");

        List tables = new ArrayList();
        tables.add(RentcarDB.orm.carTypes);

        this.result =
                RentcarDB.orm.car.select(new Selector.Adapter() {
                    public boolean approve(Cursor[] tables) {
                        return tables[0].column("carType").equals(tables[1].column("carTypeId"));
                    }
                }, columns, tables);
    }

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

    public RentcarFinder spots(Set<String> spots) {
        this.result = result.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return spots.contains(tables[0].column("spotId"));
            }
        });
        return this;
    }

    public RentcarFinder types(Set<String> types) {
        this.result = result.select(new Selector.Adapter() {
            public boolean approve(Cursor[] tables) {
                return types.contains(tables[0].column("carTypeId"));
            }
        });
        return this;
    }

    public Table getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return this.result.toString();
    }

    public static void main(String[] args) {
        RentcarFinder finder = new RentcarFinder()
                .date("20231101")
                .spot("sadang")
                ;
        System.out.println(finder.toString());
    }
}