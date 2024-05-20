package dto.productAttribute;


public class GraphicsCardDTO implements Product_AttributeDTO{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6774687705014132071L;
	private int graphics_card_id;
    private String graphics_card_manufacturer;
    private String graphics_card_speed;
    private String graphics_card_cores;
    private String graphics_card_version;
    private String graphics_card_vram_capacity;
    private String graphics_card_require_psu;
	public int getGraphics_card_id() {
		return graphics_card_id;
	}
	public void setGraphics_card_id(int graphics_card_id) {
		this.graphics_card_id = graphics_card_id;
	}
	public String getGraphics_card_manufacturer() {
		return graphics_card_manufacturer;
	}
	public void setGraphics_card_manufacturer(String graphics_card_manufacturer) {
		this.graphics_card_manufacturer = graphics_card_manufacturer;
	}
	public String getGraphics_card_speed() {
		return graphics_card_speed;
	}
	public void setGraphics_card_speed(String graphics_card_speed) {
		this.graphics_card_speed = graphics_card_speed;
	}
	public String getGraphics_card_cores() {
		return graphics_card_cores;
	}
	public void setGraphics_card_cores(String graphics_card_cores) {
		this.graphics_card_cores = graphics_card_cores;
	}
	public String getGraphics_card_version() {
		return graphics_card_version;
	}
	public void setGraphics_card_version(String graphics_card_version) {
		this.graphics_card_version = graphics_card_version;
	}
	public String getGraphics_card_vram_capacity() {
		return graphics_card_vram_capacity;
	}
	public void setGraphics_card_vram_capacity(String graphics_card_vram_capacity) {
		this.graphics_card_vram_capacity = graphics_card_vram_capacity;
	}
	public String getGraphics_card_require_psu() {
		return graphics_card_require_psu;
	}
	public void setGraphics_card_require_psu(String graphics_card_require_psu) {
		this.graphics_card_require_psu = graphics_card_require_psu;
	}
	
}
