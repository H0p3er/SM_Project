package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import entity.ProductObject;

public class ProductLibrary {
	public static Map<String,String> viewProductList(Pair<ArrayList<ProductObject>, Integer> datas,
			Quintet<Short, Byte, String, String, String> infors) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<ProductObject> productObjects = datas.getValue0();
		
		productObjects.forEach(product->{
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"property-details.html\"><img src=\"/home/assets/images/property-01.jpg\" alt=\"\"></a>");
			tmp.append("<span class=\"category\">"+product.getProduct_pc_id()+"</span>");
			tmp.append("<h6>"+product.getProduct_price()+"</h6>");
			tmp.append("<h4><a href=\"property-details.html\">"+product.getProduct_name()+"</a></h4>");
			tmp.append("<ul>");
			switch (product.getProduct_pc_id()) {
				case 1:
					tmp.append("<li>CPU:<span>8</span></li>");
					tmp.append("<li>RAM:<span>8</span></li>");
					tmp.append("<li>Mainboard:<span>545m2</span></li>");
					tmp.append("<li>Disk:<span>3</span></li>");
				break;
				
				case 2:
					tmp.append("<li>Memory: <span>8</span></li>");
					tmp.append("<li>Dimension: <span>8</span></li>");
					tmp.append("<li>Area: <span>545m2</span></li>");
					tmp.append("<li>Cache: <span>6 spots</span></li>");
					break;
					
				case 3:
					break;
			}
			tmp.append("</ul>");
			tmp.append("<div class=\"main-button\">");
			tmp.append("<a href=\"property-details.html\">Xem chi tiết</a>");
			tmp.append("</div>");//main-button
			tmp.append("</div>");//item
			tmp.append("</div>");//col-lg-4 col-md-6
		});	
		view.put("home_product_list",tmp.toString());
		
		
		return view;
	}
}