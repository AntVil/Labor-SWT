import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BluetoothInterfaceTest {
	
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
