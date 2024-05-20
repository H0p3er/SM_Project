package dto.pc;

import java.io.Serializable;

import entity.PCObject;

public interface PCDTO extends Serializable{
	public void ApplyToEntity(PCObject entity);
}
