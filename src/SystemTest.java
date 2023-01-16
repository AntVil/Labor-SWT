import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;

public class SystemTest {
	
	@Test
	@DisplayName("pressure pre 50 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest1(){
		System system = new System();
		system.evaluatePressure(49.9f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure pre 50 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest2(){
		System system = new System();
		system.evaluatePressure(49.9f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "critically low N2 pressure"));
		assertFalse(notification.historyIncludes("maintenance-team@kawum.de", "critically low N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure pre 50 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest3(){
		System system = new System();
		system.evaluatePressure(49.9f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("critically low pressure of 49.9"));
	}
	
	@Test
	@DisplayName("pressure at 50 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest4(){
		System system = new System();
		system.evaluatePressure(50.0f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 50 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest5(){
		System system = new System();
		system.evaluatePressure(50.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "low N2 pressure, refill needed"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "low N2 pressure, refill needed"));
	}
	
	@Test
	@DisplayName("pressure at 50 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest6(){
		System system = new System();
		system.evaluatePressure(50.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("low pressure of 50.0"));
	}
	
	@Test
	@DisplayName("pressure at 180 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest7(){
		System system = new System();
		system.evaluatePressure(180.0f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 180")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest8(){
		System system = new System();
		system.evaluatePressure(180.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "low N2 pressure, refill needed"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "low N2 pressure, refill needed"));
	}
	
	@Test
	@DisplayName("pressure at 180 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest9(){
		System system = new System();
		system.evaluatePressure(180.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("low pressure of 180.0"));
	}
	
	@Test
	@DisplayName("pressure post 180 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest10(){
		System system = new System();
		system.evaluatePressure(180.1f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure post 180 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest11(){
		System system = new System();
		system.evaluatePressure(180.1f);
		
		Notification notification = system.getNotification();

		assertFalse(notification.historyIncludes("operations-manager@kawum.de", "optimal N2 pressure"));
		assertFalse(notification.historyIncludes("maintenance-team@kawum.de", "optimal N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure post 180 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest12(){
		System system = new System();
		system.evaluatePressure(180.1f);
		
		Log log = system.getLog();

		assertTrue(log.historyIncludes("optimal pressure of 180.1"));
	}
	
	@Test
	@DisplayName("pressure pre 220 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest13(){
		System system = new System();
		system.evaluatePressure(219.9f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure pre 220 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest14(){
		System system = new System();
		system.evaluatePressure(219.9f);
		
		Notification notification = system.getNotification();
		
		assertFalse(notification.historyIncludes("operations-manager@kawum.de", "optimal N2 pressure"));
		assertFalse(notification.historyIncludes("maintenance-team@kawum.de", "optimal N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure pre 220 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest15(){
		System system = new System();
		system.evaluatePressure(219.9f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("optimal pressure of 219.9"));
	}
	
	@Test
	@DisplayName("pressure at 220 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest16(){
		System system = new System();
		system.evaluatePressure(220.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 220 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest17(){
		System system = new System();
		system.evaluatePressure(220.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "critically high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "critically high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure at 220 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest18(){
		System system = new System();
		system.evaluatePressure(220.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("high pressure of 220.0"));
	}
	
	@Test
	@DisplayName("pressure at 300 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest19(){
		System system = new System();
		system.evaluatePressure(300.0f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 300 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest20(){
		System system = new System();
		system.evaluatePressure(300.0f);
		
		Notification notification = system.getNotification();

		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "critically high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "critically high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure at 300 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest21(){
		System system = new System();
		system.evaluatePressure(300.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("high pressure of 300.0"));
	}
	
	@Test
	@DisplayName("pressure post 300 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest22(){
		System system = new System();
		system.evaluatePressure(300.1f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure post 300 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest23(){
		System system = new System();
		system.evaluatePressure(300.1f);
		
		Notification notification = system.getNotification();

		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "dangerously high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "dangerously high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure post 300 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest24(){
		System system = new System();
		system.evaluatePressure(300.1f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("critically high pressure of 300.1"));
	}
	
	@Test
	@DisplayName("pressure at 500 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest25(){
		System system = new System();
		system.evaluatePressure(500.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 500 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest26(){
		System system = new System();
		system.evaluatePressure(500.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "dangerously high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "dangerously high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure at 500 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest27(){
		System system = new System();
		system.evaluatePressure(500.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("critically high pressure of 500.0"));
	}
	
	@Test
	@DisplayName("pressure post 500 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest28(){
		System system = new System();
		system.evaluatePressure(500.1f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertTrue(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure post 500 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest29(){
		System system = new System();
		system.evaluatePressure(500.1f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "dangerously high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "dangerously high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure post 500 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTest30(){
		System system = new System();
		system.evaluatePressure(500.1f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("dangerously high pressure of 500.1"));
	}
}
