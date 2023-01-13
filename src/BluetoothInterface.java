public class BluetoothInterface {
    private float displayedPressure;
    private float displayedSensorVoltage;
    private float displayedValveStatus;
    private System system = new System();
    
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
}
