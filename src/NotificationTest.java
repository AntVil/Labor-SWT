import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NotificationTest {

	/**
	 * Tests if an e-mail can be written
	 */
    @Test
    void sendNotifyTest(){
        Notification notification = new Notification();
        
        String response = notification.notify("test@test.com", "This is a test");
        
        assertEquals(response, "message send successfully");
    }
    
    /**
	 * Tests if an written e-mail is in the history 
	 */
    @Test
    void readNotifyTest(){
        Notification notification = new Notification();
        
        notification.notify("test@test.com", "This is a test");
        
        assertTrue(notification.historyIncludes("test@test.com", "This is a test"));
    }
}
