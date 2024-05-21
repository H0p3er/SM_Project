package dto.shop;

import entity.ShopObject;
import entity.UserObject;

public class Shop_viewProductDTO implements Shop_DTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1409887074803398868L;
	private int id;
	private String name;
	private String images;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String image) {
		this.images = image;
	}
	
	@Override
	public void applyToEntity(ShopObject shopObject) {
		shopObject.setShop_name(name);
		shopObject.setShop_images(images);
		
	}
	
	@Override
	public void applyToEntity(ShopObject shopObject, UserObject userObject) {
		applyToEntity(shopObject);
		
	}
}
