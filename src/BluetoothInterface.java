public class BluetoothInterface {
    private float displayedPressure;
    private float displayedSensorVoltage;
    private float displayedValveStatus;
    private System system;
    
    public BluetoothInterface() {
    	system = new System();
    }
    
    public void updateIteration() {
    	system.updateIteration();
    	
    	displayedPressure = system.getCurrentPressure();
    	displayedSensorVoltage = system.getCurrentSensorVoltage();
    	displayedValveStatus = system.getCurrentValveStatus();
    }
    
    public void setDisplayedPressure() {
    	displayedPressure = system.getCurrentPressure();
    }
    
    public void setDisplayedSensorVoltage() {
    	displayedPressure = system.getCurrentSensorVoltage();
    }
    
    public void setDisplayedValveStatus() {
    	displayedPressure = system.getCurrentValveStatus();
    }

    public float getDisplayedPressure(){
        return displayedPressure;
    }

    public float getDisplayedSensorVoltage(){
        return displayedSensorVoltage;
    }

    public float getDisplayedValveStatus(){
        return displayedValveStatus;
    }
    
    public System getSystem() {
    	return system;
    }
}
