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
import dto.pc.*;
import dto.product.*;
import dto.shop.*;
import dto.user.*;

public class ShopModel {
	
	private Shop shop;
	private ProductModel product;
	private PCModel pc;
	private UserModel user;
	private BillModel bill;
	
	public ShopModel(ConnectionPool cp) {
		this.shop = new ShopImpl(cp);
		this.product = new ProductModel(cp);
		this.pc = new PCModel(cp);
		this.user = new UserModel(cp);
		this.bill = new BillModel(cp);
	}
	
	protected void finalize() throws Throwable{
		this.shop = null;
		this.product = null;
		this.pc = null;
		this.user = null;
		this.bill = null;
	}
	
	public ConnectionPool getCP() {
		this.product.releaseCP();
		this.pc.releaseCP();
		this.user.releaseCP();
		this.bill.releaseConnection();
		return this.shop.getCP();
	}
	
	public void releaseCP() {
		this.shop.releaseCP();
		this.product.releaseCP();
		this.pc.releaseCP();
		this.user.releaseCP();
		this.bill.releaseConnection();
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
					shop_viewShopDTO.setUser(this.user.getSellerById(rs.getInt("shop_user_id")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ShopObject shopObject = new ShopObject();
		shopObject.setShop_id(shop_viewShopDTO.getId());
		shop_viewShopDTO.setStorage(this.product.getProduct_viewShopDTO(productInfors,shopObject));	
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
		shop_ShopManagerDTO.applyToEntity(shopObject, currentUser);
		Triplet<List<Product_manageShopDTO>,Integer, List<Pair<Product_manageShopDTO,Double>>> productResultSets = this.product.getProduct_manageShopDTO(productInfors,shopObject);
		shop_ShopManagerDTO.setStorage(new Pair<>(productResultSets.getValue0(),productResultSets.getValue1()));
		shop_ShopManagerDTO.setStatistic(getShopStatisticDTO(productResultSets.getValue2(), shopObject));;
		return shop_ShopManagerDTO;	
	}
	

	private Shop_statisticDTO getShopStatisticDTO(List<Pair<Product_manageShopDTO,Double>> most_sold_product_current_month, ShopObject shopObject) {	
		Shop_statisticDTO shop_StatisticDTO = new Shop_statisticDTO();	
		shop_StatisticDTO.setMost_sold_product_current_month(most_sold_product_current_month);
		
		Triplet<Map<String,Double>, Double, Double> income_statistic = this.bill.getIncomeStatisticByShop(shopObject);
		Triplet<Map<String,Integer>,Integer,Integer> order_statistic = this.bill.getOrderStatisticByShop(shopObject);
		Triplet<Map<String,Integer>,Integer,Integer> customer_statistic = this.user.getCustomerStatisticByShop(shopObject);
		
		shop_StatisticDTO.setIncome_current_month(income_statistic.getValue0());
		shop_StatisticDTO.setSum_income_current_month(income_statistic.getValue1());
		shop_StatisticDTO.setSum_income_last_month(income_statistic.getValue2());
		
		shop_StatisticDTO.setOrder_current_month(order_statistic.getValue0());
		shop_StatisticDTO.setCount_order_current_month(order_statistic.getValue1());
		shop_StatisticDTO.setCount_order_last_month(order_statistic.getValue2());
		
		shop_StatisticDTO.setCustomer_current_month(customer_statistic.getValue0());
		shop_StatisticDTO.setCount_customer_current_month(customer_statistic.getValue1());
		shop_StatisticDTO.setCount_customer_last_month(customer_statistic.getValue2());
		return shop_StatisticDTO;
	}
	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc Shop
		ShopModel u=new ShopModel(cp);
		
		//Them mot nguoi su dung
		ShopObject new_Shop = new ShopObject();
		new_Shop.setShop_name("Kho hàng Nguyên");
		new_Shop.setShop_user_id(19);
		new_Shop.setShop_address("Lâm Đồng");
		new_Shop.setShop_created_date("29/12/2003");
		UserObject currentUser = new UserObject();
		currentUser.setUser_name("Tran The Hưởng");
		currentUser.setUser_id((byte)2);


	}
		
}
