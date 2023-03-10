import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PressureValveTest {

    PressureValve valve = new PressureValve();

    @BeforeEach
    void start(){
        valve.open();
    }

    @AfterEach
    void end(){
        valve.close();
    }

    /**
     * Tests whether the valve can be opened
     */
    @Test
    void openValveTest(){
        assertEquals(valve.isOpen(), true);
        assertEquals(valve.readStatus(), 1.0f);
    }

    /**
     * Tests whether the valve can be closed
     */
    @Test
    void closeValveTest(){
        valve.close();
        assertEquals(valve.isOpen(), false);
        assertEquals(valve.readStatus(), 0.0f);
    }

}
