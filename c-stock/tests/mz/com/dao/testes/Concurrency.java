package mz.com.dao.testes;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

import mz.com.cstock.dao.ProductDAO;

import org.junit.Test;

public class Concurrency {

	// @Test
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

	@Test
	public void compareDates() {
		
		ProductDAO dao = new ProductDAO();
		int hje = dao.findAll().get(8).getDateRegistered().get(Calendar.MONTH);
		if (Calendar.JANUARY == hje)
			System.out.println("Sao meses iguais: " + hje);
		else
			System.out.println("Sao meses diferentes");
	}

}
