package dto.productAttribute;

import entity.ProductObject;

public class Product_LaptopDTO extends ProductObject{
	private int laptop_id; 
	private String laptop_manufacturer; 
	private String laptop_type;
	private String laptop_cpu;
	private int laptop_ram;
	private String laptop_graphics_card;
	private int laptop_storage;
	private int laptop_screen_size;
	private int laptop_refresh_rate; 
	private String laptop_resolution;
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
	public String getLaptop_type() {
		return laptop_type;
	}
	public void setLaptop_type(String laptop_type) {
		this.laptop_type = laptop_type;
	}
	public String getLaptop_cpu() {
		return laptop_cpu;
	}
	public void setLaptop_cpu(String laptop_cpu) {
		this.laptop_cpu = laptop_cpu;
	}
	public int getLaptop_ram() {
		return laptop_ram;
	}
	public void setLaptop_ram(int laptop_ram) {
		this.laptop_ram = laptop_ram;
	}
	public String getLaptop_graphics_card() {
		return laptop_graphics_card;
	}
	public void setLaptop_graphics_card(String laptop_graphics_card) {
		this.laptop_graphics_card = laptop_graphics_card;
	}
	public int getLaptop_storage() {
		return laptop_storage;
	}
	public void setLaptop_storage(int laptop_storage) {
		this.laptop_storage = laptop_storage;
	}
	public int getLaptop_screen_size() {
		return laptop_screen_size;
	}
	public void setLaptop_screen_size(int laptop_screen_size) {
		this.laptop_screen_size = laptop_screen_size;
	}
	public int getLaptop_refresh_rate() {
		return laptop_refresh_rate;
	}
	public void setLaptop_refresh_rate(int laptop_refresh_rate) {
		this.laptop_refresh_rate = laptop_refresh_rate;
	}
	public String getLaptop_resolution() {
		return laptop_resolution;
	}
	public void setLaptop_resolution(String laptop_resolution) {
		this.laptop_resolution = laptop_resolution;
	}
	
	
}
