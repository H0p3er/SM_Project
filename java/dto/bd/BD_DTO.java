package dto.bd;

import java.io.Serializable;

import entity.BDObject;

public interface BD_DTO extends Serializable {
	public void ApplyToEntity(BDObject entity);
}
