package model;

import connection.*;
import constant.USER_EDIT_TYPE;
import constant.USER_SORT_TYPE;
import dto.user.User_viewShopDTO;
import entity.UserObject;
import repository.User;
import repository.UserImpl;
import utility.Utilities;

import java.io.*;
import java.util.*;

import org.javatuples.Pair;

import java.sql.*;

public class UserModel {
	private User user;
	
	public UserModel(ConnectionPool cp) {
		this.user= new UserImpl(cp);
	}
	
	protected void finalize()throws Throwable{
		this.user=null;
	}
	
	public ConnectionPool getCP() {
		return this.user.getCP();
	}
	
	public void releaseCP() {
		this.user.releaseCP();
	}

	//***********************Chuyen huong dieu khien tu User Impl*****************************************
	public boolean addUser(UserObject item) {
		return this.user.addUser(item);
	}
	
	public boolean editUser(UserObject item, USER_EDIT_TYPE et) {
		return this.user.editUser(item, et);
	}
	
	public boolean delUser(UserObject item) {
		return this.user.delUser(item);
	}
	
	
	//****************************************************************
	
	public UserObject getUserObject(int id) {
		//Gan gia tri khoi tao cho doi tuong UserObject
		UserObject item = null ;
		
		//Lay ban ghi 
		ResultSet rs = this.user.getUserById(id);
		
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_fullname(Utilities.decode(rs.getString("user_fullname")));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_notes(rs.getString("user_notes"));
					if (rs.getBlob("user_images")!=null) {
						item.setUser_images(rs.getString("user_images"));
					}
					item.setUser_deleted(rs.getBoolean("user_deleted"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}	
	
	public UserObject getUserObject(String username, String userpass) {
		//Gan gia tri khoi tao cho doi tuong UserObject
		UserObject item = null ;
		
		//Lay ban ghi 
		ResultSet rs = this.user.getUser(username, userpass);
		
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_nickname(rs.getString("user_nickname"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_permission(rs.getByte("user_permission"));		
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public Pair<ArrayList<UserObject>,Integer> getUserObjects(
			UserObject similar, 
			short page, 
			byte uPerPage, 
			USER_SORT_TYPE type,
			boolean isExport) {
		
		//Gan gia tri khoi tao cho doi tuong UserObject
		ArrayList<UserObject> items = new ArrayList<>();
		UserObject item = null ;
		
		//Lay ban ghi 
		int at = (page-1)*uPerPage;
		ArrayList<ResultSet> res = this.user.getUsers(similar, at, uPerPage, type);
		
		ResultSet rs = res.get(0);
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_fullname(Utilities.decode(rs.getString("user_fullname")));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(Utilities.decode(rs.getString("user_address")));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_notes(rs.getString("user_notes"));
					item.setUser_deleted(rs.getBoolean("user_deleted"));
					
					if (isExport) {
						item.setUser_name(rs.getString("user_name"));			
					};
					
//					if (isExport && similar.getUser_permission()>4) {
//						item.setUser_pass(rs.getString("user_password"));			
//					};
					
					if (rs.getBlob("user_images")!=null) {
						item.setUser_images(rs.getString("user_images"));
					}
					
					// Dua doi tuong vao tap hop
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Lay tong so ban ghi
		int totalGlobal = 0;
		rs = res.get(1);
		if (rs!=null) {
			try {
				if (rs.next()) {
					totalGlobal = rs.getInt("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Pair<>(items,totalGlobal);
	}
	
	public User_viewShopDTO getSellerById(int id) {
		//Gan gia tri khoi tao cho doi tuong UserObject
		User_viewShopDTO item = new User_viewShopDTO() ;				
		ResultSet rs = this.user.getUserById(id);		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				if (rs.next()) {
					item.setUser_fullname(Utilities.decode(rs.getString("user_fullname")));
					if (rs.getBlob("user_images")!=null) {
						item.setUser_images(rs.getString("user_images"));
					}					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}	
	
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		UserModel um = new UserModel(cp);
	
		Pair<ArrayList<UserObject>,Integer> items = um.getUserObjects(null, (short) 1, (byte) 10, USER_SORT_TYPE.FULLNAME, false);
		
		items.getValue0().forEach(item -> System.out.println(item.getUser_fullname()));
		
	};
	
}

