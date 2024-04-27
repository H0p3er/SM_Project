package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import dto.productAttribute.Product_CPUDTO;
import dto.productAttribute.Product_CaseDTO;
import dto.productAttribute.Product_CoolingDTO;
import dto.productAttribute.Product_DesktopDTO;
import dto.productAttribute.Product_GraphicsCardDTO;
import entity.ProductObject;

public class ProductLibrary {
	public static Map<String,String> viewHomeProduct(Pair<ArrayList<ProductObject>, Integer> datas,
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors, String url) {		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<ProductObject> productObjects = datas.getValue0();	
		Iterator<ProductObject> iterator =  datas.getValue0().iterator();
		
		while (iterator.hasNext()) {
			ProductObject product = iterator.next();
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"/home/product?id="+product.getProduct_id()+"\"><img src=\"/home/assets/images/product/monitor/manhinh.png\" alt=\"\"></a>");
			switch (product.getProduct_pc_id()) {
				case 1:
					tmp.append("<span class=\"category\">Case</span>");
					break;		
				case 2:
					tmp.append("<span class=\"category\">Quạt tản nhiệt</span>");
					break;					
				case 3:
					tmp.append("<span class=\"category\">CPU</span>");	
					break;					
				case 4:
					tmp.append("<span class=\"category\">Desktop</span>");	
					break;						
				case 5:
					tmp.append("<span class=\"category\">GPU</span>");		
					break;						
				case 6:	
					tmp.append("<span class=\"category\">Tai nghe</span>");	
					break;						
				case 7:
					tmp.append("<span class=\"category\">Bàn phím</span>");			
					break;						
				case 8:
					tmp.append("<span class=\"category\">Laptop</span>");	
					break;						
				case 9:		
					tmp.append("<span class=\"category\">Chuột</span>");		
					break;		
				case 10:
					tmp.append("<span class=\"category\">Màn hình</span>");
					break;				
				case 11:
					tmp.append("<span class=\"category\">Bo mạch chủ</span>");	
					break;						
				case 12:
					tmp.append("<span class=\"category\">Nguồn</span>");			
					break;						
				case 13:
					tmp.append("<span class=\"category\">RAM</span>");		
					break;				
				case 14:
					tmp.append("<span class=\"category\">Ổ cứng</span>");			
					break;					
			}	
			tmp.append("<h6>"+product.getProduct_price()+"</h6>");
			tmp.append("<h4 style=\"height: 72px\" class=\"text-truncateline\"><a href=\"/home/product?id="+product.getProduct_id()+"\">"+product.getProduct_name()+"</a></h4>");
			tmp.append("<ul class=\"item-list\">");
			
			tmp.append(viewProductAttribute(product));
			
			tmp.append("</ul>");
			tmp.append("<div class=\"main-button\">");
			tmp.append("<a href=\"/home/product/profile?id="+product.getProduct_id()+"\">Xem chi tiết</a>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");
		}

		view.put("home_product_list",tmp.toString());
		
