package com.holub.rentcar.models.db.file;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public class RentcarDBTestInitializer extends RentcarDBInitializer {
    public Table reservation() {
        Table reservation = super.reservation();
        reservation.insert(new Object[] { "134허3835", "20231103", "jpark" });
        reservation.insert(new Object[] { "134허3835", "20231101", "jpark" });
        reservation.insert(new Object[] { "134허3835", "20231102", "jpark" });
        reservation.insert(new Object[] { "134허3838", "20231102", "gd" });
        return reservation;
    }
}
