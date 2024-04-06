package repository;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Sextet;

import connection.ShareControl;
import constant.SHOP_EDIT_TYPE;
import constant.SHOP_SORT_TYPE;
import entity.ProductObject;
import entity.ShopObject;
import entity.UserObject;

public interface Shop extends ShareControl{
	//Các phương thức, chức năng cập nhật thông tin nơi làm việc
	public boolean addShop(ArrayList<ShopObject> shopObjects, ArrayList<ProductObject> productObjects);
	public boolean editShop(ArrayList<ShopObject> shopObjects, ArrayList<ProductObject> productObjects, SHOP_EDIT_TYPE et);
	public boolean delShop(ArrayList<ShopObject> shopObjects);
	
	//Các phương thức, chức năng lấy thông tin nơi làm việc
	public ResultSet getShopById(int id);
	public ArrayList<ResultSet> getShops(Sextet<UserObject, 
			ShopObject, 
			Integer, 
			Byte ,
			SHOP_SORT_TYPE,
			Boolean> infors);
}
