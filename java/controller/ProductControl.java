package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import dto.product.ProductDTO;
import dto.product.Product_DTO;
import dto.product.Product_viewProductDTO;
import dto.productAttribute.Product_AttributeDTO;
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
		this.pm.releaseCP();
	}
	
	public boolean addProduct(ProductDTO<Product_AttributeDTO> item) {
		return this.pm.addProduct(item);
	}
	
	public boolean editProduct(ProductDTO<Product_AttributeDTO> item, PRODUCT_EDIT_TYPE type) {
		return this.pm.editProduct(item, type);
	}
	
	public boolean delProduct(ProductDTO<Product_AttributeDTO> item) {
		return this.pm.delProduct(item);
	}
	
	/**
	 * Phương thức lấy product theo id
	 * @param id của sản phẩm cần lấy
	 * @return sản phẩm cần lấy nếu tìm được
	 * Cập nhật ngày 26/10/2023
	 */
	public Product_viewProductDTO getProduct_DTOById(int id) {
		return this.pm.getProduct_DTOById(id);
	}
	
	public Map<String,String> viewProductProfile(int id) {
		Product_viewProductDTO productObject = this.getProduct_DTOById(id);
		return ProductLibrary.viewProductProfile(productObject);
	}
	

	/**
	 * Phương thức trả về tập các product theo infors truyền vào
	 * @param infors các điều kiện để lấy dữ liệu
	 * @return cặp giá trị danh sách product lấy được và tổng số bản ghi lấy được
	 * 
	 * Cập nhật ngày 26/10/2023
	 */
	public Pair<ArrayList<Product_DTO>,Integer> getProducts(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {			
		return this.pm.getProduct_DTOs(infors);
	}
	
	
	/** 
	 * Phương thức trả về danh sách giao diện cho phần trình bày danh sách product
	 * @param infors các thông tin bổ sung
	 * @return danh sách giao diện trình bày cho phần product
	 * 
	 * <br/>Cập nhật ngày 26/10/2023
	 */
	public Map<String,String> viewSearchProduct(
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors, 
			String url){

		Pair<ArrayList<Product_viewProductDTO>,Integer> datas = this.pm.getProduct_DTOs(infors);		
		return ProductLibrary.viewSearchProduct(datas, infors, url);
	}
	
	/** 
	 * Phương thức trả về danh sách giao diện cho phần trình bày danh sách product cho trang home
	 * @param infors các thông tin bổ sung
	 * @return danh sách giao diện trình bày cho phần product
	 * 
	 * <br/>Cập nhật ngày 26/10/2023
	 */
	public Map<String,String> viewHomeProduct(){

		Pair<ArrayList<Product_viewProductDTO>,ArrayList<Product_viewProductDTO>> datas = this.pm.getProduct_DTOs();
		
		return ProductLibrary.viewHomeProduct(datas);
	}
	
	public Map<String,String> viewCart(TreeMap<Product_viewProductDTO,Integer> product_DTOs){
		return library.ProductLibrary.viewProductCart(product_DTOs);
	}
	
}
