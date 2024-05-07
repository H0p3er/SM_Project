package dto.product;

import dto.pc.PC_DTO;
import entity.ProductObject;
import utility.Utilities_currency;

public class Product_DTO {
	private int product_id;
    private String product_name;
    private byte product_status;
    private byte product_deleted;
    private int product_visited;
    private String product_price;
    private String product_images;
    private String product_notes;
    private String product_created_date;
    private String product_last_modified;
    private int product_quantity;
    private PC_DTO product_pc;
    private int product_shop_id;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public byte getProduct_status() {
		return product_status;
	}
	public void setProduct_status(byte product_status) {
		this.product_status = product_status;
	}
	public byte getProduct_deleted() {
		return product_deleted;
	}
	public void setProduct_deleted(byte product_deleted) {
		this.product_deleted = product_deleted;
	}
	public int getProduct_visited() {
		return product_visited;
	}
	public void setProduct_visited(int product_visited) {
		this.product_visited = product_visited;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = Utilities_currency.toVND(product_price);
	}
	public String getProduct_images() {
		return product_images;
	}
	public void setProduct_images(String product_images) {
		this.product_images = product_images;
	}
	public String getProduct_notes() {
		return product_notes;
	}
	public void setProduct_notes(String product_notes) {
		this.product_notes = product_notes;
	}
	public String getProduct_created_date() {
		return product_created_date;
	}
	public void setProduct_created_date(String product_created_date) {
		this.product_created_date = product_created_date;
	}
	public String getProduct_last_modified() {
		return product_last_modified;
	}
	public void setProduct_last_modified(String product_last_modified) {
		this.product_last_modified = product_last_modified;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public PC_DTO getProduct_pc() {
		return product_pc;
	}
	public void setProduct_pc(PC_DTO product_pc) {
		this.product_pc = product_pc;
	}
	public int getProduct_shop_id() {
		return product_shop_id;
	}
	public void setProduct_shop_id(int product_shop_id) {
		this.product_shop_id = product_shop_id;
	}
	
    public void ApplyToEntity(ProductObject productObject) {
    	productObject.setProduct_id(this.product_id);
    	productObject.setProduct_created_date(this.product_created_date); 	
    	productObject.setProduct_pc_id(this.product_pc.getId());
    }
}
