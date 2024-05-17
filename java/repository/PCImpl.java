package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basic.BasicImpl;
import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import dto.product.Product_DTO;
import entity.PCObject;
import entity.ProductObject;

public class PCImpl extends BasicImpl implements PC {

	public PCImpl(ConnectionPool cp) {
		super(cp, "PC");
	}
	
	public PCImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}	

	@Override
	public boolean addPC(PCObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPC(PCObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delPC(PCObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getPCById(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblpc pc WHERE pc.pc_id=?");
		return this.get(sql.toString(), id);
	}
	
	public static void main(String[] args) {
		int id = 1;
		ConnectionPool cp = new ConnectionPoolImpl();
		PC a = new PCImpl(cp);
		
		ResultSet rs = a.getPCById(id);
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					System.out.println(rs.getInt("pc_id"));
					System.out.println(rs.getString("pc_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public ArrayList<ResultSet> getPCs() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT pc.*, COUNT(product_id) FROM tblpc pc ");
		sql.append("INNER JOIN tblproduct p ON pc.pc_id = p.product_pc_id ");
		sql.append("GROUP BY pc_id ");
		sql.append(";");
		return this.getReList(sql.toString());
	}

	@Override
	public ResultSet getProductAttribute(ProductObject productObject) {
		StringBuilder sql = new StringBuilder();
		
		switch (productObject.getProduct_pc_id()) {
			case 1:
				sql.append("SELECT * FROM tbl_monitors ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");	
				break;
				
			case 2:
				sql.append("SELECT * FROM tbl_keyboards ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 3:
				sql.append("SELECT * FROM tbl_mice ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
		
				break;
				
			case 4:
				sql.append("SELECT * FROM tbl_headphones_speakers ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 5:
				sql.append("SELECT * FROM tbl_laptops ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
			
				break;
				
			case 6:
				sql.append("SELECT * FROM tbl_desktops ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 7:
				sql.append("SELECT * FROM tbl_cpus ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 8:
				sql.append("SELECT * FROM tbl_motherboards ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 9:
				sql.append("SELECT * FROM tbl_rams ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 10:
				sql.append("SELECT * FROM tbl_storage ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 11:
				sql.append("SELECT * FROM tbl_graphics_cards ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 12:
				sql.append("SELECT * FROM tbl_power_supply ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
				
			case 13:
				sql.append("SELECT * FROM tbl_cases ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
			
			case 14:
				sql.append("SELECT * FROM tbl_cooling ");				
				sql.append("WHERE product_id="+productObject.getProduct_id()+";");
				break;
		}
		// TODO Auto-generated method stub
		return this.gets(sql.toString());
	}

}
