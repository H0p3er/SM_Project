package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import connection.*;
import constant.PRODUCT_EDIT_TYPE;
import constant.PRODUCT_SORT_TYPE;
import entity.ProductObject;
import basic.BasicImpl;

public class ProductImpl extends BasicImpl implements Product {

	public static void main(String[] args) {
		int id = 1;
		ConnectionPool cp = new ConnectionPoolImpl();
		ArrayList<ResultSet> list = new ArrayList<ResultSet>();
		Product a = new ProductImpl(cp);
		ProductObject b = new ProductObject();
		list = a.getProducts(b, id, (byte) 5, PRODUCT_SORT_TYPE.NAME);
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
		String sql = "INSERT INTO tblproduct(";
		sql += "product_name, product_images, product_notes, product_created_date, ";
		sql += "product_pc_id, product_shop_id, product_quantity, product_price)";
		sql	+= "VALUE (?,?,?,?,?,?,?,?)";

		// Biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
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
		String sql = "UPDATE tblProduct SET ";
		switch (et) {
			case GENERAL:
				sql += "product_name=?, product_images=?, product_notes=?, ";
				sql += "product_pc_id=?, product_quantity=?, product_price=?";
			break;
			case TRASH:
				sql += "product_deleted=1";
			break;
			case RESTORE:
				sql += "product_deleted=0";
			break;
		}
		
		sql += "WHERE product_id=?; ";
		// Biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			if (et == PRODUCT_EDIT_TYPE.GENERAL) {
			pre.setString(1, utility.Utilities.encode(item.getProduct_name()));
			pre.setString(2, item.getProduct_images());
			pre.setString(3, utility.Utilities.encode(item.getProduct_notes()));
			pre.setInt(4, item.getProduct_pc_id());
			pre.setInt(5, item.getProduct_quantity());
			pre.setDouble(6, item.getProduct_price());
			pre.setInt(7, item.getProduct_id());
			} else {
				pre.setInt(1, item.getProduct_id());
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

	@Override
	public boolean delProduct(ProductObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmpty(item)) {
			return false;
		}
		String sql = "DELETE FROM tblProduct WHERE product_id=? ";

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

	private boolean isEmpty(ProductObject item) {
		boolean flag = true;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT bd_id FROM tblbd WHERE bd_product_id=" + item.getProduct_id() + "; ");
		
		
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
	public ResultSet getProductById(int id) {
		String sql = "SELECT * FROM tblProduct WHERE (product_id=?) AND (product_deleted=0)";

		return this.get(sql, id);
	}
	
	// Phương thức này có thể thực hiện nhều câu lệnh cùng lúc
	// similar là đối tượng tương tự
	@Override
	public ArrayList<ResultSet> getProducts(ProductObject similar, int at, byte total, PRODUCT_SORT_TYPE type) {

		String sql = "SELECT * FROM tblProduct ";
		String sql2 = "SELECT COUNT(Product_id) AS total FROM tblProduct ";
		sql2 += this.createConditions(similar);
		sql += this.createConditions(similar);
		switch (type) {
			case NAME:
				sql += "ORDER BY product_name ASC ";
				break;
			case PRICE:
				sql += "ORDER BY Product_address ASC ";
				break;
			case MODIFIED:
				sql += "ORDER BY product_last_modified DESC ";
				break;
			default:
				sql += "ORDER BY product_id ASC ";
		}
		if(total > 0) {
			sql += "LIMIT " + at + ", " + total + "; ";
		} else {
			sql += ";";
		}
		
		StringBuilder multiSelect = new StringBuilder();
		multiSelect.append(sql);
		multiSelect.append(sql2);
		System.out.println(sql);
		return this.getReList(multiSelect.toString());
	}
	
	private String createConditions(ProductObject similar) {
		StringBuilder conds = new StringBuilder();
//		if(similar !=  null) {
//			
//			// Từ khóa tìm kiếm
//			String key = similar.getProduct_name();
//			if(similar.getProduct_deleted()==1) {
//				conds.append("(product_deleted=1) ");
//			} else {
//				conds.append("(product_deleted=0) ");
//			}
//			if(key != null && !key.equalsIgnoreCase("")) {
//				conds.append(" AND ");
//				conds.append("(product_name LIKE '%"+key+"%')");
//			}
//		}
//		
//		if(!conds.toString().equalsIgnoreCase("")) {
//			conds.insert(0, "WHERE ");
//		}
//		
		if (similar != null)
		{
			if(similar.getProduct_deleted()==1) {
				conds.append("(product_deleted=1) ");
			} else {
				conds.append("(product_deleted=0) ");
			}
		}
		if(!conds.toString().equalsIgnoreCase("")) {
		conds.insert(0, "WHERE ");
		}
		return conds.toString();
	}

	@Override
	public ResultSet getProductByCreatedDate(Date date, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
