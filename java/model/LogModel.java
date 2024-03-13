package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap;

import org.javatuples.*;
import connection.*;
import constant.LOG_SORT_TYPE;
import entity.EmployeeObject;
import entity.LogObject;
import objects.*;
import repository.Log;
import repository.LogImpl;
import utility.Utilities;

public class LogModel {
	
	private Log w;
	
	public LogModel(ConnectionPool cp) {
		this.w= new LogImpl(cp);
	}
	
	protected void finalize() throws Throwable{
		this.w=null;
	}
	
	public ConnectionPool getCP() {
		return this.w.getCP();
	}
	
	public void releaseConnection() {
		this.w.releaseConnection();
	}

	//***********************Chuyen huong dieu khien tu Log Impl*****************************************
	public boolean addLog(LogObject wItem) {
		return this.w.addLog(wItem);
	}
	
//	public boolean editLog(LogObject wItem,  LOG_EDIT_TYPE et) {
//		return this.w.editLog(wItem,  et);
//	}
	
	public boolean delLog(LogObject item) {
		return this.w.delLog(item);
	}
	
	
	//****************************************************************
	
	public LogObject getLogObject(int id) {
		//Gan gia tri khoi tao cho doi tuong LogObject
		LogObject item = null ;
		
		//Lay ban ghi 
		ResultSet rs = this.w.getLog(id);
		
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new LogObject();
					item.setLog_id(rs.getInt("log_id"));
					item.setLog_name(rs.getString("log_name"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
		
	public Pair<ArrayList<LogObject>,Integer> 
						getLogObjects(Sextet<	EmployeeObject, 
													LogObject, 
													Short, 
													Byte ,
													LOG_SORT_TYPE,
													Boolean> infors) {
		
		//Gán giá trị khởi tạo cho đối tượng LogObject
		ArrayList<LogObject> items = new ArrayList<LogObject>();
		LogObject item = null ;
		
		short page = infors.getValue2();
		byte wPerPage = infors.getValue3();
		//Lấy bản ghi 
		int at = (page-1)*wPerPage;
		ArrayList<ResultSet> res = this.w.getLogs(infors.setAt2(at));
		
		ResultSet rs = res.get(0);
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new LogObject();
					item.setLog_id(rs.getInt("log_id"));	
					item.setLog_username(Utilities.decode(rs.getString("log_username")));;
					item.setLog_name(Utilities.decode(rs.getString("log_name")));;
					item.setLog_created_date(rs.getString("log_created_date"));
					item.setLog_user_permission(rs.getByte("log_user_permission"));
					item.setLog_notes(rs.getString("log_notes"));
					item.setLog_position(rs.getByte("log_position"));
					item.setLog_action(rs.getByte("log_action"));


					
					// Dua doi tuong vao tap hop
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//Lấy tổng số bản ghi
		int totalAll = 0;
		rs = res.get(1);
		if (rs!=null) {
			try {
				if (rs.next()) {
					totalAll = rs.getInt("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return new Pair<ArrayList<LogObject>,Integer>(items,totalAll);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		LogModel wm = new LogModel(cp);
		
		LogObject similar = new LogObject();
	
		Sextet<EmployeeObject, LogObject, Short, Byte, LOG_SORT_TYPE, Boolean> infors = new 
		Sextet<EmployeeObject, LogObject, Short, Byte, LOG_SORT_TYPE, Boolean>
		(null, similar, (short) 1, (byte) 10, LOG_SORT_TYPE.NAME, false);
		Pair<ArrayList<LogObject>,Integer> items = wm.getLogObjects(infors);
		
//		items.getValue2().forEach((key,value) -> System.out.println(key.getLog_name()+":"+value));
		items.getValue0().forEach( (value) ->System.out.println(value.getLog_name()+":"+value));

		
	};
}
