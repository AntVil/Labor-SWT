public class BluetoothInterface {
    private float displayedPressure;
    private float displayedSensorVoltage;
    private float displayedValveStatus;

    public float getCurrentPressure(){
        return 1.0f;
    }

    public float getCurrentSensorVoltage(){
        return 1.0f;
    }

    public float getCurrentValveStatus(){
        return 1.0f;
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
