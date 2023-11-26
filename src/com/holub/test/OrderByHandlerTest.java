import com.holub.database.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Handler;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderByHandlerTest {
    TableHandler orderByHandler;
    Table table;
    @BeforeEach
    void setUp() {
        orderByHandler = new OrderByHandler("score", "asc");
        table = new ConcreteTable("table", new String[]{ "name", "grade", "id", "score"});
        table.insert(new String[]{"bang", "4", "15411541", "90"});
        table.insert(new String[]{"ahn", "4", "12345678", "60"});
        table.insert(new String[]{"jeong", "4", "43215678", "70"});
        table.insert(new String[]{"kwon", "4", "35423452", "80"});
    }
    @Test
    void test() {
        try {
            Table expectedTable = new ConcreteTable("table", new String[]{ "name", "grade", "id", "score"});
            expectedTable.insert(new String[]{"ahn", "4", "12345678", "60"});
            expectedTable.insert(new String[]{"jeong", "4", "43215678", "70"});
            expectedTable.insert(new String[]{"kwon", "4", "35423452", "80"});
            expectedTable.insert(new String[]{"bang", "4", "15411541", "90"});

            Table targetTable = orderByHandler.handleRequest(table);

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
                fail("order-by keyword doesn't work correctly.");
            }
        } catch (Exception e) {
            System.out.println("order-by keyword doesn't work correctly.");
        }
    }
}