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
import dto.pc.PC_DTO;
import dto.product.Product_DTO;
import dto.product.Product_ShopStatisticDTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_viewProductDTO;
import dto.product.Product_viewShopDTO;
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
	private Product product;
	private PCModel pc;
	
	public ProductModel(ConnectionPool cp) {
		this.product = new ProductImpl(cp);
		this.pc = new PCModel(cp);
	}
	protected void finalize() throws Throwable {
		this.product = null;
		this.pc = null;
	}
	public ConnectionPool getCP() {
		return this.product.getCP();
	}
	public void releaseCP() {
		this.product.releaseCP();
		this.pc.releaseCP();
	}
	public boolean addProduct(Product_DTO item) {
		return this.product.addProduct(item);
	}
	public boolean editProduct(Product_DTO item, PRODUCT_EDIT_TYPE type) {
		return this.product.editProduct(item, type);
	}
	public boolean delProduct(Product_DTO item) {
		return this.product.delProduct(item);
	}

	public Product_DTO getProductDTO(int id) {
		Product_DTO item = null;
		ResultSet rs = this.product.getProductById(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = setProductAttribute(rs);;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public Pair<ArrayList<Product_DTO>, Integer> getProductDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {	
		short page = infors.getValue0();
		byte productPerPage = infors.getValue1();	
		Map<String,String> multiField = infors.getValue2();
		Map<String,String> multiCondition = infors.getValue3();
		Map<String,String> multiSort = infors.getValue4();		
		ArrayList<Product_DTO> items = new ArrayList<>();
		int at = (page - 1) * productPerPage;
		ArrayList<ResultSet> res = this.product.getProducts(at, productPerPage, multiField, multiCondition, multiSort);
		ResultSet rs = res.get(0);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				while (rs.next()) {				
					Product_DTO item = setProductAttribute(rs);
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(1);
		int product_count = getProductSize(rs);
		return new Pair<>(items, product_count);
	}
	
	public Pair<ArrayList<Product_DTO>, ArrayList<Product_DTO>> getProductObjects() {		
		ArrayList<Product_DTO> items1 = new ArrayList<>();
		ArrayList<ResultSet> res = this.product.getProducts();
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				while (rs.next()) {				
					Product_DTO item = setProductAttribute(rs);
					items1.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		ArrayList<Product_DTO> items2 = new ArrayList<>();
		rs = res.get(1);
		if (rs != null) {
			try {
				while (rs.next()) {				
					Product_DTO item = setProductAttribute(rs);	
					items2.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Pair<>(items1, items2);
	}	

	public Pair<ArrayList<Product_manageShopDTO>,Integer> getProduct_manageShopDTOs(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, ShopObject shopObject) {
		Short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();	
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;	
		ArrayList<Product_manageShopDTO> product_manageShopDTOs = new ArrayList<Product_manageShopDTO>();	
		ArrayList<ResultSet> resultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);	
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				while (rs.next()) {
					Product_manageShopDTO product_ShopManagerDTO = new Product_manageShopDTO();
					product_ShopManagerDTO.setId(rs.getInt("product_id"));
					product_ShopManagerDTO.setName(rs.getString("product_name"));
					product_ShopManagerDTO.setQuantity(rs.getInt("product_quantity"));
					product_ShopManagerDTO.setPrice(rs.getDouble("product_price"));
					product_manageShopDTOs.add(product_ShopManagerDTO);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = resultSets.get(1);
		int count_product = getProductSize(rs);
		return new Pair<>(product_manageShopDTOs,count_product);
	}
	
	public Pair<ArrayList<Product_viewShopDTO>,Integer> getProduct_viewShopDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, ShopObject shopObject) {
		Short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();	
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;	
		ArrayList<Product_viewShopDTO> product_viewShopDTOs = new ArrayList<Product_viewShopDTO>();	
		ArrayList<ResultSet> resultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);	
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				while (rs.next()) {
					Product_viewShopDTO product_viewShopDTO = new Product_viewShopDTO();
					product_viewShopDTO.setId(rs.getInt("product_id"));
					product_viewShopDTO.setName(rs.getString("product_name"));
					product_viewShopDTO.setQuantity(rs.getInt("product_quantity"));
					product_viewShopDTO.setPrice(rs.getDouble("product_price"));
					product_viewShopDTOs.add(product_viewShopDTO);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = resultSets.get(1);
		int count_product = getProductSize(rs);
		return new Pair<>(product_viewShopDTOs,count_product);
	}	
	
	private Product_DTO setProductAttribute(ResultSet rs) {
		try {	
			Product_DTO item = new Product_DTO();
			item.setProduct_id(rs.getInt("product_id"));
			item.setProduct_pc(new PC_DTO(rs.getInt("product_pc_id")));
			switch (rs.getInt("product_pc_id")) {
			case 1:
				item = this.pc.getProduct_MonitorDTO(item);	
				break;						
			case 2:
				item = this.pc.getProduct_KeyboardDTO(item);	
				break;
			case 3:
				item = this.pc.getProduct_MiceDTO(item);	
				break;					
			case 4:
				item = this.pc.getProduct_HeadphoneSpeakerDTO(item);	
				break;						
			case 5:	
				item = this.pc.getProduct_LaptopDTO(item);
				break;						
			case 6:
				item = this.pc.getProduct_DesktopDTO(item);		
				break;						
			case 7:	
				item = this.pc.getProduct_CPUDTO(item);
				break;						
			case 8:
				item = this.pc.getProduct_MotherboardDTO(item);
				break;						
			case 9:	
				item = this.pc.getProduct_RamDTO(item);					
				break;		
			case 10:
				item = this.pc.getProduct_StorageDTO(item);	
				break;				
			case 11:
				item = this.pc.getProduct_GraphicsCardDTO(item);
				break;						
			case 12:
				item = this.pc.getProduct_PowerSuppyDTO(item);		
				break;						
			case 13:
				item = this.pc.getProduct_CaseDTO(item);	
				break;				
			case 14:
				item = this.pc.getProduct_CoolingDTO(item);				
				break;	
			}
			item.setProduct_pc(new PC_DTO(rs.getInt("product_pc_id")));
			item.setProduct_id(rs.getInt("product_id"));
			item.setProduct_name(Utilities.decode(rs.getString("product_name")));
			item.setProduct_status(rs.getByte("product_status"));
			item.setProduct_price(rs.getDouble("product_price"));
			item.setProduct_images(rs.getString("product_images"));
			item.setProduct_notes(rs.getString("product_notes"));
			item.setProduct_last_modified(rs.getString("product_last_modified"));
			item.setProduct_shop_id(rs.getInt("product_shop_id"));
			item.setProduct_quantity(rs.getInt("product_quantity"));
			
			return item;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	private int getProductSize(ResultSet rs) {
		int count_product = 0;
		if (rs!=null) {
			try {
				if (rs.next()) {
					count_product = rs.getInt("product_count");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return count_product;
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

		ArrayList<Product_DTO> rs1 = u.getProductDTO(new Quintet<Short, Byte, Map<String, String> ,Map<String, String>, Map<String, String>>((short) 0,(byte) 0, new HashMap<String, String>(), new HashMap<String, String>(), new HashMap<String, String>())).getValue0();
		String row = null;

		if (rs1!=null) {
			rs1.forEach(product->{
				if (product instanceof Product_CaseDTO) {
					System.out.println("object:"+((Product_CaseDTO) product).getProduct_name());
				}
				
				if (product instanceof Product_LaptopDTO) {
					System.out.println("object:"+((Product_LaptopDTO) product).getLaptop_ram());
				}
				
				if (product instanceof Product_CoolingDTO) {
					System.out.println("object:"+((Product_CoolingDTO) product).getProduct_name());
				}	
	
			});	
		}
	}
}
