package dto.bd;

import dto.product.Product_manageOrderDTO;
import entity.BDObject;

public class BD_manageOrderDTO implements BD_DTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7102192124929849505L;
	private int id;
	private Product_manageOrderDTO product;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void ApplyToEntity(BDObject entity) {
		// TODO Auto-generated method stub

	}

	public Product_manageOrderDTO getProduct() {
		return product;
	}

	public void setProduct(Product_manageOrderDTO product) {
		this.product = product;
	}

}
