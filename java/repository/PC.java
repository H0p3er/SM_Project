package repository;

import java.sql.ResultSet;

import connection.ShareControl;
import entity.PCObject;

public interface PC extends ShareControl{
	public boolean addPC(PCObject object);
	public boolean editPC(PCObject object);
	public boolean delPC(PCObject object);
	
	public ResultSet getPCById(int id);
}
