package dto.bill;

import java.io.Serializable;
import entity.BillObject;


public interface Bill_DTO extends Serializable{
	public void ApplyToEntity(BillObject entity);
}
