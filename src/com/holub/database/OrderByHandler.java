package com.holub.database;

import java.util.*;
public class OrderByHandler extends TableHandler{
    private String order;
    private String orderbyID;

    public OrderByHandler(String orderbyID, String order){
        this.orderbyID = orderbyID;
        this.order = order;
    }

    private static class OrderByValue{
        int columnIdx;
        String data;
        public OrderByValue(int columnIdx, String data) {
            this.columnIdx = columnIdx;
            this.data = data;
        }
    }

    private int getRowsCount(Table table) {
        Cursor current = table.rows();
        int count = 0;
        while(current.advance()) ++count;
        return count;
    }

    @Override
    public Table handleRequest(Table table) {
        List<Object[]> tableValues = new ArrayList<>();
        String[] columnNames = extractColumnNames(table);
        Table resultTable = new ConcreteTable(null, columnNames);
        int keyIdx = findKeyColumnIndex(table, orderbyID);
        Map<String, List<List<OrderByValue>>> map = createMap(table, keyIdx);

        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, createCustomComparator(order));

        int rowIdx = 0;
        for (String key : keyList) {
            List<List<OrderByValue>> values = map.get(key);
            for (List<OrderByValue> value : values) {
                Object[] rowValues = new Object[columnNames.length];
                rowValues[keyIdx] = key;
                for (OrderByValue item : value) {
                    rowValues[item.columnIdx] = item.data;
                }
                tableValues.add(rowValues);
                rowIdx++;
            }
        }

        for (Object[] values : tableValues) {
            resultTable.insert(values);
        }

        if (successor != null) {
            resultTable = successor.handleRequest(resultTable);
        }

        return new UnmodifiableTable(resultTable);
    }
    private String[] extractColumnNames(Table table) {
        String[] columnNames = new String[table.rows().columnCount()];
        for (int i = 0; i < columnNames.length; i++) {
            columnNames[i] = table.rows().columnName(i);
        }
        return columnNames;
    }

    private int findKeyColumnIndex(Table table, String orderbyID) {
        Cursor rows = table.rows();
        for (int i = 0; i < rows.columnCount(); i++) {
            if (rows.columnName(i).equals(orderbyID)) {
                return i;
            }
        }
        return -1;
    }

    private Comparator<String> createCustomComparator(String order) {
        boolean isDesc = order.toLowerCase().equals("desc");

        return (s1, s2) -> {
            boolean isNumeric1 = isNumeric(s1);
            boolean isNumeric2 = isNumeric(s2);

            if (isNumeric1 && isNumeric2) {
                return compareNumericValues(s1, s2, isDesc);
            } else {
                return isDesc ? s2.compareTo(s1) : s1.compareTo(s2);
            }
        };
    }

    private int compareNumericValues(String s1, String s2, boolean isDesc) {
        double val1 = Double.parseDouble(s1);
        double val2 = Double.parseDouble(s2);
        return isDesc ? Double.compare(val2, val1) : Double.compare(val1, val2);
    }

    private Map<String, List<List<OrderByValue>>> createMap(Table table, int keyIdx) {
        Map<String, List<List<OrderByValue>>> map = new HashMap<>();
        Cursor current = table.rows();

        while (current.advance()) {
            List<OrderByValue> value = new ArrayList<>();
            String keyData = "";
            Iterator<?> iter = current.columns();
            int idx = 0;

            while (iter.hasNext()) {
                String item = String.valueOf(iter.next());
                if (idx == keyIdx) {
                    keyData = item;
                } else {
                    value.add(new OrderByValue(idx, item));
                }
                idx++;
            }

            map.computeIfAbsent(keyData, k -> new ArrayList<>()).add(value);
        }
        return map;
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // 정수 및 실수 여부 체크
    }
}
