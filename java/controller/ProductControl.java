package controller;

import java.util.ArrayList;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import entity.ProductObject;
import library.ProductLibrary;
import model.ProductModel;

public class ProductControl {
	private ProductModel pm;
	
	public ProductControl(ConnectionPool cp) {
		this.pm = new ProductModel(cp);
		
	}
	
	public ConnectionPool getCP() {
		return this.pm.getCP();
	}
	
	public void releaseConnection() {
		this.pm.releaseConnection();
	}

	
	public boolean addProduct(ProductObject item) {
		return this.pm.addProduct(item);
	}
	
	public boolean editProduct(ProductObject item, PRODUCT_EDIT_TYPE type) {
		return this.pm.editProduct(item, type);
	}
	
	public boolean delProduct(ProductObject item) {
		return this.pm.delProduct(item);
	}
	
	/**
	 * Phương thức lấy product theo id
	 * @param id của sản phẩm cần lấy
	 * @return sản phẩm cần lấy nếu tìm được
	 * Cập nhật ngày 26/10/2023
	 */
	public ProductObject getProductObject(int id) {
		return this.pm.getProductObject(id);
	}
	

	/**
	 * Phương thức trả về tập các product theo infors truyền vào
	 * @param infors các điều kiện để lấy dữ liệu
	 * @return cặp giá trị danh sách product lấy được và tổng số bản ghi lấy được<br/>
	 * 
	 * Cập nhật ngày 26/10/2023
	 */
	public Pair<ArrayList<ProductObject>,Integer> getProducts(Quintet<ProductObject, Short, Byte, PRODUCT_SORT_TYPE, Boolean> infors) {
		//Lay du lieu
		ProductObject similar = infors.getValue0();
		short page = infors.getValue1();
		byte total = infors.getValue2();
		PRODUCT_SORT_TYPE pst = infors.getValue3();
		
		boolean isExport = infors.getValue4();
				
		return this.pm.getProductObjects(similar, page, total, pst, isExport);
	}
	
	/** 
	 * Phương thức trả về danh sách giao diện cho phần trình bày danh sách product
	 * @param infors các thông tin bổ sung
	 * @return danh sách giao diện trình bày cho phần product
	 * 
	 * <br/>Cập nhật ngày 26/10/2023
	 */
	public Map<String,String> viewProductsList(Quintet<Short, Byte, String, String, String> infors){

		Pair<ArrayList<ProductObject>,Integer> datas = this.pm.getProductObjects(infors);
		
		return ProductLibrary.viewProductList(datas, infors);
	}
	
}
