package hu.gaborbalazs.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
		
		System.out.println("Goodbye Date");
	}

}
