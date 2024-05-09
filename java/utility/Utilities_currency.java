package utility;

import java.text.DecimalFormat;
import java.util.Locale;

public class Utilities_currency {
	public static String toVND(double price) {
		DecimalFormat df = new DecimalFormat("#,### VND");
		return df.format(price);
	}
	
	public static double toBillionVND(double price) {	
		return price/1000000000;
	}
	
	public static double toMillionVND(double price) {	
		return price/1000000;
	}
	
	public static double toThounsandVND(double price) {	
		return price/1000;
	}
	
}
