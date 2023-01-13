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
	
	public System() {
		pressureSensor = new PressureSensor();
		pressureValve = new PressureValve();
		alarm = new Alarm();
		notification = new Notification(); 
		log = new Log();
		
		pressureState = PressureState.INITIAL;
	}
	
	public void updateIteration() {
		currentPressure = pressureSensor.readPressure();
		currentSensorVoltage = pressureSensor.readVoltage();
		currentValveStatus = pressureValve.readStatus();
	}
	
	public void evaluatePressure(float pressure) {
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
		
		if(pressureState != nextPressureState) {
			pressureState = nextPressureState;

			if(pressureState == PressureState.CRITICALLY_LOW) {
				log.writeLog("critically low pressure of " + pressure);
			}else if(pressureState == PressureState.LOW) {
				log.writeLog("low pressure of " + pressure);
			}else if(pressureState == PressureState.OPTIMAL) {
				log.writeLog("optimal pressure of " + pressure);
			}else if(pressureState == PressureState.HIGH) {
				log.writeLog("high pressure of " + pressure);
			}else if(pressureState == PressureState.CRITICALLY_HIGH) {
				log.writeLog("critically high pressure of " + pressure);
			}else if(pressureState == PressureState.DANGEROUSLY_HIGH) {
				log.writeLog("dangerously high pressure of " + pressure);
			}
		}
	}
	
	public float getCurrentPressure() {
		return currentPressure;
	}

	public float getCurrentSensorVoltage() {
		return currentSensorVoltage;
	}
	
	public float getCurrentValveStatus() {
		return currentValveStatus;
	}
	
	public Alarm getAlarm() {
		return alarm;
	}
	
	public Notification getNotification() {
		return notification;
	}
	
	public Log getLog() {
		return log;
	}

	public PressureValve getPressureValve() {
		return pressureValve;
	}

	public PressureSensor getPressureSensor() {
		return pressureSensor;
	}
}
