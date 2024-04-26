package repository;

import java.sql.ResultSet;
import java.util.ArrayList;

import connection.ShareControl;
import entity.PCObject;
import entity.ProductObject;

public interface PC extends ShareControl{
	public boolean addPC(PCObject object);
	public boolean editPC(PCObject object);
	public boolean delPC(PCObject object);
	
	public ResultSet getPCById(int id);
	
	public ResultSet getPCByProduct(ProductObject productObject);
}
