package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.javatuples.Quintet;

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
	
	public ResultSet getPCByProduct(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort);
}
