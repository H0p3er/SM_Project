package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import dto.pc.PC_manageShopDTO;
import dto.product.Product_DTO;
import dto.product.Product_DTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_viewProductDTO;
import dto.product.Product_viewShopDTO;
import dto.productAttribute.Product_AttributeDTO;
import dto.shop.Shop_manageProductDTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_viewProductDTO;
import dto.shop.Shop_viewShopDTO;
import entity.ShopObject;
import entity.UserObject;
import library.ProductLibrary;
import library.ShopLibrary;
import model.ProductModel;

public class ProductControl {
	private ProductModel pm;
	
	public ProductControl(ConnectionPool cp) {
		this.pm = new ProductModel(cp);
		
	}
	
	public ConnectionPool getCP() {
		return this.pm.getCP();
	}
	
	public void releaseCP() {
		this.pm.releaseCP();
	}
	
	public boolean addProduct(Product_DTO<Product_AttributeDTO> item) {
		return this.pm.addProduct(item);
	}
	
	public boolean editProduct(Product_DTO<Product_AttributeDTO> item, PRODUCT_EDIT_TYPE type) {
		return this.pm.editProduct(item, type);
	}
	
	public boolean delProduct(Product_DTO<Product_AttributeDTO> item) {
		return this.pm.delProduct(item);
	}
	
	/**
	 * Phương thức lấy product theo id
	 * @param id của sản phẩm cần lấy
	 * @return sản phẩm cần lấy nếu tìm được
	 * Cập nhật ngày 26/10/2023
	 */
	public Product_viewProductDTO getProduct_DTOById(int id) {
		return this.pm.getProduct_viewProductDTOById(id);
	}
	
	public Pair<ArrayList<Product_viewShopDTO>, Integer> getProduct_viewShopDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors, Shop_viewShopDTO shop_viewShopDTO) {
		return this.pm.getProduct_viewShopDTO(infors,shop_viewShopDTO);
	}
	
	public Product_viewProductDTO viewProductProfile(int id) {
		 Product_viewProductDTO product_viewProductDTO = this.getProduct_DTOById(id);
		 return product_viewProductDTO;
	}
	

	/**
	 * Phương thức trả về tập các product theo infors truyền vào
	 * @param infors các điều kiện để lấy dữ liệu
	 * @return cặp giá trị danh sách product lấy được và tổng số bản ghi lấy được
	 * 
	 * Cập nhật ngày 26/10/2023
	 */

	/** 
	 * Phương thức trả về danh sách giao diện cho phần trình bày danh sách product
	 * @param infors các thông tin bổ sung
	 * @return danh sách giao diện trình bày cho phần product
	 * 
	 * <br/>Cập nhật ngày 26/10/2023
	 */
	public Pair<ArrayList<Product_viewProductDTO>,Integer> viewSearchProduct(
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors){
		Pair<ArrayList<Product_viewProductDTO>,Integer> datas = this.pm.getProduct_viewProductDTO(infors);		
		return datas;
	}
	
	public Triplet<List<Product_manageShopDTO>,Integer, List<Pair<Product_manageShopDTO,Double>>> getProduct_manageShopDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, Shop_manageShopDTO shop_manageShopDTO) {
		return this.pm.getProduct_manageShopDTO(productInfors, shop_manageShopDTO);	
	}	
	
	/** 
	 * Phương thức trả về danh sách giao diện cho phần trình bày danh sách product cho trang home
	 * @param infors các thông tin bổ sung
	 * @return danh sách giao diện trình bày cho phần product
	 * 
	 * <br/>Cập nhật ngày 26/10/2023
	 */
	public Pair<ArrayList<Product_viewProductDTO>,ArrayList<Product_viewProductDTO>> viewHomeProduct(){
		Pair<ArrayList<Product_viewProductDTO>,ArrayList<Product_viewProductDTO>> datas = this.pm.getProduct_viewProductDTO();
		return datas;		
	}
	
	public Map<String,String> viewCart(TreeMap<Product_viewProductDTO,Integer> product_DTOs){
		return library.ProductLibrary.viewProductCart(product_DTOs);
	}
	
	public Map<String,String> viewSeller_ShopProductProfle(int id){
		Product_manageShopDTO datas = this.pm.getProduct_manageShopDTO(id);
		return ProductLibrary.viewSeller_ShopProductProfile(datas);
	}

}
