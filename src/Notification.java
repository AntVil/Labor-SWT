import java.util.LinkedList;

public class Notification {
	private LinkedList<String> history;
	
	public Notification() {
		history = new LinkedList<String>();
	}
	
	public String notify(String email, String message) {
		history.add(email + message);
		
		return "message send successfully";
	}
	
	public boolean historyIncludes(String email, String message) {
		return history.contains(email + message);
	}
}
