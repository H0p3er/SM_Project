package utility;

import java.text.DecimalFormat;
import java.util.Locale;

public class Utilities_currency {
	public static String toVND(double price) {
		DecimalFormat df = new DecimalFormat("#,### VND");
		return df.format(price);
	}
}
