package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap;

import org.javatuples.*;
import connection.*;
import constant.WORKPLACE_EDIT_TYPE;
import constant.WORKPLACE_SORT_TYPE;
import entity.EmployeeObject;
import entity.ProductObject;
import entity.WorkplaceObject;
import entity.WpsdObject;
import objects.*;
import repository.Log;
import repository.Workplace;
import repository.WorkplaceImpl;
import utility.Utilities;

public class WorkplaceModel {
	
	private Workplace w;
	
	public WorkplaceModel(ConnectionPool cp) {
		this.w= new WorkplaceImpl(cp);
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

	//***********************Chuyen huong dieu khien tu Workplace Impl*****************************************
	public boolean addWorkplace(ArrayList<WorkplaceObject> wItem, ArrayList<WpsdObject> pItem, EmployeeObject currentUser) {
		return this.w.addWorkplace(wItem, pItem, currentUser);
	}
	
	public boolean editWorkplace(ArrayList<WorkplaceObject> wItem, ArrayList<WpsdObject> pItem, WORKPLACE_EDIT_TYPE et, EmployeeObject currentUser) {
		return this.w.editWorkplace(wItem, pItem, et, currentUser);
	}
	
	public boolean delWorkplace(ArrayList<WorkplaceObject> item, EmployeeObject currentUser) {
		return this.w.delWorkplace(item, currentUser);
	}
	
	
	//****************************************************************
	
	public WorkplaceObject getWorkplaceObject(int id) {
		//Gan gia tri khoi tao cho doi tuong WorkplaceObject
		WorkplaceObject item = null ;
		
		//Lay ban ghi 
		ResultSet rs = this.w.getWorkplace(id);
		
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new WorkplaceObject();
					item.setWorkplace_id(rs.getInt("workplace_id"));
					item.setWorkplace_name(rs.getString("workplace_name"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
		
	public Octet<	ArrayList<WorkplaceObject>,
					Integer, 
					HashMap<Integer,Integer>, 
					HashMap<Integer,Integer>, 
					HashMap<Pair<String,Integer>,Integer> ,
					HashMap<Pair<String,Integer>,Integer>,
					HashMap<Triplet<Integer,Integer,String>,
							Triplet<ProductObject,Integer,Integer>>,
					HashMap<Integer,EmployeeObject>>
						getWorkplaceObjects(Sextet<	EmployeeObject, 
													WorkplaceObject, 
													Short, 
													Byte ,
													WORKPLACE_SORT_TYPE,
													Boolean> infors) {
		
		//Gán giá trị khởi tạo cho đối tượng WorkplaceObject
		ArrayList<WorkplaceObject> items = new ArrayList<>();
		WorkplaceObject item = null ;
		
		short page = infors.getValue2();
		byte wPerPage = infors.getValue3();
		//Lấy bản ghi 
		int at = (page-1)*wPerPage;
		ArrayList<ResultSet> res = this.w.getWorkplaces(infors.setAt2(at));
		
		ResultSet rs = res.get(0);
		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new WorkplaceObject();
					item.setWorkplace_id(rs.getInt("workplace_id"));
					item.setWorkplace_name(Utilities.decode(rs.getString("workplace_name")));
					item.setWorkplace_address(rs.getString("workplace_address"));
					item.setWorkplace_created_date(rs.getString("workplace_created_date"));
					item.setWorkplace_last_modified_date(rs.getString("workplace_last_modified_date"));
					item.setWorkplace_last_modified_id(rs.getInt("workplace_last_modified_id"));
					item.setWorkplace_deleted(rs.getBoolean("workplace_deleted"));
					item.setWorkplace_images(rs.getString("workplace_images"));
					item.setWorkplace_manager_id(rs.getInt("workplace_manager_id"));
					item.setWorkplace_creator_id(rs.getInt("workplace_creator_id"));
					item.setWorkplace_notes(rs.getString("workplace_notes"));
					item.setWorkplace_email(rs.getString("workplace_email"));
					item.setWorkplace_phone(rs.getString("workplace_phone"));
					// Dua doi tuong vao tap hop
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//Lấy tổng doanh số nhập
		rs = res.get(1);
		HashMap<Integer, Integer> importTotal = new HashMap<Integer, Integer>();
		
		//Lấy doanh số nhập của mỗi kho hàng
		HashMap<Pair<String,Integer>,Integer> ieWorkplace = new HashMap<Pair<String,Integer>,Integer>();
		
		if (rs!=null) {
			try {
				while (rs.next()) {
					ieWorkplace.put(new Pair<>(rs.getString("bill_created_date"), rs.getInt("bill_import_target_workplace_id")), rs.getInt("import_value") );
					
					if (importTotal.get(rs.getInt("bill_import_target_workplace_id")) != null) {
						importTotal.put(rs.getInt("bill_import_target_workplace_id"), importTotal.get(rs.getInt("bill_import_target_workplace_id")) + rs.getInt("import_value"));
					} else {
						importTotal.put(rs.getInt("bill_import_target_workplace_id"), rs.getInt("import_value"));
					}	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Lấy tổng doanh số xuất
		rs = res.get(2);
		HashMap<Integer, Integer> exportTotal = new HashMap<Integer, Integer>();
		
		//Lấy doanh số xuất của mỗi kho hàng
		HashMap<Pair<String,Integer>,Integer> eeWorkplace = new HashMap<Pair<String,Integer>,Integer>();
		if (rs!=null) {
			try {
				while (rs.next()) {
					eeWorkplace.put(new Pair<>(rs.getString("bill_created_date"), rs.getInt("bill_export_current_workplace_id")), rs.getInt("export_value"));
					
					if (exportTotal.get(rs.getInt("bill_export_current_workplace_id")) != null) {
						exportTotal.put(rs.getInt("bill_export_current_workplace_id"), exportTotal.get(rs.getInt("bill_export_current_workplace_id")) + rs.getInt("export_value"));
					} else {
						exportTotal.put(rs.getInt("bill_export_current_workplace_id"), rs.getInt("export_value"));
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Lấy danh sách sản phẩm bán chạy nhất
		ProductObject pItem = null;
		rs = res.get(3);
		HashMap<Triplet<Integer,Integer,String>,
				Triplet<ProductObject,Integer,Integer>> productList = 
				new HashMap<Triplet<Integer,Integer,String>,
							Triplet<ProductObject,Integer,Integer>>();
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				while (rs.next()) {
					pItem = new ProductObject();
					pItem.setProduct_id(rs.getInt("product_id"));
					pItem.setProduct_name(rs.getString("product_name"));
					
					productList.put(
							new Triplet<Integer,Integer,String>
							(rs.getInt("product_id"),rs.getInt("wpsd_workplace_id"),rs.getString("bill_created_date")), 
							new Triplet<ProductObject,Integer,Integer>
							(pItem, rs.getInt("AvgExport"), rs.getInt("TotalExport")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Lấy tổng số bản ghi
		int totalGlobal = 0;
		rs = res.get(4);
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
			
		//Lấy danh sách nguoi dung
		EmployeeObject eItem = null;
		HashMap<Integer,EmployeeObject> eItems = new HashMap<Integer,EmployeeObject>();
		rs = res.get(5);		
		//Chuyen doi ban ghi thanh doi tuong
		if (rs!=null) {
			try {
				while (rs.next()) {
					eItem = new EmployeeObject();
					eItem.setEmployee_id(rs.getInt("user_id"));
					eItem.setUser_fullname(rs.getString("user_fullname"));
					eItem.setUser_email(rs.getString("user_email"));
					eItem.setUser_address(rs.getString("user_address"));
					eItem.setUser_office_phone(rs.getString("user_office_phone"));
					eItem.setUser_mobile_phone(rs.getString("user_mobile_phone"));
					eItem.setUser_permission(rs.getByte("user_permission"));
					eItem.setUser_notes(rs.getString("user_notes"));
					eItem.setUser_last_modified_date(rs.getString("user_last_modified_date"));
					eItem.setUser_last_modified_date(rs.getString("user_last_modified_id"));
					eItem.setUser_parent_id(rs.getInt("user_parent_id"));
					eItem.setUser_deleted(rs.getBoolean("user_deleted"));
					eItem.setUser_images(rs.getString("user_images"));
					
					// Dua doi tuong vao tap hop
					eItems.put(rs.getInt("user_id"), eItem);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Octet<	ArrayList<WorkplaceObject>,
							Integer, 
							HashMap<Integer,Integer>, 
							HashMap<Integer,Integer>, 
							HashMap<Pair<String,Integer>,Integer> ,
							HashMap<Pair<String,Integer>,Integer>,
							HashMap<Triplet<Integer,Integer,String>,
									Triplet<ProductObject,Integer,Integer>>,
							HashMap<Integer,EmployeeObject>>(items, totalGlobal, importTotal,exportTotal, ieWorkplace, eeWorkplace, productList, eItems);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		WorkplaceModel wm = new WorkplaceModel(cp);
		
		WorkplaceObject similar = new WorkplaceObject();
	
		Sextet<EmployeeObject, WorkplaceObject, Short, Byte, WORKPLACE_SORT_TYPE, Boolean> infors = new 
		Sextet<EmployeeObject, WorkplaceObject, Short, Byte, WORKPLACE_SORT_TYPE, Boolean>
		(null, similar, (short) 1, (byte) 10, WORKPLACE_SORT_TYPE.NAME, false);
		Octet<	ArrayList<WorkplaceObject>,
				Integer, 
				HashMap<Integer,Integer>, 
				HashMap<Integer,Integer>, 
				HashMap<Pair<String,Integer>,Integer> ,
				HashMap<Pair<String,Integer>,Integer>,
				HashMap<Triplet<Integer,Integer,String>,
						Triplet<ProductObject,Integer,Integer>>,
				HashMap<Integer,EmployeeObject>> items = wm.getWorkplaceObjects(infors);
		System.out.println("Tổng sản phẩm nhập:");
		items.getValue2().forEach((key,value) -> System.out.println(key+":"+value));
		
		System.out.println("Tổng sản phẩm xuất:");
		items.getValue3().forEach((key,value) -> System.out.println(key+":"+value));
		
		System.out.println("Sản phẩm xuất theo ngày:");
		items.getValue4().forEach((key,value) -> System.out.println(key+":"+value));
		System.out.println("Sản phẩm nhập theo ngày:");
		items.getValue5().forEach((key,value) -> System.out.println(key+":"+value));
		
		System.out.println("Danh sách sản phẩm:");
		items.getValue6().forEach((key,value) -> System.out.println(key+":"+value));
		
		System.out.println("Danh sách :");
		items.getValue7().forEach((key,value) -> System.out.println(key+":"+value));
	};
}
