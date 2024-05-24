package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.*;

import org.javatuples.Quartet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import connection.*;
import constant.SHOP_EDIT_TYPE;
import entity.*;
import basic.*;
import utility.Utilities;
import utility.Utilities_date;


public class ShopImpl extends BasicImpl implements Shop {
	
	public ShopImpl(ConnectionPool cp) {
		super(cp, "Shop");
	}
	
	public ShopImpl(ConnectionPool cp, String objecname) {
		super(cp, objecname);
	}

	private boolean isExisting(ShopObject item) {
		boolean flag = false;
		StringBuilder sql = new StringBuilder();		
		sql.append("SELECT shop_id FROM tblshop s WHERE (s.shop_name='"+item.getShop_name()+"');");
		ArrayList<ResultSet> res = this.getReList(sql.toString());	
		for (ResultSet rs: res) {
			try {
				if (rs!=null && rs.next()) {
					flag = false;
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}	

	private static String addShopSql() {		
		StringBuilder sql = new StringBuilder();						
		sql.append("INSERT INTO tblshop(");
		sql.append("shop_name, shop_address,  ");
		sql.append("shop_status, shop_user_id, shop_website_link,  ");
		sql.append("shop_address_link, shop_created_date, shop_modified_date,  ");
		sql.append("shop_images, shop_notes, shop_phone, shop_email ");
		sql.append(")");
		sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?); ");	
		System.out.println(sql.toString());		
		return sql.toString();
	}
	
	@Override
	public boolean addShop(ShopObject shopObject, UserObject currentUser) {
		if (this.isExisting(shopObject)) {
			return false;
		}				
		try {				
			PreparedStatement preparedStatement = this.con.prepareStatement(this.addShopSql());
			preparedStatement.setString(1,shopObject.getShop_name());
			preparedStatement.setString(2, shopObject.getShop_address());
			preparedStatement.setByte(3, shopObject.getShop_status());
			preparedStatement.setInt(4, shopObject.getShop_user_id());
			preparedStatement.setString(5, shopObject.getShop_website_link());
			preparedStatement.setString(6, shopObject.getShop_address_link());
			preparedStatement.setString(7, shopObject.getShop_created_date());
			preparedStatement.setString(8, shopObject.getShop_modified_date());
			preparedStatement.setString(9, shopObject.getShop_images());
			preparedStatement.setString(10, shopObject.getShop_notes());
			preparedStatement.setString(11, shopObject.getShop_phone());
			preparedStatement.setString(12, shopObject.getShop_email());
			return this.add(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static String editShopSql(SHOP_EDIT_TYPE et) {			
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblshop SET ");
		switch (et) {
			case GENERAL:
				sql.append("shop_name=?, shop_address=?,   ");
				sql.append("shop_website_link=?, shop_address_link=?, ");
				sql.append("shop_modified_date=?, shop_images=?, shop_notes=?, ");
				sql.append("shop_phone=?, shop_email=? ");
				break;
			case STOP:
				sql.append("shop_status=0, shop_modified_date=?, ");
				break;
			case TRASH:
				sql.append("shop_deleted=1, shop_modified_date=?");
				break;
			default:
				break;
		}		
		sql.append("WHERE (shop_id=?); ");
		System.out.println(sql.toString());		
		return sql.toString();
	}

	@Override
	public boolean editShop(ShopObject shopObject, SHOP_EDIT_TYPE et, UserObject currentUser) {
		
		//Bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(editShopSql(et));
			switch(et) {
				case GENERAL:
					pre.setString(1, shopObject.getShop_name());
					pre.setString(2, shopObject.getShop_address());
					pre.setString(3, shopObject.getShop_website_link());		
					pre.setString(4, shopObject.getShop_address_link());	
					pre.setString(5, shopObject.getShop_modified_date());
					pre.setString(6, shopObject.getShop_images());
					pre.setString(7, shopObject.getShop_notes());
					pre.setString(8, shopObject.getShop_phone());
					pre.setString(9, shopObject.getShop_email());
					pre.setInt(10, shopObject.getShop_id());
					break;
					
				case STOP:
					pre.setInt(1, shopObject.getShop_status());
					pre.setString(2, shopObject.getShop_modified_date());	
					pre.setInt(3, shopObject.getShop_id());
					break;
					
				case TRASH:
					pre.setInt(1, shopObject.getShop_status());
					pre.setString(2, shopObject.getShop_modified_date());	
					pre.setInt(3, shopObject.getShop_id());
					break;
			default:
				break;
			}
			
			return this.edit(pre);
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delShop(ShopObject shopObject, UserObject currentUser) {
		// TODO Auto-generated method stub	
		if (!this.isEmpty(shopObject)) {
			return false;
		}		
		String sql = "DELETE FROM tblShop WHERE (shop_id=?);";		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, shopObject.getShop_id());
			
			return this.del(pre);
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean isEmpty(ShopObject item) {
		boolean flag = true;	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT export_bill_id FROM tblexportbill WHERE "
				+ "(tblexportbill.export_bill_current_Shop_id="+ item.getShop_id()+"); ");		
		sql.append("SELECT transfer_bill_id FROM tbltransferbill "
				+ "WHERE ((tbltransferbill.transfer_bill_current_Shop_id="+item.getShop_id()+") OR (transfer_bill_target_Shop_id="+item.getShop_id()+")); ");		
		sql.append("SELECT import_bill_id FROM tblimportbill "
			+ "WHERE ((import_bill_target_Shop_id="+item.getShop_id()+"));");
		sql.append("SELECT employee_id FROM tblemployee "
				+ "WHERE (employee_Shop_id="+item.getShop_id()+"); ");
		
		ArrayList<ResultSet> res = this.getReList(sql.toString());
		for (ResultSet rs: res) {
			try {
				if (rs!=null && rs.next()) {
					flag = false;
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public ArrayList<ResultSet> getShopById(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append(getShopByIdSQL(id));
		return this.getReList(sql.toString());
	}
	
	@Override
	public ArrayList<ResultSet> getShopByUser(UserObject user) {
		StringBuilder sql = new StringBuilder();	
		sql.append(this.getShopByUserSQL(user));	
		return this.getReList(sql.toString());
	}


	@Override
	public ArrayList<ResultSet> getShops(
			int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();			
		return this.getReList(sql.toString());
	}
	
	private String getShopByIdSQL(int id) {	
		return "SELECT * FROM tblshop s WHERE (s.shop_id="+id+") AND (s.shop_deleted=0); ";
	}
	
	private String getShopByUserSQL(UserObject user) {	
		return "SELECT * FROM tblshop s WHERE (s.shop_user_id="+user.getUser_id()+") AND (s.shop_deleted=0); ";
	}

	
	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc Shop
		Shop u=new ShopImpl(cp);
		
		//Them mot nguoi su dung
		ShopObject new_Shop = new ShopObject();
		new_Shop.setShop_name("Kho hàng Nguyên");
		new_Shop.setShop_user_id(19);
		new_Shop.setShop_address("Lâm Đồng");
		new_Shop.setShop_created_date("29/12/2003");
		UserObject currentUser = new UserObject();
		currentUser.setUser_name("Tran The Hưởng");
		currentUser.setUser_id((byte)2);

		//Lay tap ban ghi nguoi su dung
		ResultSet rs = u.getShopByUser(currentUser).get(0);
		
		String row = null;
		//Duyen va hien thi danh sach nguoi su dung
		if (rs!=null) {
			try {
				while (rs.next()) {

					row = "\tSHOP: "+rs.getInt("shop_id");
					row += "\tSHOP NAME: "+rs.getString("shop_name");
					System.out.println(row);
				}			
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

