package dto.shop;

import java.util.List;

import dto.product.Product_ShopManagerDTO;
import entity.ShopObject;

public class Shop_ShopManagerDTO {
	private int id;
    private String name;
    private String address;
    private byte status;
    private String website_link;
    private String address_link;
    private String created_date;
    private String images;
    private String notes;
	private String phone;
    private String email;
	private List<Product_ShopManagerDTO> storage;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getWebsite_link() {
		return this.website_link;
	}

	public void setWebsite_link(String website_link) {
		this.website_link = website_link;
	}

	public String getAddress_link() {
		return this.address_link;
	}

	public void setAddress_link(String address_link) {
		this.address_link = address_link;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Product_ShopManagerDTO> getStorage() {
		return this.storage;
	}

	public void setStorage(List<Product_ShopManagerDTO> storage) {
		this.storage = storage;
	}


	public void applyToEntity(ShopObject shopObject) {
		shopObject.setShop_name(this.name);
		shopObject.setShop_address(address);
		shopObject.setShop_address_link(address_link);
		shopObject.setShop_images(images);
		shopObject.setShop_email(email);
		shopObject.setShop_notes(notes);
	}

}
    

