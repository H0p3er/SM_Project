package repository;

import java.sql.ResultSet;
import java.util.*;

import org.javatuples.*;

import connection.ShareControl;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import entity.UserObject;

public interface Bill extends ShareControl{
	public boolean addBill(BillObject item, ArrayList<BDObject> bdObjects);
	public boolean editBill(BillObject item, ArrayList<BDObject> bdObjects, BILL_EDIT_TYPE et);
	public boolean delBill(BillObject item);
	
	public ResultSet getBillById(int id);
	public ResultSet getBillByCreatedDate(Date start, Date end);
	
	public ArrayList<ResultSet> getBillByUser(int at, byte total, String multiField,  String multiCondition, String multiSort, UserObject userObject);
	public ArrayList<ResultSet> getOrderByUser(int at, byte total, String multiField,  String multiCondition, String multiSort, UserObject userObject);
	
	public ArrayList<ResultSet> getBillByShop(int at, byte total, String multiField,  String multiCondition, String multiSort, ShopObject shopObject);
	public ArrayList<ResultSet> getOrderByShop(int at, byte total, String multiField,  String multiCondition, String multiSort, ShopObject shopObject);

	public ArrayList<ResultSet> getOrderStatisticByShop(ShopObject shopObject, int month);
	public ArrayList<ResultSet> getIncomeStatisticByShop(ShopObject shopObject, int month);
}
