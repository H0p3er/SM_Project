package dto.productAttribute;

import entity.ProductObject;

public class Product_StorageDTO extends ProductObject{
	private int storage_id;
	private String storage_manufacturer; 
	private String storage_type;
	private int storage_capacity;
	private String storage_m2_pcie_type;
	private int storage_rpm;
	public int getStorage_id() {
		return storage_id;
	}
	public void setStorage_id(int storage_id) {
		this.storage_id = storage_id;
	}
	public String getStorage_manufacturer() {
		return storage_manufacturer;
	}
	public void setStorage_manufacturer(String storage_manufacturer) {
		this.storage_manufacturer = storage_manufacturer;
	}
	public String getStorage_type() {
		return storage_type;
	}
	public void setStorage_type(String storage_type) {
		this.storage_type = storage_type;
	}
	public int getStorage_capacity() {
		return storage_capacity;
	}
	public void setStorage_capacity(int storage_capacity) {
		this.storage_capacity = storage_capacity;
	}
	public String getStorage_m2_pcie_type() {
		return storage_m2_pcie_type;
	}
	public void setStorage_m2_pcie_type(String storage_m2_pcie_type) {
		this.storage_m2_pcie_type = storage_m2_pcie_type;
	}
	public int getStorage_rpm() {
		return storage_rpm;
	}
	public void setStorage_rpm(int storage_rpm) {
		this.storage_rpm = storage_rpm;
	}
	
	
}
