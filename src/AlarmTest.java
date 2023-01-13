import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class AlarmTest {
	
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void playAlarmTest(){
		Alarm alarm = new Alarm();
		alarm.playAlarm();
		assertTrue(alarm.isPlayingAlarm());
	}
	
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void playSignalTest(){
		Alarm alarm = new Alarm();
		alarm.playSignal();
		assertTrue(alarm.isPlayingSignal());
	}
	
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void playNoAlarmTest(){
		Alarm alarm = new Alarm();
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void playNoSignalTest(){
		Alarm alarm = new Alarm();
		assertFalse(alarm.isPlayingSignal());
	}
	
	@Test
	void stopAlarmTest(){
		Alarm alarm = new Alarm();
		alarm.playAlarm();
		alarm.stopAlarm();
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	void stopSignalTest(){
		Alarm alarm = new Alarm();
		alarm.playSignal();
		alarm.stopSignal();
		assertFalse(alarm.isPlayingSignal());
	}
}
