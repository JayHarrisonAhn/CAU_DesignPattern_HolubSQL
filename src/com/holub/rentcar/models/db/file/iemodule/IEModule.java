package com.holub.rentcar.models.db.file.iemodule;

import com.holub.database.Table;

import java.io.Reader;
import java.io.Writer;

public abstract class IEModule {
    public abstract Table.Importer importer(Reader in);
    public abstract Table.Exporter exporter(Writer out);
}
