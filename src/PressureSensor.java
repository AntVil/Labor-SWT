public class PressureSensor {
	private float voltage;
	private float pressure;
	
	/**
	 * Constructor of a class for handling the pressure sensor
	 */
	public PressureSensor() {
		voltage = 5.0f;
		pressure = 200.0f;
	}
	
	/**
	 * Reads the voltage at the sensor
	 * @return voltage
	 */
	public float readVoltage(){
		return voltage;
	}
	
	/**
	 * Reads the measured pressure
	 * @return current pressure
	 */
	public float readPressure(){
		return pressure;
	}

	/**
	 * Sets the pressure (for test purposes)
	 * @param p test pressure
	 */
	public void setPressure(float p){
		pressure = p;
	}
	
	/**
	 * Sets the voltage (for test purposes)
	 * @param v test voltage
	 */
	public void setVoltage(float v){
		voltage = v;
	}
}
