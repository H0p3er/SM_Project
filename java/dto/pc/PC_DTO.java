package dto.pc;

import java.io.Serializable;

import entity.PCObject;

public interface PC_DTO extends Serializable{
	public void ApplyToEntity(PCObject entity);
}
