package com.holub.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DistinctHandler extends TableHandler{
    @Override
    public Table handleRequest(Table table) {
        String[] columnNames = extractColumnNames(table);
        Table resultTable = createResultTable(columnNames);
        Set<String> rowSet = new HashSet<>();
        Cursor current = table.rows();

        while (current.advance()) {
            Object[] values = extractRowValues(current, columnNames);
            String rowKey = generateRowKey(values);

            if (!rowSet.contains(rowKey)) {
                rowSet.add(rowKey);
                resultTable.insert(values);
            }
        }

        if (successor != null) {
            resultTable = successor.handleRequest(resultTable);
        }

        return new UnmodifiableTable(resultTable);
    }

    private String generateRowKey(Object[] values) {
        StringBuilder rowKey = new StringBuilder();
        for (Object value : values) {
            rowKey.append(String.valueOf(value));
        }
        return rowKey.toString();
    }

    private String[] extractColumnNames(Table table) {
        int columnCount = table.rows().columnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = table.rows().columnName(i);
        }
        return columnNames;
    }

    private Table createResultTable(String[] columnNames) {
        return new ConcreteTable(null, columnNames);
    }

    private Object[] extractRowValues(Cursor cursor, String[] columnNames) {
        Object[] values = new Object[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            values[i] = cursor.column(columnNames[i]);
        }
        return values;
    }
}
