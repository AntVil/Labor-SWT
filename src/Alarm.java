public class Alarm {
	private boolean playingAlarm;
	private boolean playingSignal;
	
	/**
	 * Constructor of a class for handling acoustic signals
	 */
	public Alarm() {
		playingAlarm = false;
		playingSignal = false;
	}
	
	/**
	 * Starts playing the alarm
	 */
	public void playAlarm() {
		playingAlarm = true;
	}
	
	/**
	 * Starts playing the signal
	 */
	public void playSignal() {
		playingSignal = true;
	}
	
	/**
	 * Stops playing the alarm
	 */
	public void stopAlarm() {
		playingAlarm = false;
	}
	
	/**
	 * Stops playing the signal
	 */
	public void stopSignal() {
		playingSignal = false;
	}
	
	/**
	 * Getter for alarm
	 * @return playingAlarm
	 */
	public boolean isPlayingAlarm() {
		return playingAlarm;
	}
	
	/**
	 * Getter for signal
	 * @return plaingSignal
	 */
	public boolean isPlayingSignal() {
		return playingSignal;
	}
}
