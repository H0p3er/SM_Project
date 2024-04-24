package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import entity.ProductObject;

public class ProductLibrary {
	public static Map<String,String> viewHomeProduct(Pair<ArrayList<ProductObject>, Integer> datas,
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<ProductObject> productObjects = datas.getValue0();
		
		productObjects.forEach(product->{
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"property-details.html\"><img src=\""+product.getProduct_images()+"\" alt=\"\"></a>");
			tmp.append("<span class=\"category\">"+product.getProduct_pc_id()+"</span>");
			tmp.append("<h6>"+product.getProduct_price()+"</h6>");
			tmp.append("<h4><a href=\"property-details.html\">"+product.getProduct_name()+"</a></h4>");
			tmp.append("<ul>");
			switch (product.getProduct_pc_id()) {
				case 1:
					item = getProduct_CaseDTO(rs);
					tmp.append("<li>CPU:<span>8</span></li>");
					tmp.append("<li>RAM:<span>8</span></li>");
					tmp.append("<li>Mainboard:<span>545m2</span></li>");
					tmp.append("<li>Disk:<span>3</span></li>");
					break;		
				case 2:
					item = getProduct_CoolingDTO(rs);
					tmp.append("<li>CPU:<span>8</span></li>");
					tmp.append("<li>RAM:<span>8</span></li>");
					tmp.append("<li>Mainboard:<span>545m2</span></li>");
					tmp.append("<li>Disk:<span>3</span></li>");
					break;					
				case 3:
					item = getProduct_CPUDTO(rs);	
					tmp.append("<li>CPU:<span>8</span></li>");
					tmp.append("<li>RAM:<span>8</span></li>");
					tmp.append("<li>Mainboard:<span>545m2</span></li>");
					tmp.append("<li>Disk:<span>3</span></li>");
					break;					
				case 4:
					item = getProduct_DesktopDTO(rs);
					tmp.append("<li>CPU:<span>8</span></li>");
					tmp.append("<li>RAM:<span>8</span></li>");
					tmp.append("<li>Mainboard:<span>545m2</span></li>");
					tmp.append("<li>Disk:<span>3</span></li>");
					break;						
				case 5:						
					item = getProduct_GraphicsCardDTO(rs);		
					break;						
				case 6:					
					item = getProduct_HeadphoneSpeakerDTO(rs);		
					break;						
				case 7:
					item = getProduct_KeyboardDTO(rs);		
					break;						
				case 8:
					item = getProduct_LaptopDTO(rs);		
					break;						
				case 9:					
					item = getProduct_MiceDTO(rs);		
					break;		
				case 10:
					item = getProduct_MonitorDTO(rs);		
					break;				
				case 11:						
					item = getProduct_MotherboardDTO(rs);		
					break;						
				case 12:
					item = getProduct_PowerSuppyDTO(rs);		
					break;						
				case 13:
					item = getProduct_RamDTO(rs);		
					break;				
				case 14:
					item = getProduct_StorageDTO(rs);		
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
	
	public static Map<String,String> viewProductList(Pair<ArrayList<ProductObject>, Integer> datas,
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<ProductObject> productObjects = datas.getValue0();
		

		view.put("view_product_list",tmp.toString());
		
		
		return view;
	}
	
	
	public static Map<String,String> viewProductDetail(Pair<ArrayList<ProductObject>, Integer> datas,
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<ProductObject> productObjects = datas.getValue0();	

		view.put("view_product_list",tmp.toString());	
		
		return view;
	}
}