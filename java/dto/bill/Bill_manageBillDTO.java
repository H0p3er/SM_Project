package dto.bill;

import java.util.List;

import dto.bd.BD_manageBillDTO;
import dto.user.User_viewCustomerDTO;
import entity.BDObject;
import entity.BillObject;

public class Bill_manageBillDTO implements Bill_DTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1689855911518796180L;
	private int id;
	private String created_date;
	private User_viewCustomerDTO custommer;
	private int delivery_id;
	private byte status; 
	private List<BD_manageBillDTO> bd;
	

	public int getId() {
		return id;
	}


	public User_viewCustomerDTO getCustommer() {
		return custommer;
	}


	public void setCustommer(User_viewCustomerDTO custommer) {
		this.custommer = custommer;
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
		billObject.setBill_creator_id(custommer.getId());
		billObject.setBill_delivery_id(delivery_id);
		
		this.bd.forEach(bd_DTO->{
			BDObject bdObject = new BDObject();
			bd_DTO.ApplyToEntity(bdObject);
			bdObjects.add(bdObject);
		});
		
	}



}
