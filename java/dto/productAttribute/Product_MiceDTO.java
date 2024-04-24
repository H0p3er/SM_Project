package dto.productAttribute;

import entity.ProductObject;

public class Product_MiceDTO extends ProductObject{
	private int mouse_id; 
	private String mouse_manufacturer; 
	private String mouse_type;
	private String mouse_connection_type;
	private String mouse_design;
	private String mouse_battery;
	public int getMouse_id() {
		return mouse_id;
	}
	public void setMouse_id(int mouse_id) {
		this.mouse_id = mouse_id;
	}
	public String getMouse_manufacturer() {
		return mouse_manufacturer;
	}
	public void setMouse_manufacturer(String mouse_manufacturer) {
		this.mouse_manufacturer = mouse_manufacturer;
	}
	public String getMouse_type() {
		return mouse_type;
	}
	public void setMouse_type(String mouse_type) {
		this.mouse_type = mouse_type;
	}
	public String getMouse_connection_type() {
		return mouse_connection_type;
	}
	public void setMouse_connection_type(String mouse_connection_type) {
		this.mouse_connection_type = mouse_connection_type;
	}
	public String getMouse_design() {
		return mouse_design;
	}
	public void setMouse_design(String mouse_design) {
		this.mouse_design = mouse_design;
	}
	public String getMouse_battery() {
		return mouse_battery;
	}
	public void setMouse_battery(String mouse_battery) {
		this.mouse_battery = mouse_battery;
	}
	
	
}
