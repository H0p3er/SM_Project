package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

import org.javatuples.*;

import connection.*;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import dto.bd.BD_DTO;
import dto.bill.Bill_DTO;
import dto.product.Product_manageShopDTO;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import repository.Bill;
import repository.BillImpl;
import utility.Utilities;

public class BillModel {

	private Bill bill;

	public BillModel(ConnectionPool cp) {
		this.bill = new BillImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.bill = null;
	}

	public ConnectionPool getCP() {
		return this.bill.getCP();
	}

	public void releaseConnection() {
		this.bill.releaseCP();
	}

	// ***********************Chuyen huong dieu khien tu Bill
	// Impl*****************************************
	public boolean addBill(Bill_DTO bill_DTO) {
		BillObject billObject = new BillObject();
		ArrayList<BDObject> bdObjects = new ArrayList<BDObject>();
		bill_DTO.ApplyToEntity(billObject, bdObjects);
		;
		return this.bill.addBill(billObject, bdObjects);
	}

	public boolean editBill(Bill_DTO bill_DTO, BILL_EDIT_TYPE et) {
		BillObject billObject = new BillObject();
		ArrayList<BDObject> bdObjects = new ArrayList<BDObject>();
		bill_DTO.ApplyToEntity(billObject, bdObjects);
		return this.bill.editBill(billObject, bdObjects, et);
	}

	public boolean delBill(Bill_DTO bill_DTO) {
		BillObject billObject = new BillObject();
		ArrayList<BDObject> bdObjects = new ArrayList<BDObject>();
		bill_DTO.ApplyToEntity(billObject, bdObjects);
		return this.bill.delBill(billObject);
	}

	// ****************************************************************

	public BillObject getBill_DTOById(int id) {
		// Gan gia tri khoi tao cho doi tuong BillObject
		BillObject item = null;
		// Lay ban ghi
		ResultSet rs = this.bill.getBillById(id);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new BillObject();
					item.setBill_id(rs.getInt("bill_id"));
					item.setBill_created_date(rs.getString("bill_created_date"));
					item.setBill_creator_id(rs.getInt("bill_creator_id"));
					item.setBill_status(rs.getByte("bill_status"));
					item.setBill_delivery_id(rs.getInt("bill_delivery_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public Triplet<Map<String, Double>, Double, Double> getIncomeStatisticByShop(ShopObject shopObject) {
		ArrayList<ResultSet> res = this.bill.getIncomeStatisticByShop(shopObject,
				java.time.LocalDateTime.now().getMonth().getValue());
		ResultSet rs = res.get(0);
		Map<String, Double> income_current_month = new HashMap<String, Double>();
		if (rs != null) {
			try {
				while (rs.next()) {
					income_current_month.put(rs.getString("bill_created_date"), rs.getDouble("income_by_month"));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(1);
		double sum_income_current_month = 0;
		if (rs != null) {
			try {
				if (rs.next()) {
					sum_income_current_month = rs.getDouble("sum_income_by_month");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		double sum_income_last_month = 0;
		rs = res.get(2);
		if (rs != null) {
			try {
				if (rs.next()) {
					sum_income_last_month = rs.getDouble("sum_income_by_month");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Triplet<>(income_current_month, sum_income_current_month, sum_income_last_month);
	}

	public Triplet<Map<String, Integer>, Integer, Integer> getOrderStatisticByShop(ShopObject shopObject) {
		ArrayList<ResultSet> res = this.bill.getOrderStatisticByShop(shopObject,
				java.time.LocalDateTime.now().getMonth().getValue());
		ResultSet rs = res.get(0);
		Map<String, Integer> order_current_month = new HashMap<String, Integer>();
		if (rs != null) {
			try {
				while (rs.next()) {
					order_current_month.put(rs.getString("bill_created_date"), rs.getInt("order_by_month"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(1);
		int count_order_current_month = 0;
		if (rs != null) {
			try {
				if (rs.next()) {
					count_order_current_month = rs.getInt("count_order_by_month");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int count_order_last_month = 0;
		rs = res.get(2);
		if (rs != null) {
			try {
				if (rs.next()) {
					count_order_last_month = rs.getInt("count_order_by_month");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Triplet<>(order_current_month, count_order_current_month, count_order_last_month);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();

		BillModel wm = new BillModel(cp);

		BillObject similar = new BillObject();

		
//		items.getValue2().forEach((key,value) -> System.out.println(key.getBill_name()+":"+value));

	};
}
