package dto.user;

import entity.UserObject;

public class User_viewCustomerDTO implements User_DTO{
	private int id;
    private String fullname;
    private String images;

	public User_viewCustomerDTO(int id) {
		this.id = id;
	}

	public User_viewCustomerDTO(int id, String fullname) {
		this.id = id;
		this.fullname = fullname;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Override
	public void ApplyToEntity(UserObject entity) {
		// TODO Auto-generated method stub
		
	}
}
