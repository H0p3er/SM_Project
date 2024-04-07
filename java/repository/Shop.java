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
	public boolean addShop(ShopObject shopObjects, UserObject currentUser);
	public boolean editShop(ShopObject shopObjects, SHOP_EDIT_TYPE et, UserObject currentUser);
	public boolean delShop(ShopObject shopObjects, UserObject currentUser);
	
	//Các phương thức, chức năng lấy thông tin nơi làm việc
	public ArrayList<ResultSet> getShopById(int id);
	public ArrayList<ResultSet> getShopByUser(UserObject currentUser);
	public ArrayList<ResultSet> getShops(
			Quartet<ShopObject, Integer, Byte, String> infors, UserObject currentUser);
}
