package controller;

import java.util.*;

import org.apache.tomcat.jni.Library;
import org.javatuples.*;
import connection.*;
import constant.SHOP_EDIT_TYPE;
import dto.product.Product_DTO;
import dto.product.Product_manageShopDTO;
import dto.shop.Shop_DTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_statisticDTO;
import dto.shop.Shop_viewShopDTO;
import entity.UserObject;
import entity.ShopObject;
import library.*;
import model.ShopModel;


public class ShopControl {
	private ShopModel shopModel;
	
	public ShopControl(ConnectionPool cp) {
		this.shopModel = new ShopModel(cp);
		
	}
	
	public ConnectionPool getCP() {
		return this.shopModel.getCP();
	}
	
	public void releaseCP() {
		this.shopModel.releaseCP();
	}

	
	public boolean addShop(Shop_DTO shop_DTO) {		
		return this.shopModel.addShop(shop_DTO);		
	}
	
	public boolean editShop(Shop_DTO shop_DTO, SHOP_EDIT_TYPE et) {
		return this.shopModel.editShop(shop_DTO, et);
	}
	
	public boolean delShop(Shop_DTO shop_DTO) {
		return this.shopModel.delShop(shop_DTO);
	}

	
	public Map<String,String> viewShop_Profile(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, int id){
		Shop_viewShopDTO shopDTO = this.shopModel.getShopDTOById(productInfors,id);
		return ShopLibrary.viewShop_Profile(shopDTO);
	}

	public Map<String,String> viewSeller_ShopStatistic(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser){
		Shop_manageShopDTO shopDTO = this.shopModel.getShopDTOByUser(productInfors,currentUser);
		return ShopLibrary.viewSeller_ShopStatistic(shopDTO);
	}
	
	public Map<String,String> viewSeller_ShopProduct(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser){
		Shop_manageShopDTO shopDTO = this.shopModel.getShopDTOByUser(productInfors,currentUser);
		return ShopLibrary.viewSeller_ShopProduct(shopDTO);
	}
	
	public Map<String,String> viewSeller_ShopBill(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser){
		Shop_manageShopDTO shopDTO = this.shopModel.getShopDTOByUser(productInfors,currentUser);
		return ShopLibrary.viewSeller_ShopProduct(shopDTO);
	}
	
	public Map<String,String> viewSeller_ShopProfile(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser){
		Shop_manageShopDTO shop_manageShopDTO = this.shopModel.getShopDTOByUser(productInfors,currentUser);
		return ShopLibrary.viewSeller_ShopProfile(shop_manageShopDTO);
	}

}
