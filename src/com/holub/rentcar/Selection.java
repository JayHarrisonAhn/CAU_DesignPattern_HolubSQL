package com.holub.rentcar;

import com.holub.database.Table;

import java.util.ArrayList;

public class Selection {
    public String key;
    public boolean selected = false;
    Selection(String key) {
        this.key = key;
    }
    static ArrayList<Selection> fromTable(Table table) {
        ArrayList<Selection> arrayList = new ArrayList<>();
        arrayList.add(new Selection("cona"));
        return arrayList;
    }
}