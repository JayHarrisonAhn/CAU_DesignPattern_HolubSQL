package com.holub.test;

import com.holub.database.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectJoinTest {
    Table originTable;
    Table joinTable;
    @BeforeEach
    void setUp() {
        originTable = TableFactory.create("origin", new String[] { "addrId", "street", "city" });
        originTable.insert(new Object[] { "1", "Ahn", "Busan" });
        originTable.insert(new Object[] { "2", "Bang", "GyeongGi-Do" });
        originTable.insert(new Object[] { "3", "Jeong", "Seoul" });

        joinTable = TableFactory.create("join", new String[] { "street", "city", "company" });
        joinTable.insert(new Object[] { "Ahn", "Busan", "FaceBook" });
        joinTable.insert(new Object[] { "Bang", "GyeongGi-Do", "Google" });
        joinTable.insert(new Object[] { "Jeong", "Seoul", "Amazon" });
    }

    @Test
    void test(){
        try {
            Table expectedTable = new ConcreteTable("expected", new String[] { "city", "street", "addrId", "company"});
            expectedTable.insert(new Object[] { "Busan", "Ahn", "1", "FaceBook" });
            expectedTable.insert(new Object[] { "Busan", "Ahn", "1", "Google" });
            expectedTable.insert(new Object[] { "Busan", "Ahn", "1", "Amazon" });
            expectedTable.insert(new Object[] { "GyeongGi-Do", "Bang", "2", "FaceBook" });
            expectedTable.insert(new Object[] { "GyeongGi-Do", "Bang", "2", "Google" });
            expectedTable.insert(new Object[] { "GyeongGi-Do", "Bang", "2", "Amazon" });
            expectedTable.insert(new Object[] { "Seoul", "Jeong", "3", "FaceBook" });
            expectedTable.insert(new Object[] { "Seoul", "Jeong", "3", "Google" });
            expectedTable.insert(new Object[] { "Seoul", "Jeong", "3", "Amazon" });

            Table[] other = new Table[1];
            other[0] = joinTable;

            Table resultTable = originTable.select(new Selector() {
                @Override
                public boolean approve(Cursor[] rows) {
                    return true;
                }

                @Override
                public void modify(Cursor current) {

                }
            }, null, other);

            System.out.println(resultTable);
        } catch(Exception e){
            System.out.println("Join Query doesn't work correctly.");
        }
    }
}
