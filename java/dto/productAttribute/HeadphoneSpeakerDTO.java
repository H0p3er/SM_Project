package dto.productAttribute;


public class HeadphoneSpeakerDTO implements Product_AttributeDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2064299066777849858L;
	private int headphones_speakers_id; 
	private String headphones_manufacturer;
	private String headphone_type;
	private String headphones_connection; 
	private String headphones_connection_ports;
	public int getHeadphones_speakers_id() {
		return headphones_speakers_id;
	}
	public void setHeadphones_speakers_id(int headphones_speakers_id) {
		this.headphones_speakers_id = headphones_speakers_id;
	}
	public String getHeadphones_manufacturer() {
		return headphones_manufacturer;
	}
	public void setHeadphones_manufacturer(String headphones_manufacturer) {
		this.headphones_manufacturer = headphones_manufacturer;
	}
	public String getHeadphone_type() {
		return headphone_type;
	}
	public void setHeadphone_type(String headphone_type) {
		this.headphone_type = headphone_type;
	}
	public String getHeadphones_connection() {
		return headphones_connection;
	}
	public void setHeadphones_connection(String headphones_connection) {
		this.headphones_connection = headphones_connection;
	}
	public String getHeadphones_connection_ports() {
		return headphones_connection_ports;
	}
	public void setHeadphones_connection_ports(String headphones_connection_ports) {
		this.headphones_connection_ports = headphones_connection_ports;
	}
	
	
}
