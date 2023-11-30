package com.holub.rentcar.models.db.file;

import com.holub.database.Table;
import com.holub.database.XMLExporter;
import com.holub.database.XMLImporter;

import java.io.Reader;
import java.io.Writer;

public class RentcarDBXMLInitializer extends RentcarDBFileInitializer {
    @Override
    Table.Importer importer(Reader in) {
        return new XMLImporter(in);
    }

    @Override
    Table.Exporter exporter(Writer out) {
        return new XMLExporter(out);
    }
}
