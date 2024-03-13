package controller;

import java.util.*;
import org.javatuples.*;
import connection.*;
import constant.LOG_SORT_TYPE;
import entity.EmployeeObject;
import entity.LogObject;
import library.*;
import model.LogModel;
import objects.*;


public class LogControl {
	private LogModel lm;
	
	public LogControl(ConnectionPool cp) {
		this.lm = new LogModel(cp);
		
	}
	
	public ConnectionPool getCP() {
		return this.lm.getCP();
	}
	
	public void releaseConnection() {
		this.lm.releaseConnection();
	}

	
	public boolean addLog(LogObject item) {
		return this.lm.addLog(item);		
	}
	
	
	public boolean delLog(LogObject item) {		
		return this.lm.delLog(item);
	}
	

	public LogObject getLogObject(int id) {
		return this.lm.getLogObject(id);
	}
	
	public Pair<ArrayList<LogObject>,Integer> getLogObjects(Sextet<EmployeeObject, 
			LogObject, 
			Short, 
			Byte ,
			LOG_SORT_TYPE,
			Boolean> infors){
				
		return this.lm.getLogObjects(infors);
	}
	

	public ArrayList<String> viewLogs(Sextet<EmployeeObject, 
			LogObject, 
			Short, 
			Byte ,
			LOG_SORT_TYPE,
			Boolean> infors, String url){
		
		Pair<ArrayList<LogObject>,Integer> datas = this.lm.getLogObjects(infors);
		
		return LogLibrary.viewLog(datas, infors, url);
	}
	
	
	
//	public static void main(String[] args) {
//		LogControl uc = new LogControl(null);
//		
//		Quartet<LogObject, Short, Byte, LOG_SORT_TYPE> infors = new Quartet<>(null, (short) 1, (byte) 10, LOG_SORT_TYPE.NAME);
//		
//		ArrayList<String> view = uc.viewLogsList(infors);
//		
//		uc.releaseConnection();//Tra ve ket noi
//		
//		System.out.println(view);
//	}
}
