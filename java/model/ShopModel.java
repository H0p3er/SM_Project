package model;

import java.sql.*;
import java.util.*;
import org.javatuples.*;
import repository.*;
import utility.Utilities;
import connection.*;
import entity.*;
import constant.*;
import dto.*;
import dto.bill.Bill_manageShopDTO;
import dto.pc.*;
import dto.product.*;
import dto.shop.*;
import dto.user.*;

public class ShopModel {
	
	private Shop shop;
//	private ProductModel product;
//	private PCModel pc;
//	private UserModel user;
//	private BillModel bill;
	
	public ShopModel(ConnectionPool cp) {
		this.shop = new ShopImpl(cp);
//		this.product = new ProductModel(cp);
//		this.pc = new PCModel(cp);
//		this.user = new UserModel(cp);
//		this.bill = new BillModel(cp);
	}
	
	protected void finalize() throws Throwable{
		this.shop = null;
//		this.product = null;
//		this.pc = null;
//		this.user = null;
//		this.bill = null;
	}
	
	public ConnectionPool getCP() {
//		this.product.releaseCP();
//		this.pc.releaseCP();
//		this.user.releaseCP();
//		this.bill.releaseConnection();
		return this.shop.getCP();
	}
	
	public void releaseCP() {
		this.shop.releaseCP();
//		this.product.releaseCP();
//		this.pc.releaseCP();
//		this.user.releaseCP();
//		this.bill.releaseConnection();
	}

	//***********************Chuyen huong dieu khien tu Shop Impl*****************************************
	public boolean addShop(Shop_DTO shop_DTO) {
		UserObject userObject = new UserObject();
		ShopObject shopObject = new ShopObject();
		shop_DTO.applyToEntity(shopObject, userObject);
		return this.shop.addShop(shopObject, userObject);
	}
	
	public boolean editShop(Shop_DTO shop_DTO, SHOP_EDIT_TYPE et) {
		UserObject userObject = new UserObject();
		ShopObject shopObject = new ShopObject();
		shop_DTO.applyToEntity(shopObject, userObject);
		return this.shop.editShop(shopObject, et, userObject);
	}
	
	public boolean delShop(Shop_DTO shop_DTO) {
		UserObject userObject = new UserObject();
		ShopObject shopObject = new ShopObject();
		shop_DTO.applyToEntity(shopObject, userObject);
		return this.shop.delShop(shopObject, userObject);
	}
	
	public Shop_viewShopDTO getShopDTOById(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, int id) {
		Shop_viewShopDTO shop_viewShopDTO = new Shop_viewShopDTO() ;	
		ArrayList<ResultSet> res = this.shop.getShopById(id);	
		ResultSet rs = res.get(0);
		if (rs!=null) {
			try {
				if (rs.next()) {
					shop_viewShopDTO.setId(rs.getInt("shop_id"));
					shop_viewShopDTO.setName(rs.getString("shop_name"));
					shop_viewShopDTO.setAddress(rs.getString("shop_address"));
					shop_viewShopDTO.setImages(rs.getString("shop_images"));
					shop_viewShopDTO.setNotes(rs.getString("shop_notes"));
					shop_viewShopDTO.setCreated_date(rs.getString("shop_created_date"));
					shop_viewShopDTO.setEmail(rs.getString("shop_email"));
					shop_viewShopDTO.setPhone(rs.getString("shop_phone"));
					shop_viewShopDTO.setUser(new User_viewShopDTO(rs.getInt("shop_user_id")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return shop_viewShopDTO;
	}
	
	public Shop_manageShopDTO getShopDTOByUser(
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser) {
		//Lay ban ghi
		ArrayList<ResultSet> shopResultSets = this.shop.getShopByUser(currentUser);				
		ResultSet rs = shopResultSets.get(0);
		//Chuyen doi ban ghi thanh doi tuong
		//Gan gia tri khoi tao cho doi tuong ShopObject		
		ShopObject shopObject = new ShopObject();
		Shop_manageShopDTO shop_ShopManagerDTO = new Shop_manageShopDTO() ;
		if (rs!=null) {
			try {
				if (rs.next()) {
					shop_ShopManagerDTO.setId(rs.getInt("shop_id"));
					shop_ShopManagerDTO.setName(rs.getString("shop_name"));
					shop_ShopManagerDTO.setAddress(Utilities.decode(rs.getString("shop_address")));
					shop_ShopManagerDTO.setImages(rs.getString("shop_images"));
					shop_ShopManagerDTO.setPhone(rs.getString("shop_phone"));
					shop_ShopManagerDTO.setEmail(rs.getString("shop_email"));
					shop_ShopManagerDTO.setNotes(rs.getString("shop_notes"));			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shop_ShopManagerDTO;	
	}
	

	
	public static void main(String[] args) {
	    // Khởi tạo pool kết nối
	    ConnectionPool cp = new ConnectionPoolImpl();
	    
	    // Tạo đối tượng ShopModel
	    ShopModel shopModel = new ShopModel(cp);
	    
	    // Tạo một người dùng hiện tại
	    UserObject currentUser = new UserObject();
	    currentUser.setUser_id(2); // Thiết lập ID của người dùng hiện tại
	    
	    // Tạo thông tin sản phẩm
	    Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors = Quintet.with(
	        (short) 0, // Mã sản phẩm
	        (byte) 0, // Loại sản phẩm
	        new HashMap<String, String>(), // Thông tin tìm kiếm
	        new HashMap<String, String>(), // Thông tin sắp xếp
	        new HashMap<String, String>() // Thông tin lọc
	    );

	    // Gọi phương thức để lấy thông tin cửa hàng dựa trên người dùng
	    Shop_manageShopDTO shopDTO = shopModel.getShopDTOByUser(productInfors, currentUser);
	    
	    // In thông tin cửa hàng
	    System.out.println("Shop ID: " + shopDTO.getId());
	    System.out.println("Shop Name: " + shopDTO.getName());
	    System.out.println("Shop Address: " + shopDTO.getAddress());
	    System.out.println("Shop Images: " + shopDTO.getImages());
	    System.out.println("Shop Phone: " + shopDTO.getPhone());
	    System.out.println("Shop Email: " + shopDTO.getEmail());
	    System.out.println("Shop Notes: " + shopDTO.getNotes());
	    
	    // In thông tin sản phẩm trong kho hàng
	    System.out.println("Products in Storage:");
	    for (Product_manageShopDTO productDTO : shopDTO.getStorage().getValue0()) {
	        System.out.println("Product ID: " + productDTO.getId());
	        System.out.println("Product Name: " + productDTO.getName());
	        System.out.println("Product Quantity: " + productDTO.getQuantity());
	        System.out.println("Product Price: " + productDTO.getPrice());
	        System.out.println("---------------------------------");
	    }
	    
	    // In thông tin thống kê cửa hàng
	    System.out.println("Shop Statistics:");
	    Shop_statisticDTO statisticDTO = shopDTO.getStatistic();
	    System.out.println("Income in Current Month: " + statisticDTO.getSum_income_current_month());
	    System.out.println("Order Count in Current Month: " + statisticDTO.getCount_order_current_month());
	    System.out.println("Customer Count in Current Month: " + statisticDTO.getCount_customer_current_month());
	}

}
