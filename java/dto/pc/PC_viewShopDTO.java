package dto.pc;

import entity.PCObject;

public class PC_viewShopDTO implements PCDTO{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -367846039853487466L;
	private String name;

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
