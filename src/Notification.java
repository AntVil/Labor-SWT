import java.util.LinkedList;

public class Notification {
	private LinkedList<String> history;
	
	/**
     * Constructor of a class for handling the notification e-mails
     */
	public Notification() {
		history = new LinkedList<String>();
	}
	
	/**
	 * writes an e-mail and sends it
	 * @param email to send to
	 * @param message to send
	 * @return response by API
	 */
	public String notify(String email, String message) {
		history.add(email + message);
		
		return "message send successfully";
	}
	
	/**
     * Checks if e-mail is included in history
     * @param email to test for
     * @param message to test for
     * @return e-mail was found
     */
	public boolean historyIncludes(String email, String message) {
		return history.contains(email + message);
	}
}
