import java.util.LinkedList;

public class Log{
	private LinkedList<String> history;
	
	/**
     * Constructor of a class for handling the REST-API
     */
    public Log(){
    	history = new LinkedList<String>();
    }

    /**
     * Writes a log to the REST-API
     * @param log to write API
     * @return response by API
     */
    public String writeLog(String log){
    	history.add(log);
    	
        // Send to REST-API
        // if OK => Return Written
    	return "log send successfully";
    }
	
    /**
     * Checks if log is included in history
     * @param log to test for
     * @return log was found
     */
	public boolean historyIncludes(String log) {
		return history.contains(log);
	}
}
