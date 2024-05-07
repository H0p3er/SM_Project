package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.javatuples.*;

import connection.ShareControl;
import constant.SHOP_EDIT_TYPE;
import dto.product.Product_DTO;
import entity.ShopObject;
import entity.UserObject;

public interface Shop extends ShareControl{
	//Các phương thức, chức năng cập nhật thông tin nơi làm việc
	public boolean addShop(ShopObject shopObjects, UserObject currentUser);
	public boolean editShop(ShopObject shopObjects, SHOP_EDIT_TYPE et, UserObject currentUser);
	public boolean delShop(ShopObject shopObjects, UserObject currentUser);
	
	//Các phương thức, chức năng lấy thông tin nơi làm việc
	public ArrayList<ResultSet> getShopById(int id);
	
	/** 
	 * Phương thức trả về bản ghi gian hàng theo Người dùng hiện tại
	 * <br/>Cập nhật ngày 23/4/2024
	 * @param currentUser :Người dùng hiện tại
	 * @return ResultSet Danh sách bản ghi
	 * 
	 */
	public ArrayList<ResultSet> getShopByUser(UserObject currentUser);
	
	
	/** 
	 * Phương thức trả về bản ghi nhiều gian hàng
	 * <br/>Cập nhật ngày 23/4/2024
	 * @param at :vị trí bản ghi
	 * @param total :số lượng bản ghi/trang
	 * @param multiField :lấy thuộc tính theo tên trường
	 * @param multiCondition :số lượng bản ghi/trang
	 * @param multiSort :sắp xếp theo nhiều thuộc tính
	 * @return ArrayList<ResultSet> Danh sách bản ghi
	 * 
	 */
	public ArrayList<ResultSet> getShops(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort);
}
