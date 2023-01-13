import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;

public class SystemTest {
	
	@Test
	@DisplayName("pressure pre 50")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest1(){
		System system = new System();
		system.evaluatePressure(49.9f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for no email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure at 50")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest2(){
		System system = new System();
		system.evaluatePressure(50.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure at 180")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest3(){
		System system = new System();
		system.evaluatePressure(180.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure post 180")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest4(){
		System system = new System();
		system.evaluatePressure(180.1f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for no email to operations manager
		// check for no email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure pre 220")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest5(){
		System system = new System();
		system.evaluatePressure(219.9f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for no email to operations manager
		// check for no email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure at 220")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest6(){
		System system = new System();
		system.evaluatePressure(220.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure at 300")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest7(){
		System system = new System();
		system.evaluatePressure(300.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure post 300")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest8(){
		System system = new System();
		system.evaluatePressure(300.1f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure at 500")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest9(){
		System system = new System();
		system.evaluatePressure(500.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for email to maintenance team
		
		// check for log
	}
	
	@Test
	@DisplayName("pressure post 500")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest10(){
		System system = new System();
		system.evaluatePressure(500.1f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertTrue(alarm.isPlayingAlarm());
		
		// check for email to operations manager
		// check for email to maintenance team
		
		// check for log
	}
}
