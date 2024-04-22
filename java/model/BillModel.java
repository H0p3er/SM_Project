package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap;

import org.javatuples.*;

import connection.*;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import entity.BDObject;
import entity.BillObject;
import entity.EmployeeObject;
import objects.*;
import repository.Bill;
import repository.BillImpl;
import utility.Utilities;

public class BillModel {
	
	private Bill w;
	
	public BillModel(ConnectionPool cp) {
		this.w= new BillImpl(cp);
	}
	
	protected void finalize() throws Throwable{
		this.w=null;
	}
	
	public ConnectionPool getCP() {
		return this.w.getCP();
	}
	
	public void releaseConnection() {
		this.w.releaseCP();
	}

	//***********************Chuyen huong dieu khien tu Bill Impl*****************************************
	public boolean addBill(BillObject item, ArrayList<BDObject> bdObjects) {
		return this.w.addBill(item,bdObjects);
	}
	
	public boolean editBill(BillObject item, ArrayList<BDObject> bdObjects, BILL_EDIT_TYPE et) {
		return this.w.editBill(item, bdObjects, et);
	}
	
	public boolean delBill(BillObject item) {
		return this.w.delBill(item);
	}
	
	
	//****************************************************************
	
	public BillObject getBillObject(int id) {
		//Gan gia tri khoi tao cho doi tuong BillObject
		BillObject item = null ;
		
		//Lay ban ghi 
		ResultSet rs = this.w.getBillById(id);
		
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new BillObject();
					item.setBill_id(rs.getInt("bill_id"));
					item.setBill_status(rs.getByte("bill_status"));
					item.setBill_created_date(rs.getString("bill_created_date"));
					item.setBill_creator_id(rs.getInt("bill_creator_id"));				
					item.setBill_last_modified_date(rs.getString("bill_last_modified_date"));
					item.setBill_last_modified_id(rs.getInt("bill_last_modified_id"));
					item.setBill_transporter_id(rs.getInt("bill_last_modified_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
		
	public ArrayList<BillObject> getBillObjects(Sextet<	EmployeeObject, 
													BillObject, 
													Short, 
													Byte ,
													BILL_SORT_TYPE,
													Boolean> infors) {
		
		//Gán giá trị khởi tạo cho đối tượng BillObject
		ArrayList<BillObject> items = new ArrayList<>();
		BillObject item = null ;
		
		short page = infors.getValue2();
		byte wPerPage = infors.getValue3();
		//Lấy bản ghi 
		int at = (page-1)*wPerPage;
		ArrayList<ResultSet> res = this.w.getBills(infors.setAt2(at));
		
		ResultSet rs = res.get(0);
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new BillObject();
					item.setBill_id(rs.getInt("bill_id"));
					item.setBill_status(rs.getByte("bill_status"));
					item.setBill_created_date(rs.getString("bill_created_date"));
					item.setBill_creator_id(rs.getInt("bill_creator_id"));				
					item.setBill_last_modified_date(rs.getString("bill_last_modified_date"));
					item.setBill_last_modified_id(rs.getInt("bill_last_modified_id"));
					item.setBill_transporter_id(rs.getInt("bill_last_modified_id"));
					
					// Dua doi tuong vao tap hop
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		//Lấy tổng số bản ghi
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
		
		return new Quintet<ArrayList<BillObject>, Integer, HashMap<String,Integer>, HashMap<String,Integer>, ArrayList<String>>(items, totalGlobal, importBill,exportBill,date);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		BillModel wm = new BillModel(cp);
		
		BillObject similar = new BillObject();
	
		Sextet<EmployeeObject, BillObject, Short, Byte, BILL_SORT_TYPE, Boolean> infors = new 
		Sextet<EmployeeObject, BillObject, Short, Byte, BILL_SORT_TYPE, Boolean>
		(null, similar, (short) 1, (byte) 10, BILL_SORT_TYPE.NAME, false);
		Quintet<ArrayList<BillObject>, Integer, HashMap<String,Integer>, HashMap<String,Integer>, ArrayList<String>> items = wm.getBillObjects(infors);
		
//		items.getValue2().forEach((key,value) -> System.out.println(key.getBill_name()+":"+value));
		

		
	};
}
