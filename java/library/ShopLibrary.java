package library;

import java.text.DateFormat;
import java.util.*;

import org.javatuples.*;

import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_statisticDTO;
import dto.shop.Shop_viewShopDTO;
import entity.UserObject;
import utility.Utilities_data_type;
import utility.Utilities_date;

public class ShopLibrary {
	public static Map<String,String> viewShop_Profile(Shop_viewShopDTO shopDTO, UserObject currentUser){
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
		
		tmp.append("<li>Ngày tham gia <span>"+shopDTO.getCreated_date()+"</span></li>");
		tmp.append("<li>Địa chỉ <span>"+shopDTO.getAddress()+"</span></li>");
		tmp.append("<li>Điện thoại <span>"+shopDTO.getPhone()+"</span></li>");
		tmp.append("<li>Email <span>"+shopDTO.getEmail()+"</span></li>");
		view.put("shop-attribute",tmp.toString());
		tmp.setLength(0);	
		
		view.put("shop-note",tmp.toString());
		tmp.setLength(0);	
		
		if (currentUser != null && shopDTO.getUser()!=null) {
			if (currentUser.getUser_id() == shopDTO.getUser().getId()) {
				tmp.append("<ul class=\"nav nav-tabs\" role=\"tablist\">");
				tmp.append("<li class=\"nav-item\" role=\"presentation\">");
				tmp.append("<a href=\"/home/seller/shop/statistic\" class=\"nav-link active\">Quản lý shop</a>");
				tmp.append("</li>");
				tmp.append("</ul>");
				view.put("shop-user",tmp.toString());
				tmp.setLength(0);
			}
		}
	
	
		
		return view;
	}
	
	public static Map<String,String> viewUser_ShopProfile(Shop_manageShopDTO shopDTO){
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
		tmp.append("<li>Địa chỉ <span>"+shopDTO.getAddress()+"</span></li>");
		tmp.append("<li>Điện thoại <span>"+shopDTO.getPhone()+"</span></li>");
		tmp.append("<li>Email <span>"+shopDTO.getEmail()+"</span></li>");
		view.put("shop-attribute",tmp.toString());
		tmp.setLength(0);	
		
		view.put("shop-note",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<ul class=\"nav nav-tabs\" role=\"tablist\">");
		tmp.append("<li class=\"nav-item\" role=\"presentation\">");
		tmp.append("<a href=\"/home/seller/shop/statistic\" class=\"nav-link active\">Quản lý shop</a>");
		tmp.append("</li>");
		tmp.append("</ul>");
		view.put("shop-user",tmp.toString());
		tmp.setLength(0);
		
		if (shopDTO !=null) {
			if (shopDTO.getId() > 0 ) {
				view.put("shop-exist","true");
			}
		}
		
		tmp.setLength(0);	
		return view;
	}
	
	public static Map<String,String> viewSeller_ShopStatistic(
			Shop_manageShopDTO shop_manageShopDTO) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder datetime_data = new StringBuilder();
		StringBuilder income_data = new StringBuilder();
		StringBuilder order_data = new StringBuilder();	
		StringBuilder customer_data = new StringBuilder();
		Set<String> date_key = new TreeSet<String>();
		
		date_key.addAll(shop_manageShopDTO.getStatistic().getIncome_current_month().keySet());
		
		date_key.addAll(shop_manageShopDTO.getStatistic().getOrder_current_month().keySet());
		
		date_key.addAll(shop_manageShopDTO.getStatistic().getCustomer_current_month().keySet());
		
