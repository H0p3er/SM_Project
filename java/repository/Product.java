package repository;

import java.sql.ResultSet;
import java.util.*;

import connection.ShareControl;
import constant.PRODUCT_EDIT_TYPE;
import entity.BillObject;
import entity.PCObject;
import entity.ProductObject;
import entity.ShopObject;

public interface Product extends ShareControl {
	public boolean addProduct(ProductObject p);

	public boolean editProduct(ProductObject p, PRODUCT_EDIT_TYPE type);

	public boolean delProduct(ProductObject p);

	public ResultSet getProductById(int id);
	
	public ArrayList<ResultSet> getProducts();
	
	public ArrayList<ResultSet> getProducts(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort);
	
	public ArrayList<ResultSet> getProductsByShop(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, ShopObject shopObject);
	
	public ArrayList<ResultSet> getProductsByBill(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, BillObject billObject);
	
	/** 
	 * Phương thức trả về danh sách giao diện cho phần trình bày danh sách product
	 * @param at :vị trí bản ghi
	 * @param total :số lượng bản ghi/trang
	 * @param multiField :lấy thuộc tính theo tên trường
	 * @param multiCondition :số lượng bản ghi/trang
	 * @param multiSort :sắp xếp theo nhiều thuộc tính
	 * @return ArrayList<ResultSet> Danh sách bản ghi
	 * 
	 * <br/>Cập nhật ngày 23/4/2024
	 */
	public ArrayList<ResultSet> getProductsByPC(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, PCObject pcObject);
	

}
