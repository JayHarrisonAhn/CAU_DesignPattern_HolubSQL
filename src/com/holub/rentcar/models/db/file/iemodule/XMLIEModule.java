package com.holub.rentcar.models.db.file.iemodule;

import com.holub.database.Table;
import com.holub.database.XMLExporter;
import com.holub.database.XMLImporter;

import java.io.Reader;
import java.io.Writer;

public class XMLIEModule extends IEModule {
    @Override
    public Table.Importer importer(Reader in) {
        return new XMLImporter(in);
    }

    @Override
    public Table.Exporter exporter(Writer out) {
        return new XMLExporter(out);
    }
}
