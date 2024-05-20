package dto.bill;

import java.util.List;

import dto.bd.BD_manageBillDTO;
import entity.BillObject;

public class Bill_manageBillDTO implements Bill_DTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6180924257598877265L;
	private int id;
	private String created_date;
	private byte bill_status; 
	private int bill_creator_id;
	private int bill_delivery_id;
	private byte bill_type;
	private List<BD_manageBillDTO> bd;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCreated_date() {
		return created_date;
	}


	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}


	public byte getBill_status() {
		return bill_status;
	}


	public void setBill_status(byte bill_status) {
		this.bill_status = bill_status;
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


	public byte getBill_type() {
		return bill_type;
	}


	public void setBill_type(byte bill_type) {
		this.bill_type = bill_type;
	}


	public List<BD_manageBillDTO> getBd() {
		return bd;
	}


	public void setBd(List<BD_manageBillDTO> bd) {
		this.bd = bd;
	}


	@Override
	public void ApplyToEntity(BillObject entity) {
		// TODO Auto-generated method stub
		
	}

}
