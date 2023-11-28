package com.holub.rentcar;

import com.holub.rentcar.models.row.CarType;
import com.holub.rentcar.models.CarTypesFactory;
import com.holub.rentcar.models.Selection;

import java.util.ArrayList;
import java.util.Observable;

public class MainFrameModel extends Observable {
    public String currentMenu = "test";
    public ArrayList<Selection<CarType>> infos = new ArrayList<>();
//    public ArrayList<Selection> places = new ArrayList<>();
    public String time;

    MainFrameModel() {
        CarTypesFactory carTypesFactory = new CarTypesFactory();
        ArrayList<CarType> carTypes = carTypesFactory.createFrom(RentcarDB.orm.carTypes);
        this.infos.clear();
        for (CarType type : carTypes)
            this.infos.add(new Selection<>(type));
    }

    public void changeMenu(String menuId) {
        this.currentMenu = menuId;
        setChanged();
        notifyObservers();
    }

    public void setInfos(ArrayList<Selection<CarType>> infos) {
        this.infos = infos;
        setChanged();
        notifyObservers();
    }

    public void checkInfo(int index, boolean selected) {
        this.infos.get(index).selected = selected;
        setChanged();
        notifyObservers();
    }

//    public void setPlaces(ArrayList<Selection> places) {
//        this.places = places;
//        setChanged();
//        notifyObservers();
//    }

    public void changeTime(String time) {
        this.time = time;
        setChanged();
        notifyObservers();
    }
}

