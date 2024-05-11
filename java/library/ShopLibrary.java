package library;

import java.util.*;

import org.javatuples.*;

import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_statisticDTO;
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
	
	public static Map<String,String> viewSeller_ShopStatistic(
			Shop_manageShopDTO infors)
	{
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		viewSeller_manageShopStatistic(infors, view);
		return view; 
	}
	
	private static void viewSeller_manageShopStatistic(Shop_manageShopDTO shop_manageShopDTO, 	
			Map<String,String> view){
	
		StringBuilder datetime_data = new StringBuilder();
		StringBuilder income_data = new StringBuilder();
		StringBuilder order_data = new StringBuilder();	
		StringBuilder customer_data = new StringBuilder();
		
		Set<String> date_key = new HashSet<String>();
		
		date_key.addAll(shop_manageShopDTO.getStatistic().getIncome_current_month().keySet());
		
		date_key.addAll(shop_manageShopDTO.getStatistic().getOrder_current_month().keySet());
		
		date_key.addAll(shop_manageShopDTO.getStatistic().getCustomer_current_month().keySet());
		
		date_key.forEach(day -> {
			if (!datetime_data.isEmpty()&&!datetime_data.toString().isBlank()) {
				datetime_data.append(",");
			} 
			datetime_data.append(day);	
			
			if (!income_data.isEmpty()&&!income_data.toString().isBlank()) {
				income_data.append(",");
			} 
			income_data.append(shop_manageShopDTO.getStatistic().getIncome_current_month().getOrDefault(day, (double)0));
			
			if (!order_data.isEmpty()&&!order_data.toString().isBlank()) {
				order_data.append(",");
			} 
			order_data.append(shop_manageShopDTO.getStatistic().getOrder_current_month().getOrDefault(day, 0));
			
			if (!customer_data.isEmpty()&&!customer_data.toString().isBlank()) {
				customer_data.append(",");
			} 
			customer_data.append(shop_manageShopDTO.getStatistic().getCustomer_current_month().getOrDefault(day, 0));
		});
		
		view.put("datetime-data", datetime_data.toString());
		
		view.put("income-data", income_data.toString());	
		
		view.put("order-data", order_data.toString());	
		
		view.put("customer-data", customer_data.toString());	
		
		
//		shop_manageShopDTO.getStorage().getValue0().sort((o1,o2)->{
//			return o1.getName().compareTo(o2.getName());
//		});
	}
	
	
	
	private static void viewSeller_manageShopProduct(Shop_manageShopDTO UserShopDTO, Map<String,String> view, StringBuilder tmp){
		tmp.setLength(0);
		UserShopDTO.getStorage().getValue0().forEach(product->{
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
