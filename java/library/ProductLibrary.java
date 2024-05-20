package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import dto.product.Product_DTO;
import dto.productAttribute.CPUDTO;
import dto.productAttribute.CaseDTO;
import dto.productAttribute.CoolingDTO;
import dto.productAttribute.DesktopDTO;
import dto.productAttribute.GraphicsCardDTO;
import dto.productAttribute.HeadphoneSpeakerDTO;
import dto.productAttribute.KeyboardDTO;
import dto.productAttribute.LaptopDTO;
import dto.productAttribute.MiceDTO;
import dto.productAttribute.MonitorDTO;
import dto.productAttribute.MotherboardDTO;
import dto.productAttribute.PowerSuppyDTO;
import dto.productAttribute.RamDTO;
import dto.productAttribute.StorageDTO;
import dto.productAttribute.Product_UsbDTO;
import repository.Product;
import utility.Utilities_currency;

public class ProductLibrary {
	public static Map<String,String> viewHomeProduct(Pair<ArrayList<Product_DTO>, ArrayList<Product_DTO>> datas) {		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<Product_DTO> productObjects =  datas.getValue0();
		for (int i = 1; i <= productObjects.size(); i++) {
			Product_DTO product = productObjects.get(i-1);
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"/home/product/profile?id="+product.getId()+"\"><img src=\""+product.getImages()+"\" alt=\"\"></a>");
			switch (product.getPc().getId()) {
				case 1:
					tmp.append("<span class=\"category\">Màn hình</span>");
					break;		
				case 2:
					tmp.append("<span class=\"category\">Bàn phím</span>");			
					break;					
				case 3:
					tmp.append("<span class=\"category\">Chuột</span>");
					break;					
				case 4:
					tmp.append("<span class=\"category\">Tai nghe</span>");	
					break;						
				case 5:
					tmp.append("<span class=\"category\">Laptop</span>");	
					break;						
				case 6:	
					tmp.append("<span class=\"category\">Desktop</span>");	
					break;						
				case 7:
					tmp.append("<span class=\"category\">CPU</span>");
					break;						
				case 8:
					tmp.append("<span class=\"category\">Bo mạch chủ</span>");				
					break;						
				case 9:	
					tmp.append("<span class=\"category\">RAM</span>");					
					break;		
				case 10:
					tmp.append("<span class=\"category\">Ổ cứng</span>");			
					break;				
				case 11:
					tmp.append("<span class=\"category\">VGA</span>");	
					break;						
				case 12:
					tmp.append("<span class=\"category\">Nguồn</span>");			
					break;						
				case 13:
					tmp.append("<span class=\"category\">Case</span>");		
					break;				
				case 14:
					tmp.append("<span class=\"category\">Bộ tản nhiệt</span>");
					break;					
			}	
			tmp.append("<h6>"+Utilities_currency.toVND(product.getPrice())+"</h6>");
			tmp.append("<h4 style=\"height: 44px\" class=\"text-truncateline my-2\"><a href=\"/home/product/profile?id="+product.getId()+"\">"+product.getName()+"</a></h4>");
			tmp.append("<ul class=\"item-list\">");
			
			tmp.append(viewProductAttribute(product));
			
			tmp.append("</ul>");
			tmp.append("<div class=\"main-button\">");
			tmp.append("<a href=\"/home/product/profile?id="+product.getId()+"\">Xem chi tiết</a>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");
			
			if (i%3 == 0) {	
				view.put("home_most_sold_carousel_"+((int)i/3)+"",tmp.toString());
				tmp.setLength(0);
			}				
		}
		
