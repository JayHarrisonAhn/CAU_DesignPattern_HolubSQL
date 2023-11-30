package com.holub.rentcar.models.db.file;

import com.holub.database.*;

import java.io.Reader;
import java.io.Writer;

public class RentcarDBCSVInitializer extends RentcarDBFileInitializer {
    @Override
    Table.Importer importer(Reader in) {
        return new CSVImporter(in);
    }

    @Override
    Table.Exporter exporter(Writer out) {
        return new CSVExporter(out);
    }
}
