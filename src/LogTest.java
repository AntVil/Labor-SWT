import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LogTest {

    @Test
    void writeLogTest(){
        Log log = new Log();
        
        String response = log.writeLog("Test");
        
        assertEquals(response, "log send successfully");
    }
}
