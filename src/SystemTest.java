import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;

public class SystemTest {
	
	@Test
	@DisplayName("pressure pre 50 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPre50Alarm(){
		System system = new System();
		system.evaluatePressure(49.9f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure pre 50 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPre50Notification(){
		System system = new System();
		system.evaluatePressure(49.9f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "critically low N2 pressure"));
		assertFalse(notification.historyIncludes("maintenance-team@kawum.de", "critically low N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure pre 50 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPre50Log(){
		System system = new System();
		system.evaluatePressure(49.9f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("critically low pressure of 49.9"));
	}
	
	@Test
	@DisplayName("pressure at 50 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt50Alarm(){
		System system = new System();
		system.evaluatePressure(50.0f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 50 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt50Notification(){
		System system = new System();
		system.evaluatePressure(50.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "low N2 pressure, refill needed"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "low N2 pressure, refill needed"));
	}
	
	@Test
	@DisplayName("pressure at 50 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt50Log(){
		System system = new System();
		system.evaluatePressure(50.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("low pressure of 50.0"));
	}
	
	@Test
	@DisplayName("pressure at 180 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt180Alarm(){
		System system = new System();
		system.evaluatePressure(180.0f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 180")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt180Notification(){
		System system = new System();
		system.evaluatePressure(180.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "low N2 pressure, refill needed"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "low N2 pressure, refill needed"));
	}
	
	@Test
	@DisplayName("pressure at 180 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt180Log(){
		System system = new System();
		system.evaluatePressure(180.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("low pressure of 180.0"));
	}
	
	@Test
	@DisplayName("pressure post 180 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost180Alarm(){
		System system = new System();
		system.evaluatePressure(180.1f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure post 180 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost180Notification(){
		System system = new System();
		system.evaluatePressure(180.1f);
		
		Notification notification = system.getNotification();

		assertFalse(notification.historyIncludes("operations-manager@kawum.de", "optimal N2 pressure"));
		assertFalse(notification.historyIncludes("maintenance-team@kawum.de", "optimal N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure post 180 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost180Log(){
		System system = new System();
		system.evaluatePressure(180.1f);
		
		Log log = system.getLog();

		assertTrue(log.historyIncludes("optimal pressure of 180.1"));
	}
	
	@Test
	@DisplayName("pressure pre 220 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPre200Alarm(){
		System system = new System();
		system.evaluatePressure(219.9f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure pre 220 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPre200Notification(){
		System system = new System();
		system.evaluatePressure(219.9f);
		
		Notification notification = system.getNotification();
		
		assertFalse(notification.historyIncludes("operations-manager@kawum.de", "optimal N2 pressure"));
		assertFalse(notification.historyIncludes("maintenance-team@kawum.de", "optimal N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure pre 220 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPre200Log(){
		System system = new System();
		system.evaluatePressure(219.9f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("optimal pressure of 219.9"));
	}
	
	@Test
	@DisplayName("pressure at 220 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt220Alarm(){
		System system = new System();
		system.evaluatePressure(220.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 220 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt220Notification(){
		System system = new System();
		system.evaluatePressure(220.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "critically high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "critically high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure at 220 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt220Log(){
		System system = new System();
		system.evaluatePressure(220.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("high pressure of 220.0"));
	}
	
	@Test
	@DisplayName("pressure at 300 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt300Alarm(){
		System system = new System();
		system.evaluatePressure(300.0f);
		
		Alarm alarm = system.getAlarm();

		assertFalse(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 300 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt300Notification(){
		System system = new System();
		system.evaluatePressure(300.0f);
		
		Notification notification = system.getNotification();

		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "critically high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "critically high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure at 300 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt300Log(){
		System system = new System();
		system.evaluatePressure(300.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("high pressure of 300.0"));
	}
	
	@Test
	@DisplayName("pressure post 300 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost300Alarm(){
		System system = new System();
		system.evaluatePressure(300.1f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure post 300 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost300Notification(){
		System system = new System();
		system.evaluatePressure(300.1f);
		
		Notification notification = system.getNotification();

		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "dangerously high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "dangerously high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure post 300 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost300Log(){
		System system = new System();
		system.evaluatePressure(300.1f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("critically high pressure of 300.1"));
	}
	
	@Test
	@DisplayName("pressure at 500 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt500Alarm(){
		System system = new System();
		system.evaluatePressure(500.0f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertFalse(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure at 500 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt500Notification(){
		System system = new System();
		system.evaluatePressure(500.0f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "dangerously high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "dangerously high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure at 500 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestAt500Log(){
		System system = new System();
		system.evaluatePressure(500.0f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("critically high pressure of 500.0"));
	}
	
	@Test
	@DisplayName("pressure post 500 (alarm)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost500Alarm(){
		System system = new System();
		system.evaluatePressure(500.1f);
		
		Alarm alarm = system.getAlarm();
		
		assertTrue(alarm.isPlayingSignal());
		assertTrue(alarm.isPlayingAlarm());
	}
	
	@Test
	@DisplayName("pressure post 500 (notification)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost500Notification(){
		System system = new System();
		system.evaluatePressure(500.1f);
		
		Notification notification = system.getNotification();
		
		assertTrue(notification.historyIncludes("operations-manager@kawum.de", "dangerously high N2 pressure"));
		assertTrue(notification.historyIncludes("maintenance-team@kawum.de", "dangerously high N2 pressure"));
	}
	
	@Test
	@DisplayName("pressure post 500 (log)")
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void evaluatePressureTestPost500Log(){
		System system = new System();
		system.evaluatePressure(500.1f);
		
		Log log = system.getLog();
		
		assertTrue(log.historyIncludes("dangerously high pressure of 500.1"));
	}
}
