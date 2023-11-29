package com.holub.test;

import com.holub.database.Cursor;
import com.holub.database.Table;
import com.holub.rentcar.RentcarDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentcarDBTest {

    @BeforeEach
    void setUp() {
        RentcarDB.orm.createScheme();
    }

    @Test
    void testCreateScheme() {
        assertNotNull(RentcarDB.orm.spot);
        assertNotNull(RentcarDB.orm.carTypes);
        assertNotNull(RentcarDB.orm.car);
        assertNotNull(RentcarDB.orm.reservation);
        assertNotNull(RentcarDB.orm.user);

        assertEquals(4, countRows(RentcarDB.orm.spot));
        assertEquals(5, countRows(RentcarDB.orm.carTypes));
        assertEquals(8, countRows(RentcarDB.orm.car));
        assertEquals(2, countRows(RentcarDB.orm.reservation));
        assertEquals(5, countRows(RentcarDB.orm.user));
    }
    private int countRows(Table table) {
        int count = 0;
        for (Cursor cursor = table.rows(); cursor.advance(); count++);
        return count;
    }
}