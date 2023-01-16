import java.util.LinkedList;

public class Log{
	private LinkedList<String> history;
	
    public Log(){
    	history = new LinkedList<String>();
    }

    public String writeLog(String log){
    	history.add(log);
    	
        // Send to REST-API
        // if OK => Return Written
    	return "log send successfully";
    }
	
	public boolean historyIncludes(String log) {
		return history.contains(log);
	}
}
