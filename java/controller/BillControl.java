package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import dto.bd.BD_DTO;
import dto.bd.BD_manageBillDTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_manageBillDTO;
import dto.bill.Bill_viewBillDTO;
import dto.shop.Shop_manageShopDTO;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import entity.UserObject;
import library.ShopLibrary;
import model.BillModel;
import model.ShopModel;

public class BillControl {
	private BillModel billModel;
	private ShopModel shopModel;

	public BillControl(ConnectionPool cp) {
		this.billModel = new BillModel(cp);
		this.shopModel = new ShopModel(cp);

	}

	public ConnectionPool getCP() {
		return this.billModel.getCP();
	}

	public void releaseConnection() {
		this.billModel.releaseConnection();
	}

	public boolean addBill(Bill_DTO bill_DTO) {
		return this.billModel.addBill(bill_DTO);
	}

	public boolean editBill(Bill_DTO item, BILL_EDIT_TYPE et) {
		return this.billModel.editBill(item, et);
	}

	public boolean delBill(Bill_DTO item) {
		return this.billModel.delBill(item);
	}

	public BillObject getBill_DTOById(int billId) {
		return this.billModel.getBill_DTOById(billId);
	}

	public List<Bill_viewBillDTO> getBillDTOByUser(UserObject currentUser) {
		return billModel.getBillDTOByUser(currentUser);
	}

	public List<Bill_manageBillDTO> getBillDTOByShop(ShopObject shopObject) {
		return this.billModel.getBillDTOByShop(shopObject);
	}

	public List<Bill_manageBillDTO> getBillDTOByShop(UserObject currentUser) {
		return this.billModel.getBillDTOByShop(currentUser);
	}

	public void setShopModel(ShopModel shopModel) {
		this.shopModel = shopModel;
	}

	public static void main(String[] args) {
		// Tạo một ConnectionPool
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo một đối tượng BillControl
		BillControl billControl = new BillControl(cp);

		// Tạo một đối tượng Bill_DTO đại diện cho hóa đơn muốn thêm
		Bill_DTO billDTO = new Bill_manageBillDTO();
		// Đặt các thuộc tính của billDTO bằng các giá trị tương ứng

		// Gọi phương thức addBill để thêm hóa đơn
		boolean addSuccess = billControl.addBill(billDTO);

		// Kiểm tra xem việc thêm hóa đơn có thành công không
		if (addSuccess) {
			System.out.println("Hóa đơn đã được thêm thành công!");
		} else {
			System.out.println("Không thể thêm hóa đơn!");
		}

		// Giải phóng kết nối từ ConnectionPool
		billControl.releaseConnection();
	}

}
