package com.holub.rentcar.models;

import com.holub.database.Table;

import java.util.ArrayList;

public class Selection<T> {
    public T obj;
    public boolean selected = false;
    public Selection(T obj) {
        this.obj = obj;
    }
}