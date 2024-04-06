package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Quintet;
import org.javatuples.Sextet;

import basic.BasicImpl;
import connection.ConnectionPool;
import constant.LOG_SORT_TYPE;
import entity.EmployeeObject;
import entity.LogObject;
import entity.ShopObject;
import utility.Utilities_date;


public class LogImpl extends BasicImpl implements Log {

	public LogImpl(ConnectionPool cp) {
		super(cp, "Log");
	}
	
	public LogImpl(ConnectionPool cp, String objecname) {
		super(cp, objecname);
	}

	@Override
	public boolean addLog(LogObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbllog(");
		sql.append("log_user_id, log_username, log_user_permission,");
		sql.append("log_action, log_position, ");
		sql.append("log_name, log_notes, log_created_date ");
		sql.append(")");
		sql.append("VALUES(?,?,?,?,?,?,?,?); ");
		
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getLog_user_id());
			pre.setString(2, item.getLog_username());
			pre.setByte(3, item.getLog_user_permission());
			pre.setByte(4, item.getLog_action());
			pre.setByte(5, item.getLog_position());
			pre.setString(6, item.getLog_name());
			pre.setString(7, item.getLog_notes());
			pre.setString(8, Utilities_date.getCurrentDateTime());
			return this.add(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delLog(LogObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getLog(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ResultSet> getLogs(Sextet<EmployeeObject ,LogObject,
			Integer, 
			Byte ,
			LOG_SORT_TYPE,
			Boolean> infors) {
		EmployeeObject currentUser = infors.getValue0();
		LogObject similar = infors.getValue1();
		Integer at = infors.getValue2();
		Byte logPerPage = infors.getValue3();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbllog ");
		sql.append(this.createCondition(similar,currentUser));
		switch (infors.getValue4()) {	
			case NAME:
				sql.append(" ORDER BY log_name ASC ");
			break;
			case MANAGER:
				sql.append(" ORDER BY log_username ASC ");
				break;
			case CREATED:
				sql.append(" ORDER BY STR_TO_DATE(log_created_date, '%H:%i:%S %e/%c/%Y') DESC ");
				break;
			default:
				sql.append(" ORDER BY log_id ASC ");
		}	
		sql.append("LIMIT "+at+"," +logPerPage+";");
		
		sql.append("SELECT COUNT(log_id) AS total FROM tbllog LEFT JOIN tbluser ");
		sql.append("ON tbllog.log_user_id=tbluser.user_id ");
		sql.append(this.createCondition(similar,currentUser));
		sql.append(";");
		
		return this.getReList(sql.toString());
	}
	
	
	private String createCondition(LogObject similar, EmployeeObject currentUser) {
		 StringBuilder conds = new StringBuilder();
		 
		 if (similar!=null) {		 
			 
			 //Kiểm tra tồn tại
			 if (similar.isLog_deleted()) {
				 conds.append("(log_deleted=1) ");
			 } else {
				 conds.append("(log_deleted=0) ");
			 }
			 
			 //Xử lí từ khóa tìm kiếm
			 String key = similar.getLog_name();
			 if (key!=null && !key.equalsIgnoreCase("")) {
				 conds.append(" AND (");
				 conds.append("(log_name LIKE '%"+key+"%') OR ");
				 conds.append("(log_username LIKE '%"+key+"%') ");
				 conds.append(") ");
			 }
			 
			 if (currentUser !=null) {
				 byte permis = currentUser.getUser_permission();// Tài khoản đăng nhập truyên cho
				 //Phân tầng quản trị
				 conds.append("AND (log_user_permission<=").append(permis).append(") ");
				 
				 int id = currentUser.getUser_id();			 	
				 
				 if (id>0) {				 
					 if (permis<4) {			 
						 conds.append("AND ( (user_parent_id=").append(id).append(") OR (log_user_id=").append(id).append(") )") ;
					 } else {
						 
					 }
					
				 }
			 }	
		 }
		 
		 if (!conds.toString().equalsIgnoreCase("")) {
			 conds.insert(0,"WHERE ");
		 }
		 
		 return conds.toString();
	}

}
