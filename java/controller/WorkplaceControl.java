package controller;

import java.util.*;
import org.javatuples.*;
import connection.*;
import constant.WORKPLACE_EDIT_TYPE;
import constant.WORKPLACE_SORT_TYPE;
import entity.EmployeeObject;
import entity.ProductObject;
import entity.WorkplaceObject;
import entity.WpsdObject;
import library.*;
import model.WorkplaceModel;
import objects.*;


public class WorkplaceControl {
	private WorkplaceModel wm;
	
	public WorkplaceControl(ConnectionPool cp) {
		this.wm = new WorkplaceModel(cp);
		
	}
	
	public ConnectionPool getCP() {
		return this.wm.getCP();
	}
	
	public void releaseConnection() {
		this.wm.releaseConnection();
	}

	
	public boolean addWorkplace(ArrayList<WorkplaceObject> wItem, ArrayList<WpsdObject> pItem, EmployeeObject currentUser) {
//		LogObject log = null

		return this.wm.addWorkplace(wItem, pItem, currentUser);		
	}
	
	public boolean editWorkplace(ArrayList<WorkplaceObject> wItem, ArrayList<WpsdObject> pItem, WORKPLACE_EDIT_TYPE et, EmployeeObject currentUser) {
//		wItem.forEach(item->{
//			LogObject log = new LogObject();
//			log.setLog_user_id(item.getWorkplace_creator_id());
//			log.setLog_username(currentUser.getUser_name());
//			log.setLog_user_permission(currentUser.getUser_permission());
//			log.setLog_action((byte)2);
//			log.setLog_position((byte) 8);
//			
//			log.setLog_notes(Utilities.encode(""));
//			log.setLog_created_date(Utilities_date.getCurrentDateTime());
//			
//			this.lm.addLog(log);
//		});
		return this.wm.editWorkplace(wItem, pItem, et, currentUser);
	}
	
	public boolean delWorkplace(ArrayList<WorkplaceObject> wItem, EmployeeObject currentUser) {
//		wItem.forEach(item->{
//			LogObject log = new LogObject();
//			log.setLog_user_id(item.getWorkplace_creator_id());
//			log.setLog_username(currentUser.getUser_name());
//			log.setLog_user_permission(currentUser.getUser_permission());
//			log.setLog_action((byte)3);
//			log.setLog_position((byte) 8);
//			
//			log.setLog_notes(Utilities.encode(""));
//			log.setLog_created_date(Utilities_date.getCurrentDateTime());
//			
//			this.lm.addLog(log);
//		});
		
		return this.wm.delWorkplace(wItem, currentUser);
	}
	

	public WorkplaceObject getWorkplaceObject(int id) {
		return this.wm.getWorkplaceObject(id);
	}
	
	public Octet<	ArrayList<WorkplaceObject>,
					Integer, 
					HashMap<Integer,Integer>, 
					HashMap<Integer,Integer>, 
					HashMap<Pair<String,Integer>,Integer> ,
					HashMap<Pair<String,Integer>,Integer>,
					HashMap<Triplet<Integer,Integer,String>,
							Triplet<ProductObject,Integer,Integer>>,
					HashMap<Integer,EmployeeObject>> getWorkplaceObjects(Sextet<EmployeeObject, 
			WorkplaceObject, 
			Short, 
			Byte , 
			WORKPLACE_SORT_TYPE,
			Boolean> infors){
				
		return this.wm.getWorkplaceObjects(infors);
	}
	

	public ArrayList<String> viewWorkplacesList(Sextet<EmployeeObject, 
			WorkplaceObject, 
			Short, 
			Byte ,
			WORKPLACE_SORT_TYPE,
			Boolean> infors, byte isOpenModal , String url){
		
		Octet<	ArrayList<WorkplaceObject>,
		Integer, 
		HashMap<Integer,Integer>, 
		HashMap<Integer,Integer>, 
		HashMap<Pair<String,Integer>,Integer> ,
		HashMap<Pair<String,Integer>,Integer>,
		HashMap<Triplet<Integer,Integer,String>,
				Triplet<ProductObject,Integer,Integer>>,
		HashMap<Integer,EmployeeObject>> datas = this.wm.getWorkplaceObjects(infors);
		
		if (infors.getValue5()) {
			return WorkplaceLibrary.viewWorkplaceEdit(datas, infors, isOpenModal, url);
		} else {
			return WorkplaceLibrary.viewWorkplaceList(datas, infors, isOpenModal, url);
		}
		
	}
	
	
	
//	public static void main(String[] args) {
//		WorkplaceControl uc = new WorkplaceControl(null);
//		
//		Quartet<WorkplaceObject, Short, Byte, WORKPLACE_SORT_TYPE> infors = new Quartet<>(null, (short) 1, (byte) 10, WORKPLACE_SORT_TYPE.NAME);
//		
//		ArrayList<String> view = uc.viewWorkplacesList(infors);
//		
//		uc.releaseConnection();//Tra ve ket noi
//		
//		System.out.println(view);
//	}
}
