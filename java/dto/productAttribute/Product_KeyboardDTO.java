package dto.productAttribute;

import dto.product.Product_DTO;

public class Product_KeyboardDTO extends Product_DTO{
	private int keyboard_id; 
	private byte keyboard_type;
	private String keyboard_connection_type;
	private String keyboard_size_layout;
	private String keyboard_led_backlighting;
	public int getKeyboard_id() {
		return keyboard_id;
	}
	public void setKeyboard_id(int keyboard_id) {
		this.keyboard_id = keyboard_id;
	}
	public byte getKeyboard_type() {
		return keyboard_type;
	}
	public void setKeyboard_type(byte keyboard_type) {
		this.keyboard_type = keyboard_type;
	}
	public String getKeyboard_connection_type() {
		return keyboard_connection_type;
	}
	public void setKeyboard_connection_type(String keyboard_connection_type) {
		this.keyboard_connection_type = keyboard_connection_type;
	}
	public String getKeyboard_size_layout() {
		return keyboard_size_layout;
	}
	public void setKeyboard_size_layout(String keyboard_size_layout) {
		this.keyboard_size_layout = keyboard_size_layout;
	}
	public String getKeyboard_led_backlighting() {
		return keyboard_led_backlighting;
	}
	public void setKeyboard_led_backlighting(String keyboard_led_backlighting) {
		this.keyboard_led_backlighting = keyboard_led_backlighting;
	}
	
	
}
