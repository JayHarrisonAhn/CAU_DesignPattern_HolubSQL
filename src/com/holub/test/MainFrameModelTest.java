package com.holub.test;

import com.holub.rentcar.MainFrameModel;
import com.holub.rentcar.models.row.*;
import com.holub.rentcar.models.Selection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MainFrameModelTest {
    @BeforeEach
    void setup() {
        ArrayList<CarType> carTypes = new ArrayList<>();
        carTypes.add(new CarType("1", "포니"));
        carTypes.add(new CarType("2", "페라리"));

        ArrayList<Place> place = new ArrayList<>();
        place.add(new Place("11", "중앙대", "서울"));
        place.add(new Place("22", "서울대", "서울"));

        MainFrameModel model = new MainFrameModel();
        model.infos.clear();
        model.infos.add(new Selection<>(new CarType("1", "포니")));
        model.places.clear();
        model.places.add(new Selection<>(new Place("11", "중앙대", "서울")));

        model.searchResults();

        assertNotNull(model.results);
    }

    @Test
    void testChangeMenu() {
        MainFrameModel model = new MainFrameModel();

        model.changeMenu("info");

        assertEquals("info", model.currentMenu);
    }

    @Test
    void testSetInfos() {
        MainFrameModel model = new MainFrameModel();

        model.infos.clear();
        model.infos.add(new Selection<>(new CarType("1", "포니")));

        ArrayList<Selection<CarType>> newInfos = new ArrayList<>();
        newInfos.add(new Selection<>(new CarType("2", "페라리")));

        model.setInfos(newInfos);

        assertEquals(newInfos, model.infos);
    }

    @Test
    void testCheckInfo() {
        MainFrameModel model = new MainFrameModel();

        model.infos.clear();
        model.infos.add(new Selection<>(new CarType("1", "포니")));

        model.checkInfo(0, true);

        assertTrue(model.infos.get(0).selected);
    }

    @Test
    void testCheckPlace() {
        MainFrameModel model = new MainFrameModel();

        model.places.clear();
        model.places.add(new Selection<>(new Place("11", "중앙대", "서울")));

        model.checkPlace(0, true);

        assertTrue(model.places.get(0).selected);
    }

    @Test
    void testChangeTime() {
        MainFrameModel model = new MainFrameModel();

        model.changeTime(2024, 7, 1);

        assertEquals(2024, model.year);
        assertEquals(7, model.month);
        assertEquals(1, model.day);
    }
}
