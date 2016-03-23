package br.com.sgc.tool;

import java.util.Calendar;
import java.util.Date;

public class GetDateRegister {
	
	private static Calendar calendar;

	public static Date getDateRegister() {
		GetDateRegister.calendar = Calendar.getInstance();
		return calendar.getTime();
	}
}
/*
 * Author: Gileade de Jesus
 * Status: Completed And Revised (23/03/2016)
 */