package repository;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.*;

import connection.ShareControl;
import constant.LOG_SORT_TYPE;
import entity.EmployeeObject;
import entity.LogObject;
import objects.*;

public interface Log extends ShareControl{
	//Các phương thức, chức năng cập nhật thông tin nơi làm việc
	public boolean addLog(LogObject item);
	public boolean delLog(LogObject item);
	
	//Các phương thức, chức năng lấy thông tin nơi làm việc
	public ResultSet getLog(int id);
	public ArrayList<ResultSet> getLogs(Sextet<EmployeeObject,
			LogObject,
			Integer, 
			Byte ,
			LOG_SORT_TYPE,
			Boolean> infors);
}
