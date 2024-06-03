package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import connection.ConnectionPool;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import dto.bd.BD_DTO;
import dto.bd.BD_manageShopDTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_manageBillDTO;
import dto.bill.Bill_manageShopDTO;
import dto.bill.Bill_viewBillDTO;
import dto.product.Product_manageShopDTO;
import dto.shop.Shop_manageShopDTO;
import dto.user.User_viewCustomerDTO;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import entity.UserObject;
import library.ShopLibrary;
import model.BillModel;

public class BillControl {
	private BillModel billModel;
	
	public BillControl(ConnectionPool cp) {
		this.billModel = new BillModel(cp);
		
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
	
	public boolean editBill(Bill_DTO item ,BILL_EDIT_TYPE et) {
		return this.billModel.editBill(item, et);
	}
	
	public boolean delBill(Bill_DTO item) {
		return this.billModel.delBill(item);
	}
	
	public List<Bill_viewBillDTO> getBillDTOByUser(UserObject currentUser) {
	    return billModel.getBillDTOByUser(currentUser);
	}
	
	public Pair<List<Bill_manageShopDTO>,Integer> getBillDTOByShop(Shop_manageShopDTO shop_manageShopDTO) {
	    return this.billModel.getBillDTOByShop(shop_manageShopDTO);
	}
	
	public Triplet<Map<String, Double>, Double, Double> getIncomeStatisticByShop(Shop_manageShopDTO shop_manageShopDTO) {
		return this.billModel.getIncomeStatisticByShop(shop_manageShopDTO);
		
	}

	public Triplet<Map<String, Integer>, Integer, Integer> getOrderStatisticByShop(Shop_manageShopDTO shop_manageShopDTO) {
		return this.billModel.getOrderStatisticByShop(shop_manageShopDTO);
	}

}
