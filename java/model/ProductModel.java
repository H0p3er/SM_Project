package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quintet;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.PRODUCT_EDIT_TYPE;
import dto.product.Product_ShopStatisticDTO;
import dto.product.Product_viewProductDTO;
import dto.productAttribute.Product_CPUDTO;
import dto.productAttribute.Product_CaseDTO;
import dto.productAttribute.Product_CoolingDTO;
import dto.productAttribute.Product_DesktopDTO;
import dto.productAttribute.Product_GraphicsCardDTO;
import dto.productAttribute.Product_HeadphoneSpeakerDTO;
import dto.productAttribute.Product_KeyboardDTO;
import dto.productAttribute.Product_LaptopDTO;
import dto.productAttribute.Product_MiceDTO;
import dto.productAttribute.Product_MonitorDTO;
import dto.productAttribute.Product_MotherboardDTO;
import dto.productAttribute.Product_PowerSuppyDTO;
import dto.productAttribute.Product_RamDTO;
import dto.productAttribute.Product_StorageDTO;
import dto.shop.Shop_manageShopDTO;
import repository.*;
import entity.ProductObject;
import entity.ShopObject;
import entity.UserObject;
import utility.Utilities;

public class ProductModel {
	private Product p;
	private PC pc;
	public ProductModel(ConnectionPool cp) {
		this.p = new ProductImpl(cp);
		this.pc = new PCImpl(cp);
	}
	protected void finalize() throws Throwable {
		this.p = null;
		this.pc = null;
	}
	public ConnectionPool getCP() {
		return this.p.getCP();
	}
	public void releaseConnection() {
		this.p.releaseCP();
		this.pc.releaseCP();
	}
	public boolean addProduct(ProductObject item) {
		return this.p.addProduct(item);
	}
	public boolean editProduct(ProductObject item, PRODUCT_EDIT_TYPE type) {
		return this.p.editProduct(item, type);
	}
	public boolean delProduct(ProductObject item) {
		return this.p.delProduct(item);
	}

