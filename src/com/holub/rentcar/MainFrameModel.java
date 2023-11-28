package com.holub.rentcar;

import com.holub.database.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class MainFrameModel extends Observable {
    public String currentMenu = "test";
    public ArrayList<Selection> infos = Selection.fromTable(RentcarDB.orm.car);
    public ArrayList<Selection> places = new ArrayList<>();
    public String time;

    public void changeMenu(String menuId) {
        this.currentMenu = menuId;
        setChanged();
        notifyObservers();
    }

    public void setInfos(ArrayList<Selection> infos) {
        this.infos = infos;
        setChanged();
        notifyObservers();
    }

    public void setPlaces(ArrayList<Selection> places) {
        this.places = places;
        setChanged();
        notifyObservers();
    }

    public void changeTime(String time) {
        this.time = time;
        setChanged();
        notifyObservers();
    }
}

