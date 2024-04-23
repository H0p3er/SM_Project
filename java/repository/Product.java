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
	boolean addProduct(ProductObject p);

	boolean editProduct(ProductObject p, PRODUCT_EDIT_TYPE type);

	boolean delProduct(ProductObject p);

	public ResultSet getProductById(int id);
	
	public ResultSet getProductsByCreatedDate(Date date, Date date2);
	
	public ArrayList<ResultSet> getProducts(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort);

	public ArrayList<ResultSet> getProductsByShop(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, ShopObject shopObject);
	
	public ArrayList<ResultSet> getProductsByBill(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, BillObject billObject);
	
	public ArrayList<ResultSet> getProductsByPC(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, PCObject pcObject);
}
