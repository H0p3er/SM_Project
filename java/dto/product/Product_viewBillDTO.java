package dto.product;

import dto.pc.PC_viewBillDTO;
import dto.productAttribute.Product_AttributeDTO;
import entity.ProductObject;

public class Product_viewBillDTO implements Product_DTO<Product_AttributeDTO>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7243964225705406402L;
	private int id;
    private String name;
    private byte status;
    private int visited;
    private double price;
    private String images;
    private String notes;
    private String last_modified;
    private int quantity;
    private PC_viewBillDTO pc;
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

	@Override
    public void ApplyToEntity(ProductObject productObject) {
    	productObject.setProduct_id(this.id);	
    }
	public Product_AttributeDTO getAttribute() {
		return attribute;
	}
	public void setAttribute(Product_AttributeDTO attribute) {
		this.attribute = attribute;
	}
	public PC_viewBillDTO getPc() {
		return pc;
	}
	public void setPc(PC_viewBillDTO pc) {
		this.pc = pc;
	}

}
