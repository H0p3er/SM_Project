package dto.product;


import dto.pc.PC_DTO;
import dto.productAttribute.Product_AttributeDTO;
import dto.shop.Shop_viewProductDTO;
import entity.ProductObject;

public class Product_viewProductDTO implements ProductDTO<Product_AttributeDTO>{
    private String name;
    private byte status;
    private String price;
    private String images;
    private String last_modified;
    private PC_DTO pc;
    private Shop_viewProductDTO shop;
    private Product_AttributeDTO attribute;
    
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
	public String getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = utility.Utilities_currency.toVND(price);
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
	
	@Override
	public void ApplyToEntity(ProductObject productObject) {

	}
	public Product_AttributeDTO getAttribute() {
		return attribute;
	}
	public void setAttribute(Product_AttributeDTO attribute) {
		this.attribute = attribute;
	}
    
    
}
