package dto.product;

import dto.pc.PC_viewProductDTO;
import dto.productAttribute.Product_AttributeDTO;
import dto.shop.Shop_viewProductDTO;
import entity.ProductObject;

public class Product_viewProductDTO implements ProductDTO<Product_AttributeDTO>, Comparable<Product_viewProductDTO>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5700954887225147387L;
	
	private int id;
	private String name;
    private byte status;
    private double price;
    private int quantity;
    private String images;
    private String last_modified;
    private PC_viewProductDTO pc;
    private Shop_viewProductDTO shop;
    private Product_AttributeDTO attribute;
    private String notes;
    
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
	
	public Shop_viewProductDTO getShop() {
		return shop;
	}
	public void setShop(Shop_viewProductDTO shop) {
		this.shop = shop;
	}

	public Product_AttributeDTO getAttribute() {
		return attribute;
	}
	public void setAttribute(Product_AttributeDTO attribute) {
		this.attribute = attribute;
	}


	public PC_viewProductDTO getPc() {
		return pc;
	}
	public void setPc(PC_viewProductDTO pc) {
		this.pc = pc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public void ApplyToEntity(ProductObject productObject) {
		productObject.setProduct_id(this.id);
    	productObject.setProduct_pc_id(this.pc.getId());
	}
	
	
	@Override
	public boolean equals(Object obj) {
		try {
			Product_viewProductDTO dto = (Product_viewProductDTO) obj;
			if (this.id == dto.id) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

	@Override
	public int compareTo(Product_viewProductDTO o) {
		return Integer.compare(this.getId(), o.getId());
	}
    
}
