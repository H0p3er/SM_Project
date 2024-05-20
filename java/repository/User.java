package repository;

import java.sql.*;
import java.util.*;

import connection.ShareControl;
import constant.USER_EDIT_TYPE;
import entity.ShopObject;
import entity.UserObject;
import constant.*;

//extends ShareControl thay vi extend Basic de gioi han luong thong tin can import
public interface User extends ShareControl{

	public boolean addUser(UserObject item);
	
	public boolean editUser(UserObject item, USER_EDIT_TYPE et);
	
	public boolean delUser(UserObject item);
	
	
	public ResultSet getUserById(int id);
	
	public ResultSet getUser(String username, String userpass);
	
	public ArrayList<ResultSet> getUsers(UserObject similar, int at, byte total, USER_SORT_TYPE type);
	
	public ArrayList<ResultSet> getCustomerStatisticByShopAndMonth(ShopObject shopObject, int month);
	
	public ArrayList<ResultSet> getCustomerByShop(ShopObject shopObject);
}