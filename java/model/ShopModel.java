package model;

import java.sql.*;
import java.util.ArrayList;

import repository.*;
import connection.*;
import entity.*;
import constant.*;
import dto.*;

public class ShopModel {
	
	private Shop shop;
	
	public ShopModel(ConnectionPool cp) {
		this.shop= new ShopImpl(cp);
	}
	
	protected void finalize() throws Throwable{
		this.shop=null;
	}
	
	public ConnectionPool getCP() {
		return this.shop.getCP();
	}
	
	public void releaseCP() {
		this.shop.releaseCP();
	}

	//***********************Chuyen huong dieu khien tu Shop Impl*****************************************
	public boolean addShop(ShopDTO shopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shopDTO.applyToEntity(shopObject);
		return this.shop.addShop(shopObject, currentUser);
	}
	
	public boolean editShop(ShopDTO shopDTO, SHOP_EDIT_TYPE et, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shopDTO.applyToEntity(shopObject);
		return this.shop.editShop(shopObject, et, currentUser);
	}
	
	public boolean delShop(ShopDTO shopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shopDTO.applyToEntity(shopObject);
		return this.shop.delShop(shopObject, currentUser);
	}
	
	
	//****************************************************************
	
	public ShopDTO getShopDTOById(int id) {
		//Khoi tao cac gia tri cua DTO
		ShopDTO shopDTO = null ;
		ShopSellerDTO shopUserDTO = null;
		
		ArrayList<ResultSet> resultSets = this.shop.getShopById(id);
		
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				if (rs.next()) {
					shopDTO = new ShopDTO();
					shopDTO.setId(rs.getInt("shop_id"));
					shopDTO.setName(rs.getString("shop_name"));
					shopDTO.setAddress(rs.getString("shop_address"));
					shopDTO.setImages(rs.getString("shop_images"));
					shopDTO.setNotes(rs.getString("shop_notes"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ShopProductDTO shopProductDTO = null;
		ArrayList<ShopProductDTO> shopProductDTOs = new ArrayList<ShopProductDTO>();
		ShopPCDTO shopPCDTO = null;
		rs = resultSets.get(1);
		if (rs!=null) {
			try {
				if (rs.next()) {
					shopDTO = new ShopDTO();
					shopDTO.setId(rs.getInt("shop_id"));
					shopDTO.setName(rs.getString("shop_name"));
					shopDTO.setAddress(rs.getString("shop_address"));
					shopDTO.setImages(rs.getString("shop_images"));
					shopDTO.setNotes(rs.getString("shop_notes"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shopDTO;
		
		
	}
	
	public ShopDTO getShopDTOByUser(UserObject currentUser) {
		//Gan gia tri khoi tao cho doi tuong ShopObject
		ShopDTO shopDTO = null ;
		ShopSellerDTO shopUserDTO = null;
		ArrayList<ShopProductDTO> shopProductDTOs = new ArrayList<ShopProductDTO>();
		//Lay ban ghi 
		ArrayList<ResultSet> resultSets = this.shop.getShopByUser(currentUser);
		
		ResultSet rs = resultSets.get(0);
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				if (rs.next()) {
					shopDTO = new ShopDTO();
					shopDTO.setId(rs.getInt("shop_id"));
					shopDTO.setName(rs.getString("shop_name"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shopDTO;
	}
		
}
