package dto.product;


import dto.pc.PC_DTO;
import dto.shop.Shop_viewProductDTO;

public class Product_viewProductDTO {
    private String name;
    private byte status;
    private double price;
    private String images;
    private String last_modified;
    private PC_DTO pc;
    private Shop_viewProductDTO shop;
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
	public String getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}
	public PC_DTO getPc() {
		return pc;
	}
	public void setPc(PC_DTO pc) {
		this.pc = pc;
	}
	public Shop_viewProductDTO getShop() {
		return shop;
	}
	public void setShop(Shop_viewProductDTO shop) {
		this.shop = shop;
	}

    
    
}
