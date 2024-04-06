package repository;

import java.sql.ResultSet;
import java.util.*;

import org.javatuples.*;

import connection.ShareControl;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import entity.BillObject;
import entity.UserObject;

public interface Bill extends ShareControl{
	public boolean addBill(BillObject item);
	public boolean editBill(BillObject item, BILL_EDIT_TYPE et);
	public boolean delBill(BillObject item);
	
	public ResultSet getBillById(int id);
	public ResultSet getBillByCreator(UserObject user);
	public ResultSet getBillByCreatedDate(Date start, Date end);
	public ArrayList<ResultSet> getBillList(Sextet<UserObject, BillObject, Integer, Byte, BILL_SORT_TYPE, Boolean> infors);
}
