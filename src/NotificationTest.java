import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NotificationTest {

    @Test
    void sendLog(){
        Notification notification = new Notification;
        assertEquals("Works",notification.notify("test@test.com", "This is a test"));
    }

}
