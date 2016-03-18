package br.com.sgc.tool;

import java.util.Calendar;
import java.util.Date;

public class GetDateRegister {
	
	private static Calendar calendar;
	
	public static Date getDateRegister(){
		GetDateRegister.calendar = Calendar.getInstance();
		return calendar.getTime();
	}
}