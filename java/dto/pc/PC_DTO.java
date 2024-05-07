package dto.pc;

public class PC_DTO {
	
	private int id;
	
	private String name;

	public PC_DTO(int id) {
		this.id = id; 
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
}
