package utility;

import javax.servlet.ServletRequest;

//Thư viện xử lí 
public class Utilities_text {
	private static final String VALID_NUMBER = "[0-9]";
	private static final String VALID_CHARACTER = "[a-zA-Z]";
	public static boolean checkValidPass (String pass1, String pass2) {
		if (pass1!= null && pass2!=null) {
			if(!pass1.equalsIgnoreCase("") && !pass2.equalsIgnoreCase("")) {
				if (pass1.length()>6 && pass1.equals(pass2)) {
					return true;
				} 
			}
		}
		
		return false;
	}
	
	
	public static boolean checkValidString(ServletRequest request, String param) {
		String str_value = request.getParameter(param);
		if (str_value!=null && !str_value.isBlank()) {
			return true;
		}
		return false;
	}
	
	public static boolean checkValidStringNumber(ServletRequest request, String param) {
		String str_value = request.getParameter(param);
		if (str_value!=null && !str_value.isBlank()) {
			if (str_value.matches(VALID_NUMBER)) {
				return true;
			}	
		}
		return false;
	}
}
