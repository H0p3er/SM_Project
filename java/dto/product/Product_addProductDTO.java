package dto.product;

import dto.pc.PC_addProductDTO;
import dto.productAttribute.Product_AttributeDTO;
import dto.shop.Shop_addProductDTO;
import entity.ProductObject;

public class Product_addProductDTO implements ProductDTO<Product_AttributeDTO>, Comparable<Product_addProductDTO>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5870513737626444437L;
	private int id;
    private String name;
    private byte status;
    private byte deleted;
    private int visited;
    private double price;
    private String images;
    private String notes;
    private String created_date;
    private String last_modified;
    private int quantity;
    private PC_addProductDTO pc;
    private Shop_addProductDTO shop;
    private Product_AttributeDTO attribute;
    
	public PC_addProductDTO getPc() {
		return pc;
	}
	public void setPc(PC_addProductDTO pc) {
		this.pc = pc;
	}
	public Shop_addProductDTO getShop() {
		return shop;
	}
	public void setShop(Shop_addProductDTO shop) {
		this.shop = shop;
	}
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




	public Product_AttributeDTO getAttribute() {
		return attribute;
	}


	public void setAttribute(Product_AttributeDTO attribute) {
		this.attribute = attribute;
	}


	@Override
	public void ApplyToEntity(ProductObject productObject) {
		productObject.setProduct_id(this.id);
		productObject.setProduct_name(this.name);
    	productObject.setProduct_created_date(this.created_date); 	
    	productObject.setProduct_pc_id(this.pc.getId());
    	productObject.setProduct_notes(this.notes);
    	productObject.setProduct_shop_id(this.shop.getId());
    	productObject.setProduct_quantity(this.quantity);
	}

	
	@Override
	public boolean equals(Object obj) {
		try {
			Product_addProductDTO dto = (Product_addProductDTO) obj;
			if (this.id == dto.id) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}
	@Override
	public int compareTo(Product_addProductDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
