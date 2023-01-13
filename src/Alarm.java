public class Alarm {
	private boolean playingAlarm;
	private boolean playingSignal;
	
	public Alarm() {
		playingAlarm = false;
		playingSignal = false;
	}
	
	public void playAlarm() {
		playingAlarm = true;
	}
	
	public void playSignal() {
		playingSignal = true;
	}
	
	public void stopAlarm() {
		playingAlarm = false;
	}
	
	public void stopSignal() {
		playingSignal = false;
	}
	
	public boolean isPlayingAlarm() {
		return playingAlarm;
	}
	
	public boolean isPlayingSignal() {
		return playingSignal;
	}
}
