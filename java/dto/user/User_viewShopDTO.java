package dto.user;

import entity.UserObject;

public class User_viewShopDTO implements User_DTO{
    private String user_fullname;
    private String user_images;
    
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getUser_images() {
		return user_images;
	}
	public void setUser_images(String user_images) {
		this.user_images = user_images;
	}
	
	@Override
	public void ApplyToEntity(UserObject entity) {
		// TODO Auto-generated method stub
		
	}
}
