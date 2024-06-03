package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import basic.BasicImpl;
import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.BILL_EDIT_TYPE;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import entity.UserObject;

public class BillImpl extends BasicImpl implements Bill {

	public BillImpl(ConnectionPool cp) {
		super(cp, "Bill");
	}

	public BillImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}

	@Override
    public boolean addBill(BillObject item, ArrayList<BDObject> bdObjects) {
        if (this.isExisting(item)) {
            return false;
        }
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tblbill(");
            sql.append("bill_created_date, bill_creator_id, ");
            sql.append("bill_delivery_id, bill_status ");
            sql.append(")");
            sql.append("VALUES(?,?,?,?); ");

            PreparedStatement pre = this.con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pre.setString(1, item.getBill_created_date());
            pre.setInt(2, item.getBill_creator_id());
            pre.setInt(3, item.getBill_delivery_id());
            pre.setByte(4, item.getBill_status());

            if (this.add(pre)) {
                int billId;
                ResultSet generatedKeys = pre.getGeneratedKeys();
                if (generatedKeys.next()) {
                    billId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating bill failed, no ID obtained.");
                }
                sql.setLength(0);
                sql.append("INSERT INTO tblbd(");
                sql.append("bd_bill_id, bd_product_id, ");
                sql.append("bd_product_quantity");
                sql.append(")");
                sql.append("VALUES(?,?,?,?);");
                PreparedStatement pre2 = this.con.prepareStatement(sql.toString());
                for (BDObject bd : bdObjects) {
                    pre2.setInt(1, billId);
                    pre2.setInt(2, bd.getBd_product_id());
                    pre2.setInt(3, bd.getBd_product_quantity());
                    pre2.addBatch();
                }
                int[] batchResult = pre2.executeBatch();
                for (int result : batchResult) {
                    if (result == PreparedStatement.EXECUTE_FAILED) {
                        return false;
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


	private boolean isExisting(BillObject item) {
		boolean flag = false;
		String sql = "SELECT bill_id FROM tblbill WHERE (bill_id='" + item.getBill_id() + "'); ";
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
	public boolean editBill(BillObject item, ArrayList<BDObject> bdObjects, BILL_EDIT_TYPE et) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblbill SET ");
		switch (et) {
		case GENERAL:
			sql.append("bill_status=?, ");
			sql.append("bill_delivery_id=? ");
			break;
		default:
			break;

		}
		sql.append("WHERE bill_id=?; ");

		// Bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch (et) {
			case GENERAL:
				pre.setByte(1, item.getBill_status());
				pre.setInt(2, item.getBill_delivery_id());
				pre.setInt(3, item.getBill_id());
				break;
			default:
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

	// Phương thức kiểm tra tồn tại
	private boolean isEmpty(BillObject item) {
		boolean flag = true;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT user_id FROM tbluser WHERE (user_id=" + item.getBill_creator_id() + ") ;");

		ArrayList<ResultSet> res = this.getReList(sql.toString());

		for (ResultSet rs : res) {
			try {
				if (rs != null && rs.next()) {
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
		String sql = "SELECT * FROM tblbill WHERE (bill_id=?); ";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getBillByCreatedDate(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ResultSet> getBillByUser(int at, byte total, String multiField, String multiCondition,
			String multiSort, UserObject userObject) {
		StringBuilder sql = new StringBuilder();
		sql.append(getBillByUserSQL(at, total, multiField, multiCondition, multiSort, userObject));
//		sql.append(getBillSizeByUserSQL(multiCondition, userObject));
		System.out.print(sql.toString());
		return this.getReList(sql.toString());
	}

	private static String getBillByUserSQL(int at, byte total, String multiField, String multiCondition,
			String multiSort, UserObject userObject) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM tblbill b ");
		sql.append("INNER JOIN tblbd bd ON b.bill_id = bd.bd_bill_id ");
		sql.append("INNER JOIN tblproduct p ON bd.bd_product_id = p.product_id ");
		sql.append("LEFT JOIN tblshop s ON p.product_shop_id = s.shop_id ");
		sql.append("WHERE b.bill_creator_id=" + userObject.getUser_id() + " ");
		sql.append(ORDERConditions(multiSort));
		sql.append("; ");
		return sql.toString();
	}

	/*
	 * private static String getBillSizeByUserSQL(String multiCondition, UserObject
	 * userObject) { StringBuilder sql = new StringBuilder();
	 * sql.append("SELECT COUNT(b.bill_id) AS total FROM tblbill b ");
	 * sql.append("WHERE b.bill_creator_id = ").append(userObject.getUser_id());
	 * sql.append(" AND b.bill_status = 0 "); // Assuming 0 represents an active
	 * bill sql.append("; "); return sql.toString(); }
	 */

	@Override
	public ArrayList<ResultSet> getBillByShop(int at, byte total, String multiField, String multiCondition,
			String multiSort, ShopObject shopObject) {
		StringBuilder sql = new StringBuilder();
		sql.append(getBillByShopSQL(at, total, multiField, multiCondition, multiSort, shopObject));
		sql.append(getBillSizeByShopSQL(multiCondition, shopObject));
		System.out.print(sql.toString());
		return this.getReList(sql.toString());
	}

	private static String getBillByShopSQL(int at, byte total, String multiField, String multiCondition,
			String multiSort, ShopObject shopObject) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblbill b ");
		sql.append("INNER JOIN tblbd bd ON b.bill_id=bd.bd_bill_id ");
		sql.append("INNER JOIN tbluser u ON u.user_id=b.bill_creator_id ");
		sql.append("INNER JOIN tblproduct p ON bd.bd_product_id=p.product_id ");
		sql.append("WHERE p.product_shop_id=" + shopObject.getShop_id() + " ");
		sql.append(ORDERConditions(multiSort));
		sql.append("LIMIT " + at + "," + total + "; ");
		return sql.toString();
	}

	private static String getBillSizeByShopSQL(String multiCondition, ShopObject shopObject) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(b.bill_id) AS total FROM tblbill b ");
		sql.append("INNER JOIN tbluser u ON u.user_id=b.bill_creator_id ");
		sql.append("INNER JOIN tblbd bd ON b.bill_id=bd.bd_id ");
		sql.append("INNER JOIN tblproduct p ON bd.bd_product_id=p.product_id ");
		sql.append("WHERE p.product_shop_id=" + shopObject.getShop_id() + " ");
		sql.append("; ");
		return sql.toString();
	}

	@Override
	public ArrayList<ResultSet> getOrderStatisticByShop(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append(getOrderByShopAndMonthSQL(shopObject, month));
		sql.append(getCountOrderByShopAndMonthSQL(shopObject, month));
		sql.append(getCountOrderByShopAndMonthSQL(shopObject, month - 1));
		return this.getReList(sql.toString());
	}

	private static String getOrderByShopAndMonthSQL(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT bill_created_date, COUNT(bill_id) AS order_by_month FROM tblproduct p ");
		sql.append("INNER JOIN tblbd bd ON p.product_id = bd.bd_product_id ");
		sql.append("INNER JOIN tblbill b ON b.bill_id = bd.bd_bill_id ");
		sql.append("WHERE ((p.product_shop_id=" + shopObject.getShop_id()
				+ ") AND (p.product_deleted=0) AND MONTH(STR_TO_DATE(bill_created_date, '%e/%c/%Y')) = (" + month
				+ ") ) ");
		sql.append("GROUP BY bill_created_date ");
		sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC;");
		return sql.toString();
	}

	private static String getCountOrderByShopAndMonthSQL(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(bill_id) AS count_order_by_month FROM tblproduct p ");
		sql.append("INNER JOIN tblbd bd ON p.product_id = bd.bd_product_id ");
		sql.append("INNER JOIN tblbill b ON b.bill_id = bd.bd_bill_id ");
		sql.append("WHERE ((p.product_shop_id=" + shopObject.getShop_id()
				+ ") AND (p.product_deleted=0) AND MONTH(STR_TO_DATE(bill_created_date, '%e/%c/%Y')) = (" + month
				+ ") ) ");
		sql.append("ORDER BY count_order_by_month ASC;");
		return sql.toString();
	}

	@Override
	public ArrayList<ResultSet> getIncomeStatisticByShop(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append(getIncomeByShopAndMonthSQL(shopObject, month));
		sql.append(getSumIncomeByShopAndMonthSQL(shopObject, month));
		sql.append(getSumIncomeByShopAndMonthSQL(shopObject, month - 1));
		return this.getReList(sql.toString());
	}

	private static String getIncomeByShopAndMonthSQL(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT bill_created_date, SUM(product_price*bd_product_quantity) AS income_by_month FROM tblproduct p ");
		sql.append("INNER JOIN tblbd bd ON p.product_id = bd.bd_product_id ");
		sql.append("INNER JOIN tblbill b ON b.bill_id = bd.bd_bill_id ");
		sql.append("WHERE ((p.product_shop_id=" + shopObject.getShop_id()
				+ ") AND (p.product_deleted=0) AND MONTH(STR_TO_DATE(bill_created_date, '%e/%c/%Y')) = (" + month
				+ ") ) ");
		sql.append("GROUP BY bill_created_date ");
		sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC;");
		return sql.toString();
	}

	private static String getSumIncomeByShopAndMonthSQL(ShopObject shopObject, int month) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SUM(product_price*bd_product_quantity) AS sum_income_by_month FROM tblproduct p ");
		sql.append("INNER JOIN tblbd bd ON p.product_id = bd.bd_product_id ");
		sql.append("INNER JOIN tblbill b ON b.bill_id = bd.bd_bill_id ");
		sql.append("WHERE ((p.product_shop_id=" + shopObject.getShop_id()
				+ ") AND (p.product_deleted=0) AND MONTH(STR_TO_DATE(bill_created_date, '%e/%c/%Y')) = (" + month
				+ ") ) ");
		sql.append("ORDER BY STR_TO_DATE(bill_created_date, '%e/%c/%Y') ASC;");
		return sql.toString();
	}

//	
//	private String SELECTConditions(String multiField) {
//		StringBuilder SELECT = new StringBuilder();
//
//	
//		return SELECT.toString();
//	}
//	
//	private String WHEREConditions(String multiCondition) {
//		StringBuilder WHERE = new StringBuilder();
//
//		return WHERE.toString();
//	}
//	

	private static String ORDERConditions(String multiSort) {
		StringBuilder ORDER = new StringBuilder();
		if (multiSort != null) {
			if (!multiSort.equalsIgnoreCase("")) {
				Map<String, String> SortMap = new TreeMap<String, String>();

				String[] Pair = multiSort.trim().split(";");
				for (int i = 0; i < Pair.length; i++) {
					String[] div = Pair[i].split(":");
					SortMap.put(div[0], div[1]);
				}

				SortMap.forEach((key, value) -> {
					if (!ORDER.isEmpty() && !ORDER.toString().isBlank()) {
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
					case "shop":
						ORDER.append("bill_creator_id");
						break;
					case "delivery":
						ORDER.append("bill_delivery_id");
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

				if (!ORDER.toString().equalsIgnoreCase("")) {
					ORDER.insert(0, "ORDER BY ");
				}
			}
		}
		return ORDER.toString();
	}

	public static void main(String[] args) {
	    // Khởi tạo pool kết nối
	    ConnectionPool cp = new ConnectionPoolImpl();
	    // Tạo một đối tượng BillImpl
	    BillImpl billImpl = new BillImpl(cp);

	    // Tạo một đối tượng BillObject đại diện cho hóa đơn bạn muốn thêm
	    BillObject billObject = new BillObject();
	    billObject.setBill_created_date("2024-06-03"); // Đặt ngày tạo
	    billObject.setBill_creator_id(2); // Đặt ID của người tạo
	    billObject.setBill_delivery_id(2); // Đặt ID của người giao hàng
	    billObject.setBill_status((byte) 0); // Đặt trạng thái

	    // Tạo một ArrayList của BDObject đại diện cho các mặt hàng trong hóa đơn
	    ArrayList<BDObject> bdObjects = new ArrayList<>();
	    // Thêm các BDObject đại diện cho từng mặt hàng vào danh sách
	    if (bdObjects == null) {
	        System.out.println("null bd");
	    } else {
	        System.out.println("not null");
	    }
	    // Gọi phương thức addBill
	    boolean addSuccess = billImpl.addBill(billObject, bdObjects);

	    // Xử lý kết quả
	    if (addSuccess) {
	        System.out.println("Hóa đơn được thêm thành công!");
	    } else {
	        System.out.println("Không thể thêm hóa đơn!");
	    }
	}
}
