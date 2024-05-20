package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

import connection.*;
import entity.ShopObject;
import entity.UserObject;
import basic.*;
import utility.Utilities;
import constant.*;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
	}

	public UserImpl(ConnectionPool cp, String objecname) {
		super(cp, objecname);
	}

	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub

		if (this.isExisting(item)) {
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbluser(");
		sql.append("user_name, user_pass, ");
		sql.append("user_nickname, user_fullname, user_images, ");
		sql.append("user_email, user_notes, user_permission, ");
		sql.append("user_gender, user_address, user_created_date, ");
		sql.append("user_phone, user_social_links ");
		sql.append(")");
		sql.append("VALUES(?,md5(?),?,?,?,?,?,?,?,?,?,?,?);");

		// Bien dich
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, item.getUser_name());
            pre.setString(2, item.getUser_pass());
            pre.setString(3, item.getUser_nickname());
            pre.setString(4, Utilities.encode(item.getUser_fullname()));
            pre.setString(5, item.getUser_images());
            pre.setString(6, item.getUser_email());
            pre.setString(7, item.getUser_notes());
            pre.setByte(8, item.getUser_permission());
            pre.setByte(9, item.getUser_gender());
            pre.setString(10, Utilities.encode(item.getUser_address()));
            pre.setString(11, item.getUser_created_date());
            pre.setString(12, item.getUser_phone());
            pre.setString(13, item.getUser_social_links());
            boolean success = this.add(pre);
            if (success) {
                ResultSet generatedKeys = pre.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int newUserId = generatedKeys.getInt(1);
                    item.setUser_id(newUserId);
                } 
            }
            return success;
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean isExisting(UserObject item) {
		boolean flag = false;
		String sql = "SELECT user_id FROM tbluser WHERE (user_name='" + item.getUser_name() + "'); ";
		ResultSet rs = this.gets(sql);
		try {
			if (rs.next()) {
				flag = true;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean editUser(UserObject item, USER_EDIT_TYPE et) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tbluser SET ";
		switch (et) {
		case GENERAL:
			sql += "user_nickname=?, user_fullname=?, user_images=?, ";
			sql += "user_email=?, user_notes=?, user_gender=?, ";
			sql += "user_address=?, user_phone=?, user_social_links=?";
			break;
		case SETTINGS:
			sql += "user_permission=? ";
			break;

		case TRASH:
			sql += "user_deleted=1 ";
			break;
		}

		sql += " WHERE user_id=?;";

		// Bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			switch (et) {
			case GENERAL:
				pre.setString(1, item.getUser_nickname());
				pre.setString(2, item.getUser_fullname());
				pre.setString(3, item.getUser_images());
				pre.setString(4, item.getUser_email());
				pre.setString(5, item.getUser_notes());
				pre.setByte(6, item.getUser_gender());
				pre.setString(7, item.getUser_address());
				pre.setString(8, item.getUser_phone());
				pre.setString(9, item.getUser_social_links());
				pre.setInt(10, item.getUser_id());
				break;

			case SETTINGS:
				pre.setByte(1, item.getUser_permission());
				pre.setInt(2, item.getUser_id());
				break;

			case TRASH:
				pre.setInt(1, item.getUser_id());
				break;
			}

			return this.edit(pre);
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delUser(UserObject item) {
	    // Kiểm tra xem user_id hợp lệ không
	    if (!isValidUserId(item.getUser_id())) {
	        return false;
	    }

	    String sql = "DELETE FROM tbluser WHERE (user_id=?);";

	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        pre.setInt(1, item.getUser_id());

	        return this.del(pre);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            this.con.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }

	    return false;
	}

	// Kiểm tra xem user_id có tồn tại không
	private boolean isValidUserId(int userId) {
	    String sql = "SELECT user_id FROM tbluser WHERE user_id=? AND user_deleted=0;";
	    ResultSet rs = this.get(sql, userId);
	    try {
	        return rs.next(); // Trả về true nếu có bản ghi tồn tại
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}

	@Override
	public ResultSet getUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbluser WHERE (user_id=?) AND (user_deleted=0); ";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		// TODO Auto-generated method stub
		String sqlSelect = "SELECT * FROM tbluser WHERE (user_name=?) AND (user_pass=md5(?)) AND (user_deleted=0); ";

		String sqlUpdate = "UPDATE tbluser SET user_logined = user_logined+1 WHERE (user_name=?) AND (user_pass=md5(?)); ";

		ArrayList<String> sql = new ArrayList<>();
		sql.add(sqlSelect);
		sql.add(sqlUpdate);

		return this.get(sql, username, userpass);
	}

	@Override
	public ArrayList<ResultSet> getUsers(UserObject similar, int at, byte uPerPage, USER_SORT_TYPE type) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tbluser ";
		sql += this.createCondition(similar);

		switch (type) {
		case NAME:
			sql += " ORDER BY user_name ASC ";
			break;
		case FULLNAME:
			sql += " ORDER BY user_fullname ASC ";
			break;
		case ADDRESS:
			sql += " ORDER BY user_address ASC ";
			break;
		case CREATED:
			sql += " ORDER BY user_created_date DESC ";
			break;
		case MODIFIED:
			sql += " ORDER BY user_last_modified_date DESC ";
			break;
		default:
			sql += "ORDER BY user_id ASC ";
		}

		sql += "LIMIT " + at + "," + uPerPage + ";";
		sql += " ";

		StringBuilder multiSelect = new StringBuilder();
		multiSelect.append(sql);
		multiSelect.append("SELECT COUNT(user_id) AS total FROM tbluser ");
		multiSelect.append(this.createCondition(similar));
		multiSelect.append(";");

		return this.getReList(multiSelect.toString());
	}

	@Override
	public ArrayList<ResultSet> getCustomerStatisticByShopAndMonth(ShopObject shopObject, int month){
		StringBuilder sql = new StringBuilder();
		sql.append(getCustomerByShopAndMonth(shopObject, month));
		sql.append(getCustomerCountByShopAndMonth(shopObject, month));
		sql.append(getCustomerCountByShopAndMonth(shopObject, month-1));
		return this.getReList(sql.toString());
	}
	
	private static String getCustomerByShopAndMonth(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT bill_created_date , COUNT(bill_creator_id) AS count_customer_by_month FROM tblproduct p ");
		sql.append("INNER JOIN tblbd bd ON p.product_id = bd.bd_product_id ");
		sql.append("INNER JOIN tblbill b ON b.bill_id = bd.bd_bill_id ");
		sql.append("WHERE ( (p.product_shop_id="+shopObject.getShop_id()+") AND (p.product_deleted=0) AND MONTH(STR_TO_DATE(bill_created_date, '%e/%c/%Y')) = ("+month+") ) ");
		sql.append("GROUP BY bill_created_date ");
		sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC;");
		return sql.toString();
	}
	
	private static String getCustomerCountByShopAndMonth(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(bill_creator_id) AS count_customer_by_month FROM tblproduct p ");
		sql.append("INNER JOIN tblbd bd ON p.product_id = bd.bd_product_id ");
		sql.append("INNER JOIN tblbill b ON b.bill_id = bd.bd_bill_id ");
		sql.append("WHERE ( (p.product_shop_id="+shopObject.getShop_id()+") AND (p.product_deleted=0) AND MONTH(STR_TO_DATE(bill_created_date, '%e/%c/%Y')) = ("+month+") ) ");
		sql.append("ORDER BY count_customer_by_month ASC;");
		return sql.toString();
	}
	
	
	private String createCondition(UserObject similar) {
		StringBuilder conds = new StringBuilder();

		if (similar != null) {
			byte permis = similar.getUser_permission();// Tài khoản đăng nhập truyên cho

			// Phân tầng quản trị
			conds.append("(user_permission<=").append(permis).append(") ");

			if (permis < 4) {
				int id = similar.getUser_id();

				if (id > 0) {
					conds.append("AND (user_id=").append(id).append(") )");
				}
			}

			// Xử lí từ khóa tìm kiếm
			String key = similar.getUser_fullname();
			if (key != null && !key.equalsIgnoreCase("")) {
				conds.append(" AND (");
				conds.append("(user_fullname LIKE '%" + key + "%') OR ");
				conds.append("(user_address LIKE '%" + key + "%') OR ");
				conds.append("(user_email LIKE '%" + key + "%')");
				conds.append(") ");
			}

			// Kiểm tra tồn tại
			if (similar.isUser_deleted()) {
				conds.append("AND (user_deleted=1)");
			} else {
				conds.append("AND (user_deleted=0)");
			}
		}

		if (!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, "WHERE ");
		}

		return conds.toString();
	}

	public static void main(String[] args) throws SQLException {
		// Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tao doi tuong thuc thi chuc nang muc User
		User u = new UserImpl(cp);
		
		// Them mot nguoi su dung
		UserObject new_user = new UserObject();
		new_user.setUser_name("tester");
		new_user.setUser_pass("linhuu111");
		new_user.setUser_fullname("123 ling");
		new_user.setUser_email("admin1@gmail.com");
		new_user.setUser_address("Ha Noi");
		new_user.setUser_phone("1231231313");

		boolean resultAdd = u.addUser(new_user);
		if (resultAdd) {
			System.out.println("ok1");
		} else {
			System.out.println("FAILED1");
		}
		System.out.println(new_user.getUser_id());
		
//		boolean resultEdit = u.editUser(new_user, USER_EDIT_TYPE.GENERAL);
//		if (resultEdit) {
//			System.out.println("ok2");
//		} else {
//			System.out.println("FAILED2");
//		}
//		boolean resultDel = u.delUser(new_user);
//		if (resultDel) {
//			System.out.println("ok3");
//		} else {
//			System.out.println("FAILED3");
//		}
		ArrayList<ResultSet> res = u.getUsers(null, 0, (byte) 25, USER_SORT_TYPE.NAME);

		ResultSet rs = res.get(0);
		String row;
		// Duyen va hien thi danh sach nguoi su dung
		if (rs != null) {
			try {
				while (rs.next()) {
					row = "ID: " + rs.getInt("user_id");
					row += "\tNAME: " + rs.getString("user_name");
					row += "\tLOGINED: " + rs.getShort("user_logined");

					System.out.println(row);
				}
				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		rs = res.get(1);
		if (rs != null) {
			try {
				if (rs.next()) {
					System.out.print("Total:" + rs.getInt("total"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<ResultSet> getCustomerByShop(ShopObject shopObject) {	
		return null;
	}
}