		date_key.forEach(day -> {	
			if (!datetime_data.isEmpty()&&!datetime_data.toString().isBlank()) {
				datetime_data.append(", ");
			} 
			datetime_data.append("\""+Utilities_date.getDate(day,"dd/MM/yyyy", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")+"\"");
			
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
		
		
		StringBuilder tmp = new StringBuilder();
		
		
		
		double change = shop_manageShopDTO.getStatistic().getCount_customer_current_month() - shop_manageShopDTO.getStatistic().getCount_customer_last_month();
		tmp.append("<h6>"+shop_manageShopDTO.getStatistic().getCount_customer_current_month()+"</h6>");
		if (change < 0) {
			tmp.append("<span class=\"text-muted small pt-2 ps-1\"><i class=\"bi bi-arrow-down\"></i></span>");
			tmp.append("<span class=\"text-danger small pt-1 fw-bold\">"+Math.abs(change)+"</span>");
		} else {
			tmp.append("<span class=\"text-muted small pt-2 ps-1\"><i class=\"bi bi-arrow-up\"></i></span>");
			tmp.append("<span class=\"text-success small pt-1 fw-bold\">"+Math.abs(change)+"</span>");
		}
		view.put("count-customer-current-month", tmp.toString());
		tmp.setLength(0);

		change = shop_manageShopDTO.getStatistic().getCount_order_current_month()- shop_manageShopDTO.getStatistic().getCount_order_last_month();
		tmp.append("<h6>"+shop_manageShopDTO.getStatistic().getCount_order_current_month()+"</h6>");
		if (change < 0) {
			tmp.append("<span class=\"text-muted small pt-2 ps-1\"><i class=\"bi bi-arrow-down\"></i></span>");
			tmp.append("<span class=\"text-danger small pt-1 fw-bold\">"+Math.abs(change)+"</span>");
		} else {
			tmp.append("<span class=\"text-muted small pt-2 ps-1\"><i class=\"bi bi-arrow-up\"></i></span>");
			tmp.append("<span class=\"text-success small pt-1 fw-bold\">"+Math.abs(change)+"</span>");
		}
		view.put("count-bill-current-month", tmp.toString());
		tmp.setLength(0);
		

		change = shop_manageShopDTO.getStatistic().getSum_income_current_month() - shop_manageShopDTO.getStatistic().getSum_income_last_month();
		tmp.append("<h6>"+utility.Utilities_currency.toVND(shop_manageShopDTO.getStatistic().getSum_income_current_month())+"</h6>");
		if (change < 0) {
			tmp.append("<span class=\"text-muted small pt-2 ps-1\"><i class=\"bi bi-arrow-down\"></i></span>");
			tmp.append("<span class=\"text-danger small pt-1 fw-bold\">"+utility.Utilities_currency.toVND(Math.abs(change))+"</span>");
		} else {
			tmp.append("<span class=\"text-muted small pt-2 ps-1\"><i class=\"bi bi-arrow-up\"></i></span>");
			tmp.append("<span class=\"text-success small pt-1 fw-bold\">"+utility.Utilities_currency.toVND(Math.abs(change))+"</span>");
		}
		view.put("count-income-current-month", tmp.toString());
		tmp.setLength(0);
		
		
		
		tmp.append("<div id=\"reportsChart\"></div>");
		tmp.append("<script>");
		tmp.append("	document.addEventListener(\"DOMContentLoaded\", () => {");
		tmp.append("	  new ApexCharts(document.querySelector(\"#reportsChart\"), {");
		tmp.append("		series: [{");
		tmp.append("		  name: 'Đơn hàng',");
		tmp.append("		  data: ["+order_data.toString()+"]");
		tmp.append("		}, {");
		tmp.append("		  name: 'Doanh thu',");
		tmp.append("		  data: ["+income_data.toString()+"]");
		tmp.append("		}, {");
		tmp.append("		  name: 'Lượt khách',");
		tmp.append("		  data: ["+customer_data.toString()+"]");
		tmp.append("		}],");
		tmp.append("		chart: {");
		tmp.append("		  height: 350,");
		tmp.append("		  type: 'area',");
		tmp.append("		  toolbar: {");
		tmp.append("			show: false");
		tmp.append("		  },");
		tmp.append("		},");
		tmp.append("		markers: {");
		tmp.append("		  size: 4");
		tmp.append("		},");
		tmp.append("		colors: ['#4154f1', '#2eca6a', '#ff771d'],");
		tmp.append("		fill: {");
		tmp.append("		  type: \"gradient\",");
		tmp.append("		  gradient: {");
		tmp.append("			shadeIntensity: 1,");
		tmp.append("			opacityFrom: 0.3,");
		tmp.append("			opacityTo: 0.4,");
		tmp.append("			stops: [0, 90, 100]");
		tmp.append("		  }");
		tmp.append("		},");
		tmp.append("		dataLabels: {");
		tmp.append("		  enabled: false");
		tmp.append("		},");
		tmp.append("		stroke: {");
		tmp.append("		  curve: 'smooth',");
		tmp.append("		  width: 2");
		tmp.append("		},");
		tmp.append("		xaxis: {");
		tmp.append("		  type: 'datetime',");
		tmp.append("		  categories: ["+datetime_data.toString()+"]");
		tmp.append("		},");
		tmp.append("		tooltip: {");
		tmp.append("		  x: {");
		tmp.append("			format: 'dd/MM/yy HH:mm',");
		tmp.append("		  },");
		tmp.append("		}");
		tmp.append("	  }).render();");
		tmp.append("	});");
		tmp.append("</script>");
		
		view.put("data-chart", tmp.toString());
		return view; 
	}
	
	public static Map<String,String> viewSeller_ShopProduct(
			Shop_manageShopDTO infors){
		Map<String,String> view = new HashMap<String,String>();
		viewSeller_manageShopProduct(infors, view);
		return view; 
	}
	


	private static void viewSeller_manageShopProduct(Shop_manageShopDTO shop_manageShopDTO, Map<String,String> view){
		StringBuilder tmp = new StringBuilder();
		shop_manageShopDTO.getStorage().getValue0().forEach(product->{
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\"><img width=\"120px\" src=\""+product.getImages()+"\" alt=\"\"></th>");
			tmp.append("<td><a href=\"/home/seller/shop/product/profile?id="+product.getId()+"\">"+product.getName()+"</a></td>");
			tmp.append("<td>"+utility.Utilities_currency.toVND(product.getPrice())+"</td>");
			tmp.append("<td>"+product.getNotes()+"</td>");
			tmp.append("<td>"+product.getQuantity()+"</td>");
			tmp.append("<td>"+product.getPc().getName()+"</td>");
			tmp.append("</tr>");
			
		});
		view.put("product-list",tmp.toString());
		
		view.put("shop-id",""+shop_manageShopDTO.getId());
	}
	
	public static Map<String,String> viewSeller_ShopProfile(Shop_manageShopDTO shop_manageShopDTO){
		Map<String,String> view = new HashMap<String,String>();		
		
		view.put("shop-id", ""+shop_manageShopDTO.getId()+"");
		
		view.put("shop-images", shop_manageShopDTO.getImages());
		
		view.put("shop-name", shop_manageShopDTO.getName());
		
		view.put("shop-status", ""+shop_manageShopDTO.getStatus());
		
		view.put("shop-website-link", shop_manageShopDTO.getWebsite_link());
		
		view.put("shop-address-link", shop_manageShopDTO.getAddress_link());
		
		view.put("shop-address", shop_manageShopDTO.getAddress());
		
		view.put("shop-phone", shop_manageShopDTO.getPhone());
		
		view.put("shop-email", shop_manageShopDTO.getEmail());
		
		view.put("shop-notes", shop_manageShopDTO.getNotes());
		
		
		System.out.print(view);
		return view;
	}
	
	public static Map<String, String> viewSeller_ShopBill(Shop_manageShopDTO shopDTO) {
        Map<String, String> data = new HashMap<>();
        //null
        return data;
    }
}
