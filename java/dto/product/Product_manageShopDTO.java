package dto.product;

import dto.pc.PC_ShopManagerDTO;

public class Product_manageShopDTO {
	private int id;
    private String name;
    private byte status;
    private int visited;
    private double price;
    private String images;
    private String notes;
    private String last_modified;
    private int quantity;
    private PC_ShopManagerDTO pc;
    private byte product_deleted;
    
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
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public PC_ShopManagerDTO getPc() {
		return pc;
	}
	public void setPc(PC_ShopManagerDTO pc) {
		this.pc = pc;
	}
	public byte getProduct_deleted() {
		return product_deleted;
	}
	public void setProduct_deleted(byte product_deleted) {
		this.product_deleted = product_deleted;
	}
}
