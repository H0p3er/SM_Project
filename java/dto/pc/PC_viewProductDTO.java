package dto.pc;

import entity.PCObject;

public class PC_viewProductDTO implements PCDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8371052839529548311L;

	private int id;
	
	private String name;

	
	public PC_viewProductDTO() {
		
	}

	public PC_viewProductDTO(int id) {
		this.id = id;
	}
	
	public PC_viewProductDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void ApplyToEntity(PCObject entity) {
		// TODO Auto-generated method stub
		
	}
}
