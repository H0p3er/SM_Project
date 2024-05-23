package dto.pc;

import entity.PCObject;

public class PC_viewShopDTO implements PC_DTO{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -367846039853487466L;
	private int id;
	private String name;

	

	public PC_viewShopDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void ApplyToEntity(PCObject entity) {
		// TODO Auto-generated method stub
		
	}


}
