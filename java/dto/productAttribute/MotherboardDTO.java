package dto.productAttribute;

public class MotherboardDTO implements Product_AttributeDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2923434328987527529L;
	private int motherboard_id;
	private String motherboard_manufacturer;
	private String motherboard_chipset;
	private String motherboard_socket;
	private String motherboard_size;
	private String motherboard_ram_support; 
	private String motherboard_ram_slots;
	public int getMotherboard_id() {
		return motherboard_id;
	}
	public void setMotherboard_id(int motherboard_id) {
		this.motherboard_id = motherboard_id;
	}
	public String getMotherboard_manufacturer() {
		return motherboard_manufacturer;
	}
	public void setMotherboard_manufacturer(String motherboard_manufacturer) {
		this.motherboard_manufacturer = motherboard_manufacturer;
	}
	public String getMotherboard_chipset() {
		return motherboard_chipset;
	}
	public void setMotherboard_chipset(String motherboard_chipset) {
		this.motherboard_chipset = motherboard_chipset;
	}
	public String getMotherboard_socket() {
		return motherboard_socket;
	}
	public void setMotherboard_socket(String motherboard_socket) {
		this.motherboard_socket = motherboard_socket;
	}
	public String getMotherboard_size() {
		return motherboard_size;
	}
	public void setMotherboard_size(String motherboard_size) {
		this.motherboard_size = motherboard_size;
	}
	public String getMotherboard_ram_support() {
		return motherboard_ram_support;
	}
	public void setMotherboard_ram_support(String motherboard_ram_support) {
		this.motherboard_ram_support = motherboard_ram_support;
	}
	public String getMotherboard_ram_slots() {
		return motherboard_ram_slots;
	}
	public void setMotherboard_ram_slots(String motherboard_ram_slots) {
		this.motherboard_ram_slots = motherboard_ram_slots;
	}
	
	
}
