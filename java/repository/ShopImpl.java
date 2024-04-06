package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.*;

import org.javatuples.Sextet;
import org.javatuples.Triplet;

import connection.*;
import constant.SHOP_EDIT_TYPE;
import constant.SHOP_SORT_TYPE;
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
		
		sql.append("SELECT Shop_id FROM tblShop WHERE (tblShop.Shop_name='"+item.getShop_name()+"');");

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
	

	
	/**
	 * Chỉnh sửa một Nơi làm việc
	 * @since: 25/10/2023 
	 * @author: Trần Thế Hưởng 
	 */
	
	@Override
	public boolean editShop(ArrayList<ShopObject> wItems, ArrayList<ProductObject> pItem, SHOP_EDIT_TYPE et) {
		// TODO Auto-generated method stub
		ShopObject wItem = wItems.get(0);
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblShop SET ");
		switch (et) {
			case GENERAL:
				sql.append("Shop_name=?, Shop_type=?, Shop_address=?, ");
				sql.append("Shop_website_link=?, Shop_map_link=?, ");
				sql.append("Shop_last_modified_id=?, Shop_last_modified_date=?, ");
				sql.append("Shop_images=?, Shop_type=? ");
			break;
			
			case STOP:
				sql.append("Shop_status=0 ");
			break;
			
			case TRASH:
				sql.append("Shop_deleted=1, Shop_last_modified_id=?, Shop_last_modified_date=?");
			break;
		}
		
		sql.append("WHERE (Shop_id=?); ");
		System.out.println(sql.toString());	
		
		//Bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch(et) {
				case GENERAL:
					pre.setString(1, wItem.getShop_name());
					pre.setString(3, wItem.getShop_address());
					pre.setString(4, wItem.getShop_website_link());		
					pre.setString(5, wItem.getShop_map_link());	
					pre.setString(8, wItem.getShop_images());
					pre.setInt(10, wItem.getShop_id());
					break;
				
				case TRASH:
					pre.setInt(1, wItem.getShop_last_modified_id());
					pre.setString(2, wItem.getShop_last_modified_date());	
					pre.setInt(3, wItem.getShop_id());
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
	public boolean delShop(ArrayList<ShopObject> wItems) {
		// TODO Auto-generated method stub
		ShopObject wItem = wItems.get(0);
		
		if (!this.isEmpty(wItem)) {
			return false;
		}		
		String sql = "DELETE FROM tblShop WHERE (Shop_id=?);";		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, wItem.getShop_id());
			
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
	public ResultSet getShopById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblShop WHERE (Shop_id=?) AND (Shop_deleted=0); ";
		return this.get(sql, id);
	}


	@Override
	public synchronized ArrayList<ResultSet> getShops(
			Triplet<UserObject, 
			ShopObject, 
			Integer, 
			Byte ,
		> String filter
			Boolean> infors) {
		// TODO Auto-generated method stub
		UserObject currentUser = infors.getValue0();
		ShopObject similar = infors.getValue1();
		int at = infors.getValue2();
		byte wpPerPage = infors.getValue3(); 
		SHOP_SORT_TYPE type = infors.getValue4();
		boolean isDetail = infors.getValue5();
		
		StringBuilder sql = new StringBuilder();			
		
		if (isDetail) {
			//Lấy thông tin chi tiết
			sql.append("SELECT * FROM tblShop LEFT JOIN tblemployee ");
			sql.append("ON tblShop.Shop_manager_id=tblemployee.employee_id ");
			sql.append("WHERE Shop_id = "+similar.getShop_id()+"; ");
			
			//Lấy thông tin tạo biểu đồ
			
			sql.append("SELECT bill_import_target_Shop_id, tblbill.bill_created_date, SUM(bill_detail_product_price*bill_detail_product_quantity) as import_value FROM tblbill ");
			sql.append("INNER JOIN tblbilldetail ON tblbill.bill_id=tblbilldetail.bill_detail_id ");
			sql.append("WHERE bill_import_target_Shop_id = "+similar.getShop_id()+" AND bill_type=0 ");
			sql.append("GROUP BY bill_created_date, bill_import_target_Shop_id ");
			sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC ");		
			sql.append(";");
			
			sql.append("SELECT bill_export_current_Shop_id, tblbill.bill_created_date, SUM(bill_detail_product_price*bill_detail_product_quantity) as export_value FROM tblbill ");
			sql.append("INNER JOIN tblbilldetail ON tblbill.bill_id=tblbilldetail.bill_detail_id ");
			sql.append("WHERE bill_export_current_Shop_id = "+similar.getShop_id()+" AND bill_type=1 ");
			sql.append("GROUP BY bill_created_date, bill_export_current_Shop_id ");
			sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC ");		
			sql.append(";");
			
			sql.append("SELECT tblproduct.*, bill_created_date, wpsd_Shop_id, AVG(bill_detail_product_price) AS AvgExport, SUM(bill_detail_product_quantity) as TotalExport FROM tblwpsd ");
			sql.append("LEFT JOIN tblbilldetail ON tblbilldetail.bill_detail_product_id=tblwpsd.wpsd_product_id ");
			sql.append("LEFT JOIN tblbill ON tblbill.bill_id=tblbilldetail.bill_detail_id ");
			sql.append("LEFT JOIN tblproduct ON tblwpsd.wpsd_product_id=tblproduct.product_id ");
			sql.append("WHERE bill_type=1 AND wpsd_deleted=0 AND wpsd_Shop_id="+similar.getShop_id()+" ");
			sql.append("GROUP BY product_id, bill_created_date, wpsd_Shop_id ");
			sql.append("ORDER BY ABS(DATEDIFF(STR_TO_DATE(bill_created_date, '%e/%c/%Y'), NOW())) ASC, TotalExport DESC");
			sql.append(";");
			
			
			
			
			System.out.println(sql.toString());
		} else {
			sql.append("SELECT * FROM tblShop ");
			sql.append("LEFT JOIN tbluser ON tblShop.Shop_creator_id=tbluser.user_id ");
			sql.append(this.createCondition(similar,currentUser));
			switch (type) {	
				case NAME:
					sql.append(" ORDER BY Shop_name ASC ");
				break;
				case MANAGER:
					sql.append(" ORDER BY user_name ASC ");
					break;
				case ADDRESS:
					sql.append(" ORDER BY Shop_address ASC ");
					break;
				case CREATED:
					sql.append(" ORDER BY ORDER BY STR_TO_DATE(Shop_created_date, '%e/%c/%Y') DESC ");
					break;
				case MODIFIED:
					sql.append(" ORDER BY Shop_last_modified_date DESC ");
					break;
				default:
					sql.append(" ORDER BY Shop_id ASC ");
			}	
			sql.append("LIMIT "+at+"," +wpPerPage+";");
			
			
			
			//Lấy thông tin tạo biểu đồ
			
			sql.append("SELECT tblbill.bill_import_target_Shop_id, bill_created_date, SUM(bill_detail_product_price*bill_detail_product_quantity/1000) AS import_value FROM tblbill ");
			sql.append("LEFT JOIN tblbilldetail ON tblbill.bill_id=tblbilldetail.bill_detail_id ");
			sql.append("WHERE bill_type=0 ");
			sql.append("GROUP BY bill_import_target_Shop_id,bill_created_date ");
			sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC ");
			sql.append(";");
			
			sql.append("SELECT tblbill.bill_export_current_Shop_id, bill_created_date, SUM(bill_detail_product_price*bill_detail_product_quantity/1000) AS export_value FROM tblbill ");
			sql.append("LEFT JOIN tblbilldetail ON tblbill.bill_id=tblbilldetail.bill_detail_id ");
			sql.append("WHERE bill_type=1 ");
			sql.append("GROUP BY bill_export_current_Shop_id,bill_created_date ");
			sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC ");	
			sql.append(";");	
		
			sql.append("SELECT tblproduct.*, wpsd_Shop_id, bill_created_date, MAX(bill_detail_product_price) AS AvgExport, SUM(bill_detail_product_quantity) as TotalExport FROM tblwpsd ");
			sql.append("LEFT JOIN tblproduct ON tblwpsd.wpsd_product_id=tblproduct.product_id ");
			sql.append("LEFT JOIN tblbilldetail ON tblbilldetail.bill_detail_product_id=tblwpsd.wpsd_product_id ");
			sql.append("LEFT JOIN tblbill ON tblbill.bill_id=tblbilldetail.bill_detail_id ");	
			sql.append("WHERE bill_type=1 AND wpsd_deleted=0 ");
			sql.append("GROUP BY product_id, bill_created_date, wpsd_Shop_id ");
			sql.append("ORDER BY ABS(DATEDIFF(STR_TO_DATE(bill_created_date, '%e/%c/%Y'), NOW())) ASC, TotalExport DESC");
			sql.append(";");	
			System.out.println(sql.toString());
		}
		
		sql.append("SELECT COUNT(Shop_id) AS total FROM tblShop LEFT JOIN tbluser ");
		sql.append("ON tblShop.Shop_creator_id=tbluser.user_id ");
		sql.append(this.createCondition(similar,currentUser));
		sql.append(";");					
		
		sql.append("SELECT * FROM tblemployee ");
		sql.append("INNER JOIN tbluser ON tbluser.user_id=tblemployee.employee_id ");
		if (currentUser!=null) {
			sql.append("WHERE user_permission<="+currentUser.getUser_permission()+" ");
			int id = currentUser.getUser_id();	
			if (id>0) {			 
				if (currentUser.getUser_permission()<4) {			 
					 sql.append("AND ( (user_parent_id=").append(id).append(") OR (user_id=").append(id).append(") )") ;
				} else {
					 
				}		
			}
		}
		sql.append(";");
	
//		sql.append(this.createCondition(currentUser));
//		System.out.print(sql.toString());		
		
		return this.getReList(sql.toString());
	}
	
	private String SELECTCondition(ShopObject similar, UserObject currentUser) {
		 StringBuilder conds = new StringBuilder();
		 
		 if (similar!=null) {
		
		 }
		 
		 if (!conds.toString().equalsIgnoreCase("")) {
			 conds.insert(0,"HAVING ");
		 }
		 
		 return conds.toString();
	}
	
	private String createCondition(ShopObject similar, UserObject currentUser) {
		 StringBuilder conds = new StringBuilder();
		 if (currentUser!=null) {
			 byte permis = currentUser.getUser_permission();// Tài khoản đăng nhập truyên cho
			 //Phân tầng quản trị
			 conds.append("(user_permission<=").append(permis).append(") ");
			 
			 int id = currentUser.getUser_id();			 	
			 
			 if (id>0) {				 
				 if (permis<4) {			 
					 conds.append("AND ( (user_parent_id=").append(id).append(") OR (Shop_creator_id=").append(id).append(") OR (Shop_creator_id=").append(id).append(") )") ;
				 } else {
					 
				 }			
			 }
			 
			 if (similar!=null) {
				 //Kiểm tra tồn tại
				 if (similar.isShop_deleted()) {
					 conds.append("AND (Shop_deleted=1)");
				 } else {
					 conds.append("AND (Shop_deleted=0)");
				 }
				 
				 //Xử lí từ khóa tìm kiếm
				 String key = similar.getShop_name();
				 if (key!=null && !key.equalsIgnoreCase("")) {
					 conds.append(" AND (");
					 conds.append("(Shop_name LIKE '%"+key+"%') OR ");
					 conds.append("(Shop_address LIKE '%"+key+"%') ");
					 conds.append(") ");
				 }		 
			 }		
		 }
		 	 
		 if (!conds.toString().equalsIgnoreCase("")) {
			 conds.insert(0,"WHERE ");
		 }
		 
		 return conds.toString();
	}

	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc Shop
		Shop u=new ShopImpl(cp);
		
		//Them mot nguoi su dung
		ShopObject new_Shop = new ShopObject();
		new_Shop.setShop_name("Kho hàng Nguyên");
		new_Shop.setShop_manager_id(19);
		new_Shop.setShop_address("Lâm Đồng");
		new_Shop.setShop_created_date("29/12/2003");
		UserObject currentUser = new UserObject();
		currentUser.setUser_name("Tran The Hưởng");
		currentUser.setUser_permission((byte)1);
		ProductObject wsd1 = new ProductObject();
		wsd1.setWpsd_product_id(1);
		wsd1.setWpsd_product_quantity(12);
		ProductObject wsd2 = new ProductObject();
		wsd2.setWpsd_product_id(3);
		wsd2.setProduct_quantity(5);
		ArrayList<ProductObject> sdl = new ArrayList<ProductObject>();
		sdl.add(wsd1);
		sdl.add(wsd2);
