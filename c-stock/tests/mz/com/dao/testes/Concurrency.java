package mz.com.dao.testes;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

import org.junit.Test;

public class Concurrency {

	@Test
	public void test() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						System.out.print("12345");
					}
				});
			}
		}, 0, 2000);
	}

}
