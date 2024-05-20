package dto.productAttribute;

public class UsbDTO implements Product_AttributeDTO{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3454915298618804525L;
	private int usb_id;
    private String usb_manufacturer;
    private String usb_capacity;
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
	public String getUsb_capacity() {
		return usb_capacity;
	}
	public void setUsb_capacity(String usb_capacity) {
		this.usb_capacity = usb_capacity;
	}
	
}
