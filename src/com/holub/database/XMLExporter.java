package com.holub.database;

import java.io.*;
import java.util.*;
public class XMLExporter implements Table.Exporter {
    private final Writer out;
    private int	width;
    private int height;
    private String[] columnNames;
    private String tableName;

    public XMLExporter( Writer out ) {
        this.out = out;
    }

    public void storeMetadata( String tableName, int width, int height, Iterator columnNames ) throws IOException {
        this.width = width;
        this.height = height;
        this.tableName = tableName;
        out.write(tableName == null ? "<anonymous>" : "<" + tableName + ">");
        out.write("\n");
        this.columnNames = new String[width];
        for (int i = 0; columnNames.hasNext(); i++) {
            this.columnNames[i] = columnNames.next().toString();
        }
    }

    public void storeRow( Iterator data ) throws IOException {
        int idx = 0;
        out.write("\t<row>\n");
        while (data.hasNext())
        {
            Object datum = data.next();
            if( datum != null ) {
                out.write("\t\t<" + columnNames[idx] + ">");
                out.write(datum.toString());
                out.write("</" + columnNames[idx] + ">");
            } else {
                out.write("\t\t<" + columnNames[idx] + ">");
                out.write("</" + columnNames[idx] + ">");
            }

            out.write("\n");
            if (idx < width) {
                idx += 1;
            }
        }
        out.write("\t</row>\n");
    }

    public void startTable() throws IOException {out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");}
    public void endTable()   throws IOException {out.write("</" + this.tableName + ">");}
}
