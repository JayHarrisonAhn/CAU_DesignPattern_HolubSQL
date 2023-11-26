import com.holub.database.Table;
import com.holub.database.TableFactory;
import com.holub.database.XMLExporter;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

class XMLExporterTest {
    Table XMLTestTable;
    @BeforeEach
    void setUp() {
        XMLTestTable = TableFactory.create("XMLTestTable", new String[] { "addrId", "street", "city" });
        XMLTestTable.insert(new Object[] { "1", "Ahn", "Busan" });
        XMLTestTable.insert(new Object[] { "2", "Bang", "GyeongGi-Do" });
        XMLTestTable.insert(new Object[] { "3", "Jeong", "Seoul" });
    }
    @Test
    void test() {
        try {
            String expectedXML= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<XMLTestTable>\n" +
                    "\t<row>\n" +
                    "\t\t<addrId>1</addrId>\n" +
                    "\t\t<street>Ahn</street>\n" +
                    "\t\t<city>Busan</city>\n" +
                    "\t</row>\n" +
                    "\t<row>\n" +
                    "\t\t<addrId>2</addrId>\n" +
                    "\t\t<street>Bang</street>\n" +
                    "\t\t<city>GyeongGi-Do</city>\n" +
                    "\t</row>\n" +
                    "\t<row>\n" +
                    "\t\t<addrId>3</addrId>\n" +
                    "\t\t<street>Jeong</street>\n" +
                    "\t\t<city>Seoul</city>\n" +
                    "\t</row>\n" +
                    "</XMLTestTable>";
            StringBuffer sb = new StringBuffer();  // StringBuffer 객체 sb 생성

            Writer out = new FileWriter("c:/dp2023/XMLExporter.xml");
            XMLTestTable.export(new XMLExporter(out));
            out.close();

            BufferedReader reader = new BufferedReader(new FileReader("c:/dp2023/XMLExporter.xml"));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n"); // 읽은 내용을 StringBuffer에 추가
            }
            sb.delete(sb.length() - 1, sb.length());
            reader.close();

            assertEquals(expectedXML, sb.toString());
        } catch (Exception e){
            System.err.println("XML Exporter doesn't working correctly.");
        }
    }
}