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
import utility.Utilities;
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
	private ProductModel product;
	private PCModel pc;
	private UserModel user;
	
	public ShopModel(ConnectionPool cp) {
		this.shop = new ShopImpl(cp);
		this.product = new ProductModel(cp);
		this.pc = new PCModel(cp);
		this.user = new UserModel(cp);
	}
	
	protected void finalize() throws Throwable{
		this.shop = null;
		this.product = null;
		this.pc = null;
		this.user = null;
	}
	
	public ConnectionPool getCP() {
		this.product.releaseCP();
		this.pc.releaseCP();
		this.user.releaseCP();
		return this.shop.getCP();
	}
	
	public void releaseCP() {
		this.shop.releaseCP();
		this.product.releaseCP();
		this.pc.releaseCP();
		this.user.releaseCP();
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
	
	public Shop_viewShopDTO getShopDTOById(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, int id) {
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
		Pair<Pair<ArrayList<Product_manageShopDTO>,Integer>, Product_ShopStatisticDTO> productResultSets = this.product.getProduct_manageShopDTOs(productInfors,shopObject);
		shop_ShopManagerDTO.setStorage(productResultSets.getValue0());
		shop_ShopManagerDTO.setStatistic(productResultSets.getValue1());
		return shop_ShopManagerDTO;	
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
