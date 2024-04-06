package entity;

public class PCObject {
    private int pc_id;
    private String pc_name;
    private String pc_notes;
    private String pc_created_date;
    private String pc_image;
    private boolean pc_enable;
    private int pc_parent_id;
    private int pc_creator_id;
    
	public int getPc_id() {
		return pc_id;
	}
	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}
	public String getPc_name() {
		return pc_name;
	}
	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}
	public String getPc_notes() {
		return pc_notes;
	}
	public void setPc_notes(String pc_notes) {
		this.pc_notes = pc_notes;
	}
	public String getPc_created_date() {
		return pc_created_date;
	}
	public void setPc_created_date(String pc_created_date) {
		this.pc_created_date = pc_created_date;
	}
	public String getPc_image() {
		return pc_image;
	}
	public void setPc_image(String pc_image) {
		this.pc_image = pc_image;
	}
	public boolean isPc_enable() {
		return pc_enable;
	}
	public void setPc_enable(boolean pc_enable) {
		this.pc_enable = pc_enable;
	}
	public int getPc_parent_id() {
		return pc_parent_id;
	}
	public void setPc_parent_id(int pc_parent_id) {
		this.pc_parent_id = pc_parent_id;
	}
	public int getPc_creator_id() {
		return pc_creator_id;
	}
	public void setPc_creator_id(int pc_creator_id) {
		this.pc_creator_id = pc_creator_id;
	}
}
