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
import dto.bd.BD_manageShopDTO;
import dto.bd.BD_viewBillDTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_manageBillDTO;
import dto.bill.Bill_manageShopDTO;
import dto.bill.Bill_viewBillDTO;
import dto.product.Product_manageBillDTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_viewBillDTO;
import dto.shop.Shop_manageShopDTO;
import dto.user.User_viewCustomerDTO;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import entity.UserObject;
import entity.total.shop;
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
		bill_DTO.ApplyToEntity(billObject, bdObjects);;
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

	public Triplet<Map<String, Double>, Double, Double> getIncomeStatisticByShop(Shop_manageShopDTO shop_manageShopDTO) {
		
		ShopObject shopObject = new ShopObject();
		shop_manageShopDTO.applyToEntity(shopObject);
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

	public Triplet<Map<String, Integer>, Integer, Integer> getOrderStatisticByShop(Shop_manageShopDTO shop_manageShopDTO) {
		ShopObject shopObject = new ShopObject();
		shop_manageShopDTO.applyToEntity(shopObject);
		
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

		ArrayList<ResultSet> billResultSets = this.bill.getBillByUser(0, (byte) 100, "", "", "created_date:desc", currentUser);

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
								billDTO.setCustommer(new User_viewCustomerDTO(rs.getInt("bill_creator_id")));
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

	    ArrayList<ResultSet> billResultSets = this.bill.getBillByShop(0, (byte) 30, "", "", "created_date:desc", shopObject);

	    try {
	        if (billResultSets != null && billResultSets.size() > 0) {
	            ResultSet rs = billResultSets.get(0);
	            ResultSet rsCount = null;
	            
	            if (rs != null) {
	            	Bill_manageBillDTO billDTO = null;
					int currentBillId = -1; // Giá trị ban đầu của bill_id

					while (rs.next()) {
						int billId = rs.getInt("bill_id");

						// Kiểm tra xem billDTO đã được khởi tạo chưa
						if (billDTO == null || currentBillId != billId) {
							// Tạo mới một đối tượng Bill_viewBillDTO cho mỗi bill_id mới
							billDTO = new Bill_manageBillDTO();
							billDTO.setId(billId);
							billDTO.setCreated_date(rs.getString("bill_created_date"));
							billDTO.setCustommer(new User_viewCustomerDTO(rs.getInt("bill_creator_id")));
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
						BD_manageBillDTO bdDTO = new BD_manageBillDTO();
						bdDTO.setId(rs.getInt("bd_id"));
						bdDTO.setProduct_quantity(rs.getInt("bd_product_quantity"));

						Product_manageBillDTO product = new Product_manageBillDTO();
						product.setId(rs.getInt("product_id"));
						product.setName(rs.getString("product_name"));
						product.setPrice(rs.getDouble("product_price"));

						bdDTO.setProduct(product);

						// Thêm sản phẩm vào danh sách sản phẩm của hóa đơn
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
				} else {
					System.out.println("ResultSet is null");
				}

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return billList;
	}
	
	public Pair<List<Bill_manageShopDTO>,Integer> getBillDTOByShop(Shop_manageShopDTO shop_manageShopDTO) {
		ShopObject shopObject = new ShopObject();
		shop_manageShopDTO.applyToEntity(shopObject);
	    List<Bill_manageShopDTO> billList = new ArrayList<>();
	    ArrayList<ResultSet> res = this.bill.getBillByShop(0, (byte) 20, "", "", "", shopObject);

	    try {
	        if (res != null) {
	        	Bill_manageShopDTO billDTO = null;
	        	ResultSet rs = res.get(0);
	        	if (rs != null) {  
                    int currentBillId = -1; // Giá trị ban đầu của bill_id
                    while (rs.next()) {
                        int billId = rs.getInt("bill_id");

                        // Kiểm tra xem billDTO đã được khởi tạo chưa
                        if (billDTO == null || currentBillId != billId) {
                            // Tạo mới một đối tượng Bill_viewBillDTO cho mỗi bill_id mới
                            billDTO = new Bill_manageShopDTO();
                            billDTO.setId(billId);
                            billDTO.setCreated_date(rs.getString("bill_created_date"));
                            billDTO.setCustommer(new User_viewCustomerDTO(rs.getInt("bill_creator_id"), rs.getString("user_name")));
                            
                            billDTO.setDelivery_id(rs.getInt("bill_delivery_id"));
                            billDTO.setStatus(rs.getByte("bill_status"));

                            // Tạo mới một danh sách sản phẩm cho mỗi hóa đơn
                            billDTO.setBd(new ArrayList<BD_manageShopDTO>());

                            // Cập nhật bill_id hiện tại
                            currentBillId = billId;

                            // Thêm hóa đơn vào danh sách
                            billList.add(billDTO);
                        }

                        // Tạo mới một đối tượng BD_viewBillDTO cho mỗi sản phẩm
                        BD_manageShopDTO bdDTO = new BD_manageShopDTO();
                        bdDTO.setId(rs.getInt("bd_id"));
                        bdDTO.setProduct_quantity(rs.getInt("bd_product_quantity"));

                        Product_manageShopDTO product = new Product_manageShopDTO();
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

	        } else {
	            System.out.println("Bill result set is null");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return new Pair<>(billList, 0);
	}

	public List<Bill_manageBillDTO> getBillDTOByShop(UserObject currentUser) {
	    List<Bill_manageBillDTO> billList = new ArrayList<>();

	    // Lấy thông tin cửa hàng dựa trên người dùng
	    if (this.shopModel != null) {
	        // Kiểm tra xem shopModel có khả dụng không
	        Shop_manageShopDTO shopManageShopDTO = this.shopModel.getShopDTOByUser(Quintet.with((short) 0, (byte) 30, new HashMap<>(), new HashMap<>(), new HashMap<>()), currentUser);
	        if (shopManageShopDTO != null) {
	            // Tạo đối tượng ShopObject từ dữ liệu cửa hàng
	            ShopObject shopObject = new ShopObject();
	            shopManageShopDTO.applyToEntity(shopObject, currentUser);
	            // Gọi phương thức getBillDTOByShop với đối tượng ShopObject đã được xác định
	            return getBillDTOByShop(shopObject);
	        } else {
	            System.out.println("Shop data is not available for the user.");
	        }
	    } else {
	        System.out.println("Shop model is null");
	    }
	    return billList;
	}

	public static void main(String[] args) {
	    ConnectionPool cp = new ConnectionPoolImpl(); // Khởi tạo connection pool
	    BillModel billModel = new BillModel(cp); // Khởi tạo đối tượng BillModel
	    UserModel userModel = new UserModel(cp); 
	    ShopModel shopModel = new ShopModel(cp); 
	    billModel.setShopModel(shopModel);
	    UserObject userx = new UserObject();
	    userx.setUser_id(2); // Tạo đối tượng ShopObject đại diện cho cửa hàng
	    // Thiết lập thông tin cửa hàng // Đặt ID của cửa hàng

	    List<Bill_manageBillDTO> billDTOs = billModel.getBillDTOByShop(userx); // Gọi phương thức getBillDTOByShop và lấy danh sách hóa đơn

	    if (!billDTOs.isEmpty()) { // Kiểm tra nếu danh sách hóa đơn không trống
	        for (Bill_manageBillDTO billDTO : billDTOs) { // Duyệt qua từng hóa đơn trong danh sách
	            System.out.println("Bill ID: " + billDTO.getId()); // In ra ID của hóa đơn

	            // Lấy thông tin của người mua từ UserModel
	            UserObject userObject = userModel.getUserObject(billDTO.getCustommer().getId());
	            String userName = userObject.getUser_fullname();
	            String userAddress = userObject.getUser_address();

	            System.out.println("User Name: " + userName); // In ra tên của người mua
	            System.out.println("User Address: " + userAddress); // In ra địa chỉ của người mua

	            // In thông tin chi tiết về sản phẩm (danh sách sản phẩm trong hóa đơn)
	            for (BD_manageBillDTO bdDTO : billDTO.getBd()) { // Duyệt qua từng sản phẩm trong hóa đơn
	                System.out.println("  Product ID: " + bdDTO.getProduct().getId()); // In ra ID của sản phẩm
	                System.out.println("  Product Name: " + bdDTO.getProduct().getName()); // In ra tên của sản phẩm
	                System.out.println("  Product Quantity: " + bdDTO.getProduct_quantity()); // In ra số lượng của sản phẩm
	            }

	            System.out.println("Status: " + billDTO.getStatus()); // In ra trạng thái của hóa đơn
	            System.out.println("--------------------------------------------"); // In ra dấu phân cách
	        }
	    } else {
	        System.out.println("No bills found for the shop."); // In ra thông báo nếu không tìm thấy hóa đơn cho cửa hàng
	    }

	    billModel.releaseConnection(); // Giải phóng kết nối
	}
}