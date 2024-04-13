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
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");
		tmp.append("<h5 class=\"card-title\">Small tables</h5>");
		tmp.append("<table class=\"table table-sm\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th scope=\"col\">#</th>");
		tmp.append("<th scope=\"col\">Tên sản phẩm</th>");
		tmp.append("<th scope=\"col\">Số lượng sản phẩm</th>");
		tmp.append("<th scope=\"col\">Giá bán</th>");
		tmp.append("</tr>");
		tmp.append("</thead>");
		tmp.append("<tbody>");
		
		UserShopDTO.getStorage().forEach(product->{
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+product.getId()+"</th>");
			tmp.append("<td>"+product.getName()+"</td>");
			tmp.append("<td>"+product.getQuantity()+"</td>");
			tmp.append("<td>"+product.getPrice()+"</td>");
			tmp.append("<td>2014-12-05</td>");
			tmp.append("</tr>");
		});
	
		tmp.append("</tbody>");
		tmp.append("</table>");
		tmp.append("<!-- End small tables -->");
		tmp.append("");
		tmp.append("</div><!-- card-body -->");
		tmp.append("</div><!-- card -->");
		
		view.add(tmp.toString());
		return view;
	}
}
