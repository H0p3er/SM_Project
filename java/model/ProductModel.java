package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.javatuples.Pair;
import org.javatuples.Quintet;

import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import repository.*;
import entity.PCObject;
import entity.ProductObject;
import utility.Utilities;

public class ProductModel {
	private Product p;
	private PC pc;

	public ProductModel(ConnectionPool cp) {
		this.p = new ProductImpl(cp);
		this.pc = new PCImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.p = null;
		this.pc = null;
	}

	public ConnectionPool getCP() {
		return this.p.getCP();
	}

	public void releaseConnection() {
		this.p.releaseCP();
		this.pc.releaseCP();
	}

	// ***********************Chuyen huong dieu khien tu Product
	// Impl*****************************************
	public boolean addProduct(ProductObject item) {
		return this.p.addProduct(item);
	}

	public boolean editProduct(ProductObject item, PRODUCT_EDIT_TYPE type) {
		return this.p.editProduct(item, type);
	}

	public boolean delProduct(ProductObject item) {
		return this.p.delProduct(item);
	}

	// ****************************************************************

	public ProductObject getProductObject(int id) {
		// Gan gia tri khoi tao cho doi tuong ProductObject
		ProductObject item = null;

		// Lay ban ghi
		ResultSet rs = this.p.getProductById(id);

		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getInt("product_id"));
					item.setProduct_name(Utilities.decode(rs.getString("product_name")));
					item.setProduct_status(rs.getByte("product_status"));
					item.setProduct_price(rs.getDouble("product_price"));
					item.setProduct_images(rs.getString("product_images"));
					item.setProduct_notes(rs.getString("product_notes"));
					item.setProduct_last_modified(rs.getString("product_last_modified"));
					item.setProduct_pc_id(rs.getInt("product_pc_id"));
					item.setProduct_shop_id(rs.getInt("product_shop_id"));
					item.setProduct_quantity(rs.getInt("product_quantity"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	

	/**
	 * Phương thức lấy về danh sách đối tượng và tổng số bản ghi
	 * @param similar
	 * @param page
	 * @param pPerPage
	 * @param type
	 * @param isExport
	 * @return
	 * 		danh sách đối tượng<br/>
	 * 		Tổng số bản ghi
	 */
	public Pair<ArrayList<ProductObject>, Integer> getProductObjects(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {
		//Lay du lieu
		short page = infors.getValue0();
		byte productPerPage = infors.getValue1();	
		Map<String,String> multiField = infors.getValue2();
		Map<String,String> multiCondition = infors.getValue3();
		Map<String,String> multiSort = infors.getValue4();
		ArrayList<ProductObject> items = new ArrayList<>();
		ProductObject item = null;
		// Lay ban ghi
		int at = (page - 1) * productPerPage;
		ArrayList<ResultSet> res = this.p.getProducts(at, productPerPage, multiField, multiCondition, multiSort);
		ResultSet rs = res.get(0);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getInt("product_id"));
					item.setProduct_name(Utilities.decode(rs.getString("product_name")));
					item.setProduct_status(rs.getByte("product_status"));
					item.setProduct_price(rs.getDouble("product_price"));
					item.setProduct_images(rs.getString("product_images"));
					item.setProduct_notes(rs.getString("product_notes"));
					item.setProduct_last_modified(rs.getString("product_last_modified"));
					item.setProduct_pc_id(rs.getInt("product_pc_id"));
					item.setProduct_shop_id(rs.getInt("product_shop_id"));
					item.setProduct_quantity(rs.getInt("product_quantity"));
					// Dua doi tuong vao tap hop
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int product_count = getProductObjectsSize(rs);
		return new Pair<>(items, product_count);
	}
	
	
	public int getProductObjectsSize(ResultSet rs) {
		// Lay tong so ban ghi
		int product_count = 0;
		if (rs != null) {
			try {
				if (rs.next()) {
					product_count = rs.getInt("product_count");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return product_count;
	}
}
