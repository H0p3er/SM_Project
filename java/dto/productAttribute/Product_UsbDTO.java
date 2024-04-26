package dto.productAttribute;

import entity.ProductObject;

public class Product_UsbDTO extends ProductObject{
	private int usb_id; 
	private String usb_manufacturer; 
	private int usb_capacity;
	
	public int getUsb_id() {
		return usb_id;
	}
	public void setUsb_id(int usb_id) {
		this.usb_id = usb_id;
	}
	public String getUsb_manufacturer() {
		return usb_manufacturer;
	}
	public void setUsb_manufacturer(String usb_manufacturer) {
		this.usb_manufacturer = usb_manufacturer;
	}
	public int getUsb_capacity() {
		return usb_capacity;
	}
	public void setUsb_capacity(int usb_capacity) {
		this.usb_capacity = usb_capacity;
	}
	
	
}
