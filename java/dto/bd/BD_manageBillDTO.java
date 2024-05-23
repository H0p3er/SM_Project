package dto.bd;

import dto.product.Product_manageBillDTO;
import entity.BDObject;

public class BD_manageBillDTO implements BD_DTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7102192124929849505L;
	private int id;
	private Product_manageBillDTO product;
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
	public void ApplyToEntity(BDObject entity) {
		// TODO Auto-generated method stub

	}

	public Product_manageBillDTO getProduct() {
		return product;
	}

	public void setProduct(Product_manageBillDTO product) {
		this.product = product;
	}

}
