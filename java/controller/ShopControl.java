package controller;

import java.util.*;

import org.apache.tomcat.jni.Library;
import org.javatuples.*;
import connection.*;
import constant.SHOP_EDIT_TYPE;
import dto.product.Product_DTO;
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

	
	public boolean addShop(Shop_viewShopDTO shopDTO, UserObject currentUser) {
		return this.shopModel.addShop(shopDTO, currentUser);		
	}
	
	public boolean editShop(Shop_viewShopDTO shopDTO, SHOP_EDIT_TYPE et, UserObject currentUser) {
		return this.shopModel.editShop(shopDTO, et, currentUser);
	}
	
	public boolean delShop(Shop_viewShopDTO wItem, UserObject currentUser) {
		return this.shopModel.delShop(wItem, currentUser);
	}

	
	public Map<String,String> displayShop_Profile(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, int id){
		Shop_viewShopDTO shopDTO = this.shopModel.getShopDTOById(productInfors,id);
		return ShopLibrary.viewShop_Profile(shopDTO);
	}

	public Map<String,String> displaySeller_ShopStatistic(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser){
		Shop_manageShopDTO shopDTO = this.shopModel.getShopDTOByUser(productInfors,currentUser);
		return ShopLibrary.viewSeller_ShopStatistic(shopDTO);
	}

}
