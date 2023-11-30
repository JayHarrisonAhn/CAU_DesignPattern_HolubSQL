package com.holub.database;

import java.util.*;

public class GroupByHandler extends TableHandler{
    private Map aggregateColumn;
    private String[] groupByColumn;

    public GroupByHandler(Map<String, String> aggregateColumn, String[] groupByColumn){
        this.aggregateColumn = aggregateColumn;
        this.groupByColumn = groupByColumn;
    }

    @Override
    public Table handleRequest(Table table) {
        String[] columnNames = generateColumnNames();
        Map<String, Double> sum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        Set<String> rowSet = new HashSet<>();

        calculateAggregates(table, columnNames, sum, count, rowSet);

        Table resultTable = createResultTable(columnNames, sum, count, rowSet);

        if (successor != null) {
            resultTable = successor.handleRequest(resultTable);
        }

        return new UnmodifiableTable(resultTable);
    }

    private String[] generateColumnNames() {
        List<String> columnNames = new ArrayList<>(Arrays.asList(groupByColumn));
        aggregateColumn.keySet().forEach(aggregateKey ->
                columnNames.add(aggregateColumn.get(aggregateKey) + "_" + aggregateKey)
        );
        return columnNames.toArray(new String[0]);
    }

    private String generateGroupingKey(Cursor current) {
        // Logic to generate the grouping key
        StringBuilder groupKey = new StringBuilder();
        for (String groupColumn : groupByColumn) {
            groupKey.append(current.column(groupColumn)).append(" ");
        }
        return groupKey.toString();
    }

    private void calculateAggregateValues(Cursor current, Map<String, Double> sum,
                                          Map<String, Integer> count, String key) {
        Iterator aggregateKeys = aggregateColumn.keySet().iterator();

        while (aggregateKeys.hasNext()) {
            String aggregateKey = aggregateKeys.next().toString();

            switch (aggregateColumn.get(aggregateKey).toString()) {
                case "sum":
                    try {
                        if(sum.containsKey(key)) sum.put(key, sum.get(key) + Double.parseDouble(current.column(aggregateKey).toString()));
                        else sum.put(key, Double.parseDouble(current.column(aggregateKey).toString()));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("숫자 형식이 아닌 문자열이 포함되어 있습니다.");
                    }
                    break;
                case "count":
                    if(count.containsKey(key)) count.put(key, count.get(key) + 1);
                    else count.put(key, 1);
                    break;
            }
        }
    }

    private void calculateAggregates(Table table, String[] columnNames, Map<String, Double> sum,
                                     Map<String, Integer> count, Set<String> rowSet) {
        Cursor current = table.rows();

        while (current.advance()) {
            String key = generateGroupingKey(current);
            calculateAggregateValues(current, sum, count, key);
            rowSet.add(key);
        }
    }

    private Table createResultTable(String[] columnNames, Map<String, Double> sum,
                                    Map<String, Integer> count, Set<String> rowSet) {
        Table resultTable = new ConcreteTable(null, columnNames);

        for (String setKeys : rowSet) {
            String[] columns = setKeys.split(" ");
            Object[] values = new Object[columns.length + aggregateColumn.size()];
            int cnt2 = 0;
            for (String column : columns) {
                values[cnt2++] = column;
            }

            for (Object aggregateKey : aggregateColumn.keySet()) {
                switch (aggregateColumn.get(aggregateKey).toString()) {
                    case "sum":
                        values[cnt2++] = sum.get(setKeys);
                        break;
                    case "count":
                        values[cnt2++] = count.get(setKeys);
                        break;
                }
            }
            resultTable.insert(values);
        }
        return resultTable;
    }
}
