public class PressureSensor {
	private Pressure pressure = new Pressure();
	
	public float readVoltage() {
		return 5.0f;
	}
	
	public float readPressure() {
		return pressure.getPressure();
	}

	public Pressure getPressureObject(){
		return pressure;
	}
}
