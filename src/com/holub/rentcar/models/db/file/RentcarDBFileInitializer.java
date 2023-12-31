package com.holub.rentcar.models.db.file;

import com.holub.database.*;
import com.holub.rentcar.models.db.file.iemodule.IEModule;

import java.io.*;

public class RentcarDBFileInitializer extends RentcarDBInitializer {

    IEModule ieModule;

    public RentcarDBFileInitializer(IEModule ieModule) {
        this.ieModule = ieModule;
    }

    private Table importTable(String fileName) throws IOException {
        Reader in = new FileReader(fileName);
        Table spot = new ConcreteTable(ieModule.importer(in));
        in.close();
        return spot;
    }

    @Override
    public Table spot() {
        try {
            return importTable("rentcar_spot");
        } catch (IOException e) {
            return super.spot();
        }
    }

    @Override
    public Table carTypes() {
        try {
            return importTable("rentcar_carTypes");
        } catch (IOException e) {
            return super.carTypes();
        }
    }

    @Override
    public Table car() {
        try {
            return importTable("rentcar_car");
        } catch (IOException e) {
            return super.car();
        }
    }

    @Override
    public Table reservation() {
        try {
            return importTable("rentcar_reservation");
        } catch (IOException e) {
            return super.reservation();
        }
    }

    @Override
    public Table user() {
        try {
            return importTable("rentcar_user");
        } catch (IOException e) {
            return super.user();
        }
    }

    @Override
    public void save(Table spot, Table carTypes, Table car, Table reservation, Table user) {
        write(spot, "rentcar_spot");
        write(carTypes, "rentcar_carTypes");
        write(car, "rentcar_car");
        write(reservation, "rentcar_reservation");
        write(user, "rentcar_user");
    }

    private void write(Table table, String fileName) {
        try {
            Writer out = new FileWriter(fileName);
            table.export(ieModule.exporter(out));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
