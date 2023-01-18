import java.util.Locale;

public class System {
	private float currentPressure;
	private float currentSensorVoltage;
	private float currentValveStatus;
	
	private PressureSensor pressureSensor;
	private PressureValve pressureValve;
	private Alarm alarm;
	private Notification notification;
	private Log log;
	
	private enum PressureState {
		INITIAL, CRITICALLY_LOW, LOW, OPTIMAL, HIGH, CRITICALLY_HIGH, DANGEROUSLY_HIGH
	}
	private PressureState pressureState;
	
	/**
	 * Constructor of a class for handling the connections between components
	 */
	public System() {
		pressureSensor = new PressureSensor();
		pressureValve = new PressureValve();
		alarm = new Alarm();
		notification = new Notification(); 
		log = new Log();
		
		pressureState = PressureState.INITIAL;
	}
	
	/**
     * A single update iteration in the system
     */
	public void updateIteration() {
		currentPressure = pressureSensor.readPressure();
		currentSensorVoltage = pressureSensor.readVoltage();
		currentValveStatus = pressureValve.readStatus();
	}
	
	/**
	 * Sends the required notifications/signals/logs for a specified pressure
	 * @param pressure to evaluate
	 */
	public void evaluatePressure(float pressure) {
		// evaluation
		PressureState nextPressureState;
		if(pressure < 50.0f) {
			alarm.playSignal();
			notification.notify("operations-manager@kawum.de", "critically low N2 pressure");
			nextPressureState = PressureState.CRITICALLY_LOW;
		}else if(pressure <= 180) {
			notification.notify("operations-manager@kawum.de", "low N2 pressure, refill needed");
			notification.notify("maintenance-team@kawum.de", "low N2 pressure, refill needed");
			nextPressureState = PressureState.LOW;
		}else if(pressure < 220) {
			nextPressureState = PressureState.OPTIMAL;
		}else if(pressure <= 300) {
			notification.notify("operations-manager@kawum.de", "critically high N2 pressure");
			notification.notify("maintenance-team@kawum.de", "critically high N2 pressure");
			nextPressureState = PressureState.HIGH;
		}else {
			alarm.playSignal();
			notification.notify("operations-manager@kawum.de", "dangerously high N2 pressure");
			notification.notify("maintenance-team@kawum.de", "dangerously high N2 pressure");
			nextPressureState = PressureState.CRITICALLY_HIGH;
			
			if(pressure > 500) {
				alarm.playAlarm();
				nextPressureState = PressureState.DANGEROUSLY_HIGH;
			}
		}
		
		// logging
		if(pressureState != nextPressureState) {
			pressureState = nextPressureState;

			if(pressureState == PressureState.CRITICALLY_LOW) {
				log.writeLog("critically low pressure of " + String.format(Locale.US, "%.1f", pressure));
			}else if(pressureState == PressureState.LOW) {
				log.writeLog("low pressure of " + String.format(Locale.US, "%.1f", pressure));
			}else if(pressureState == PressureState.OPTIMAL) {
				log.writeLog("optimal pressure of " + String.format(Locale.US, "%.1f", pressure));
			}else if(pressureState == PressureState.HIGH) {
				log.writeLog("high pressure of " + String.format(Locale.US, "%.1f", pressure));
			}else if(pressureState == PressureState.CRITICALLY_HIGH) {
				log.writeLog("critically high pressure of " + String.format(Locale.US, "%.1f", pressure));
			}else if(pressureState == PressureState.DANGEROUSLY_HIGH) {
				log.writeLog("dangerously high pressure of " + String.format(Locale.US, "%.1f", pressure));
			}
		}
	}
	
	/**
	 * Getter for currentPressure
	 * @return current pressure
	 */
	public float getCurrentPressure() {
		return currentPressure;
	}

	/**
	 * Getter for currentSensorVoltage
	 * @return current Sensor Voltage
	 */
	public float getCurrentSensorVoltage() {
		return currentSensorVoltage;
	}
	
	/**
	 * Getter for currentValveStatus
	 * @return current Valve Status
	 */
	public float getCurrentValveStatus() {
		return currentValveStatus;
	}
	
	/**
	 * Getter for alarm
	 * @return the underlying alarm component
	 */
	public Alarm getAlarm() {
		return alarm;
	}
	
	/**
	 * Getter for notification
	 * @return the underlying notification component
	 */
	public Notification getNotification() {
		return notification;
	}
	
	/**
	 * Getter for log
	 * @return the underlying log component
	 */
	public Log getLog() {
		return log;
	}

	/**
	 * Getter for pressureValve
	 * @return the underlying pressure valve component
	 */
	public PressureValve getPressureValve() {
		return pressureValve;
	}

	/**
	 * Getter for pressureSensor
	 * @return the underlying pressure sensor component
	 */
	public PressureSensor getPressureSensor() {
		return pressureSensor;
	}
}
