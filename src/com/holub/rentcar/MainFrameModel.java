package com.holub.rentcar;

import java.util.Observable;

public class MainFrameModel extends Observable {
    public String currentMenu = "test";
    void changeMenu(String menuId) {
        this.currentMenu = menuId;
        setChanged();
        notifyObservers();
    }
}