package controller;

import java.util.*;

import org.apache.tomcat.jni.Library;
import org.javatuples.*;
import connection.*;
import constant.SHOP_EDIT_TYPE;
import constant.SHOP_SORT_TYPE;
import dto.ShopDTO;
import dto.seller.SellerShopDTO;
import dto.seller.SellerShopStatisticDTO;
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
	
	public void releaseCP() {
		this.shopModel.releaseCP();
	}

	
	public boolean addShop(ShopDTO shopDTO, UserObject currentUser) {
		return this.shopModel.addShop(shopDTO, currentUser);		
	}
	
	public boolean editShop(ShopDTO shopDTO, SHOP_EDIT_TYPE et, UserObject currentUser) {
		return this.shopModel.editShop(shopDTO, et, currentUser);
	}
	
	public boolean delShop(ShopDTO wItem, UserObject currentUser) {
		return this.shopModel.delShop(wItem, currentUser);
	}

	
	public ArrayList<String> displayShopProfile(Triplet<String, Short, Byte> infors, int id){
		ShopDTO shopDTO = this.shopModel.getShopDTOById(infors,id);
		return ShopLibrary.viewShop(shopDTO);
	}
	
	public Map<String,String> displaySellerShopProfile(Triplet<String, Short, Byte> infors, UserObject currentUser){
		Pair<SellerShopDTO,SellerShopStatisticDTO> userShopDTO = this.shopModel.getShopDTOByUser(infors,currentUser);
		return ShopLibrary.viewSellerShopProfile(userShopDTO);
	}

}
