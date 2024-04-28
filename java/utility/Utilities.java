package utility;

import java.util.*;
import javax.servlet.*;
import net.htmlparser.jericho.*;

public class Utilities {
	
	// Lấy dữ liệu kiểu Byte từ Para
	public static byte getByteParam(ServletRequest request, String name) {
		byte value = -1;
		
		String str_value = request.getParameter(name);
		
		if (str_value!=null && !str_value.equalsIgnoreCase("")) {
			value = Byte.parseByte(str_value);
		}
		return value;
	}
	
	public static short getShortParam(ServletRequest request, String name) {
		short value = -1;
		
		String str_value = request.getParameter(name);
		
		if (str_value!=null && !str_value.equalsIgnoreCase("")) {
			value = Short.parseShort(str_value);
		}
		return value;
	}
	
	public static int getIntParam(ServletRequest request, String name) {
		int value = -1;
		
		String str_value = request.getParameter(name);
		
		if (str_value!=null && !str_value.equalsIgnoreCase("")) {
			value = Integer.parseInt(str_value);
		}
		return value;
	}
	
	public static Map<String, String> getMapParam(ServletRequest request, String name) {	
		String str_value = request.getParameter(name);
	
		String safe_value = 
				(str_value!=null && !str_value.isBlank()
				&& str_value.contains(":") && str_value.contains(";")) 
				? str_value.trim() : "";
		
		Map<String, String> map = new TreeMap<>();			
		if (safe_value!=null && !safe_value.equalsIgnoreCase("")) {
	        String[] pairs = safe_value.split(";");
	        for (String pair : pairs) {
	            String[] keyValue = pair.split(":");        
	            map.put(keyValue[0], keyValue[1]);
	        }	
		}
		
		System.out.println(map);
		return map;
	}
	
	
	// Lấy dữ liệu kiểu Boolean từ Para
	public static boolean getBooleanParam(ServletRequest request, String name) {
		boolean value = false;
		
		String str_value = request.getParameter(name);
		
		if (str_value!=null && !str_value.equalsIgnoreCase("")) {
			value = Boolean.parseBoolean(str_value);
		}
		return value;
	}
	
	public static String encode(String str_unicode) {
		return CharacterReference.encode(str_unicode);
	}
	
	public static String decode(String str_html) {
		return CharacterReference.decode(str_html);
	}
}
