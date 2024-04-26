package dto.productAttribute;

import entity.ProductObject;

public class Product_DesktopDTO extends ProductObject{
	private int desktop_id; 
	private String desktop_manufacturer; 
	private String desktop_type; 
	private String desktop_cpu; 
	private String desktop_gpu; 
	private int desktop_ram_capacity; 
	private String desktop_ram_type; 
	private int desktop_storage; 
	private String desktop_power_supply;
	public int getDesktop_id() {
		return desktop_id;
	}
	public void setDesktop_id(int desktop_id) {
		this.desktop_id = desktop_id;
	}
	public String getDesktop_manufacturer() {
		return desktop_manufacturer;
	}
	public void setDesktop_manufacturer(String desktop_manufacturer) {
		this.desktop_manufacturer = desktop_manufacturer;
	}
	public String getDesktop_type() {
		return desktop_type;
	}
	public void setDesktop_type(String desktop_type) {
		this.desktop_type = desktop_type;
	}
	public String getDesktop_cpu() {
		return desktop_cpu;
	}
	public void setDesktop_cpu(String desktop_cpu) {
		this.desktop_cpu = desktop_cpu;
	}
	public String getDesktop_gpu() {
		return desktop_gpu;
	}
	public void setDesktop_gpu(String desktop_gpu) {
		this.desktop_gpu = desktop_gpu;
	}
	public int getDesktop_ram_capacity() {
		return desktop_ram_capacity;
	}
	public void setDesktop_ram_capacity(int desktop_ram_capacity) {
		this.desktop_ram_capacity = desktop_ram_capacity;
	}
	public String getDesktop_ram_type() {
		return desktop_ram_type;
	}
	public void setDesktop_ram_type(String desktop_ram_type) {
		this.desktop_ram_type = desktop_ram_type;
	}
	public int getDesktop_storage() {
		return desktop_storage;
	}
	public void setDesktop_storage(int desktop_storage) {
		this.desktop_storage = desktop_storage;
	}
	public String getDesktop_power_supply() {
		return desktop_power_supply;
	}
	public void setDesktop_power_supply(String desktop_power_supply) {
		this.desktop_power_supply = desktop_power_supply;
	}
	
	
}
