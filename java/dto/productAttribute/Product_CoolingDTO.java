package dto.productAttribute;

import entity.ProductObject;

public class Product_CoolingDTO extends ProductObject{
	private int cooling_id;
	private String cooling_manufacturer; 
	private int cooling_type;
	private String cooling_color;
	private String cooling_fan_size;	
	
	public int getCooling_id() {
		return cooling_id;
	}
	public void setCooling_id(int cooling_id) {
		this.cooling_id = cooling_id;
	}
	public String getCooling_manufacturer() {
		return cooling_manufacturer;
	}
	public void setCooling_manufacturer(String cooling_manufacturer) {
		this.cooling_manufacturer = cooling_manufacturer;
	}
	public int getCooling_type() {
		return cooling_type;
	}
	public void setCooling_type(int cooling_type) {
		this.cooling_type = cooling_type;
	}
	public String getCooling_color() {
		return cooling_color;
	}
	public void setCooling_color(String cooling_color) {
		this.cooling_color = cooling_color;
	}
	public String getCooling_fan_size() {
		return cooling_fan_size;
	}
	public void setCooling_fan_size(String cooling_fan_size) {
		this.cooling_fan_size = cooling_fan_size;
	}
	
	
}
