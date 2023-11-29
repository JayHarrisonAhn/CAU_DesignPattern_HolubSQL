package com.holub.test;

import com.holub.database.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class XMLImporterTest {
    Table expectedTable;
    @BeforeEach
    void setUp() {
        expectedTable = new ConcreteTable("XMLTestTable", new String[] { "addrId", "street", "city" });
        expectedTable.insert(new Object[] { "1", "Ahn", "Busan" });
        expectedTable.insert(new Object[] { "2", "Bang", "GyeongGi-Do" });
        expectedTable.insert(new Object[] { "3", "Jeong", "Seoul" });
    }

    @Test
    void test() {
        try {
            Reader in = new FileReader("c:/dp2023/XMLExporter.xml");
            Table XMLTestTable = new ConcreteTable(new XMLImporter(in));
            in.close();

            Cursor target = XMLTestTable.rows();
            Cursor origin = expectedTable.rows();

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
                fail("Imported Table isn't correct.");
            }
        } catch (Exception e){
            System.out.println("XML Importer doesn't working correctly.");
        }
    }
}