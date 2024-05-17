package dto.product;

import dto.pc.PC_DTO;
import dto.productAttribute.Product_AttributeDTO;
import dto.shop.Shop_DTO;
import entity.ProductObject;
import utility.Utilities_currency;

public class Product_DTO implements ProductDTO<Product_AttributeDTO> {
	private int id;
    private String name;
    private byte status;
    private byte deleted;
    private int visited;
    private String price;
    private String images;
    private String notes;
    private String created_date;
    private String last_modified;
    private int quantity;
    private PC_DTO pc;
    private Shop_DTO shop;
    private Product_AttributeDTO attribute;
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
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public byte getDeleted() {
		return deleted;
	}
	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = Utilities_currency.toVND(price);
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
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public PC_DTO getPc() {
		return pc;
	}
	public void setPc(PC_DTO pc) {
		this.pc = pc;
	}
	public Shop_DTO getShop() {
		return shop;
	}
	public void setShop(Shop_DTO shop) {
		this.shop = shop;
	}
    
	@Override
    public void ApplyToEntity(ProductObject productObject) {
    	productObject.setProduct_id(this.id);
    	productObject.setProduct_created_date(this.created_date); 	
    	productObject.setProduct_pc_id(this.pc.getId());
    }
	public Product_AttributeDTO getAttribute() {
		return attribute;
	}
	public void setAttribute(Product_AttributeDTO attribute) {
		this.attribute = attribute;
	}

}
