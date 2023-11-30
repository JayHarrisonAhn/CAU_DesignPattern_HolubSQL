package com.holub.rentcar.models.db.file.iemodule;

import com.holub.database.CSVExporter;
import com.holub.database.CSVImporter;
import com.holub.database.Table;

import java.io.Reader;
import java.io.Writer;

public class CSVIEModule extends IEModule {

    @Override
    public Table.Importer importer(Reader in) {
        return new CSVImporter(in);
    }

    @Override
    public Table.Exporter exporter(Writer out) {
        return new CSVExporter(out);
    }
}
