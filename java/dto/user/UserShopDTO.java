package dto.user;

import java.util.ArrayList;

import dto.ShopProductDTO;
import entity.ShopObject;

public class UserShopDTO {
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
	private ArrayList<ShopProductDTO> storage;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getWebsite_link() {
		return website_link;
	}

	public void setWebsite_link(String website_link) {
		this.website_link = website_link;
	}

	public String getAddress_link() {
		return address_link;
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
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<ShopProductDTO> getStorage() {
		return storage;
	}

	public void setStorage(ArrayList<ShopProductDTO> storage) {
		this.storage = storage;
	}

	public void applyToEntity(ShopObject shopObject) {
		shopObject.setShop_name(this.name);
		shopObject.setShop_address(address);
		shopObject.setShop_address_link(address_link);
		shopObject.setShop_images(images);
		shopObject.setShop_email(images);
	}
}
    