		tmp.setLength(0);
		Iterator<Product_DTO> iterator =  datas.getValue1().iterator();
		while (iterator.hasNext()) {
			Product_DTO product = iterator.next();
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"/home/product/profile?id="+product.getId()+"\"><img src=\""+product.getImages()+"\" alt=\"\"></a>");
			switch (product.getPc().getId()) {
			case 1:
				tmp.append("<span class=\"category\">Màn hình</span>");
				break;		
			case 2:
				tmp.append("<span class=\"category\">Bàn phím</span>");			
				break;					
			case 3:
				tmp.append("<span class=\"category\">Chuột</span>");
				break;					
			case 4:
				tmp.append("<span class=\"category\">Tai nghe</span>");	
				break;						
			case 5:
				tmp.append("<span class=\"category\">Laptop</span>");	
				break;						
			case 6:	
				tmp.append("<span class=\"category\">Desktop</span>");	
				break;						
			case 7:
				tmp.append("<span class=\"category\">CPU</span>");
				break;						
			case 8:
				tmp.append("<span class=\"category\">Bo mạch chủ</span>");				
				break;						
			case 9:	
				tmp.append("<span class=\"category\">RAM</span>");					
				break;		
			case 10:
				tmp.append("<span class=\"category\">Ổ cứng</span>");			
				break;				
			case 11:
				tmp.append("<span class=\"category\">VGA</span>");	
				break;						
			case 12:
				tmp.append("<span class=\"category\">Nguồn</span>");			
				break;						
			case 13:
				tmp.append("<span class=\"category\">Case</span>");		
				break;				
			case 14:
				tmp.append("<span class=\"category\">Bộ tản nhiệt</span>");
				break;					
		}	
			tmp.append("<h6>"+Utilities_currency.toVND(product.getPrice())+"</h6>");
			tmp.append("<h4 style=\"height: 44px\" class=\"text-truncateline my-2\"><a href=\"/home/product/profile?id="+product.getId()+"\">"+product.getName()+"</a></h4>");
			tmp.append("<ul class=\"item-list\">");
			
			tmp.append(viewProductAttribute(product));
			
