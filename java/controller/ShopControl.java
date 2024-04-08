package controller;

import java.util.*;

import org.apache.tomcat.jni.Library;
import org.javatuples.*;
import connection.*;
import constant.SHOP_EDIT_TYPE;
import constant.SHOP_SORT_TYPE;
import dto.ShopDTO;
import entity.UserObject;
import entity.ProductObject;
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
	
	public void releaseConnection() {
		this.shopModel.releaseCP();
	}

	
	public boolean addShop(ShopDTO wItem, UserObject currentUser) {
		return this.shopModel.addShop(wItem, currentUser);		
	}
	
	public boolean editShop(ShopObject wItem, SHOP_EDIT_TYPE et, UserObject currentUser) {
		return this.shopModel.editShop(wItem, et, currentUser);
	}
	
	public boolean delShop(ShopObject wItem, UserObject currentUser) {
		return this.shopModel.delShop(wItem, currentUser);
	}

	
	public ArrayList<String> displayShopDetail(int id){
		ShopDTO shopDTO = this.shopModel.getShopDTOById(id);
		return ShopLibrary.viewShop(shopDTO);
	}
	
	public ArrayList<String> displayShopDetail(UserObject currentUser){
		ShopDTO shopObject = this.shopModel.getShopDTOByUser(currentUser);
		return ShopLibrary.viewUserShop(shopObject);
	}

}
