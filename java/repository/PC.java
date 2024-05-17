package repository;

import java.sql.ResultSet;
import java.util.ArrayList;

import connection.ShareControl;
import dto.product.Product_DTO;
import entity.PCObject;
import entity.ProductObject;

public interface PC extends ShareControl{
	public boolean addPC(PCObject object);
	public boolean editPC(PCObject object);
	public boolean delPC(PCObject object);
	public ResultSet getPCById(int id);
	public ResultSet getProductAttribute(ProductObject productObject);
	
	public ArrayList<ResultSet> getPCs();
}
