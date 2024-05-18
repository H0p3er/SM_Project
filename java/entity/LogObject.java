package entity;

public class LogObject {
	private int log_id; 
	private int log_user_id; 
	private byte log_user_permission; 
	private String log_username; 
	private byte log_action; 
	private byte log_position; 
	private String log_name; 
	private String log_notes; 
	private String log_created_date;
	private boolean log_deleted;
	
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getLog_user_id() {
		return log_user_id;
	}
	public void setLog_user_id(int log_user_id) {
		this.log_user_id = log_user_id;
	}
	public byte getLog_user_permission() {
		return log_user_permission;
	}
	public void setLog_user_permission(byte log_user_permission) {
		this.log_user_permission = log_user_permission;
	}
	public String getLog_username() {
		return log_username;
	}
	public void setLog_username(String log_username) {
		this.log_username = log_username;
	}
	public byte getLog_action() {
		return log_action;
	}
	public void setLog_action(byte log_action) {
		this.log_action = log_action;
	}
	public byte getLog_position() {
		return log_position;
	}
	public void setLog_position(byte log_position) {
		this.log_position = log_position;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}
	public String getLog_notes() {
		return log_notes;
	}
	public void setLog_notes(String log_notes) {
		this.log_notes = log_notes;
	}
	public String getLog_created_date() {
		return log_created_date;
	}
	public void setLog_created_date(String log_created_date) {
		this.log_created_date = log_created_date;
	}
	public boolean isLog_deleted() {
		return log_deleted;
	}
	public void setLog_deleted(boolean log_deleted) {
		this.log_deleted = log_deleted;
	}
	
}
