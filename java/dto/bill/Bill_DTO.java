package dto.bill;

import java.io.Serializable;
import java.util.List;

import entity.BDObject;
import entity.BillObject;

public interface Bill_DTO extends Serializable{
	public void ApplyToEntity(BillObject billObject, List<BDObject> bdObjects);
}