			tmp.append("</ul>");
			tmp.append("<div class=\"main-button\">");
			tmp.append("<a href=\"/home/product/profile?id="+product.getId()+"\">Xem chi tiết</a>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");
		}
		view.put("home_newest_product",tmp.toString());
		return view;
	}

	
	public static Map<String,String> viewSearchProduct(Pair<ArrayList<Product_DTO>, Integer> datas,
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors, 
			String url) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		Iterator<Product_DTO> iterator =  datas.getValue0().iterator();	
		while (iterator.hasNext()) {
			Product_DTO product = iterator.next();
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"property-details.html\"><img src=\""+product.getImages()+"\" alt=\"\"></a>");
			tmp.append("");
			tmp.append("<h4 style=\"height: 45px\" class=\"text-truncateline my-2\"><a href=\"property-details.html\">");
			tmp.append(product.getName());
			tmp.append("</a></h4>");
			tmp.append("<h6 class=\"float-none mt-0 my-2\">"+Utilities_currency.toVND(product.getPrice())+"</h6>");
			tmp.append("<ul class=\"item-list\">");
			tmp.append(viewProductAttribute(product));
			tmp.append("</ul>");
			tmp.append("<div class=\"main-button\">");
			tmp.append("<a href=\"/home/product/profile?id="+product.getId()+"\">Xem chi tiết</a>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");
		}	
		view.put("product-search",tmp.toString());
		tmp.setLength(0);
		
		view.put("product-filter", viewSearchPC(datas.getValue0()));
		
		
		view.put("product-search-pagination", viewProductPagination(datas.getValue1(), infors.getValue0(), infors.getValue1(), infors.getValue3(), url));
		return view;
	}
	
	private static String viewSearchPC(ArrayList<Product_DTO> product_DTOs) {
		StringBuilder tmp = new StringBuilder();
		Map<String,Integer> map = new HashMap<String, Integer>();
		product_DTOs.forEach(product->{
			String category_name = (product.getPc().getName()!=null)?product.getPc().getName():"Khác";
			if (map.get(category_name) != null) {
				map.put(category_name, map.get(category_name)+1);		
			} else {
				map.put(category_name, 1);
			}
		});
		
		map.forEach((key,value)->{
			tmp.append("<li><a class=\"text-black\" href=\"\">"+key+"("+value+")</a></li>");
		});
		return tmp.toString();
	}
	
	
	public static Map<String,String> viewProductProfile(Product_DTO product_DTO){
		Map<String,String> view = new HashMap<String, String>();
		
		StringBuilder tmp = new StringBuilder();
		
		tmp.append("<img src=\""+product_DTO.getImages()+"\" alt=\"\" style=\"max-height: 430px;\">");
		view.put("product-image", tmp.toString());
		tmp.setLength(0);	
		
		tmp.append(viewProductAttribute(product_DTO));		
		view.put("product-attribute",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<h3>"+product_DTO.getName()+"</h3>");
		view.put("product-name",tmp.toString());
		tmp.setLength(0);	

		tmp.append("<h6 style=\"color: #f35525;\" class=\"fs-3 my-4\">"+Utilities_currency.toVND(product_DTO.getPrice())+"</h6>");
		view.put("product-price",tmp.toString());
		tmp.setLength(0);

		tmp.append("<div class=\"col-3\">Số lượng: <span>"+product_DTO.getQuantity()+"</span></div>");
		view.put("product-left",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<div class=\"col-7\">"+product_DTO.getShop().getId()+"</div>");
		view.put("seller-name",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<span class=\"mt-4 overflow-y-auto\">"+product_DTO.getNotes()+"</span>");
		view.put("product-notes",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<a class=\"btn btn-dark col-4\" href=\"/home/shop/profile?id="+product_DTO.getShop().getId()+"\">Xem gian hàng</a>");
		view.put("product-shop",tmp.toString());
		tmp.setLength(0);
		
		tmp.append(product_DTO.getId());
		view.put("product-id",tmp.toString());
		tmp.setLength(0);
		return view;
		
	}
	
	
	private static String viewProductPagination(int record_count, short current_page, byte record_per_page, Map<String,String> multiCondition, String url) {
		StringBuilder tmp = new StringBuilder();
		short page_count = (short) (record_count/record_per_page);		
		String page_parameter = utility.Utilities.toParam(multiCondition);
		if (page_parameter.isBlank() || page_parameter==null) {
			page_parameter+="?page=";
		} else {
			page_parameter+="&page=";
		}
		
		if (record_count%record_per_page!=0) page_count++;
		if (current_page>page_count) current_page=page_count;
		if (current_page<=0) current_page=1;	
		if (page_count<=3) {
			if (current_page == 1) {
				
			}		
			if (current_page == 2) {
				tmp.append("<li><a href=\""+url+page_parameter+(current_page-1)+"\"><</a></li>");
			}	
			if (current_page==3) {
				tmp.append("<li><a href=\""+url+page_parameter+"1\"><<</a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+(current_page-1)+"\"><</a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+(current_page-1)+"\">"+(current_page-1)+"</a></li>");	
			}
		} else {
			if (current_page == 1) {
				
			}		
			if (current_page == 2) {
				tmp.append("<li><a href=\""+url+page_parameter+(current_page-1)+"\"><</a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+(current_page-1)+"\">"+(current_page-1)+"</a></li>");	
			}
			if (current_page>=3) {
				tmp.append("<li><a href=\""+url+page_parameter+"1\"><<</a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+(current_page-1)+"\"><</a></li>");
				tmp.append("<li><a class=\"disabled\" tabindex=\"-1\" href=\"\"  role=\"button\" aria-disabled=\"true\" >...</a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+(current_page-1)+"\">"+(current_page-1)+"</a></li>");	
			}
		}		
		tmp.append("<li><a class=\"is_active\" href=\"#\" disabled>"+current_page+"</a></li>");	
		if (page_count<=3) {			
			if (current_page<page_count) {
				tmp.append("<li><a href=\""+url+page_parameter+(current_page+1)+"\">"+(current_page+1)+"</a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+(current_page+1)+"\">></a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+page_count+"\">>></a></li>");	
			}
		} else {
			if (current_page<page_count) {
				tmp.append("<li><a href=\""+url+page_parameter+(current_page+1)+"\">"+(current_page+1)+"</a></li>");
				tmp.append("<li><a  class=\"disabled\" tabindex=\"-1\" href=\"\" role=\"button\" aria-disabled=\"true\">...</a></li>");			
				tmp.append("<li><a href=\""+url+page_parameter+(current_page+1)+"\">></a></li>");
				tmp.append("<li><a href=\""+url+page_parameter+page_count+"\">>></a></li>");	
			} 

		}	
		return tmp.toString();
	}
	
	
	private static String viewProductAttribute(Product_DTO product) {
		StringBuilder tmp = new StringBuilder();
		switch (product.getPc().getId()) {
		case 1:
			//monitor
			tmp.append("<li>Hãng: <span>"+((MonitorDTO)product.getAttribute()).getMonitor_manufacturer()+"</span></li>");
			tmp.append("<li>Dòng: <span>"+((MonitorDTO)product.getAttribute()).getMonitor_type()+"</span></li>");
			tmp.append("<li>Độ phân giải: <span>"+((MonitorDTO)product.getAttribute()).getMonitor_resolution()+"</span></li>");
			tmp.append("<li>Tấm nền: <span>"+((MonitorDTO)product.getAttribute()).getMonitor_panel_type()+"</span></li>");
			tmp.append("<li>Tần số quét: <span>"+((MonitorDTO)product.getAttribute()).getMonitor_refresh_rate()+"Hz</span></li>");
			tmp.append("<li>Kiểu màn hình: <span>"+((MonitorDTO)product.getAttribute()).getMonitor_screen_type()+"</span></li>");
			tmp.append("<li>Tốc độ phản hồi: <span>"+((MonitorDTO)product.getAttribute()).getMonitor_response()+"ms</span></li>");
			break;		
		case 2:
			//Keyboard
			tmp.append("<li>Loại: <span>"+((KeyboardDTO)product.getAttribute()).getKeyboard_type()+"</span></li>");
			tmp.append("<li>Kiểu kết nối: <span>"+((KeyboardDTO)product.getAttribute()).getKeyboard_connection_type()+"</span></li>");
			tmp.append("<li>kích thước: <span>"+((KeyboardDTO)product.getAttribute()).getKeyboard_size_layout()+"</span></li>");
			tmp.append("<li>Led: <span>"+((KeyboardDTO)product.getAttribute()).getKeyboard_led_backlighting()+"</span></li>");
			break;					
		case 3:
			//Mouse
			tmp.append("<li>Hãng: <span>"+((MiceDTO)product.getAttribute()).getMouse_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((MiceDTO)product.getAttribute()).getMouse_type()+"</span></li>");
			tmp.append("<li>Kiểu kết nối: <span>"+((MiceDTO)product.getAttribute()).getMouse_connection_type()+"</span></li>");
			tmp.append("<li>Thiết kế: <span>"+((MiceDTO)product.getAttribute()).getMouse_design()+"</span></li>");
			tmp.append("<li>Pin: <span>"+((MiceDTO)product.getAttribute()).getMouse_battery()+"</span></li>");
			break;					
		case 4:
			//Headphone
			tmp.append("<li>Hãng: <span>"+((HeadphoneSpeakerDTO)product.getAttribute()).getHeadphones_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((HeadphoneSpeakerDTO)product.getAttribute()).getHeadphone_type()+"</span></li>");
			tmp.append("<li>Kiểu kết nối: <span>"+((HeadphoneSpeakerDTO)product.getAttribute()).getHeadphones_connection()+"</span></li>");
			tmp.append("<li>Cổng: <span>"+((HeadphoneSpeakerDTO)product.getAttribute()).getHeadphones_connection_ports()+"</span></li>");
			break;	
			
		case 5:	
			//laptop
			tmp.append("<li>Hãng: <span>"+((LaptopDTO)product.getAttribute()).getLaptop_manufacturer()+"</span></li>");
			tmp.append("<li>Dòng: <span>"+((LaptopDTO)product.getAttribute()).getLaptop_type()+"</span></li>");
			tmp.append("<li>Kích thước màn: <span>"+((LaptopDTO)product.getAttribute()).getLaptop_screen_size()+"</span></li>");
			tmp.append("<li>CPU: <span>"+((LaptopDTO)product.getAttribute()).getLaptop_cpu()+"</span></li>");
			tmp.append("<li>RAM: <span>"+((LaptopDTO)product.getAttribute()).getLaptop_ram()+" GB</span></li>");
			tmp.append("<li>Bộ nhớ: <span>"+((LaptopDTO)product.getAttribute()).getLaptop_storage()+"</span></li>");		
			break;						
		case 6:
			//desktop
			tmp.append("<li>Hãng: <span>"+((DesktopDTO) product.getAttribute()).getDesktop_manufacturer()+"</span></li>");
			tmp.append("<li>Dòng: <span>"+((DesktopDTO) product.getAttribute()).getDesktop_type()+"</span></li>");
			tmp.append("<li>CPU: <span>"+((DesktopDTO) product.getAttribute()).getDesktop_cpu()+"</span></li>");
			tmp.append("<li>GPU: <span>"+((DesktopDTO) product.getAttribute()).getDesktop_gpu()+"</span></li>");
			tmp.append("<li>RAM: <span>"+((DesktopDTO) product.getAttribute()).getDesktop_ram_capacity()+" "+((DesktopDTO) product.getAttribute()).getDesktop_ram_type()+"</span></li>");
			tmp.append("<li>Bộ nhớ: <span>"+((DesktopDTO) product.getAttribute()).getDesktop_storage()+"</span></li>");		
			tmp.append("<li>Nguồn: <span>"+((DesktopDTO) product.getAttribute()).getDesktop_power_supply()+"</span></li>");
			break;						
		case 7:
			//cpu
			tmp.append("<li>Bộ: <span>"+((CPUDTO)product.getAttribute()).getCpu_collection()+"</span></li>");
			tmp.append("<li>Socket: <span>"+((CPUDTO)product.getAttribute()).getCpu_socket()+"</span></li>");
			tmp.append("<li>Số nhân: <span>"+((CPUDTO)product.getAttribute()).getCpu_cores()+"</span></li>");
			tmp.append("<li>Số luồng: <span>"+((CPUDTO)product.getAttribute()).getCpu_threads()+"</span></li>");
			tmp.append("<li>Xung nhịp: <span>"+((CPUDTO)product.getAttribute()).getCpu_speed_ghz()+"</span></li>");
			break;						
		case 8:
			//Mainboard
			tmp.append("<li>Hãng: <span>"+((MotherboardDTO)product.getAttribute()).getMotherboard_manufacturer()+"</span></li>");
			tmp.append("<li>Chipset: <span>"+((MotherboardDTO)product.getAttribute()).getMotherboard_chipset()+"</span></li>");
			tmp.append("<li>Socket: <span>"+((MotherboardDTO)product.getAttribute()).getMotherboard_socket()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((MotherboardDTO)product.getAttribute()).getMotherboard_size()+"</span></li>");
			tmp.append("<li>Loại RAM hỗ trợ: <span>"+((MotherboardDTO)product.getAttribute()).getMotherboard_ram_support()+"</span></li>");
			tmp.append("<li>Số khe RAM: <span>"+((MotherboardDTO)product.getAttribute()).getMotherboard_ram_slots()+"</span></li>");
			break;						
		case 9:			
			//RAM
			tmp.append("<li>Hãng: <span>"+((RamDTO)product.getAttribute()).getRam_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((RamDTO)product.getAttribute()).getRam_type()+"</span></li>");
			tmp.append("<li>Dung lượng: <span>"+((RamDTO)product.getAttribute()).getRam_capacity()+"</span></li>");
			tmp.append("<li>Tốc độ: <span>"+((RamDTO)product.getAttribute()).getRam_bus_speed()+"</span></li>");
			tmp.append("<li>Hỗ trợ: <span>"+((RamDTO)product.getAttribute()).getRam_standard()+"</span></li>");		
			break;		
		case 10:
			//storage
			tmp.append("<li>Hãng: <span>"+((StorageDTO)product.getAttribute()).getStorage_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((StorageDTO)product.getAttribute()).getStorage_type()+"</span></li>");
			tmp.append("<li>Dung lượng: <span>"+((StorageDTO)product.getAttribute()).getStorage_capacity()+"</span></li>");
			tmp.append("<li>Kiểu: <span>"+((StorageDTO)product.getAttribute()).getStorage_m2_pcie_type()+"</span></li>");
			tmp.append("<li>Tốc độ: <span>"+((StorageDTO)product.getAttribute()).getStorage_rpm()+"</span></li>");		
			break;				
		case 11:	
			//vga
			tmp.append("<li>Hãng: <span>"+((GraphicsCardDTO)product.getAttribute()).getGraphics_card_manufacturer()+"</span></li>");
			tmp.append("<li>Phiên bản: <span>"+((GraphicsCardDTO)product.getAttribute()).getGraphics_card_version()+"</span></li>");
			tmp.append("<li>Xung nhịp: <span>"+((GraphicsCardDTO)product.getAttribute()).getGraphics_card_speed()+"</span></li>");
			tmp.append("<li>Số nhân: <span>"+((GraphicsCardDTO)product.getAttribute()).getGraphics_card_cores()+"</span></li>");
			tmp.append("<li>Dung lượng VRAM: <span>"+((GraphicsCardDTO)product.getAttribute()).getGraphics_card_vram_capacity()+"</span></li>");
			tmp.append("<li>Bộ nguồn khuyến nghị: <span>"+((GraphicsCardDTO)product.getAttribute()).getGraphics_card_require_psu()+"</span></li>");	
			break;						
		case 12:
			//PSU
			tmp.append("<li>Hãng: <span>"+((PowerSuppyDTO)product.getAttribute()).getPsu_manufacturer()+"</span></li>");
			tmp.append("<li>Chứng nhận: <span>"+((PowerSuppyDTO)product.getAttribute()).getPsu_certification()+"</span></li>");
			tmp.append("<li>Loại cap: <span>"+((PowerSuppyDTO)product.getAttribute()).getPsu_cable_type()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((PowerSuppyDTO)product.getAttribute()).getPsu_size()+"</span></li>");	
			tmp.append("<li>Công suất: <span>"+((PowerSuppyDTO)product.getAttribute()).getPsu_power_output()+"</span></li>");	
			break;						
		case 13:
			//case
			tmp.append("<li>Hãng: <span>"+((CaseDTO)product.getAttribute()).getCase_manufacturer()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((CaseDTO)product.getAttribute()).getCase_size()+"</span></li>");
			tmp.append("<li>Màu sắc: <span>"+((CaseDTO)product.getAttribute()).getCase_color()+"</span></li>");	
			break;				
		case 14:
			//cooling
			tmp.append("<li>Hãng: <span>"+((CoolingDTO)product.getAttribute()).getCooling_manufacturer()+"</span></li>");
			tmp.append("<li>Phân loại: <span>"+((CoolingDTO)product.getAttribute()).getCooling_type()+"</span></li>");
			tmp.append("<li>Màu sắc: <span>"+((CoolingDTO)product.getAttribute()).getCooling_color()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((CoolingDTO)product.getAttribute()).getCooling_fan_size()+"</span></li>");	
			break;	
//		case 15:
//			//usb
//			tmp.append("<li>Hãng: <span>"+((Product_UsbDTO)product.getAttribute()).getUsb_manufacturer()+"</span></li>");
//			tmp.append("<li>Dung lượng: <span>"+((Product_UsbDTO)product.getAttribute()).getUsb_capacity()+"</span></li>");	
//			break;	
			
			//Bug??
		
		}	
		return tmp.toString();
	}
	
	public static Map<String,String> viewProductCart(TreeMap<Product_DTO,Integer> product_DTOs){
		Map<String,String> view = new HashMap<String, String>();
		StringBuilder tmp = new StringBuilder();		
  		if (product_DTOs!=null){
		product_DTOs.forEach((product, quantity)->{		                   			 
                tmp.append("<tr>");
				tmp.append("<th scope=\"row\">1</th>");
				tmp.append("<td><img height=\"70px\" class=\"p-0\" src=\"/"+product.getImages()+"\" alt=\"\">");
				tmp.append("</td>");
				tmp.append("<td><a href=\"\">"+product.getName()+"</a></td>");
				tmp.append("<td class=\"col-2\">");
				tmp.append("<div class=\"input-group\">");
				tmp.append("<span class=\"input-group-btn\">");
				tmp.append("<button type=\"button\" class=\"btn btn-default btn-number\" disabled=\"disabled\" data-type=\"minus\" data-field=\"quant["+product.getId()+"]\">");
				tmp.append("<i class=\"fa-solid fa-minus\"></i>");
				tmp.append("</button>");
				tmp.append("</span>");
				tmp.append("<input type=\"text\" name=\"quant["+product.getId()+"]\" class=\"form-control input-number\" value=\""+quantity+"\" min=\"1\" max=\"99\" maxlength=\"2\">");
				tmp.append("<span class=\"input-group-btn\">");
				tmp.append("<button type=\"button\" class=\"btn btn-default btn-number\" data-type=\"plus\" data-field=\"quant["+product.getId()+"]\">");
				tmp.append("<i class=\"fa-solid fa-plus\"></i>");
				tmp.append("</button>");
				tmp.append("</span>");
				tmp.append("</div>");
				tmp.append("</td>");
				tmp.append("<td><span class=\"product-price\" data-field=\"quant["+product.getId()+"]\"  value=\""+product.getPrice()+"\">"+Utilities_currency.toVND(product.getPrice())+"</span></td>");
				tmp.append("<td><i class=\"fa-solid fa-trash\"></i></td>");
				tmp.append("</tr>");        	
  			});
		view.put("product-cart",tmp.toString());
		} 
		return view;
		
	}
	
}