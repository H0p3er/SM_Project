package library;

import java.util.*;

import org.javatuples.*;

import dto.ShopDTO;
import dto.user.UserShopDTO;

public class ShopLibrary {
	public static ArrayList<String> viewShop(ShopDTO shopDTO){
		ArrayList<String> view = new ArrayList<String>();
		
		StringBuilder tmp = new StringBuilder();
		
		return view;
	}
	
	public static ArrayList<String> viewShopProductList(UserShopDTO UserShopDTO){
		ArrayList<String> view = new ArrayList<String>();
		
		StringBuilder tmp = new StringBuilder();
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
		return view;
	}
}
