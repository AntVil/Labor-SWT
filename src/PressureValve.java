public class PressureValve{
    private float openStatus;

    /**
     * Constructor of a class for handling the pressure valve
     */
    public PressureValve() {
    	openStatus = 0.0f;
    }
    
    /**
     * opens the pressure valve
     */
    public void open(){
        openStatus = 1.0f;
    }

    /**
     * closes the pressure valve
     */
    public void close(){
        openStatus = 0.0f;
    }

    /**
     * reads the open status of the pressure valve
     */
    public float readStatus(){
        return openStatus;
    }

    /**
     * checks if the pressure valve is completely closed 
     * @return completely closed
     */
    public boolean isOpen(){
        return openStatus != 0.0f;
    }
}
