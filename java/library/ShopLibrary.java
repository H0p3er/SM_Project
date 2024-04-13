package library;

import java.util.*;

import org.javatuples.*;

import dto.ShopDTO;
import dto.seller.SellerShopDTO;

public class ShopLibrary {
	public static ArrayList<String> viewShop(ShopDTO shopDTO){
		ArrayList<String> view = new ArrayList<String>();		
		StringBuilder tmp = new StringBuilder();	
		return view;
	}
	
	public static ArrayList<String> viewSellerShopProfile(
			SellerShopDTO sellerShopDTO)
	{
		ArrayList<String> view = new ArrayList<String>();
		StringBuilder tmp = new StringBuilder();
		
		tmp.append(sellerShopDTO.getName());
		view.add(tmp.toString());
		
		tmp.setLength(0);
		tmp.append("<img src=\""+sellerShopDTO.getImages()+"\" alt=\"\">");
		view.add(tmp.toString());
		
		tmp.setLength(0);
		tmp.append(sellerShopDTO.getNotes());
		view.add(tmp.toString());
		
		viewSellerShopChartStatistic(sellerShopDTO,view, tmp);
		viewSellerShopProduct(sellerShopDTO,view, tmp);
		
		return view; 
	}
	
	private static void viewSellerShopChartStatistic(SellerShopDTO sellerShopDTO, ArrayList<String> view, StringBuilder tmp){
		tmp.setLength(0);
		StringBuilder label = new StringBuilder();
		StringBuilder series = new StringBuilder();
		
		sellerShopDTO.getStatistic().getTotalSellingPricePerProduct().forEach((id,product)->{
			if (!label.isEmpty()) {
				label.append(",");
				series.append(",");
			}
			label.append("\""+product.getValue0().getName()+"\"");	
			double demical = (double)product.getValue1()*100/sellerShopDTO.getStatistic().getTotalSellingPriceAllProduct();
			series.append(""+demical+"");
		});
		label.insert(0, "[");
		label.append("]");
		series.insert(0, "[");
		series.append("]");
		view.add(label.toString());
		view.add(series.toString());
		tmp.setLength(0);
		
		tmp.append("<ul>");
		tmp.append("<li>Số sản phẩm còn lại <span>"+sellerShopDTO.getStatistic().getTotalProduct()+"</span></li>");
		tmp.append("<li>Số sản phẩm đã bán ra <span>"+sellerShopDTO.getStatistic().getTotalQuantityAllProduct()+"</span></li>");
		tmp.append("<li>Lợi nhuận<span>"+sellerShopDTO.getStatistic().getTotalPriceAllProduct()+"</span></li>");
		tmp.append("</ul>");
		view.add(tmp.toString());
	}
	
	private static void viewSellerShopProduct(SellerShopDTO UserShopDTO, ArrayList<String> view, StringBuilder tmp){
		tmp.setLength(0);
		UserShopDTO.getStorage().forEach(product->{
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+product.getId()+"</th>");
			tmp.append("<td>"+product.getName()+"</td>");
			tmp.append("<td>"+product.getQuantity()+"</td>");
			tmp.append("<td>"+product.getPrice()+"</td>");
			tmp.append("<td>2014-12-05</td>");
			tmp.append("</tr>");
		});
		view.add(tmp.toString());
	}
	

}
