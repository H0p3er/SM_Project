package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.javatuples.*;

import connection.*;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import dto.bd.BD_DTO;
import dto.bd.BD_manageBillDTO;
import dto.bd.BD_viewBillDTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_manageBillDTO;
import dto.bill.Bill_viewBillDTO;
import dto.product.Product_manageBillDTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_viewBillDTO;
import dto.shop.Shop_manageShopDTO;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import entity.UserObject;
import repository.Bill;
import repository.*;

import utility.Utilities;

public class BillModel {

	private Bill bill;
    private ShopModel shopModel;
    private UserModel userModel;

    public BillModel(ConnectionPool cp) {
        this.bill = new BillImpl(cp);
        this.userModel = new UserModel(cp); 
    }

    public void setShopModel(ShopModel shopModel) {
        this.shopModel = shopModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
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

	public ArrayList<ResultSet> getBillByUser(int at, byte total, String multiField, String multiCondition,
			String multiSort, UserObject userObject) {
		return this.bill.getBillByUser(at, total, multiField, multiCondition, multiSort, userObject);
	}

	public List<Bill_viewBillDTO> getBillDTOByUser(UserObject currentUser) {
		List<Bill_viewBillDTO> billList = new ArrayList<>();

		ArrayList<ResultSet> billResultSets = this.bill.getBillByUser(0, (byte) 30, "", "", "created_date:desc", currentUser);

		try {
			if (billResultSets != null) {
				for (ResultSet rs : billResultSets) {
					if (rs != null) {
						Bill_viewBillDTO billDTO = null;
						int currentBillId = -1; // Giá trị ban đầu của bill_id

						while (rs.next()) {
							int billId = rs.getInt("bill_id");

							// Kiểm tra xem billDTO đã được khởi tạo chưa
							if (billDTO == null || currentBillId != billId) {
								// Tạo mới một đối tượng Bill_viewBillDTO cho mỗi bill_id mới
								billDTO = new Bill_viewBillDTO();
								billDTO.setId(billId);
								billDTO.setCreated_date(rs.getString("bill_created_date"));
								billDTO.setCreator_id(rs.getInt("bill_creator_id"));
								billDTO.setDelivery_id(rs.getInt("bill_delivery_id"));
								billDTO.setStatus(rs.getByte("bill_status"));

								// Tạo mới một danh sách sản phẩm cho mỗi hóa đơn
								billDTO.setBd(new ArrayList<>());

								// Cập nhật bill_id hiện tại
								currentBillId = billId;

								// Thêm hóa đơn vào danh sách
								billList.add(billDTO);
							}

							// Tạo mới một đối tượng BD_viewBillDTO cho mỗi sản phẩm
							BD_viewBillDTO bdDTO = new BD_viewBillDTO();
							bdDTO.setId(rs.getInt("bd_id"));
							bdDTO.setProduct_quantity(rs.getInt("bd_product_quantity"));

							Product_viewBillDTO product = new Product_viewBillDTO();
							product.setId(rs.getInt("product_id"));
							product.setName(rs.getString("product_name"));
							product.setPrice(rs.getDouble("product_price"));

							bdDTO.setProduct(product);

							// Thêm sản phẩm vào danh sách sản phẩm của hóa đơn
							billDTO.getBd().add(bdDTO);
						}
					} else {
						System.out.println("ResultSet is null");
					}
				}
			} else {
				System.out.println("Bill result set is null");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return billList;
	}

	public List<Bill_manageBillDTO> getBillDTOByShop(ShopObject shopObject) {
	    List<Bill_manageBillDTO> billList = new ArrayList<>();

	    ArrayList<ResultSet> billResultSets = this.bill.getBillByShop(0, (byte) 30, "", "", "", shopObject);

	    try {
	        if (billResultSets != null && billResultSets.size() > 0) {
	            ResultSet rs = billResultSets.get(0);
	            ResultSet rsCount = null;

	            while (rs.next()) {
	                int billId = rs.getInt("bill_id");
	                int creatorId = rs.getInt("bill_creator_id");

	                Bill_manageBillDTO billDTO = new Bill_manageBillDTO();
	                billDTO.setId(billId);
	                billDTO.setCreator_id(creatorId);
	                billDTO.setDelivery_id(rs.getInt("bill_delivery_id"));
	                billDTO.setStatus(rs.getByte("bill_status"));
	                billDTO.setBd(new ArrayList<>());

	                BD_manageBillDTO bdDTO = new BD_manageBillDTO();
	                bdDTO.setId(rs.getInt("bd_id"));
	                bdDTO.setProduct_quantity(rs.getInt("bd_product_quantity"));

	                Product_manageBillDTO product = new Product_manageBillDTO();
	                product.setId(rs.getInt("product_id"));
	                product.setName(rs.getString("product_name"));
	                product.setPrice(rs.getDouble("product_price"));

	                bdDTO.setProduct(product);

	                billDTO.getBd().add(bdDTO);
	                billList.add(billDTO);
	            }

	            if (billResultSets.size() > 1) {
	                rsCount = billResultSets.get(1);
	                if (rsCount.next()) {
	                    int totalCount = rsCount.getInt("total");
	                    System.out.println("Total bills: " + totalCount);
	                }
	            }
	        } else {
	            System.out.println("Bill result set is empty");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return billList;
	}


	 public List<Bill_manageBillDTO> getBillDTOByShop(UserObject currentUser) {
		 	List<Bill_manageBillDTO> billList = new ArrayList<>();

		    // Lấy thông tin cửa hàng dựa trên người dùng
		    Shop_manageShopDTO shopManageShopDTO = this.shopModel.getShopDTOByUser(Quintet.with((short)0, (byte)30, new HashMap<>(), new HashMap<>(), new HashMap<>()), currentUser);

		    // Tạo đối tượng ShopObject từ dữ liệu cửa hàng
		    ShopObject shopObject = new ShopObject();
		    shopManageShopDTO.applyToEntity(shopObject, currentUser);

		    // Gọi phương thức getBillDTOByShop với đối tượng ShopObject đã được xác định
		    return getBillDTOByShop(shopObject);
		}

	 public static void main(String[] args) {
		    ConnectionPool cp = new ConnectionPoolImpl(); // Initialize the connection pool
		    BillModel billModel = new BillModel(cp); 

	        UserModel userModel = new UserModel(cp);
		    ShopModel shopModel = new ShopModel(cp); 

		    // Set the ShopModel in BillModel
		    billModel.setShopModel(shopModel);

		    UserObject user = new UserObject();
		    user.setUser_id(2);
		    // Get the list of Bill_manageBillDTO objects
		    List<Bill_manageBillDTO> billDTOs = billModel.getBillDTOByShop(user);
		    // Iterate over each bill
		    for (Bill_manageBillDTO billDTO : billDTOs) {
		        // Print bill details
		        System.out.println("Bill ID: " + billDTO.getId());
		        System.out.println("Bill Status: " + billDTO.getStatus());
		        UserObject userObject = userModel.getUserObject(billDTO.getCreator_id());

	            // Print user details
	            if (userObject != null) {
	                System.out.println("User Full Name: " + userObject.getUser_fullname());
	                System.out.println("User Address: " + userObject.getUser_address());
	            } else {
	                System.out.println("User not found for creatorId: " + billDTO.getCreator_id());
	            }

		        // Iterate over each BD_manageBillDTO (product details)
		        for (BD_manageBillDTO bdDTO : billDTO.getBd()) {
		            // Print product details
		            System.out.println("Product ID: " + bdDTO.getProduct().getId());
		            System.out.println("Product Name: " + bdDTO.getProduct().getName());
		            System.out.println("Product Quantity: " + bdDTO.getProduct_quantity());
		        }

		        System.out.println("--------------------------------------------");
		    }

		    billModel.releaseConnection(); // Release the connection
		}

}