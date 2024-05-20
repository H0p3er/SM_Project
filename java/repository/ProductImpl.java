package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import connection.*;
import constant.PRODUCT_EDIT_TYPE;
import entity.BillObject;
import entity.PCObject;
import entity.ProductObject;
import entity.ShopObject;
import entity.UserObject;
import basic.BasicImpl;


public class ProductImpl extends BasicImpl implements Product{
	
	public static void main(String[] args) {
		int id = 1;
		ConnectionPool cp = new ConnectionPoolImpl();
		ArrayList<ResultSet> list = new ArrayList<ResultSet>();
		Product a = new ProductImpl(cp);
		ProductObject b = new ProductObject();
		
		ResultSet rs = list.get(0);
		if (rs!=null) {
			try {
				while (rs.next()) {
					System.out.println(rs.getString("product_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ProductObject c = new ProductObject();
		c.setProduct_name("Dell XPS 15 9530 i7 13700H (71015716)");
		c.setProduct_images(null);
		c.setProduct_notes(null);
		c.setProduct_created_date(utility.Utilities_date.getCurrentDateTime());
		c.setProduct_pc_id(3);
		c.setProduct_shop_id(1);
		c.setProduct_quantity(100);
		c.setProduct_price(20000);
		c.setProduct_id(46);
		if (a.editProduct(c,PRODUCT_EDIT_TYPE.GENERAL))
			System.out.print("true");
		else {
			System.out.print("false");
			}
		
	}
	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
	}

	@Override
	public boolean addProduct(ProductObject item) {
		if (this.isExisting(item)) {
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblproduct(");
		sql.append("product_name, product_images, product_notes, product_created_date, ");
		sql.append("product_pc_id, product_shop_id, product_quantity, product_price) ");
		sql.append("VALUE (?,?,?,?,?,?,?,?);");

		// Biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, utility.Utilities.encode(item.getProduct_name()));
			pre.setString(2, item.getProduct_images());
			pre.setString(3, utility.Utilities.encode(item.getProduct_notes()));
			pre.setString(4, item.getProduct_created_date());
			pre.setInt(5, item.getProduct_pc_id());
			pre.setInt(6, item.getProduct_shop_id());
			pre.setInt(7, item.getProduct_quantity());
			pre.setDouble(8, item.getProduct_price());

			return this.add(pre);
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

	// Phương thức ràng buộc sự duy nhất của Product_name
	private boolean isExisting(ProductObject item) {
		boolean flag = false;
		String sql = "SELECT product_id FROM tblProduct WHERE product_name='" + item.getProduct_name() + "' AND product_shop_id='"+item.getProduct_shop_id()+"'; ";
		ResultSet rs = this.gets(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean editProduct(ProductObject item, PRODUCT_EDIT_TYPE et) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblproduct SET ");
		switch (et) {
			case GENERAL:
				sql.append("product_name=?, product_images=?, product_notes=?, ");
				sql.append("product_pc_id=?, product_quantity=?, product_price=?");
			break;
			case TRASH:
				sql.append("product_deleted=1 ");
			break;
			case RESTORE:
				sql.append("product_deleted=0 ");
			break;
			
			default:
				break;
		}
		
		sql.append("WHERE product_id=?; ");
		// Biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch (et) {
			case GENERAL:
				pre.setString(1, utility.Utilities.encode(item.getProduct_name()));
				pre.setString(2, item.getProduct_images());
				pre.setString(3, utility.Utilities.encode(item.getProduct_notes()));
				pre.setInt(4, item.getProduct_pc_id());
				pre.setInt(5, item.getProduct_quantity());
				pre.setDouble(6, item.getProduct_price());
				pre.setInt(7, item.getProduct_id());
				break;	
				
			case TRASH:	
				pre.setInt(1, item.getProduct_id());
				break;
				
			default:
				break;
			} 
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	private boolean isEmpty(ProductObject item) {
		boolean flag = true;	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT bd_id FROM tblbd WHERE bd_product_id=" + item.getProduct_id() + "; ");
		sql.append("SELECT shop_id FROM tblshop WHERE product_shop_id=" + item.getProduct_id() + "; ");
		ArrayList<ResultSet> res = this.getReList(sql.toString());		
		for(ResultSet rs : res) {
			try {
				if(rs != null && rs.next()) {
					flag = false;
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return flag;
	}


	@Override
	public boolean delProduct(ProductObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmpty(item)) {
			return false;
		}
		String sql = "DELETE FROM tblproduct WHERE product_id=? ";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getProduct_id());

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
	public ResultSet getProductById(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.*, pc.pc_name FROM tblproduct p ");
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("WHERE (product_id=?) AND (product_deleted=0); ");
		return this.get(sql.toString(), id);
	}	
	
	@Override
	public ArrayList<ResultSet> getProducts() {
		StringBuilder sql = new StringBuilder();
		sql.append(getProductsNewestSQL());
		sql.append(getProductsMostSoldSQL());
		return this.getReList(sql.toString());
	}

	private String getProductsNewestSQL() {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.*, pc.pc_name FROM tblproduct p ");
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("WHERE (p.product_deleted=0) ");
		sql.append("ORDER BY STR_TO_DATE(product_created_date, '%e/%c/%Y') ASC ");
		sql.append("LIMIT 0,6; ");
		return sql.toString();
	}
	
	private String getProductsMostSoldSQL() {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.*, pc.pc_name, SUM(bd_product_quantity) as sold_quantity FROM tblproduct p ");
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("INNER JOIN tblbd bd ON bd.bd_product_id = p.product_id ");
		sql.append("WHERE (p.product_deleted=0) ");
		sql.append("GROUP BY (p.product_id) ");
		sql.append("ORDER BY (sold_quantity) DESC ");
		sql.append("LIMIT 0,6; ");
		return sql.toString();
	}	
	
	/**
	 * Lấy danh sách sản phẩm theo hoạt động tìm kiếm
	 * @param 
	 * 
	 * 
	 * */
	@Override
	public ArrayList<ResultSet> getProducts(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort) {
		StringBuilder sql = new StringBuilder();
		sql.append(getProductsSQL(at, total, multiField, multiCondition ,multiSort));
		sql.append(getProductsSizeSQL(multiCondition));		
		System.out.println(sql.toString());
		return this.getReList(sql.toString());
	}
	
	private String getProductsSQL(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproduct p ");
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append(this.WHEREConditions(multiCondition));
		sql.append(this.ORDERConditions(multiSort));	
		if(total > 0) {
			sql.append("LIMIT " + at + ", " + total + "; ");
		} else {
			sql.append(";");
		}
		return sql.toString();
	}
	
	private String getProductsSizeSQL(Map<String,String> multiCondition) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(product_id) AS product_count FROM tblproduct p ");
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append(this.WHEREConditions(multiCondition));	
		sql.append(";");
		return sql.toString();
	}
	
	@Override
	public ArrayList<ResultSet> getProductsByShop(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, ShopObject shopObject){
		StringBuilder sql = new StringBuilder();
		sql.append(getProductsByShopSQL(at, total, multiCondition, multiField, multiSort, shopObject));
		sql.append(getProductsSizeByShopSQL(shopObject));
	
//		sql.append(getIncomeLastMonthByShopSQL(shopObject));
//		sql.append(getIncomeCurrentMonthByShopSQL(shopObject));
//		
//		sql.append(getOrderLastMonthByShopSQL(shopObject));
//		sql.append(getOrderCurrentMonthByShopSQL(shopObject));
//		
//		sql.append(getCustomerLastMonthByShopSQL(shopObject));
//		sql.append(getCustomerCurrentMonthByShopSQL(shopObject));
		
		sql.append(getProductsMostSoldCurrentMonthByShopSQL(shopObject));
		System.out.println(sql.toString());
		return this.getReList(sql.toString());
	}
	
	
	private String getProductsByShopSQL(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, ShopObject object) {	
		StringBuilder sql = new StringBuilder();
		total=-1;
		sql.append("SELECT p.*, pc.pc_name FROM tblproduct p ");	
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("INNER JOIN tblshop s ON p.product_shop_id = s.shop_id ");
		sql.append("WHERE (p.product_shop_id="+object.getShop_id()+") AND (p.product_deleted=0) ");
		if(total > 0) {
			sql.append("LIMIT " + at + ", " + total + "; ");
		} else {
			sql.append(";");
		}
		return sql.toString();
	}	
	
	private String getProductsSizeByShopSQL(ShopObject object) {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(p.product_id) as product_count FROM tblproduct p ");	
		sql.append("INNER JOIN tblshop s ON p.product_shop_id = s.shop_id ");
		sql.append("WHERE ((p.product_shop_id="+object.getShop_id()+") AND (p.product_deleted=0)); ");
		return sql.toString();
	}

	
	private static String getProductsMostSoldCurrentMonthByShopSQL(ShopObject object) {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.*, SUM(product_price*bd_product_quantity) AS most_sold_product_by_month FROM tblproduct p ");
		sql.append("INNER JOIN tblbd bd ON p.product_id = bd.bd_product_id ");
		sql.append("INNER JOIN tblbill b ON b.bill_id = bd.bd_bill_id ");
		sql.append("WHERE ((p.product_shop_id="+object.getShop_id()+") AND (p.product_deleted=0) AND MONTH(STR_TO_DATE(bill_created_date, '%e/%c/%Y')) = (MONTH(CURRENT_DATE())) ) ");
		sql.append("GROUP BY product_id ");
		sql.append("ORDER BY most_sold_product_by_month ASC;");
		return sql.toString();
	}	
	
	
	@Override
	public ArrayList<ResultSet> getProductsByPC(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, PCObject pcObject) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(getProductsByPCSQL(at, total, multiField, multiCondition, multiSort, pcObject));
		sql.append(getProductsSizeByPCSQL(pcObject));
		return this.getReList(sql.toString());
	}
	
	private String getProductsByPCSQL(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, PCObject object) {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.*, pc.pc_name FROM tblproduct p ");	
		sql.append("INNER JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("WHERE (pc.pc_id="+object.getPc_id()+") AND (p.product_deleted=0) ");
		sql.append("GROUP BY p.product_id, pc.pc_name; ");
		if(total > 0) {
			sql.append("LIMIT " + at + ", " + total + "; ");
		} else {
			sql.append(";");
		}

		return sql.toString();
	}	
	
	private String getProductsSizeByPCSQL(PCObject object) {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(p.product_id) as product_count FROM tblproduct p ");	
		sql.append("INNER JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("WHERE (pc.pc_id="+object.getPc_id()+") AND (p.product_deleted=0); ");
		return sql.toString();
	}
	
	@Override
	public ArrayList<ResultSet> getProductsByBill(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, BillObject shopObject) {
		StringBuilder sql = new StringBuilder();
		sql.append(getProductsByBillSQL(at, total, multiCondition, multiField, multiSort, shopObject));
		sql.append(getProductsSizeByBillSQL(shopObject));
		return this.getReList(sql.toString());
	}
	
	private String getProductsByBillSQL(int at, byte total, Map<String,String> multiField, Map<String,String> multiCondition, Map<String,String> multiSort, BillObject object) {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.*, pc.pc_name FROM tblproduct p ");
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("INNER JOIN tblbd bd ON bd.bd_product_id = p.product_id ");
		sql.append("WHERE (p.product_shop_id="+object.getBill_id()+") AND (p.product_deleted=0) ");
		sql.append("GROUP BY p.product_id, pc.pc_name ; ");
		return sql.toString();
	}	
	
	private String getProductsSizeByBillSQL(BillObject object) {	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(p.product_id) as product_count FROM tblproduct p ");	
		sql.append("LEFT JOIN tblpc pc ON p.product_pc_id = pc.pc_id ");
		sql.append("INNER JOIN tblbd bd ON bd.bd_product_id = p.product_id ");
		sql.append("WHERE (p.product_shop_id="+object.getBill_id()+") AND (p.product_deleted=0); ");
		return sql.toString();
	}	
	

	private String WHEREConditions(Map<String,String> multiCondition) {
		StringBuilder WHERE = new StringBuilder();
		multiCondition.forEach((key,value)->{
			if (!WHERE.isEmpty() && !WHERE.toString().isBlank()) {
				WHERE.append("AND ");
			}
			switch (key) {
			case "search":
				WHERE.append("product_name LIKE '%"+value+"%' OR pc_name LIKE '%"+value+"%'");
				break;
			case "id":
				WHERE.append("product_id= ");
				break;
			case "address":
				WHERE.append("product_address="+value+" ");
				break;
			case "last_modified":
				WHERE.append("product_last_modified="+value+" ");
				break;
			case "category":
				WHERE.append("product_pc_id="+value+" ");
				break;
			case "max":
				WHERE.append("product_price <"+value+" ");
				break;
			case "min":
				WHERE.append("product_price >"+value+" ");
				break;
			default:
				WHERE.append("product_name LIKE '%"+value+"%' ");
				break;
			}			
		});		
		if(!WHERE.toString().equalsIgnoreCase("")) {
			WHERE.insert(0, "WHERE ");
		}
		
		return WHERE.toString();
	}
	
	private String ORDERConditions(Map<String,String> multiSort) {
		StringBuilder ORDER = new StringBuilder();
		multiSort.forEach((key,value)->{
			switch (key) {			
			case "name":
				ORDER.append("product_name");
				break;
			case "address":
				ORDER.append("product_address");
				break;
			case "last_modified":
				ORDER.append("product_last_modified");
				break;
			default:
				ORDER.append("STR_TO_DATE(product_created_date, '%e/%c/%Y')");
			}			
			switch (value) {
			case "asc":
				ORDER.append(" ASC;");
				break;
			case "desc":
				ORDER.append(" DESC;");
				break;
			default:
				ORDER.append(" ASC;");
				break;
			}
		});
		
		if(!ORDER.toString().equalsIgnoreCase("")) {
			ORDER.insert(0, "ORDER BY ");
		}
		return ORDER.toString();
	}
}
