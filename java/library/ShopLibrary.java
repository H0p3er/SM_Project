package library;

import java.util.*;

import org.javatuples.*;

import dto.ShopDTO;
import dto.seller.SellerShopDTO;
import dto.seller.SellerShopStatisticDTO;

public class ShopLibrary {
	public static ArrayList<String> viewShop(ShopDTO shopDTO){
		ArrayList<String> view = new ArrayList<String>();		
		StringBuilder tmp = new StringBuilder();	
		return view;
	}
	
	public static Map<String,String> viewSellerShopProfile(
			Pair<SellerShopDTO,SellerShopStatisticDTO> infors)
	{
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		SellerShopDTO sellerShopDTO = infors.getValue0();
		SellerShopStatisticDTO sellerShopStatisticDTO = infors.getValue1();
		
		tmp.append(sellerShopDTO.getName());
		view.put("shop_name",tmp.toString());
		
		tmp.setLength(0);
		tmp.append("<img src=\""+sellerShopDTO.getImages()+"\" alt=\"\">");
		view.put("shop_image",tmp.toString());
		
		tmp.setLength(0);
		tmp.append(sellerShopDTO.getNotes());
		view.put("shop_note",tmp.toString());
		
		viewSellerShopChartStatistic(sellerShopDTO,sellerShopStatisticDTO,view, tmp);
		viewSellerShopProduct(sellerShopDTO,view, tmp);
		
		return view; 
	}
	
	private static void viewSellerShopChartStatistic(SellerShopDTO sellerShopDTO,
			SellerShopStatisticDTO sellerShopStatisticDTO, 	
			Map<String,String> view, StringBuilder tmp){
		tmp.setLength(0);
		StringBuilder label = new StringBuilder();
		StringBuilder series = new StringBuilder();
		
		sellerShopStatisticDTO.getTotalSellingPricePerProduct().forEach((id,product)->{
			if (!label.isEmpty()) {
				label.append(",");
				series.append(",");
			}
			label.append("\""+product.getValue0().getName()+"\"");	
			double demical = (double)product.getValue1()*100/sellerShopStatisticDTO.getTotalSellingPriceAllProduct();
			series.append(""+demical+"");
		});
		
		sellerShopDTO.getStorage().sort((o1,o2)->{
			return o1.getName().compareTo(o2.getName());
		});
		
		label.insert(0, "[");
		label.append("]");
		series.insert(0, "[");
		series.append("]");
		view.put("label", label.toString());
		view.put("series",series.toString());
		tmp.setLength(0);
		
		tmp.append("<ul>");
		tmp.append("<li>Số sản phẩm còn lại <span>"+sellerShopStatisticDTO.getTotalProduct()+"</span></li>");
		tmp.append("<li>Số sản phẩm đã bán ra <span>"+sellerShopStatisticDTO.getTotalQuantityAllProduct()+"</span></li>");
		tmp.append("<li>Lợi nhuận<span>"+utility.Utilities_currency.toVND(sellerShopStatisticDTO.getTotalSellingPriceAllProduct())+"</span></li>");
		tmp.append("</ul>");
		view.put("statistic_overview",tmp.toString());
	}
	
	private static void viewSellerShopProduct(SellerShopDTO UserShopDTO, Map<String,String> view, StringBuilder tmp){
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
