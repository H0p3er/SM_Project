package dto.shop;

import java.io.Serializable;

import entity.ShopObject;
import entity.UserObject;

public interface Shop_DTO extends Serializable{
	public void applyToEntity(ShopObject shopObject, UserObject userObject);
	
	public void applyToEntity(ShopObject shopObject);
}
