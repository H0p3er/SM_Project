package repository;

import java.sql.ResultSet;
import java.util.*;

import org.javatuples.*;

import connection.ShareControl;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import entity.BDObject;
import entity.BillObject;
import entity.UserObject;

public interface Bill extends ShareControl{
	public boolean addBill(BillObject item, ArrayList<BDObject> bdObjects);
	public boolean editBill(BillObject item, ArrayList<BDObject> bdObjects, BILL_EDIT_TYPE et);
	public boolean delBill(BillObject item);
	
	public ResultSet getBillById(int id);
	public ArrayList<ResultSet> getBillByUser(UserObject user, Integer at, Byte bPerPage, String multiSort, String multiFilter);
	public ResultSet getBillByCreatedDate(Date start, Date end);
	public ArrayList<ResultSet> getBillList(UserObject currentUser, BillObject similar, Integer at, Byte bPerPage, BILL_SORT_TYPE type);
}
