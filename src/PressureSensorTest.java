import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;

public class PressureSensorTest {
	private float CRITICALLY_LOW = 49.9f;
	private float LOW = 179.9f;
	private float OPTIMAL_LOW = 180.0f;
	private float OPTIMAL_HIGH = 219.9f;
	private float HIGH = 220.0f;
	private float CRITICALLY_HIGH = 300.1f;
	private float DANGEROUSLY_HIGH = 500.1f;

	PressureSensor pressuresensor = new PressureSensor();
	private Pressure pressure = pressuresensor.getPressureObject();
	
	@Test
	@DisplayName("pressure pre 50")
	//@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTest_CRITICALLY_LOW() {
		pressure.setPressure(CRITICALLY_LOW);
		assertEquals(pressuresensor.readPressure(), pressure.getPressure());
	}

	@Test
	@DisplayName("pressure pre 180")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTest_LOW() {
		pressure.setPressure(LOW);
		assertEquals(pressuresensor.readPressure(), pressure.getPressure());
	}

	@Test
	@DisplayName("pressure at 180")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTest_OPTIMAL_LOW() {
		pressure.setPressure(OPTIMAL_LOW);
		assertEquals(pressuresensor.readPressure(), pressure.getPressure());
	}

	@Test
	@DisplayName("pressure pre 220")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTest_OPTIMAL_HIGH() {
		pressure.setPressure(OPTIMAL_HIGH);
		assertEquals(pressuresensor.readPressure(), pressure.getPressure());
	}

	@Test
	@DisplayName("pressure at 220")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTest_HIGH() {
		pressure.setPressure(HIGH);
		assertEquals(pressuresensor.readPressure(), pressure.getPressure());
	}

	@Test
	@DisplayName("pressure post 300")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTestCRITICALLY_HIGH() {
		pressure.setPressure(CRITICALLY_HIGH);
		assertEquals(pressuresensor.readPressure(), pressure.getPressure());
	}

	@Test
	@DisplayName("pressure post 500")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void readPressureTest_DANGEROUSLY_HIGH() {
		pressure.setPressure(DANGEROUSLY_HIGH);
		assertEquals(pressuresensor.readPressure(), pressure.getPressure());
	}
}