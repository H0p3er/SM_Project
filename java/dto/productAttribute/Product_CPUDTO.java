package dto.productAttribute;

import entity.ProductObject;

public class Product_CPUDTO extends ProductObject{
	private int cpu_id; 
	private String cpu_collection; 
	private byte cpu_socket; 
	private byte cpu_cores; 
	private byte cpu_theats; 
	private double cpu_speed_ghz;
	public int getCpu_id() {
		return cpu_id;
	}
	public void setCpu_id(int cpu_id) {
		this.cpu_id = cpu_id;
	}
	public String getCpu_collection() {
		return cpu_collection;
	}
	public void setCpu_collection(String cpu_collection) {
		this.cpu_collection = cpu_collection;
	}
	public byte getCpu_socket() {
		return cpu_socket;
	}
	public void setCpu_socket(byte cpu_socket) {
		this.cpu_socket = cpu_socket;
	}
	public byte getCpu_cores() {
		return cpu_cores;
	}
	public void setCpu_cores(byte cpu_cores) {
		this.cpu_cores = cpu_cores;
	}
	public byte getCpu_theats() {
		return cpu_theats;
	}
	public void setCpu_theats(byte cpu_theats) {
		this.cpu_theats = cpu_theats;
	}
	public double getCpu_speed_ghz() {
		return cpu_speed_ghz;
	}
	public void setCpu_speed_ghz(double cpu_speed_ghz) {
		this.cpu_speed_ghz = cpu_speed_ghz;
	}
	
	
}
