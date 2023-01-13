import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LogTest {

    @Test
    void sendLog(){
        Log log = new Log;
        assertEquals("Works",log.writeLog("Test"));
    }
}
