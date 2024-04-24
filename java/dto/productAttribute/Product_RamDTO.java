package dto.productAttribute;

import entity.ProductObject;

public class Product_RamDTO extends ProductObject{
	private int ram_id; 
	private String ram_manufacturer; 
	private String ram_type; 
	private short ram_capacity_gb; 
	private int ram_bus_speed; 
	private String ram_standard;
	public int getRam_id() {
		return ram_id;
	}
	public void setRam_id(int ram_id) {
		this.ram_id = ram_id;
	}
	public String getRam_manufacturer() {
		return ram_manufacturer;
	}
	public void setRam_manufacturer(String ram_manufacturer) {
		this.ram_manufacturer = ram_manufacturer;
	}
	public String getRam_type() {
		return ram_type;
	}
	public void setRam_type(String ram_type) {
		this.ram_type = ram_type;
	}
	public short getRam_capacity_gb() {
		return ram_capacity_gb;
	}
	public void setRam_capacity_gb(short ram_capacity_gb) {
		this.ram_capacity_gb = ram_capacity_gb;
	}
	public int getRam_bus_speed() {
		return ram_bus_speed;
	}
	public void setRam_bus_speed(int ram_bus_speed) {
		this.ram_bus_speed = ram_bus_speed;
	}
	public String getRam_standard() {
		return ram_standard;
	}
	public void setRam_standard(String ram_standard) {
		this.ram_standard = ram_standard;
	}
	
	
}
