package repository;

import java.sql.*;
import java.util.ArrayList;
import connection.*;
import constant.PRODUCT_SORT_TYPE;
import entity.ProductObject;
import basic.BasicImpl;

public class ProductImpl extends BasicImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
	}

	@Override
	public boolean addProduct(ProductObject item) {
		if (this.isExisting(item)) {
			return false;
		}

		String sql = "INSERT INTO tblProduct(";
		sql += "product_name, product_category_id, product_status, product_deleted, ";
		sql += "product_price, product_images, product_provider_id, product_guarantee_id, product_notes, product_last_modified) ";
		sql += "product_discount, product_sold ";
		sql	+= "VALUE(?,?,?,?,?,?,?,?)";

		// Biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getProduct_name());
			pre.setShort(2, item.getProduct_category_id());
			pre.setShort(3, item.getProduct_status());
			pre.setBoolean(4, item.isProduct_deleted());
			pre.setInt(5, item.getProduct_price());
			pre.setString(6, item.getProduct_images());
			pre.setShort(7, item.getProduct_provider_id());
			pre.setInt(8, item.getProduct_guarantee_id());
			pre.setString(9, item.getProduct_notes());
			pre.setString(10, item.getProduct_last_modified());


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
		// Trường hợp giả định tài khoản chưa tồn tại
		boolean flag = false;

		String sql = "SELECT product_id FROM tblProduct WHERE product_name='" + item.getProduct_name() + "' AND product_provider_id='"+item.getProduct_provider_id()+"'; ";
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
	public boolean editProduct(ProductObject item) {
		String sql = "UPDATE tblProduct SET ";
		sql += "product_name=?, product_category_id=?, product_status=?, product_deleted=?, ";
		sql += "product_price=?, product_images=?, product_provider_id=?, product_guarantee_id=?, product_notes=?, product_last_modified=? ";
		sql += "product_discount=?, product_sold=? ";
		sql += "WHERE product_id=?; ";

		// Biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getProduct_name());
			pre.setShort(2, item.getProduct_category_id());
			pre.setShort(3, item.getProduct_status());
			pre.setBoolean(4, item.isProduct_deleted());
			pre.setInt(5, item.getProduct_price());
			pre.setString(6, item.getProduct_images());
			pre.setShort(7, item.getProduct_provider_id());
			pre.setInt(8, item.getProduct_guarantee_id());
			pre.setString(9, item.getProduct_notes());
			pre.setString(10, item.getProduct_last_modified());


			return this.edit(pre);
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
	public boolean delProduct(ProductObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmpty(item)) {
			return false;
		}
		String sql = "DELETE FROM tblProduct WHERE product_id=? ";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setShort((short)1, item.getProduct_id());

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
		sql.append("SELECT article_id FROM tblarticle WHERE article_author_name=" + item.getProduct_name() + "; ");
		sql.append("SELECT product_id FROM tblproduct WHERE product_manager_id=" + item.getProduct_id() + "; ");
		sql.append("SELECT Product_id FROM tblProduct WHERE Product_parent_id=" + item.getProduct_id() + ";");
		
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
	public ResultSet getProduct(int id) {
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
		
		return this.getReList(multiSelect.toString());
	}
	
	private String createConditions(ProductObject similar) {
		StringBuilder conds = new StringBuilder();
		if(similar !=  null) {
			
			// Từ khóa tìm kiếm
			String key = similar.getProduct_name();
			if(key != null && !key.equalsIgnoreCase("")) {
				conds.append(" AND ");
				conds.append("(product_name LIKE '%"+key+"%')");
			}
			
			if(similar.isProduct_deleted()) {
				conds.append(" AND (product_deleted=1) ");
			} else {
				conds.append(" AND (product_deleted=0) ");
			}
		}
		
		if(!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, " WHERE ");
		}
		
		return conds.toString();
	}
}
