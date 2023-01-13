import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class BluetoothInterfaceTest {
	
	
	@Test
	void getDisplayedPressureTest() {
		BluetoothInterface bluetoothinterface = new BluetoothInterface();
		System system = new System();
		assertEquals(bluetoothinterface.getDisplayedPressure(), system.getCurrentPressure());
		
	}
	
	@Test
	void getDisplayedSensorVoltageTest() {
		BluetoothInterface bluetoothinterface = new BluetoothInterface();
		System system = new System();
		assertEquals(bluetoothinterface.getDisplayedSensorVoltage(), system.getCurrentSensorVoltage());
		
	}
	
	@Test
	void getDisplayedValveStatusTest() {
		BluetoothInterface bluetoothinterface = new BluetoothInterface();
		System system = new System();
		assertEquals(bluetoothinterface.getDisplayedValveStatus(), system.getCurrentValveStatus());
		
	}
}