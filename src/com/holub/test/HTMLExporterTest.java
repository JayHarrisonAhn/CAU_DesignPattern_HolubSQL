import com.holub.database.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class HTMLExporterTest {
    Table HTMLTestTable;
    @BeforeEach
    void setUp() {
        HTMLTestTable = TableFactory.create("HTMLTestTable", new String[] { "addrId", "street", "city" });
        HTMLTestTable.insert(new Object[] { "1", "Ahn", "Busan" });
        HTMLTestTable.insert(new Object[] { "2", "Bang", "GyeongGi-Do" });
        HTMLTestTable.insert(new Object[] { "3", "Jeong", "Seoul" });
    }
    @Test
    void test() {
        try {
            String expectedHTML= "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\t<table>\n" +
                    "\t\t<caption>HTMLTestTable</caption>\n" +
                    "\t\t<thead>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<th>addrId</th>\n" +
                    "\t\t\t\t<th>street</th>\n" +
                    "\t\t\t\t<th>city</th>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t</thead>\n" +
                    "\t\t<tbody>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<td>1</td>\n" +
                    "\t\t\t\t<td>Ahn</td>\n" +
                    "\t\t\t\t<td>Busan</td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<td>2</td>\n" +
                    "\t\t\t\t<td>Bang</td>\n" +
                    "\t\t\t\t<td>GyeongGi-Do</td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<td>3</td>\n" +
                    "\t\t\t\t<td>Jeong</td>\n" +
                    "\t\t\t\t<td>Seoul</td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t</tbody>\n" +
                    "\t</table>\n" +
                    "</body>";
            StringBuffer sb = new StringBuffer();  // StringBuffer 객체 sb 생성

            Writer out = new FileWriter("c:/dp2023/HTMLExporter.html");
            HTMLTestTable.export(new HTMLExporter(out));
            out.close();

            BufferedReader reader = new BufferedReader(new FileReader("c:/dp2023/HTMLExporter.html"));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n"); // 읽은 내용을 StringBuffer에 추가
            }
            sb.delete(sb.length() - 1, sb.length());
            reader.close();

            assertEquals(expectedHTML, sb.toString());
        } catch (Exception e) {
            System.out.println("HTMLExporter doesn't work correctly.");
        }
    }
}