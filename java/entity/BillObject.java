package entity;

public class BillObject {
	private int bill_id;
	private String bill_created_date;
	private int bill_creator_id;
	private int bill_delivery_id;
	private byte bill_status;
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getBill_created_date() {
		return bill_created_date;
	}
	public void setBill_created_date(String bill_created_date) {
		this.bill_created_date = bill_created_date;
	}
	public int getBill_creator_id() {
		return bill_creator_id;
	}
	public void setBill_creator_id(int bill_creator_id) {
		this.bill_creator_id = bill_creator_id;
	}
	public int getBill_delivery_id() {
		return bill_delivery_id;
	}
	public void setBill_delivery_id(int bill_delivery_id) {
		this.bill_delivery_id = bill_delivery_id;
	}
	public byte getBill_status() {
		return bill_status;
	}
	public void setBill_status(byte bill_status) {
		this.bill_status = bill_status;
	} 


}
