package utility;

public class Utilities_currency {
	public static String toVND(double price) {
		StringBuilder builder = new StringBuilder();
		if (price<999999) {
			builder.append(toThounsandVND(price));
			builder.append(" Nghìn Đồng");
			return builder.toString();
		}
		
		if (price<999999999) {
			builder.append(toMillionVND(price));
			builder.append(" Triệu Đồng");
			return builder.toString();
		}
		
		if (price>=1000000000) {
			builder.append(toBillionVND(price));
			builder.append(" Tỉ Đồng");
			return builder.toString();
		}
		
		builder.append(" Đồng");
		return builder.toString();
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
