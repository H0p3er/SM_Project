package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Lấy ngày
public class Utilities_date {
	public static String getCurrentDate(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		
		Date date = new Date();
		
		return dateFormat.format(date);
 	}
	
	public static String getCurrentDate() {
		return Utilities_date.getCurrentDate("dd/MM/yyyy");
 	}
	
	public static String getCurrentDateTime() {
		return Utilities_date.getCurrentDate("HH:mm:ss dd/MM/yyyy");
 	}
	
	public static String getDateProfiles() {
		return Utilities_date.getCurrentDate("ddMMyyHHmmss");
 	}
	
	public static String getDate(String format, double numericDate) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		
		Date date = new Date((long) (numericDate * 1000));

		return dateFormat.format(date);
 	}
	
	public static String getDate(double numericDate) {
		return Utilities_date.getDate("dd/MM/yyyy", numericDate);
 	}
	
	public static Date getDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	

}
