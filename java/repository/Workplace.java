package repository;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Sextet;

import connection.ShareControl;
import constant.WORKPLACE_EDIT_TYPE;
import constant.WORKPLACE_SORT_TYPE;
import entity.EmployeeObject;
import entity.WorkplaceObject;
import entity.WpsdObject;

public interface Workplace extends ShareControl{
	//Các phương thức, chức năng cập nhật thông tin nơi làm việc
	public boolean addWorkplace(ArrayList<WorkplaceObject> wItem, ArrayList<WpsdObject> pItem, EmployeeObject currentUser);
	public boolean editWorkplace(ArrayList<WorkplaceObject> wItem, ArrayList<WpsdObject> pItem, WORKPLACE_EDIT_TYPE et, EmployeeObject currentUser);
	public boolean delWorkplace(ArrayList<WorkplaceObject> item, EmployeeObject currentUser);
	
	//Các phương thức, chức năng lấy thông tin nơi làm việc
	public ResultSet getWorkplace(int id);
	public ArrayList<ResultSet> getWorkplaces(Sextet<EmployeeObject, 
			WorkplaceObject, 
			Integer, 
			Byte ,
			WORKPLACE_SORT_TYPE,
			Boolean> infors);
}
