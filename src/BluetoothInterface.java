public class BluetoothInterface {
    private float displayedPressure;
    private float displayedSensorVoltage;
    private float displayedValveStatus;
    private System system;
    
    /**
     * Constructor of a class for handling the bluetooth interface
     */
    public BluetoothInterface() {
    	system = new System();
    }
    
    /**
     * A single update iteration in the interface/system
     */
    public void updateIteration() {
    	system.updateIteration();
    	
    	displayedPressure = system.getCurrentPressure();
    	displayedSensorVoltage = system.getCurrentSensorVoltage();
    	displayedValveStatus = system.getCurrentValveStatus();
    }

    /**
     * Getter for displayed pressure
     * @return the displayed pressure
     */
    public float getDisplayedPressure(){
        return displayedPressure;
    }

    /**
     * Getter for displayed sensor voltage
     * @return the displayed sensor voltage
     */
    public float getDisplayedSensorVoltage(){
        return displayedSensorVoltage;
    }

    /**
     * Getter for displayed valve open status
     * @return the displayed valve status
     */
    public float getDisplayedValveStatus(){
        return displayedValveStatus;
    }
    
    /**
     * Getter for system
     * @return the underlying system
     */
    public System getSystem() {
    	return system;
    }
}
