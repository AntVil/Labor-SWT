import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PressureSensorTest {
	
	/**
	 * Tests whether the pressure can be read
	 */
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTest(){
		PressureSensor pressureSensor = new PressureSensor();
		
		pressureSensor.setPressure(200.0f);
		
		assertTrue(pressureSensor.readPressure() == 200.0f);
	}

	/**
	 * Tests whether the voltage can be read
	 */
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readVoltageTest(){
		PressureSensor pressureSensor = new PressureSensor();
		
		pressureSensor.setVoltage(5.0f);
		
		assertTrue(pressureSensor.readVoltage() == 5.0f);
	}
}
