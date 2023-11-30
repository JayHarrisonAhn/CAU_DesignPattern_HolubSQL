package com.holub.test;

import com.holub.database.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Handler;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class GroupByHandlerTest {
    TableHandler tableHandler;
    Table table;
    @BeforeEach
    void setUp() {
        Map<String, String> aggregateColumn = new HashMap<>();
        aggregateColumn.put("score", "sum");
        tableHandler = new OrderByHandler("sum_score", "asc");
        tableHandler.SetSuccessor(new GroupByHandler(aggregateColumn, new String[] {"name", "id"}));
        table = new ConcreteTable("table", new String[]{ "name", "grade", "id", "score"});
        table.insert(new String[]{"bang", "4", "15411541", "90"});
        table.insert(new String[]{"ahn", "4", "12345678", "60"});
        table.insert(new String[]{"jeong", "4", "43215678", "70"});
        table.insert(new String[]{"bang", "4", "15411541", "50"});
    }
    @Test
    void test() {
        try {
            Table expectedTable = new ConcreteTable("table", new String[]{ "name", "id", "sum_score"});
            expectedTable.insert(new String[]{"ahn", "12345678", "60.0"});
            expectedTable.insert(new String[]{"jeong", "43215678", "70.0"});
            expectedTable.insert(new String[]{"bang", "15411541", "140.0"});

            Table targetTable = tableHandler.handleRequest(table);

            Cursor origin = expectedTable.rows();
            Cursor target = targetTable.rows();

            while (target.advance() && origin.advance()) {
                Iterator<?> targetIter = target.columns();
                Iterator<?> originIter = origin.columns();

                while (targetIter.hasNext() && originIter.hasNext()) {
                    String targetItem = String.valueOf(targetIter.next());
                    String originItem = String.valueOf(originIter.next());
                    assertEquals(targetItem, originItem);
                }
            }

            if(target.advance() || origin.advance()){
                fail("group-by keyword doesn't work correctly.");
            }
        } catch (Exception e) {
            System.out.println("group-by keyword doesn't work correctly.");
        }
    }
}