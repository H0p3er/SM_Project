package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import basic.BasicImpl;
import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import entity.BDObject;
import entity.BillObject;
import entity.UserObject;
import utility.Utilities;

public class BillImpl extends BasicImpl implements Bill {

	public BillImpl(ConnectionPool cp) {
		super(cp, "Bill");
		// TODO Auto-generated constructor stub
	}
	
	public BillImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	private boolean isExisting(BillObject item) {
		boolean flag = false;
		String sql = "SELECT bill_id FROM tblbill WHERE (bill_id='"+item.getBill_id()+"'); ";
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
	public boolean addBill(BillObject item, ArrayList<BDObject> bdObjects) {
		
		if (this.isExisting(item)) {
			return false;
		}
		
		StringBuilder getIdSql = new StringBuilder();
		getIdSql.append("SELECT AUTO_INCREMENT ");
		getIdSql.append("FROM information_schema.TABLES ");
		getIdSql.append("WHERE TABLE_SCHEMA=\"test\" ");
		getIdSql.append("AND TABLE_NAME=\"tblbill\"; ");
		System.out.println(getIdSql.toString());		
		ResultSet billId = this.getReList(getIdSql.toString()).get(0);
		
		if (billId==null) {
			return false;
		}
		
		try {
			if (billId.next()) {
				int id = billId.getInt("AUTO_INCREMENT");
				billId.close();			
				
				StringBuilder sql = new StringBuilder();
				
				sql.append("INSERT INTO tblbill(");
				sql.append("bill_status, bill_created_date, ");
				sql.append("bill_last_modified_date, bill_last_modified_id, bill_shop_id, ");
				sql.append("bill_transporter_id, bill_type, bill_customer_id, bill_target_address ");
				sql.append(")");
				sql.append("VALUES(?,?,?,?,?,?,?,?,?); ");	
				
				PreparedStatement pre = this.con.prepareStatement(sql.toString());
				
				pre.setByte(1,item.getBill_status());
				pre.setString(2, item.getBill_created_date());		
				pre.setString(3, item.getBill_last_modified_date());
				pre.setInt(4, item.getBill_last_modified_id());
				pre.setInt(5, item.getBill_creator_id());
				pre.setInt(6, item.getBill_transporter_id());
				pre.setByte(7, item.getBill_type());
				
				if (this.add(pre)) {
					sql.setLength(0);
					sql.append("INSERT INTO tblbd(");
					sql.append("bd_bill_id, bd_product_id, ");
					sql.append("bd_product_quantity");				
					sql.append(")");
					sql.append("VALUES(?,?,?,?);");	
					PreparedStatement pre2 = this.con.prepareStatement(sql.toString());
					bdObjects.forEach(bd->{
						try {
							pre2.setInt(1, bd.getBd_bill_id());
							pre2.setInt(2, bd.getBd_product_id());
							pre2.setInt(3, bd.getBd_product_quantity());
							pre2.addBatch();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					});
					return this.addList(pre);
				} 	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

	@Override
	public boolean editBill(BillObject item, ArrayList<BDObject> bdObjects ,BILL_EDIT_TYPE et) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblbill SET ");
		switch (et) {
			case GENERAL:
				sql.append("bill_status, ");
				sql.append("bill_last_modified_date, bill_last_modified_id, ");
				sql.append("bill_transporter_id,");
			break;
			
		}
		
		sql.append("WHERE (bill_id=?); ");
		
		
		//Bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch(et) {
				case GENERAL:
					pre.setByte(1,item.getBill_status());
					pre.setString(2, item.getBill_last_modified_date());
					pre.setInt(3, item.getBill_last_modified_id());
					pre.setInt(4, item.getBill_transporter_id());
					pre.setInt(6, item.getBill_id());
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

	//Phương thức kiểm tra tồn tại
	private boolean isEmpty(BillObject item) {
		boolean flag = true;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT user_id FROM tbluser WHERE (user_id="+item.getBill_creator_id()+") ;");
		sql.append("SELECT user_id FROM tbluser WHERE (user_id="+item.getBill_last_modified_id()+") ;");
		
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
	public boolean delBill(BillObject item) {
		
		if (!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblbill WHERE (bill_id=?);";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getBill_id());
			
			return this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@Override
	public ResultSet getBillById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblbill WHERE (bill_id=?) AND (bill_deleted=0); ";
		return this.get(sql, id);
	}
	
	private String createCondition(UserObject similar) {
		 StringBuilder conds = new StringBuilder();
		 
		 if (similar!=null) {
			 byte permis = similar.getUser_permission();// Tài khoản đăng nhập truyên cho
			 
			 //Phân tầng quản trị
			 conds.append("(user_permission<=").append(permis).append(") ");
			 
			 if (permis<4) {
				 int id = similar.getUser_id();
				 
				 if (id>0) {
					 conds.append("AND ( (user_parent_id=").append(id).append(") OR (user_id=").append(id).append(") )") ;
				 }
			 }
			 
			 
			 //Xử lí từ khóa tìm kiếm
			 String key = similar.getUser_fullname();
			 if (key!=null && !key.equalsIgnoreCase("")) {
				 conds.append(" AND (");
				 conds.append("(user_fullname LIKE '%"+key+"%') OR ");
				 conds.append("(user_address LIKE '%"+key+"%') OR ");
				 conds.append("(user_email LIKE '%"+key+"%')");
				 conds.append(") ");
			 }
			 
			 //Kiểm tra tồn tại
			 if (similar.isUser_deleted()) {
				 conds.append("AND (user_deleted=1)");
			 } else {
				 conds.append("AND (user_deleted=0)");
			 }
		 }
		 
		 if (!conds.toString().equalsIgnoreCase("")) {
			 conds.insert(0,"WHERE ");
		 }
		 
		 return conds.toString();
	}
	
	@Override
	public ArrayList<ResultSet> getBillList(UserObject currentUser, BillObject similar, Integer at, Byte bPerPage, BILL_SORT_TYPE type) {
//		UserObject currentUser = infors.getValue0();
//		BillObject similar = infors.getValue1();
//		int at = infors.getValue2();
//		byte bPerPage = infors.getValue3(); 
//		BILL_SORT_TYPE type = infors.getValue4();
//		boolean isDetail = infors.getValue5();
//		
		StringBuilder sql = new StringBuilder();
		
	
		sql.append("SELECT * FROM tblbill ");	 
		sql.append("LEFT JOIN tblemployee ON tblbill.bill_creator_id=tblemployee.employee_id ");
		sql.append("LEFT JOIN tblbilldetail ON tblbill.bill_id=tblbilldetail.bill_detail_id");

//		sql.append(this.createCondition(currentUser));
		switch (type) {	
			case NAME:
				sql.append(" ORDER BY bill_id ASC ");
			break;
			case ADDRESS:
				sql.append(" ORDER BY bill_address ASC ");
				break;
			case CREATED:
				sql.append(" ORDER BY bill_created_date DESC ");
				break;
			case MODIFIED:
				sql.append(" ORDER BY bill_last_modified_date DESC ");
				break;
			default:
				sql.append(" ORDER BY bill_id ASC ");
		}	
		sql.append("LIMIT "+at+"," +bPerPage+"; ") ;
		sql.append(" ");	
		
		sql.append("SELECT tblbill.bill_created_date, SUM(bill_detail_product_price*bill_detail_product_quantity) as export_price FROM tblbill ");
		sql.append("LEFT JOIN tblbilldetail ON tblbill.bill_id=tblbilldetail.bill_detail_id ");

		sql.append("GROUP BY tblbill.bill_created_date ");
		sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC ");
		sql.append("LIMIT 50; ");

		
		
		sql.append("SELECT COUNT(bill_id) AS total FROM tblbill");
//		sql.append(this.createCondition(currentUser));
		sql.append("; ");
		System.out.print(sql.toString());
		return this.getReList(sql.toString());
	}



	@Override
	public ResultSet getBillByCreatedDate(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ResultSet> getBillByUser(UserObject user, Integer at, Byte bPerPage, String multiSort, String multiFilter) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblbill b ");	 
		sql.append("LEFT JOIN tblbd bd ON b.bill_id=bd.bd_id ");
		sql.append(this.ORDERConditions(multiSort));
		sql.append("LIMIT "+at+"," +bPerPage+"; ") ;

		
		sql.append("SELECT COUNT(bill_id) AS total FROM tblbill");
		sql.append("; ");
		System.out.print(sql.toString());
		return this.getReList(sql.toString());
	}
	
	private String SELECTConditions(String multiField) {
		StringBuilder SELECT = new StringBuilder();

	
		return SELECT.toString();
	}
	
	private String WHEREConditions(String multiCondition) {
		StringBuilder WHERE = new StringBuilder();

		return WHERE.toString();
	}
	
	private String ORDERConditions(String multiSort) {
		StringBuilder ORDER = new StringBuilder();
		if (multiSort!=null) {
			if (!multiSort.equalsIgnoreCase("")) {
				Map<String,String> SortMap = new TreeMap<String,String>();
				
				String[] Pair = multiSort.trim().split(";");
				for (int i=0; i<Pair.length;i++) {
					String[] div = Pair[i].split(":");
					SortMap.put(div[0], div[1]);
				}			

				SortMap.forEach((key,value)->{
					if(!ORDER.isEmpty()&&!ORDER.toString().isBlank()) {
						ORDER.append(",");
					}
					switch (key) {			
					case "id":
						ORDER.append("bill_id");
						break;
					case "status":
						ORDER.append("bill_status");
						break;
					case "created_date":
						ORDER.append("STR_TO_DATE(bill_created_date, '%e/%c/%Y')");
						break;
					case "modified_date":
						ORDER.append("STR_TO_DATE(bill_last_modified_date, '%e/%c/%Y')");
						break;
					case "shop":
						ORDER.append("bill_shop_id");
						break;
					case "transporter":
						ORDER.append("bill_transporter_id");
						break;					
					case "type":
						ORDER.append("bill_type");
						break;
					case "customer":
						ORDER.append("bill_customer_id");
						break;
					case "address":
						ORDER.append("bill_target_address");
						break;
					default:
						ORDER.append("STR_TO_DATE(bill_created_date, '%e/%c/%Y')");
					}		
					
					switch (value) {
					case "asc":
						ORDER.append(" ASC ");
						break;
					case "desc":
						ORDER.append(" DESC ");
						break;
					default:
						ORDER.append(" ASC ");
						break;
					}
				});
				
				if(!ORDER.toString().equalsIgnoreCase("")) {
					ORDER.insert(0, "ORDER BY ");
				}
			}
		}
		return ORDER.toString();
	}
	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc User
		BillImpl u = new BillImpl(cp);
		

		UserObject currentUser = new UserObject();
		int at = 0;
		byte bPerPage = 6; 
		
//		boolean result = u.addBill(bill);
//		
//		if (!result) {
//			System.out.print("\n---------------------Khong thanh cong-------------------\n");
//		}
		
		ArrayList<ResultSet> res = u.getBillByUser(currentUser, at, bPerPage, "created_date:desc;shop:asc","");
		
		ResultSet rs = res.get(0);
		String row;
		//Duyen va hien thi danh sach nguoi su dung
		if (rs!=null) {
			try {
				while (rs.next()) {
					row = " date: "+rs.getString("bill_created_date");
					row += " shop: "+rs.getInt("bill_shop_id");
					System.out.println(row);
				}			
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs=res.get(1);
		if (rs!=null) {
			try {
				if (rs.next()) {
					System.out.print("Total:"+rs.getInt("total"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
