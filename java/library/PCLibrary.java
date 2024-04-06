package library;

import entity.*;

public class PCLibrary {
	public static String viewPCDetail(PCObject pcObject) {
		StringBuilder builder = new StringBuilder();
		builder.append("ID="+pcObject.getPc_id());
		
		return builder.toString();
	}
	
}
