public class PressureValve{
    private boolean isOpened = false;
    private float openStatus = 0.0f;
    
    public PressureValve(){

    }

    public void open(){
        isOpened = true;
        openStatus = 1.0f;
    }

    public void close(){
        isOpened = false;
        openStatus = 0.0f;
    }

    public float readStatus(){
        return openStatus;
    }

    public boolean isOpen(){
        return isOpened;
    }
}
