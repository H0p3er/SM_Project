package dto.bill;

import java.util.ArrayList;
import java.util.List;

import dto.bd.BD_manageBillDTO;
import entity.BDObject;
import entity.BillObject;

public class Bill_manageBillDTO implements Bill_DTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6180924257598877265L;
	private int id;
	private String created_date;
	private int creator_id;
	private int delivery_id;
	private byte status; 
	private List<BD_manageBillDTO> bd;
	
	public Bill_manageBillDTO() {
        this.bd = new ArrayList<>(); // Khởi tạo danh sách bd trong constructor
    }
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


	public int getCreator_id() {
		return creator_id;
	}


	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}


	public int getDelivery_id() {
		return delivery_id;
	}


	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}


	public byte getStatus() {
		return status;
	}


	public void setStatus(byte status) {
		this.status = status;
	}


	public List<BD_manageBillDTO> getBd() {
		return bd;
	}


	public void setBd(List<BD_manageBillDTO> bd) {
		this.bd = bd;
	}


	@Override
	public void ApplyToEntity(BillObject billObject, List<BDObject> bdObjects) {
	    billObject.setBill_id(id);
	    billObject.setBill_created_date(created_date);
	    billObject.setBill_status(status);
	    billObject.setBill_creator_id(creator_id);
	    billObject.setBill_delivery_id(delivery_id);

	    // Loop through the list of BD_manageBillDTO and create BDObject instances
	    for (BD_manageBillDTO bdDTO : bd) {
	        BDObject bdObject = new BDObject();
	        bdDTO.ApplyToEntity(bdObject);
	        bdObjects.add(bdObject);
	    }
	}
}
