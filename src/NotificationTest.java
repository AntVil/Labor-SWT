import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NotificationTest {

    @Test
    void notifyTest(){
        Notification notification = new Notification();
        
        String response = notification.notify("test@test.com", "This is a test");
        
        assertEquals(response, "message send successfully");
    }
}
