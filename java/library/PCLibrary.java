package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Pair;
import org.javatuples.Quintet;

import dto.pc.PC_viewProductDTO;
import utility.Utilities;


public class PCLibrary {
	
	public static Map<String,String> viewSearchPC(
			TreeMap<PC_viewProductDTO,Integer> data, 
			Quintet<Short, Byte, Map<String, String>, Map<String, String>, Map<String, String>> infors,
			String requestURI) {
		StringBuilder tmp = new StringBuilder();
		Map<String,String> view = new HashMap<String, String>();
		String parameter = (utility.Utilities.toParam(infors.getValue3()));
		parameter = (parameter.isBlank() || parameter==null)? (parameter+"?pc="):(parameter+"&pc=");
		String URI = (requestURI+parameter);
		data.forEach((key,value)->{			
			tmp.append("<li><a class=\"text-black\" href=\""+URI+key.getId()+"\">"+key.getName()+"("+value+")</a></li>");
		});
		view.put("category", tmp.toString());
		return view;
	}
	
	public static String viewPCDetail(PC_viewProductDTO pc_viewProductDTO) {
		StringBuilder builder = new StringBuilder();
		builder.append("ID="+pc_viewProductDTO.getId());
		
		return builder.toString();
	}

}
