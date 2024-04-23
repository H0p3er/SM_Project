package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.javatuples.*;

import connection.ShareControl;
import constant.SHOP_EDIT_TYPE;
import entity.ProductObject;
import entity.ShopObject;
import entity.UserObject;

public interface Shop extends ShareControl{
	//Các phương thức, chức năng cập nhật thông tin nơi làm việc
	public boolean addShop(ShopObject shopObjects, UserObject currentUser);
	public boolean editShop(ShopObject shopObjects, SHOP_EDIT_TYPE et, UserObject currentUser);
	public boolean delShop(ShopObject shopObjects, UserObject currentUser);
	
	//Các phương thức, chức năng lấy thông tin nơi làm việc
	public ArrayList<ResultSet> getShopById(String filter, int pagePos, byte pageLength, int id);
	public ArrayList<ResultSet> getShopByUser(UserObject currentUser);
	
	
	/** 
	 * Phương thức trả về danh sách giao diện cho phần trình bày danh sách product
	 * @param at :vị trí bản ghi
	 * @param total :số lượng bản ghi/trang
	 * @param total :số lượng bản ghi/trang
	 * @param total :số lượng bản ghi/trang
	 * @param total :số lượng bản ghi/trang
	 * @return ArrayList<ResultSet> Danh sách bản ghi
	 * 
	 * <br/>Cập nhật ngày 23/4/2024
	 */
	public ArrayList<ResultSet> getShops(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort);
}
