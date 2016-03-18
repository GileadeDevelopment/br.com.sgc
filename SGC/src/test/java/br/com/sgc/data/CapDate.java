package br.com.sgc.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CapDate {
		
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String teste = dateFormat.format(date);
		System.out.println(teste);
		System.out.println(dateFormat.format(date));
	}
}
