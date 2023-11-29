package com.holub.test;

import com.holub.database.Table;
import com.holub.database.TableFactory;
import com.holub.rentcar.RentcarFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.holub.rentcar.RentcarDB;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RentcarFinderTest {
    @BeforeEach
    void setup() {
        RentcarDB.orm.spot = TableFactory.create("spot", new String[] { "spotId", "spotName", "address" });
        RentcarDB.orm.spot.insert(new Object[] { "gangnam", "강남", "" });

        RentcarDB.orm.carTypes = TableFactory.create("carTypes", new String[] { "carTypeId", "name" });
        RentcarDB.orm.carTypes.insert(new Object[]{"pony", "포니"});
        RentcarDB.orm.carTypes.insert(new Object[]{"ferrari", "페라리"});

        RentcarDB.orm.car = TableFactory.create("car", new String[] { "carId", "carType", "spotId" });
        RentcarDB.orm.car.insert(new Object[]{"101하1010", "pony", "sadang"});
        RentcarDB.orm.car.insert(new Object[]{"202하2020", "ferrari", "gangnam"});

        RentcarDB.orm.user = TableFactory.create("user", new String[] { "userId", "userName" });
        RentcarDB.orm.user.insert(new Object[]{"gd", "홍길동"});

        RentcarDB.orm.reservation = TableFactory.create("reservation", new String[] { "carId", "date", "userId" });
        RentcarDB.orm.reservation.insert(new Object[]{"101하1010", "20240701", "gd"});
        RentcarDB.orm.reservation.insert(new Object[]{"202하2020", "20240701", "gd"});
//        RentcarDB.orm.createScheme();
    }

    @Test
    void testRentcarFinder() {
        RentcarFinder finder = new RentcarFinder();

        assertNotNull(finder.getResult());

        assertTrue(finder.getResult() instanceof Table);

        String expectedResult ="<anonymous>\n"
                + "carId\tcarTypeId\tname\tspotId\t\n" +
                "----------------------------------------\n" +
                "101하1010\tpony\t포니\tsadang\t\n" +
                "202하2020\tferrari\t페라리\tgangnam\t\n";
        assertEquals(expectedResult, finder.toString());
    }
}