import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class AlarmTest {
	
	/**
	 * Tests whether the alarm can start in 10ms
	 */
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void playAlarmTest(){
		Alarm alarm = new Alarm();
		alarm.playAlarm();
		assertTrue(alarm.isPlayingAlarm());
	}
	
	/**
	 * Tests whether the signal can start in 10ms
	 */
	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void playSignalTest(){
		Alarm alarm = new Alarm();
		alarm.playSignal();
		assertTrue(alarm.isPlayingSignal());
	}
	
	/**
	 * Tests whether the alarm is turned off by default
	 */
	@Test
	void playNoAlarmTest(){
		Alarm alarm = new Alarm();
		assertFalse(alarm.isPlayingAlarm());
	}
	
	/**
	 * Tests whether the signal is turned off by default
	 */
	@Test
	void playNoSignalTest(){
		Alarm alarm = new Alarm();
		assertFalse(alarm.isPlayingSignal());
	}
	
	/**
	 * Tests whether the alarm can be turned off
	 */
	@Test
	void stopAlarmTest(){
		Alarm alarm = new Alarm();
		alarm.playAlarm();
		alarm.stopAlarm();
		assertFalse(alarm.isPlayingAlarm());
	}
	
	/**
	 * Tests whether the signal can be turned off
	 */
	@Test
	void stopSignalTest(){
		Alarm alarm = new Alarm();
		alarm.playSignal();
		alarm.stopSignal();
		assertFalse(alarm.isPlayingSignal());
	}
}
