package dto.bd;

import dto.product.Product_manageShopDTO;
import entity.BDObject;

public class BD_manageShopDTO implements BD_DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1776085191316647346L;
	private int id;
	private Product_manageShopDTO product;
	private int product_quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	@Override
	public void ApplyToEntity(BDObject bdObject) {
		bdObject.setBd_id(id);
		bdObject.setBd_product_quantity(product_quantity);
		

	}

	public Product_manageShopDTO getProduct() {
		return product;
	}

	public void setProduct(Product_manageShopDTO product) {
		this.product = product;
	}


}
