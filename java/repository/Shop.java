package repository;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.*;

import connection.ShareControl;
import constant.SHOP_EDIT_TYPE;
import entity.ShopObject;
import entity.UserObject;

public interface Shop extends ShareControl{
	//Các phương thức, chức năng cập nhật thông tin nơi làm việc
	public boolean addShop(ArrayList<ShopObject> shopObjects, UserObject currentUser);
	public boolean editShop(ArrayList<ShopObject> shopObjects, SHOP_EDIT_TYPE et, UserObject currentUser);
	public boolean delShop(ArrayList<ShopObject> shopObjects, UserObject currentUser);
	
	//Các phương thức, chức năng lấy thông tin nơi làm việc
	public ResultSet getShopById(int id);
	public ArrayList<ResultSet> getShops(
			Quartet<ShopObject, Integer, String, Byte> infors, UserObject currentUser);
}
