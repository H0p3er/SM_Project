package repository;

import java.sql.ResultSet;
import java.util.*;

import connection.ShareControl;
import constant.PRODUCT_SORT_TYPE;
import entity.ProductObject;

public interface Product extends ShareControl {
	boolean addProduct(ProductObject p);

	boolean editProduct(ProductObject p);

	boolean delProduct(ProductObject p);

	ResultSet getProduct(int id);

	ArrayList<ResultSet> getProducts(ProductObject similar, int at, byte total, PRODUCT_SORT_TYPE type);
}
