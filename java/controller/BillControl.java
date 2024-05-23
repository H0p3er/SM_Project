package controller;

import java.util.ArrayList;
import java.util.HashMap;
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
	

	
//	public static void main(String[] args) {
//		BillControl uc = new BillControl(null);
//		
//		Quartet<BillObject, Short, Byte, BILL_SORT_TYPE> infors = new Quartet<>(null, (short) 1, (byte) 10, BILL_SORT_TYPE.NAME);
//		
//		ArrayList<String> view = uc.viewBillsList(infors);
//		
//		uc.releaseConnection();//Tra ve ket noi
//		
//		System.out.println(view);
//	}
}
