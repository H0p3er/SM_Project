package dto.bd;

import dto.product.Product_viewBillDTO;
import entity.BDObject;

public class BD_viewBillDTO implements BD_DTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7102192124929849505L;
	private int id;
	private Product_viewBillDTO product;
	private int product_quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product_viewBillDTO getProduct() {
		return product;
	}

	public void setProduct(Product_viewBillDTO product) {
		this.product = product;
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

}
