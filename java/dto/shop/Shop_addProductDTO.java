package dto.shop;

import java.util.List;

import org.javatuples.Pair;

import dto.product.Product_manageShopDTO;
import dto.user.User_manageShopDTO;
import entity.ShopObject;
import entity.UserObject;

public class Shop_addProductDTO implements Shop_DTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8070648219807688134L;
	private int id;
    private String name;
    private String address;
    private byte status;
    private User_manageShopDTO user;
    private String website_link;
    private String address_link;
    private String created_date;
    private String images;
    private String notes;
	private String phone;
    private String email;
	private Pair<List<Product_manageShopDTO>,Integer> storage;
	private Shop_statisticDTO statistic;	

	public Shop_addProductDTO(int id) {
		this.id = id;
	}

	public Shop_addProductDTO() {
		
	}

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

	public Pair<List<Product_manageShopDTO>,Integer> getStorage() {
		return this.storage;
	}

	public void setStorage(Pair<List<Product_manageShopDTO>,Integer> storage) {
		this.storage = storage;
	}	

	public Shop_statisticDTO getStatistic() {
		return statistic;
	}

	public void setStatistic(Shop_statisticDTO statistic) {
		this.statistic = statistic;
	}


	public User_manageShopDTO getUser() {
		return user;
	}

	public void setUser(User_manageShopDTO user) {
		this.user = user;
	}
	
	public void applyToEntity(ShopObject shopObject) {
		shopObject.setShop_id(id);
		shopObject.setShop_name(this.name);
		shopObject.setShop_address(address);
		shopObject.setShop_address_link(address_link);
		shopObject.setShop_images(images);
		shopObject.setShop_email(email);
		shopObject.setShop_notes(notes);
	}

	@Override
	public void applyToEntity(ShopObject shopObject, UserObject userObject) {
		applyToEntity(shopObject);
	}



}
    

