package library;

import java.util.*;

import org.javatuples.*;

import dto.product.Product_ShopStatisticDTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_viewShopDTO;

public class ShopLibrary {
	public static ArrayList<String> viewShop_Profile(Shop_viewShopDTO shopDTO){
		ArrayList<String> view = new ArrayList<String>();		
		StringBuilder tmp = new StringBuilder();	
		return view;
	}
	
	public static Map<String,String> viewSeller_manageShop(
			Shop_manageShopDTO infors)
	{
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();

		return view; 
	}
	
	private static void viewSeller_manageShopStatistic(Shop_manageShopDTO shop_manageShopDTO, 	
			Map<String,String> view, StringBuilder tmp){
		tmp.setLength(0);
		StringBuilder label = new StringBuilder();
		StringBuilder series = new StringBuilder();
		
		shop_manageShopDTO.getStatistic().getSold_price_current_month().forEach((date,price)->{
			if (!label.isEmpty()&&!label.toString().isBlank()) {
				label.append(",");
				series.append(",");
			}
			label.append("\""+date+"\"");	
			series.append(""+price+"");
		});
		
		shop_manageShopDTO.getStorage().sort((o1,o2)->{
			return o1.getName().compareTo(o2.getName());
		});
		
		label.insert(0, "[");
		label.append("]");
		series.insert(0, "[");
		series.append("]");
		view.put("label", label.toString());
		view.put("series",series.toString());
		tmp.setLength(0);
		

		view.put("product_sold_this_month",tmp.toString());
		
		view.put("product_sold_this_month",tmp.toString());
	}
	
	private static void viewSeller_manageShopProduct(Shop_manageShopDTO UserShopDTO, Map<String,String> view, StringBuilder tmp){
		tmp.setLength(0);
		UserShopDTO.getStorage().forEach(product->{
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+product.getId()+"</th>");
			tmp.append("<td>"+product.getName()+"</td>");
			tmp.append("<td>"+product.getQuantity()+"</td>");
			tmp.append("<td>"+product.getPrice()+"</td>");
			tmp.append("<td>2014-12-05</td>");
			
			tmp.append("<td class=\"align-middle\">");
			tmp.append("<a class=\"btn btn-secondary btn-sm product-edit-action\" id=\""+product.getId()+"\">");
			tmp.append("<i class=\"fa-solid fa-pen-to-square\"></i>");
			tmp.append("</a>");
			tmp.append("</td>");
			tmp.append("<td class=\"align-middle\">");
			tmp.append("<a class=\"btn btn-danger btn-sm product-del-action\" id=\""+product.getId()+"\">");
			tmp.append("<i class=\"fa-solid fa-trash\"></i>");
			tmp.append("</a>");
			tmp.append("</td>");
			tmp.append("</tr>");
		});
		view.put("product_list",tmp.toString());
	}
	

}
