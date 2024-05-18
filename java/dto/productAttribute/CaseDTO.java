package dto.productAttribute;

public class CaseDTO implements Product_AttributeDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6924286724403532621L;
	private int case_id;
	private String case_manufacturer;
	private String case_color; 
	private String case_size;
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	public String getCase_manufacturer() {
		return case_manufacturer;
	}
	public void setCase_manufacturer(String case_manufacturer) {
		this.case_manufacturer = case_manufacturer;
	}
	public String getCase_color() {
		return case_color;
	}
	public void setCase_color(String case_color) {
		this.case_color = case_color;
	}
	public String getCase_size() {
		return case_size;
	}
	public void setCase_size(String case_size) {
		this.case_size = case_size;
	}

	
}