		tmp.setLength(0);
		tmp.append(viewProductPagination(datas.getValue1(), infors.getValue0(), infors.getValue1(),url));
		view.put("home-product-pagination", tmp.toString());
		return view;
	}

	
	public static Map<String,String> viewSearchProduct(Pair<ArrayList<ProductObject>, Integer> datas,
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors, String url) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<ProductObject> productObjects = datas.getValue0();
		
		Iterator<ProductObject> iterator =  datas.getValue0().iterator();
		
		while (iterator.hasNext()) {
			ProductObject product = iterator.next();
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"property-details.html\"><img src=\"/home/assets/images/banphim.png\" alt=\"\"></a>");
			tmp.append("");
			tmp.append("<h4 style=\"height: 95px\" class=\"text-truncateline\"><a href=\"property-details.html\">");
			tmp.append(product.getProduct_name());
			tmp.append("</a></h4>");
			tmp.append("<h6 class=\"float-none mt-0 my-2\">"+product.getProduct_price()+"</h6>");
			tmp.append("<ul class=\"item-list\">");
			tmp.append(viewProductAttribute(product));
			tmp.append("</ul>");
			tmp.append("<div class=\"main-button\">");
			tmp.append("<a href=\"/home/product/profile?"+product.getProduct_id()+"\">Xem chi tiết</a>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");
		}	
		view.put("product-search",tmp.toString());	
		
		
		tmp.setLength(0);
		tmp.append(viewProductPagination(datas.getValue1(), infors.getValue0(), infors.getValue1(), url));
		view.put("product-search-pagination", tmp.toString());
		return view;
	}
	
	
	public static Map<String,String> viewProductProfile(ProductObject productObject){
		Map<String,String> view = new HashMap<String, String>();
		
		StringBuilder tmp = new StringBuilder();
		
		tmp.append("<img src=\"/home/assets/images/manhinh.png\" alt=\"\" style=\"max-height: 430px;\">");
		view.put("product-image", tmp.toString());
		tmp.setLength(0);	
		
		tmp.append(viewProductAttribute(productObject));		
		view.put("product-attribute",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<h3>"+productObject.getProduct_name()+"</h3>");
		view.put("product-name",tmp.toString());
		tmp.setLength(0);	

		tmp.append("<h6 style=\"color: #f35525;\" class=\"fs-4 my-4\">"+productObject.getProduct_price()+"</h6>");
		view.put("product-price",tmp.toString());
		tmp.setLength(0);	

		tmp.append("<div class=\"col-3\">Số lượng: <span>"+productObject.getProduct_quantity()+"</span></div>");
		view.put("product-left",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<div class=\"col-7\">"+productObject.getProduct_shop_id()+"</div>");
		view.put("seller-name",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<span class=\"mt-4 overflow-y-auto\" style=\"height: 250px\">"+productObject.getProduct_notes()+"</span>");
		view.put("product-notes",tmp.toString());
		tmp.setLength(0);
		
		return view;
		
	}
	
	
	private static String viewProductPagination(int record_count, short current_page, byte record_per_page, String url) {
		StringBuilder tmp = new StringBuilder();
		short page_count = (short) (record_count/record_per_page);
		
		if (record_count%record_per_page!=0) page_count++;
		if (current_page>page_count) current_page=page_count;
		if (current_page<=0) current_page=1;
		
		if (page_count<=3) {
			if (current_page == 1) {
				
			}
			
			if (current_page == 2) {
				tmp.append("<li><a href=\""+url+"?page="+(current_page-1)+"\"><</a></li>");
			}
			
			if (current_page==3) {
				tmp.append("<li><a href=\""+url+"?page=1\"><<</a></li>");
				tmp.append("<li><a href=\""+url+"?page="+(current_page-1)+"\"><</a></li>");
				tmp.append("<li><a href=\""+url+"?page="+(current_page-1)+"\">"+(current_page-1)+"</a></li>");	
			}

		} else {
			if (current_page == 1) {
				
			}
			
			if (current_page == 2) {
				tmp.append("<li><a href=\""+url+"?page="+(current_page-1)+"\"><</a></li>");
				tmp.append("<li><a href=\""+url+"?page="+(current_page-1)+"\">"+(current_page-1)+"</a></li>");	
			}
			if (current_page>=3) {
				tmp.append("<li><a href=\""+url+"?page=1\"><<</a></li>");
				tmp.append("<li><a href=\""+url+"?page="+(current_page-1)+"\"><</a></li>");
				tmp.append("<li><a class=\"disabled\" tabindex=\"-1\" href=\"\"  role=\"button\" aria-disabled=\"true\" >...</a></li>");
				tmp.append("<li><a href=\""+url+"?page="+(current_page-1)+"\">"+(current_page-1)+"</a></li>");	
			}
		}
		
		tmp.append("<li><a class=\"is_active\" href=\"#\" disabled>"+current_page+"</a></li>");
		
		if (page_count<=3) {
			
			
			if (current_page<page_count) {
				tmp.append("<li><a href=\""+url+"?page="+(current_page+1)+"\">"+(current_page+1)+"</a></li>");
				tmp.append("<li><a href=\""+url+"?page="+(current_page+1)+"\">></a></li>");
				tmp.append("<li><a href=\""+url+"?page="+page_count+"\">>></a></li>");	
			}
		} else {
			if (current_page<page_count) {
				tmp.append("<li><a href=\""+url+"?page="+(current_page+1)+"\">"+(current_page+1)+"</a></li>");
				tmp.append("<li><a  class=\"disabled\" tabindex=\"-1\" href=\"\" role=\"button\" aria-disabled=\"true\">...</a></li>");			
				tmp.append("<li><a href=\""+url+"?page="+(current_page+1)+"\">></a></li>");
				tmp.append("<li><a href=\""+url+"?page="+page_count+"\">>></a></li>");	
			} 

		}

			
		
		return tmp.toString();
	}
	
	
	private static String viewProductAttribute(ProductObject product) {
		StringBuilder tmp = new StringBuilder();
		
		switch (product.getProduct_pc_id()) {
		case 1:
			tmp.append("<li>Hãng:<span>"+((Product_CaseDTO)product).getCase_manufacturer()+"</span></li>");
			tmp.append("<li>Kích thước:<span>"+((Product_CaseDTO)product).getCase_manufacturer()+"</span></li>");
			tmp.append("<li>Màu sắc <span>"+((Product_CaseDTO)product).getCase_color()+"</span></li>");
			break;		
		case 2:
			tmp.append("<li>Hãng: <span>"+((Product_CoolingDTO)product).getCooling_manufacturer()+"</span></li>");
			tmp.append("<li>Phân loại: <span>"+((Product_CoolingDTO)product).getCooling_type()+"</span></li>");
			tmp.append("<li>Màu sắc: <span>"+((Product_CoolingDTO)product).getCooling_color()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((Product_CoolingDTO)product).getCooling_fan_size()+"</span></li>");
			break;					
		case 3:
			tmp.append("<li>Bộ: <span>"+((Product_CPUDTO)product).getCpu_collection()+"</span></li>");
			tmp.append("<li>Socket: <span>"+((Product_CPUDTO)product).getCpu_socket()+"</span></li>");
			tmp.append("<li>Số nhân: <span>"+((Product_CPUDTO)product).getCpu_cores()+"</span></li>");
			tmp.append("<li>Số luồng: <span>"+((Product_CPUDTO)product).getCpu_theats()+"</span></li>");
			tmp.append("<li>Xung nhịp: <span>"+((Product_CPUDTO)product).getCpu_speed_ghz()+"</span></li>");
			break;					
		case 4:
			tmp.append("<li>Hãng: <span>"+((Product_DesktopDTO)product).getDesktop_manufacturer()+"</span></li>");
			tmp.append("<li>Dòng: <span>"+((Product_DesktopDTO)product).getDesktop_type()+"</span></li>");
			tmp.append("<li>CPU: <span>"+((Product_DesktopDTO)product).getDesktop_cpu()+"</span></li>");
			tmp.append("<li>GPU: <span>"+((Product_DesktopDTO)product).getDesktop_gpu()+"</span></li>");
			tmp.append("<li>RAM: <span>"+((Product_DesktopDTO)product).getDesktop_ram_capacity()+" "+((Product_DesktopDTO)product).getDesktop_ram_type()+"</span></li>");
			tmp.append("<li>Bộ nhớ: <span>"+((Product_DesktopDTO)product).getDesktop_storage()+"</span></li>");		
			break;						
		case 5:	
			tmp.append("<li>Hãng: <span>"+((Product_GraphicsCardDTO)product).getGraphics_card_manufacturer()+"</span></li>");
			tmp.append("<li>Xung nhịp: <span>"+((Product_GraphicsCardDTO)product).getGraphics_card_speed()+"</span></li>");
			tmp.append("<li>Số nhân: <span>"+((Product_GraphicsCardDTO)product).getGraphics_card_cores()+"</span></li>");
			tmp.append("<li>Phiên bản: <span>"+((Product_GraphicsCardDTO)product).getGraphics_card_version()+"</span></li>");
			tmp.append("<li>Dung lượng VRAM: <span>"+((Product_GraphicsCardDTO)product).getGraphics_card_vram_capacity()+"</span></li>");
			tmp.append("<li>Bộ nguồn khuyến nghị: <span>"+((Product_GraphicsCardDTO)product).getGraphics_card_require_psu()+"</span></li>");			
			break;						
		case 6:
			
//			item = getProduct_HeadphoneSpeakerDTO(rs);		
			break;						
		case 7:
//			item = getProduct_KeyboardDTO(rs);		
			break;						
		case 8:
//			item = getProduct_LaptopDTO(rs);		
			break;						
		case 9:					
//			item = getProduct_MiceDTO(rs);		
			break;		
		case 10:
			tmp.append("<li>Hãng: <span>Samsung</span></li>");
			tmp.append("<li>Kích thước: <span>49 inch</span></li>");
			tmp.append("<li>Độ phân giải: <span>5120x1440</span></li>");
			tmp.append("<li>Tấm nền: <span>OLED</span></li>");
			tmp.append("<li>Tần số quét: <span>3</span></li>");
			tmp.append("<li>Tốc độ phản hồi: <span>0.03 ms</span></li>");
			break;				
		case 11:						
//			item = getProduct_MotherboardDTO(rs);		
			break;						
		case 12:
//			item = getProduct_PowerSuppyDTO(rs);		
			break;						
		case 13:
//			item = getProduct_RamDTO(rs);		
			break;				
		case 14:
//			item = getProduct_StorageDTO(rs);		
			break;	
		
		}	
		return tmp.toString();
	}
}