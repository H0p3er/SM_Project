package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;

import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import constant.PRODUCT_SORT_TYPE;
import repository.*;
import entity.ProductObject;
import utility.Utilities;

public class ProductModel {
	private Product p;

	public ProductModel(ConnectionPool cp) {
		this.p = new ProductImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.p = null;
	}

	public ConnectionPool getCP() {
		return this.p.getCP();
	}

	public void releaseConnection() {
		this.p.releaseCP();
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
	public Pair<ArrayList<ProductObject>, Integer> getProductObjects(ProductObject similar, short page, byte pPerPage,
			PRODUCT_SORT_TYPE type, boolean isExport) {

		// Gan gia tri khoi tao cho doi tuong ProductObject
		ArrayList<ProductObject> items = new ArrayList<>();
		ProductObject item = null;

		// Lay ban ghi
		int at = (page - 1) * pPerPage;
		ArrayList<ResultSet> res = this.p.getProducts(similar, at, pPerPage, type);

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

		// Lay tong so ban ghi
		int totalGlobal = 0;
		rs = res.get(1);
		if (rs != null) {
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
		return new Pair<>(items, totalGlobal);
	}
}
