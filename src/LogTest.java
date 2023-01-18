import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class LogTest {

	/**
	 * Tests if a log can be written
	 */
    @Test
    void writeLogTest(){
        Log log = new Log();
        
        String response = log.writeLog("Test");
        
        assertEquals(response, "log send successfully");
    }
    
    /**
	 * Tests if a written log is in the history 
	 */
    @Test
    void readLogTest(){
        Log log = new Log();
        
        log.writeLog("Test");
        
        assertTrue(log.historyIncludes("Test"));
    }
}
