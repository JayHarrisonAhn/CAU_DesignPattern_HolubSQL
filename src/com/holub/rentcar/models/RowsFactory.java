package com.holub.rentcar.models;

import com.holub.database.Cursor;
import com.holub.database.Table;
import com.holub.rentcar.models.row.Row;

import java.util.ArrayList;
import java.util.Iterator;

abstract public class RowsFactory<T extends Row> {
    public ArrayList<T> createFrom(Table table) {
        ArrayList<T> array = new ArrayList<>();
        for (Cursor i = table.rows(); i.advance();) {
            Iterator columns = i.columns();
            T obj = create(columns);
            array.add(obj);
        }
        return array;
    }
    abstract T create(Iterator column);
}