	public ProductObject getProductObject(int id) {
		ProductObject item = null;
		ResultSet rs = this.p.getProductById(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = setProductObject(rs);;
					
					System.out.println(item.getProduct_id());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public Pair<ArrayList<ProductObject>, Integer> getProductObjects(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {	
		short page = infors.getValue0();
		byte productPerPage = infors.getValue1();	
		Map<String,String> multiField = infors.getValue2();
		Map<String,String> multiCondition = infors.getValue3();
		Map<String,String> multiSort = infors.getValue4();		
		ArrayList<ProductObject> items = new ArrayList<>();

		int at = (page - 1) * productPerPage;
		ArrayList<ResultSet> res = this.p.getProducts(at, productPerPage, multiField, multiCondition, multiSort);
		ResultSet rs = res.get(0);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				while (rs.next()) {				
					ProductObject item = setProductObject(rs);
					System.out.println(item.getProduct_id());
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(1);
		int product_count = getProductObjectsSize(rs);
		return new Pair<>(items, product_count);
	}
	
	public Pair<ArrayList<ProductObject>, ArrayList<ProductObject>> getProductObjects() {		
		ArrayList<ProductObject> items1 = new ArrayList<>();
		ArrayList<ResultSet> res = this.p.getProducts();
		ResultSet rs = res.get(0);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				while (rs.next()) {				
					ProductObject item = setProductObject(rs);
					items1.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<ProductObject> items2 = new ArrayList<>();
		rs = res.get(1);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				while (rs.next()) {				
					ProductObject item = setProductObject(rs);
					System.out.println(item.getProduct_id());
					items2.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Pair<>(items1, items2);
	}
	

	private int getProductObjectsSize(ResultSet rs) {
		int product_count = 0;
		if (rs != null) {
			try {
				if (rs.next()) {
					product_count = rs.getInt("product_count");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return product_count;
	}
	
	private ProductObject setProductObject(ResultSet rs) {
		ProductObject item = new ProductObject();
		try {	
			switch (rs.getInt("product_pc_id")) {
			case 1:
				item = getProduct_MonitorDTO(rs);	
				break;						
			case 2:
				item = getProduct_KeyboardDTO(rs);	
				break;					
			case 3:
				item = getProduct_MiceDTO(rs);	
				
				break;					
			case 4:
				item = getProduct_HeadphoneSpeakerDTO(rs);	
				break;						
			case 5:	
				item = getProduct_LaptopDTO(rs);			
				break;						
			case 6:
				item = getProduct_DesktopDTO(rs);		
				break;						
			case 7:	
				item = getProduct_CPUDTO(rs);
				break;						
			case 8:
				item = getProduct_MotherboardDTO(rs);
				break;						
			case 9:	
				item = getProduct_RamDTO(rs);					
				break;		
			case 10:
				item = getProduct_StorageDTO(rs);	
				break;				
			case 11:
				item = getProduct_GraphicsCardDTO(rs);
				break;						
			case 12:
				item = getProduct_PowerSuppyDTO(rs);		
				break;						
			case 13:
				item = getProduct_CaseDTO(rs);	
				break;				
			case 14:
				item = getProduct_CoolingDTO(rs);
					
				break;	
			}
			item.setProduct_id(rs.getInt("product_id"));
			item.setProduct_name(Utilities.decode(rs.getString("product_name")));
			item.setProduct_status(rs.getByte("product_status"));
			item.setProduct_price(rs.getDouble("product_price"));
			item.setProduct_images(rs.getString("product_images"));
			item.setProduct_notes(rs.getString("product_notes"));
			item.setProduct_last_modified(rs.getString("product_last_modified"));
			item.setProduct_pc_id(rs.getInt("product_pc_id"));
			item.setProduct_shop_id(rs.getInt("product_shop_id"));
			item.setProduct_quantity(rs.getInt("product_quantity"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return item;
	}
	
	private Product_CaseDTO getProduct_CaseDTO(ResultSet rs) throws SQLException {
		Product_CaseDTO item = new Product_CaseDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);	
		if (attribute.next()) {
			((Product_CaseDTO) item).setCase_size(attribute.getString("case_size"));
			((Product_CaseDTO) item).setCase_manufacturer(attribute.getString("case_manufacturer"));
			((Product_CaseDTO) item).setCase_color(attribute.getString("case_color"));
		}	
		return item;
	}
	
	private Product_CoolingDTO getProduct_CoolingDTO(ResultSet rs) throws SQLException {	
		Product_CoolingDTO item = new Product_CoolingDTO();	
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		if (attribute.next()) {
			((Product_CoolingDTO) item).setCooling_color(attribute.getString("cooling_color"));
			((Product_CoolingDTO) item).setCooling_fan_size(attribute.getString("cooling_fan_size"));
			((Product_CoolingDTO) item).setCooling_manufacturer(attribute.getString("cooling_manufacturer"));
		}
		
		return item;
	}
	
	private Product_CPUDTO getProduct_CPUDTO(ResultSet rs) throws SQLException {	
		Product_CPUDTO item = new Product_CPUDTO();	
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}
	
	private Product_DesktopDTO getProduct_DesktopDTO(ResultSet rs) throws SQLException {	
		Product_DesktopDTO item = new Product_DesktopDTO();	
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}
	
	private Product_GraphicsCardDTO getProduct_GraphicsCardDTO(ResultSet rs) throws SQLException {	
		Product_GraphicsCardDTO item = new Product_GraphicsCardDTO();	
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		
		return item;
	}
	
	private Product_HeadphoneSpeakerDTO getProduct_HeadphoneSpeakerDTO(ResultSet rs) throws SQLException {	
		Product_HeadphoneSpeakerDTO item = new Product_HeadphoneSpeakerDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}
	
	private Product_KeyboardDTO getProduct_KeyboardDTO(ResultSet rs) throws SQLException {	
		Product_KeyboardDTO item = new Product_KeyboardDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}
	
	private Product_LaptopDTO getProduct_LaptopDTO(ResultSet rs) throws SQLException {	
		Product_LaptopDTO item = new Product_LaptopDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		if (attribute.next()) {
			((Product_LaptopDTO) item).setLaptop_manufacturer(attribute.getString("laptop_manufacturer"));
			((Product_LaptopDTO) item).setLaptop_cpu(attribute.getString("laptop_cpu"));
			((Product_LaptopDTO) item).setLaptop_ram(attribute.getInt("laptop_ram"));
		
			((Product_LaptopDTO) item).setLaptop_storage(attribute.getInt("laptop_storage"));
			((Product_LaptopDTO) item).setLaptop_screen_size(attribute.getInt("laptop_screen_size"));
			((Product_LaptopDTO) item).setLaptop_resolution(attribute.getString("laptop_resolution"));
			((Product_LaptopDTO) item).setLaptop_type(attribute.getString("laptop_type"));
		}		
		return item;
	}

	private Product_StorageDTO getProduct_StorageDTO(ResultSet rs) throws SQLException {
		Product_StorageDTO item = new Product_StorageDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}

	private Product_RamDTO getProduct_RamDTO(ResultSet rs)  throws SQLException{
		Product_RamDTO item = new Product_RamDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}

	private Product_PowerSuppyDTO getProduct_PowerSuppyDTO(ResultSet rs)  throws SQLException{
		Product_PowerSuppyDTO item = new Product_PowerSuppyDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}

	private Product_MotherboardDTO getProduct_MotherboardDTO(ResultSet rs)  throws SQLException{
		Product_MotherboardDTO item = new Product_MotherboardDTO();	
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}

	private Product_MonitorDTO getProduct_MonitorDTO(ResultSet rs)  throws SQLException{
		Product_MonitorDTO item = new Product_MonitorDTO();
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}

	private Product_MiceDTO getProduct_MiceDTO(ResultSet rs)  throws SQLException{
		Product_MiceDTO item = new Product_MiceDTO();	
		item.setProduct_pc_id(rs.getInt("product_pc_id"));
		ResultSet attribute = this.pc.getPCByProduct(item);
		return item;
	}
	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc Shop
		ProductModel u= new ProductModel(cp);
		
		//Them mot nguoi su dung
		ShopObject new_Shop = new ShopObject();
		new_Shop.setShop_name("Kho hàng Nguyên");
		new_Shop.setShop_user_id(19);
		new_Shop.setShop_address("Lâm Đồng");
		new_Shop.setShop_created_date("29/12/2003");
		UserObject currentUser = new UserObject();
		currentUser.setUser_name("Tran The Hưởng");
		currentUser.setUser_id((byte)2);

		//Lay tap ban ghi nguoi su dung

		ArrayList<ProductObject> rs1 = u.getProductObjects(new Quintet<Short, Byte, Map<String, String> ,Map<String, String>, Map<String, String>>((short) 0,(byte) 0, new HashMap<String, String>(), new HashMap<String, String>(), new HashMap<String, String>())).getValue0();
		String row = null;

		if (rs1!=null) {
			rs1.forEach(product->{
				if (product instanceof Product_CaseDTO) {
					System.out.println("object:"+((Product_CaseDTO) product).getProduct_name());
				}
				
				if (product instanceof Product_CoolingDTO) {
					System.out.println("object:"+((Product_CoolingDTO) product).getProduct_name());
				}	
	
			});	
		}
	}
}
