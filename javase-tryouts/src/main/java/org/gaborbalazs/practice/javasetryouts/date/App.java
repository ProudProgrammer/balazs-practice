package org.gaborbalazs.practice.javasetryouts.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class App {

	public static void main(String[] args) throws ParseException {

		System.out.println("Hello Date");
		
		String text = "11-16-2016";
		String pattern = "MM-dd-yyyy";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDate localDate = LocalDate.parse(text, formatter);
		System.out.println("LocalDate [text: " + text + ", pattern: " + pattern + "]: " + localDate);
		
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("LocalDate without time from pattern [" + text + "]: " + date.toString());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern(pattern);
		dateFormat.setLenient(false);
		System.out.println("Date from pattern [" + text + "]: " + dateFormat.parse(text).getTime());
		
		System.out.println("Current date and time: " + new Date().getTime());
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		System.out.println("Current date without time: " + calendar.getTimeInMillis());
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

		String time = "2017-04-10T13:31:00";
		String timeZone = "Europe/Prague";

		LocalDateTime dateTime = LocalDateTime.parse(time, formatter2);
		ZoneId z = ZoneId.of(timeZone);

		System.out.println("datetime:\t " + dateTime + ", zoneid: " + z);
		System.out.println("millis:\t\t " + ZonedDateTime.of(dateTime, z).toInstant().toEpochMilli());
		System.out.println("now:\t\t " + Instant.now());
		System.out.println("millis:\t\t " + Instant.now().toEpochMilli());
		System.out.println("datetime:\t" + ZonedDateTime.of(LocalDateTime.parse("2017-04-01T12:00:00", formatter2), ZoneId.of("America/New_York")));
		
		//Date to LocalDate
		Date nowDate = new Date();
		LocalDate nowLocalDate = nowDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("nowDate: " + nowDate + ", nowLocalDate: " + nowLocalDate);
		
		System.out.println("Goodbye Date");
	}

}
