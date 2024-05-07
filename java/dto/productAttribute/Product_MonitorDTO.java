package dto.productAttribute;

import dto.product.Product_DTO;

public class Product_MonitorDTO extends Product_DTO{
	private int monitor_id;
	private String monitor_manufacturer; 
	private String monitor_size;
	private String monitor_type; 
	private String monitor_resolution;
	private String monitor_panel_type;
	private int monitor_refresh_rate;
	private String monitor_screen_type; 
	private double monitor_response;
	public int getMonitor_id() {
		return monitor_id;
	}
	public void setMonitor_id(int monitor_id) {
		this.monitor_id = monitor_id;
	}
	public String getMonitor_manufacturer() {
		return monitor_manufacturer;
	}
	public void setMonitor_manufacturer(String monitor_manufacturer) {
		this.monitor_manufacturer = monitor_manufacturer;
	}
	public String getMonitor_size() {
		return monitor_size;
	}
	public void setMonitor_size(String monitor_size) {
		this.monitor_size = monitor_size;
	}
	public String getMonitor_type() {
		return monitor_type;
	}
	public void setMonitor_type(String monitor_type) {
		this.monitor_type = monitor_type;
	}
	public String getMonitor_resolution() {
		return monitor_resolution;
	}
	public void setMonitor_resolution(String monitor_resolution) {
		this.monitor_resolution = monitor_resolution;
	}
	public String getMonitor_panel_type() {
		return monitor_panel_type;
	}
	public void setMonitor_panel_type(String monitor_panel_type) {
		this.monitor_panel_type = monitor_panel_type;
	}
	public int getMonitor_refresh_rate() {
		return monitor_refresh_rate;
	}
	public void setMonitor_refresh_rate(int monitor_refresh_rate) {
		this.monitor_refresh_rate = monitor_refresh_rate;
	}
	public String getMonitor_screen_type() {
		return monitor_screen_type;
	}
	public void setMonitor_screen_type(String monitor_screen_type) {
		this.monitor_screen_type = monitor_screen_type;
	}
	public double getMonitor_response() {
		return monitor_response;
	}
	public void setMonitor_response(double monitor_response) {
		this.monitor_response = monitor_response;
	}

	
}
