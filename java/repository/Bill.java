package repository;

import java.sql.ResultSet;
import java.util.*;

import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;

import connection.ShareControl;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import entity.BillObject;
import entity.EmployeeObject;
import entity.UserObject;

public interface Bill extends ShareControl{
	public boolean addBill(BillObject item);
	public boolean editBill(BillObject item, BILL_EDIT_TYPE et);
	public boolean delBill(BillObject item);
	
	public ResultSet getBill(int id);
	public ArrayList<ResultSet> getBills(Sextet<EmployeeObject, BillObject, Integer, Byte, BILL_SORT_TYPE, Boolean> infors);
}
