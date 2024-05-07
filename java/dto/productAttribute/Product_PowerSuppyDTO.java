package dto.productAttribute;

import dto.product.Product_DTO;

public class Product_PowerSuppyDTO extends Product_DTO{
	private int psu_id;
	private String psu_manufacturer;
	private String psu_certification;
	private String psu_cable_type; 
	private String psu_size;
	private String psu_power_output;
	
	public int getPsu_id() {
		return psu_id;
	}
	public void setPsu_id(int psu_id) {
		this.psu_id = psu_id;
	}
	public String getPsu_manufacturer() {
		return psu_manufacturer;
	}
	public void setPsu_manufacturer(String psu_manufacturer) {
		this.psu_manufacturer = psu_manufacturer;
	}
	public String getPsu_certification() {
		return psu_certification;
	}
	public void setPsu_certification(String psu_certification) {
		this.psu_certification = psu_certification;
	}
	public String getPsu_cable_type() {
		return psu_cable_type;
	}
	public void setPsu_cable_type(String psu_cable_type) {
		this.psu_cable_type = psu_cable_type;
	}
	public String getPsu_size() {
		return psu_size;
	}
	public void setPsu_size(String psu_size) {
		this.psu_size = psu_size;
	}
	public String getPsu_power_output() {
		return psu_power_output;
	}
	public void setPsu_power_output(String psu_power_output) {
		this.psu_power_output = psu_power_output;
	}

}

