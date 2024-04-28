package library;

import java.util.*;

import org.javatuples.*;

import dto.product.Product_ShopStatisticDTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_viewShopDTO;

public class ShopLibrary {
	public static Map<String,String> viewShop_Profile(Shop_viewShopDTO shopDTO){
		Map<String,String> view = new HashMap<String,String>();		
		StringBuilder tmp = new StringBuilder();
		tmp.append("<h2>"+shopDTO.getName()+"</h2>");
		view.put("shop-name",tmp.toString());
		tmp.setLength(0);
		
		if (shopDTO.getStatus()==0) {
			tmp.append("<div class=\"d-flex align-items-center\"><span class=\"me-3 fs-2 text-danger\">●</span> <h5>Tạm dừng hoạt động</h5></div>");
		} else {
			tmp.append("<div class=\"d-flex align-items-center\"><span class=\"me-3 fs-2 text-success\">●</span> <h5>Đang hoạt động</h5></div>");
		}
		view.put("shop-status",tmp.toString());
		tmp.setLength(0);
		
		
		tmp.append("<li>Tổng sản phẩm <span>185</span></li>");
		tmp.append("<li>Ngày tham gia <span>"+shopDTO.getCreated_date()+"</span></li>");
		tmp.append("<li>Khu vực <span>Hanoi</span></li>");
		tmp.append("<li>Địa chỉ <span>Yes</span></li>");
		tmp.append("<li>Điện thoại <span>"+shopDTO.getPhone()+"</span></li>");
		tmp.append("<li>Email <span>"+shopDTO.getEmail()+"</span></li>");
		view.put("shop-attribute",tmp.toString());
		tmp.setLength(0);
		
		
		view.put("shop-note",tmp.toString());
		tmp.setLength(0);
		
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
