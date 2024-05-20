package dto.pc;

import entity.PCObject;

public class PC_viewBillDTO implements PCDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1545601451621138455L;
	private int id;
	private String name;

	public PC_viewBillDTO(int id, String name) {
		super();
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
