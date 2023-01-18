import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BluetoothInterfaceTest {
	
	/**
	 * Test whether displayed pressure is the same as read pressure
	 */
	@Test
	void getDisplayedPressureTest() {
		BluetoothInterface bluetoothInterface = new BluetoothInterface();
		System system = bluetoothInterface.getSystem();
		PressureSensor pressureSensor = system.getPressureSensor();
		
		bluetoothInterface.updateIteration();
		
		assertEquals(
			bluetoothInterface.getDisplayedPressure(),
			pressureSensor.readPressure()
		);
	}
	
	/**
	 * Test whether displayed sensor voltage is the same as read sensor voltage
	 */
	@Test
	void getDisplayedSensorVoltageTest() {
		BluetoothInterface bluetoothInterface = new BluetoothInterface();
		System system = bluetoothInterface.getSystem();
		PressureSensor pressureSensor= system.getPressureSensor();
		
		bluetoothInterface.updateIteration();
		
		assertEquals(
			bluetoothInterface.getDisplayedSensorVoltage(),
			pressureSensor.readVoltage()
		);
	}
	
	/**
	 * Test whether displayed valve open status is the same as read valve open status
	 */
	@Test
	void getDisplayedValveStatusTest() {
		BluetoothInterface bluetoothInterface = new BluetoothInterface();
		System system = bluetoothInterface.getSystem();
		PressureValve pressureValve = system.getPressureValve();
		
		bluetoothInterface.updateIteration();
		
		assertEquals(
			bluetoothInterface.getDisplayedValveStatus(),
			pressureValve.readStatus()
		);
	}
}