//		new_Shop.setShop_id(2);
		
		ArrayList<ShopObject> new_ShopList = new ArrayList<ShopObject>();
		new_ShopList.add(new_Shop);
//		boolean result = u.addShop(new_ShopList,sdl, currentUser);
//		
//		if (!result) {
//			System.out.print("\n---------------------Khong thanh cong---------------------\n");
//		}
		
		Sextet<UserObject, 
		ShopObject, 
		Integer, 
		Byte ,
		SHOP_SORT_TYPE,
		Boolean> infors = new Sextet<>(currentUser,new_Shop,0,(byte)25, SHOP_SORT_TYPE.NAME,false);
		//Lay tap ban ghi nguoi su dung
		ArrayList<ResultSet> res = u.getShops(infors);
		
		ResultSet rs = res.get(3);
		String row = null;
		//Duyen va hien thi danh sach nguoi su dung
		if (rs!=null) {
			try {
				while (rs.next()) {
//					row = "ID: "+rs.getInt("Shop_id");
//					row += "\tNAME: "+rs.getString("Shop_name");
//					row += "\tNICKNAME: "+rs.getString("Shop_manager_id");
//					row += "\tADDRESS: "+rs.getString("Shop_address");
					row = "\tDATE: "+rs.getString("bill_created_date");
					row += "\tEXPORT:"+rs.getInt("TotalExport");
					row += "\tTOTAL: "+rs.getInt("AvgExport");
					row += "\tWP: "+rs.getInt("wpsd_Shop_id");
					row += "\tPRODUCT: "+rs.getInt("product_id");
					System.out.println(row);
				}			
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs=res.get(4);
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

	@Override
	public boolean addShop(ArrayList<ShopObject> shopObjects, UserObject currentUser) {
		ShopObject wItem = wItems.get(0);
		if (this.isExisting(wItem)) {
			return false;
		}
		
		StringBuilder getIdSql = new StringBuilder();
		getIdSql.append("SELECT AUTO_INCREMENT ");
		getIdSql.append("FROM information_schema.TABLES ");
		getIdSql.append("WHERE TABLE_SCHEMA=\"test\" ");
		getIdSql.append("AND TABLE_NAME=\"tblShop\"; ");
		System.out.println(getIdSql.toString());		
		ResultSet ShopId = this.getReList(getIdSql.toString()).get(0);
		
		if (ShopId==null) {
			return false;
		}
		
		try {
			if (ShopId.next()) {
				int id = ShopId.getInt("AUTO_INCREMENT");
				ShopId.close();
				
				StringBuilder sql = new StringBuilder();			
				
				sql.append("INSERT INTO tblShop(");
				sql.append("Shop_name, Shop_type, Shop_address, ");
				sql.append("Shop_manager_id, Shop_created_date, Shop_website_link, ");
				sql.append("Shop_map_link, Shop_last_modified_id, ");
				sql.append("Shop_last_modified_date, Shop_images, ");
				sql.append("Shop_investment, Shop_expected_profit, Shop_notes, ");
				sql.append("Shop_phone, Shop_email, Shop_creator_id");
				sql.append(")");
				sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ");
			
				
				System.out.println(sql.toString());
				
				PreparedStatement pre1 = this.con.prepareStatement(sql.toString());
				
				pre1.setString(1,wItem.getShop_name());
				pre1.setString(3, wItem.getShop_address());
				pre1.setString(5, wItem.getShop_created_date());
				pre1.setString(6, wItem.getShop_website_link());
				pre1.setString(7, wItem.getShop_map_link());
				pre1.setString(9, wItem.getShop_last_modified_date());
				pre1.setString(10, wItem.getShop_images());
				pre1.setString(13, wItem.getShop_notes());
				pre1.setString(14, wItem.getShop_phone());
				pre1.setString(15, wItem.getShop_email());
				pre1.setInt(16, wItem.getShop_creator_id());
				

				
				boolean result = this.add(pre1);
				
				if (result && wsdItem != null && wsdItem.size()>0) {								
					
					sql.setLength(0);
					sql.append("INSERT INTO tblwpsd(");
					sql.append("wpsd_Shop_id, wpsd_product_id, ");
					sql.append("wpsd_product_quantity, wpsd_created_date ");
					sql.append(")");
					sql.append("VALUES");
					sql.append("(?,?,?,?)");		
					System.out.println(sql.toString());
					PreparedStatement pre3 = this.con.prepareStatement(sql.toString());									
					wsdItem.forEach(item->{
						try {
							pre3.setInt(1, id);
							pre3.setInt(2, item.getWpsd_product_id());
							pre3.setInt(3, item.getWpsd_product_quantity());
							pre3.setString(4, item.getWpsd_created_date());
							pre3.addBatch();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
					});	
					return this.addList(pre3);							
				}					
				return result;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editShop(ArrayList<ShopObject> shopObjects, SHOP_EDIT_TYPE et, UserObject currentUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delShop(ArrayList<ShopObject> shopObjects, UserObject currentUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ResultSet> getShops(Triplet<ShopObject, Integer, Byte> infors, SHOP_SORT_TYPE st,
			UserObject currentUser) {
		// TODO Auto-generated method stub
		return null;
	}
}
