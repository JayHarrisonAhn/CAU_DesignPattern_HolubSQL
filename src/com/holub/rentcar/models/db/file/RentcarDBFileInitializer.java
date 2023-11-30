package com.holub.rentcar.models.db.file;

import com.holub.database.*;

import java.io.*;

public class RentcarDBFileInitializer extends RentcarDBInitializer {
    Table.Importer importer;
    Table.Exporter exporter;
    public RentcarDBFileInitializer(Table.Importer importer, Table.Exporter exporter) {
        this.importer = importer;
        this.exporter = exporter;
    }

    private Table importTable(String fileName) throws IOException {
        Reader in = new FileReader(fileName);
        Table spot = new ConcreteTable(new CSVImporter(in));
        in.close();
        return spot;
    }

    @Override
    public Table spot() {
        try {
            return importTable("spot");
        } catch (IOException e) {
            return super.spot();
        }
    }

    @Override
    public Table carTypes() {
        try {
            return importTable("carTypes");
        } catch (IOException e) {
            return super.spot();
        }
    }

    @Override
    public Table car() {
        try {
            return importTable("car");
        } catch (IOException e) {
            return super.spot();
        }
    }

    @Override
    public Table reservation() {
        try {
            return importTable("reservation");
        } catch (IOException e) {
            return super.spot();
        }
    }

    @Override
    public Table user() {
        try {
            return importTable("user");
        } catch (IOException e) {
            return super.spot();
        }
    }

    @Override
    public void save(Table spot, Table carTypes, Table car, Table reservation, Table user) {
        try {
            Writer out;

            out = new FileWriter("spot");
            spot.export(new CSVExporter(out));
            out.close();

            out = new FileWriter("carTypes");
            carTypes.export(new CSVExporter(out));
            out.close();

            out = new FileWriter("car");
            car.export(new CSVExporter(out));
            out.close();

            out = new FileWriter("reservation");
            reservation.export(new CSVExporter(out));
            out.close();

            out = new FileWriter("user");
            user.export(new CSVExporter(out));
            out.close();
        } catch (IOException e) { }
    }
}
