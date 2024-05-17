package dto.productAttribute;

import dto.product.Product_DTO;

public class LaptopDTO implements Product_AttributeDTO{
    private int laptop_id;
    private String laptop_manufacturer;
    private String laptop_cpu;
    private String laptop_ram;
    private String laptop_graphics_card;
    private String laptop_storage;
    private String laptop_screen_size;
    private String laptop_refresh_rate;
    private String laptop_resolution;
    private String laptop_type;
	public int getLaptop_id() {
		return laptop_id;
	}
	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}
	public String getLaptop_manufacturer() {
		return laptop_manufacturer;
	}
	public void setLaptop_manufacturer(String laptop_manufacturer) {
		this.laptop_manufacturer = laptop_manufacturer;
	}
	public String getLaptop_cpu() {
		return laptop_cpu;
	}
	public void setLaptop_cpu(String laptop_cpu) {
		this.laptop_cpu = laptop_cpu;
	}
	public String getLaptop_ram() {
		return laptop_ram;
	}
	public void setLaptop_ram(String laptop_ram) {
		this.laptop_ram = laptop_ram;
	}
	public String getLaptop_graphics_card() {
		return laptop_graphics_card;
	}
	public void setLaptop_graphics_card(String laptop_graphics_card) {
		this.laptop_graphics_card = laptop_graphics_card;
	}
	public String getLaptop_storage() {
		return laptop_storage;
	}
	public void setLaptop_storage(String laptop_storage) {
		this.laptop_storage = laptop_storage;
	}
	public String getLaptop_screen_size() {
		return laptop_screen_size;
	}
	public void setLaptop_screen_size(String laptop_screen_size) {
		this.laptop_screen_size = laptop_screen_size;
	}
	public String getLaptop_refresh_rate() {
		return laptop_refresh_rate;
	}
	public void setLaptop_refresh_rate(String laptop_refresh_rate) {
		this.laptop_refresh_rate = laptop_refresh_rate;
	}
	public String getLaptop_resolution() {
		return laptop_resolution;
	}
	public void setLaptop_resolution(String laptop_resolution) {
		this.laptop_resolution = laptop_resolution;
	}
	public String getLaptop_type() {
		return laptop_type;
	}
	public void setLaptop_type(String laptop_type) {
		this.laptop_type = laptop_type;
	}
	
}
