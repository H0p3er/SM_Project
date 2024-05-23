package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import dto.pc.PC_DTO;
import dto.pc.PC_DTO;
import dto.pc.PC_manageProductDTO;
import dto.product.Product_DTO;
import dto.product.Product_DTO;
import dto.product.Product_manageProductDTO;
import dto.product.Product_manageBillDTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_viewBillDTO;
import dto.product.Product_viewProductDTO;
import dto.product.Product_viewShopDTO;
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
import dto.productAttribute.Product_AttributeDTO;
import dto.productAttribute.RamDTO;
import dto.productAttribute.StorageDTO;
import dto.productAttribute.UsbDTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_viewProductDTO;
import repository.Product;
import utility.Utilities;
import utility.Utilities_currency;
import utility.Utilities_data_type;

public class ProductLibrary {
	public static Map<String,String> viewHomeProduct(Pair<ArrayList<Product_viewProductDTO>,ArrayList<Product_viewProductDTO>> datas) {		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		
		ArrayList<Product_viewProductDTO> productObjects =  datas.getValue0();
		for (int i = 1; i <= productObjects.size(); i++) {
			Product_viewProductDTO product = productObjects.get(i-1);
			tmp.append("<div class=\"col-lg-4 col-md-6\">");
			tmp.append("<div class=\"item\">");
			tmp.append("<a href=\"/home/product/profile?id="+product.getId()+"\"><img src=\""+product.getImages()+"\" alt=\"\"></a>");

			switch (Utilities_data_type.getProductAttribute(product.getPc())) {
			case CASE:
				tmp.append("<span class=\"category\">Case</span>");		
				break;
			case COOLING:
				tmp.append("<span class=\"category\">Bộ tản nhiệt</span>");
				break;
			case CPU:
				tmp.append("<span class=\"category\">CPU</span>");
				break;
			case DESKTOP:
				tmp.append("<span class=\"category\">Desktop</span>");	
				break;
			case GRAPHIC_CARD:
				tmp.append("<span class=\"category\">VGA</span>");
				break;
			case HEADPHONE:
				tmp.append("<span class=\"category\">Tai nghe</span>");
				break;
			case KEYBOARD:
				tmp.append("<span class=\"category\">Bàn phím</span>");	
				break;
			case LAPTOP:
				tmp.append("<span class=\"category\">Laptop</span>");
				break;
			case MAINBOARD:
				tmp.append("<span class=\"category\">Bo mạch chủ</span>");	
				break;
			case MONITOR:
				tmp.append("<span class=\"category\">Màn hình</span>");
				break;
			case MOUSE:
				tmp.append("<span class=\"category\">Chuột</span>");
				break;
			case OTHER:
				tmp.append("<span class=\"category\">Khác</span>");
				break;
			case POWER_SUPPLY:
				tmp.append("<span class=\"category\">Nguồn</span>");	
				break;
			case RAM:
				tmp.append("<span class=\"category\">RAM</span>");
				break;
			case STORAGE:
				tmp.append("<span class=\"category\">Ổ cứng</span>");
				break;
			case USB:
				tmp.append("<span class=\"category\">USB</span>");
				break;
			default:
				tmp.append("<span class=\"category\">Khác</span>");
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
		Iterator<Product_viewProductDTO> iterator =  datas.getValue1().iterator();
		while (iterator.hasNext()) {
			Product_viewProductDTO product = iterator.next();
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

	
	public static Map<String,String> viewSearchProduct(Pair<ArrayList<Product_viewProductDTO>, Integer> datas,
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors, 
			String url) {
		
		Map<String,String> view = new HashMap<String,String>();
		StringBuilder tmp = new StringBuilder();
		Iterator<Product_viewProductDTO> iterator =  datas.getValue0().iterator();	
		while (iterator.hasNext()) {
			Product_viewProductDTO product = iterator.next();
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
		
		
		view.put("product-search-pagination", viewProductPagination(datas.getValue1(), infors.getValue0(), infors.getValue1(), infors.getValue3(), url));
		return view;
	}
	
	
	public static Map<String,String> viewProductProfile(Product_viewProductDTO product_DTO){
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
		
		tmp.append("<div class=\"col-7\">"+((Shop_viewProductDTO) product_DTO.getShop()).getId()+"</div>");
		view.put("seller-name",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<span class=\"mt-4 overflow-y-auto\">"+product_DTO.getNotes()+"</span>");
		view.put("product-notes",tmp.toString());
		tmp.setLength(0);
		
		tmp.append("<a class=\"btn btn-dark col-4\" href=\"/home/shop/profile?id="+((Shop_viewProductDTO) product_DTO.getShop()).getId()+"\">Xem gian hàng</a>");
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
	
	public static Map<String,String> viewProductCart(TreeMap<Product_viewProductDTO,Integer> product_DTOs){
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
	
	public static Map<String,String> viewSeller_ShopProductProfile(
			Product_manageShopDTO product_manageShopDTO){
		Map<String,String> view = new HashMap<String,String>();
		
		view.put("product-name", product_manageShopDTO.getName());
		
		view.put("product-price", ""+product_manageShopDTO.getPrice());
		
		view.put("product-category", ""+product_manageShopDTO.getPc().getName());
		
		view.put("product-notes", product_manageShopDTO.getNotes());
		
		view.put("product-quantity", ""+product_manageShopDTO.getQuantity());
		
		return view; 
	}
	
	
	private static String viewProductAttribute(Product_DTO<Product_AttributeDTO> product) {
		StringBuilder tmp = new StringBuilder();
		Product_AttributeDTO product_AttributeDTO = null;
		PC_DTO pc_DTO = null;
		if (product instanceof Product_viewProductDTO) {
			product_AttributeDTO = ((Product_viewProductDTO) product).getAttribute();
			pc_DTO = ((Product_viewProductDTO) product).getPc();
		}
		
		if (product instanceof Product_manageShopDTO) {
			product_AttributeDTO = ((Product_manageShopDTO) product).getAttribute();
			pc_DTO = ((Product_manageShopDTO) product).getPc();
		}
		
		if (product instanceof Product_manageProductDTO) {
			product_AttributeDTO = ((Product_manageProductDTO) product).getAttribute();
			pc_DTO = ((Product_manageProductDTO) product).getPc();
		}
		
		if (product instanceof Product_viewShopDTO) {
			product_AttributeDTO = ((Product_viewShopDTO) product).getAttribute();
			pc_DTO = ((Product_viewShopDTO) product).getPc();
		}
		
		if (product instanceof Product_manageBillDTO) {
			product_AttributeDTO = ((Product_manageBillDTO) product).getAttribute();
			pc_DTO = ((Product_manageBillDTO) product).getPc();
		}
		
		if (product instanceof Product_viewBillDTO) {
			product_AttributeDTO = ((Product_viewBillDTO) product).getAttribute();
			pc_DTO = ((Product_viewBillDTO) product).getPc();
		}
		
		switch (Utilities_data_type.getProductAttribute(pc_DTO)) {
		case CASE:
			//case
			tmp.append("<li>Hãng: <span>"+((CaseDTO)product_AttributeDTO).getCase_manufacturer()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((CaseDTO)product_AttributeDTO).getCase_size()+"</span></li>");
			tmp.append("<li>Màu sắc: <span>"+((CaseDTO)product_AttributeDTO).getCase_color()+"</span></li>");		
			break;
		case COOLING:
			//cooling
			tmp.append("<li>Hãng: <span>"+((CoolingDTO)product_AttributeDTO).getCooling_manufacturer()+"</span></li>");
			tmp.append("<li>Phân loại: <span>"+((CoolingDTO)product_AttributeDTO).getCooling_type()+"</span></li>");
			tmp.append("<li>Màu sắc: <span>"+((CoolingDTO)product_AttributeDTO).getCooling_color()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((CoolingDTO)product_AttributeDTO).getCooling_fan_size()+"</span></li>");	
			break;
		case CPU:
			//cpu
			tmp.append("<li>Bộ: <span>"+((CPUDTO)product_AttributeDTO).getCpu_collection()+"</span></li>");
			tmp.append("<li>Socket: <span>"+((CPUDTO)product_AttributeDTO).getCpu_socket()+"</span></li>");
			tmp.append("<li>Số nhân: <span>"+((CPUDTO)product_AttributeDTO).getCpu_cores()+"</span></li>");
			tmp.append("<li>Số luồng: <span>"+((CPUDTO)product_AttributeDTO).getCpu_threads()+"</span></li>");
			tmp.append("<li>Xung nhịp: <span>"+((CPUDTO)product_AttributeDTO).getCpu_speed_ghz()+"</span></li>");
			break;
		case DESKTOP:
			//desktop
			tmp.append("<li>Hãng: <span>"+((DesktopDTO) product_AttributeDTO).getDesktop_manufacturer()+"</span></li>");
			tmp.append("<li>Dòng: <span>"+((DesktopDTO) product_AttributeDTO).getDesktop_type()+"</span></li>");
			tmp.append("<li>CPU: <span>"+((DesktopDTO) product_AttributeDTO).getDesktop_cpu()+"</span></li>");
			tmp.append("<li>GPU: <span>"+((DesktopDTO) product_AttributeDTO).getDesktop_gpu()+"</span></li>");
			tmp.append("<li>RAM: <span>"+((DesktopDTO) product_AttributeDTO).getDesktop_ram_capacity()+" "+((DesktopDTO) product_AttributeDTO).getDesktop_ram_type()+"</span></li>");
			tmp.append("<li>Bộ nhớ: <span>"+((DesktopDTO) product_AttributeDTO).getDesktop_storage()+"</span></li>");		
			tmp.append("<li>Nguồn: <span>"+((DesktopDTO) product_AttributeDTO).getDesktop_power_supply()+"</span></li>");
			break;
		case GRAPHIC_CARD:
			//vga
			tmp.append("<li>Hãng: <span>"+((GraphicsCardDTO)product_AttributeDTO).getGraphics_card_manufacturer()+"</span></li>");
			tmp.append("<li>Phiên bản: <span>"+((GraphicsCardDTO)product_AttributeDTO).getGraphics_card_version()+"</span></li>");
			tmp.append("<li>Xung nhịp: <span>"+((GraphicsCardDTO)product_AttributeDTO).getGraphics_card_speed()+"</span></li>");
			tmp.append("<li>Số nhân: <span>"+((GraphicsCardDTO)product_AttributeDTO).getGraphics_card_cores()+"</span></li>");
			tmp.append("<li>Dung lượng VRAM: <span>"+((GraphicsCardDTO)product_AttributeDTO).getGraphics_card_vram_capacity()+"</span></li>");
			tmp.append("<li>Bộ nguồn khuyến nghị: <span>"+((GraphicsCardDTO)product_AttributeDTO).getGraphics_card_require_psu()+"</span></li>");	
			break;
		case HEADPHONE:
			//Headphone
			tmp.append("<li>Hãng: <span>"+((HeadphoneSpeakerDTO)product_AttributeDTO).getHeadphones_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((HeadphoneSpeakerDTO)product_AttributeDTO).getHeadphone_type()+"</span></li>");
			tmp.append("<li>Kiểu kết nối: <span>"+((HeadphoneSpeakerDTO)product_AttributeDTO).getHeadphones_connection()+"</span></li>");
			tmp.append("<li>Cổng: <span>"+((HeadphoneSpeakerDTO)product_AttributeDTO).getHeadphones_connection_ports()+"</span></li>");
			break;
		case KEYBOARD:
			//Keyboard
			tmp.append("<li>Loại: <span>"+((KeyboardDTO)product_AttributeDTO).getKeyboard_type()+"</span></li>");
			tmp.append("<li>Kiểu kết nối: <span>"+((KeyboardDTO)product_AttributeDTO).getKeyboard_connection_type()+"</span></li>");
			tmp.append("<li>kích thước: <span>"+((KeyboardDTO)product_AttributeDTO).getKeyboard_size_layout()+"</span></li>");
			tmp.append("<li>Led: <span>"+((KeyboardDTO)product_AttributeDTO).getKeyboard_led_backlighting()+"</span></li>");
			break;
		case LAPTOP:
			//laptop
			tmp.append("<li>Hãng: <span>"+((LaptopDTO)product_AttributeDTO).getLaptop_manufacturer()+"</span></li>");
			tmp.append("<li>Dòng: <span>"+((LaptopDTO)product_AttributeDTO).getLaptop_type()+"</span></li>");
			tmp.append("<li>Kích thước màn: <span>"+((LaptopDTO)product_AttributeDTO).getLaptop_screen_size()+"</span></li>");
			tmp.append("<li>CPU: <span>"+((LaptopDTO)product_AttributeDTO).getLaptop_cpu()+"</span></li>");
			tmp.append("<li>RAM: <span>"+((LaptopDTO)product_AttributeDTO).getLaptop_ram()+" GB</span></li>");
			tmp.append("<li>Bộ nhớ: <span>"+((LaptopDTO)product_AttributeDTO).getLaptop_storage()+"</span></li>");
			break;
		case MAINBOARD:
			//Mainboard
			tmp.append("<li>Hãng: <span>"+((MotherboardDTO)product_AttributeDTO).getMotherboard_manufacturer()+"</span></li>");
			tmp.append("<li>Chipset: <span>"+((MotherboardDTO)product_AttributeDTO).getMotherboard_chipset()+"</span></li>");
			tmp.append("<li>Socket: <span>"+((MotherboardDTO)product_AttributeDTO).getMotherboard_socket()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((MotherboardDTO)product_AttributeDTO).getMotherboard_size()+"</span></li>");
			tmp.append("<li>Loại RAM hỗ trợ: <span>"+((MotherboardDTO)product_AttributeDTO).getMotherboard_ram_support()+"</span></li>");
			tmp.append("<li>Số khe RAM: <span>"+((MotherboardDTO)product_AttributeDTO).getMotherboard_ram_slots()+"</span></li>");
			break;
		case MONITOR:
			tmp.append("<li>Hãng: <span>"+((MonitorDTO)product_AttributeDTO).getMonitor_manufacturer()+"</span></li>");
			tmp.append("<li>Dòng: <span>"+((MonitorDTO)product_AttributeDTO).getMonitor_type()+"</span></li>");
			tmp.append("<li>Độ phân giải: <span>"+((MonitorDTO)product_AttributeDTO).getMonitor_resolution()+"</span></li>");
			tmp.append("<li>Tấm nền: <span>"+((MonitorDTO)product_AttributeDTO).getMonitor_panel_type()+"</span></li>");
			tmp.append("<li>Tần số quét: <span>"+((MonitorDTO)product_AttributeDTO).getMonitor_refresh_rate()+"Hz</span></li>");
			tmp.append("<li>Kiểu màn hình: <span>"+((MonitorDTO)product_AttributeDTO).getMonitor_screen_type()+"</span></li>");
			tmp.append("<li>Tốc độ phản hồi: <span>"+((MonitorDTO)product_AttributeDTO).getMonitor_response()+"ms</span></li>");
			break;
		case MOUSE:
			//Mouse
			tmp.append("<li>Hãng: <span>"+((MiceDTO)product_AttributeDTO).getMouse_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((MiceDTO)product_AttributeDTO).getMouse_type()+"</span></li>");
			tmp.append("<li>Kiểu kết nối: <span>"+((MiceDTO)product_AttributeDTO).getMouse_connection_type()+"</span></li>");
			tmp.append("<li>Thiết kế: <span>"+((MiceDTO)product_AttributeDTO).getMouse_design()+"</span></li>");
			tmp.append("<li>Pin: <span>"+((MiceDTO)product_AttributeDTO).getMouse_battery()+"</span></li>");
			break;
		case OTHER:
			
			break;
		case POWER_SUPPLY:
			//PSU
			tmp.append("<li>Hãng: <span>"+((PowerSuppyDTO)product_AttributeDTO).getPsu_manufacturer()+"</span></li>");
			tmp.append("<li>Chứng nhận: <span>"+((PowerSuppyDTO)product_AttributeDTO).getPsu_certification()+"</span></li>");
			tmp.append("<li>Loại cap: <span>"+((PowerSuppyDTO)product_AttributeDTO).getPsu_cable_type()+"</span></li>");
			tmp.append("<li>Kích thước: <span>"+((PowerSuppyDTO)product_AttributeDTO).getPsu_size()+"</span></li>");	
			tmp.append("<li>Công suất: <span>"+((PowerSuppyDTO)product_AttributeDTO).getPsu_power_output()+"</span></li>");	
			break;
		case RAM:
			//RAM
			tmp.append("<li>Hãng: <span>"+((RamDTO)product_AttributeDTO).getRam_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((RamDTO)product_AttributeDTO).getRam_type()+"</span></li>");
			tmp.append("<li>Dung lượng: <span>"+((RamDTO)product_AttributeDTO).getRam_capacity()+"</span></li>");
			tmp.append("<li>Tốc độ: <span>"+((RamDTO)product_AttributeDTO).getRam_bus_speed()+"</span></li>");
			tmp.append("<li>Hỗ trợ: <span>"+((RamDTO)product_AttributeDTO).getRam_standard()+"</span></li>");		
			break;
		case STORAGE:
			//storage
			tmp.append("<li>Hãng: <span>"+((StorageDTO)product_AttributeDTO).getStorage_manufacturer()+"</span></li>");
			tmp.append("<li>Loại: <span>"+((StorageDTO)product_AttributeDTO).getStorage_type()+"</span></li>");
			tmp.append("<li>Dung lượng: <span>"+((StorageDTO)product_AttributeDTO).getStorage_capacity()+"</span></li>");
			tmp.append("<li>Kiểu: <span>"+((StorageDTO)product_AttributeDTO).getStorage_m2_pcie_type()+"</span></li>");
			tmp.append("<li>Tốc độ: <span>"+((StorageDTO)product_AttributeDTO).getStorage_rpm()+"</span></li>");	
			break;
		case USB:
			//usb
			tmp.append("<li>Hãng: <span>"+((UsbDTO)product_AttributeDTO).getUsb_manufacturer()+"</span></li>");
			tmp.append("<li>Dung lượng: <span>"+((UsbDTO)product_AttributeDTO).getUsb_capacity()+"</span></li>");
			break;
		default:
			break;	
		}
		return tmp.toString();
	}
}