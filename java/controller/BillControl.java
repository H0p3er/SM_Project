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
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import dto.bd.BD_DTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_manageBillDTO;
import dto.bill.Bill_viewBillDTO;
import dto.shop.Shop_manageShopDTO;
import entity.BDObject;
import entity.BillObject;
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

}
