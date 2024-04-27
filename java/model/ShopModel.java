package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import repository.*;
import connection.*;
import entity.*;
import constant.*;
import dto.*;
import dto.pc.PC_ShopManagerDTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_ShopStatisticDTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_viewShopDTO;
import dto.user.User_viewShopDTO;

public class ShopModel {
	
	private Shop shop;
	private Product product;
	private PC pc;
	
	public ShopModel(ConnectionPool cp) {
		this.shop = new ShopImpl(cp);
		this.product = new ProductImpl(cp);
		this.pc = new PCImpl(cp);
	}
	
	protected void finalize() throws Throwable{
		this.shop=null;
		this.product=null;
		this.pc = null;
	}
	
	public ConnectionPool getCP() {
		return this.shop.getCP();
	}
	
	public void releaseCP() {
		this.shop.releaseCP();
		this.product.releaseCP();
		this.pc.releaseCP();
	}

	//***********************Chuyen huong dieu khien tu Shop Impl*****************************************
	public boolean addShop(Shop_viewShopDTO shop_viewShopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shop_viewShopDTO.applyToEntity(shopObject);
		return this.shop.addShop(shopObject, currentUser);
	}
	
	public boolean editShop(Shop_viewShopDTO shop_viewShopDTO, SHOP_EDIT_TYPE et, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shop_viewShopDTO.applyToEntity(shopObject);
		return this.shop.editShop(shopObject, et, currentUser);
	}
	
	public boolean delShop(Shop_viewShopDTO shop_viewShopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shop_viewShopDTO.applyToEntity(shopObject);
		return this.shop.delShop(shopObject, currentUser);
	}
	
	public Shop_viewShopDTO getShopDTOById(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors,int id) {
		ShopObject shopObject = new ShopObject();
		Shop_viewShopDTO shop_viewShopDTO = new Shop_viewShopDTO() ;
		
		Short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();
		
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;
		ArrayList<ResultSet> res = this.shop.getShopById(id);
		
		ResultSet rs = res.get(0);

		if (rs!=null) {
			try {
				if (rs.next()) {
					shopObject.setShop_id(rs.getInt("shop_id"));
					shopObject.setShop_name(rs.getString("shop_name"));
					shopObject.setShop_address(rs.getString("shop_address"));
					shopObject.setShop_images(rs.getString("shop_images"));
					shopObject.setShop_notes(rs.getString("shop_notes"));			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<ResultSet> productResultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);
		shop_viewShopDTO.setStorage(getShopStorage(productResultSets.get(0)));
		return shop_viewShopDTO;
	}
	
	public Shop_manageShopDTO getShopDTOByUser(
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser) {
		//Lay ban ghi 

		Short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();
		
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;
		
		ArrayList<ResultSet> shopResultSets = this.shop.getShopByUser(currentUser);		
		
		ResultSet rs = shopResultSets.get(0);
		//Chuyen doi ban ghi thanh doi tuong
		//Gan gia tri khoi tao cho doi tuong ShopObject
		
		ShopObject shopObject = new ShopObject();
		Shop_manageShopDTO shop_ShopManagerDTO = new Shop_manageShopDTO() ;

		if (rs!=null) {
			try {
				if (rs.next()) {
					shopObject.setShop_id(rs.getInt("shop_id"));
					shopObject.setShop_name(rs.getString("shop_name"));
					shopObject.setShop_address(rs.getString("shop_address"));
					shopObject.setShop_images(rs.getString("shop_images"));
					shopObject.setShop_notes(rs.getString("shop_notes"));			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		shop_ShopManagerDTO.setStorage(new ArrayList<Product_manageShopDTO>());		
		ArrayList<ResultSet> productResultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);
		
		shop_ShopManagerDTO.setStorage(getShopStorage(productResultSets.get(0)));
		shop_ShopManagerDTO.setStatistic(getShopStatisticDTO(productResultSets));
		
		
		return shop_ShopManagerDTO;	
	}
	
	
	//****************************************************************

	private int getProductSize(ResultSet rs) {
		int count_product = 0;
		if (rs!=null) {
			try {
				if (rs.next()) {
					count_product = rs.getInt("count_product");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count_product;
	}


	private Product_ShopStatisticDTO getShopStatisticDTO(ArrayList<ResultSet> productResultSets) {	
		Product_ShopStatisticDTO product_ShopStatisticDTO = new Product_ShopStatisticDTO();	
		ResultSet rs = productResultSets.get(2);
		
		Map<String, Double> sold_price_by_date = new HashMap<String, Double>();
		if (rs!=null) {
			try {			
				while (rs.next()) {			
					sold_price_by_date.put(rs.getString("bill_created_date"), rs.getDouble("sold_price_by_month"));
					product_ShopStatisticDTO.setSold_price_current_month(sold_price_by_date);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		rs = productResultSets.get(3);
		sold_price_by_date = new HashMap<String, Double>();
		if (rs!=null) {
			try {			
				while (rs.next()) {
					sold_price_by_date.put(rs.getString("bill_created_date"), rs.getDouble("sold_price_by_month"));
					product_ShopStatisticDTO.setSold_price_last_month(sold_price_by_date);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return product_ShopStatisticDTO;
	}

	private ArrayList<Product_manageShopDTO> getShopStorage(ResultSet rs) {
		ArrayList<Product_manageShopDTO> product_manageShopDTOs = new ArrayList<Product_manageShopDTO>();
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
		
		return product_manageShopDTOs;
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
