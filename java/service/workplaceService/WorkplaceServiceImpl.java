package service.workplaceService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.SHOP_EDIT_TYPE;
import constant.SHOP_SORT_TYPE;
import controller.WorkplaceControl;
import entity.EmployeeObject;
import entity.ProductObject;
import entity.ShopObject;
import entity.WpsdObject;
import jakarta.jws.WebService;
import library.WorkplaceLibrary;
import model.WorkplaceModel;

@WebService(endpointInterface="service.workplaceService.WorkplaceService")
public class WorkplaceServiceImpl implements WorkplaceService {
	private WorkplaceControl wc;
	private final ObjectMapper jsonMapper = new ObjectMapper();
	public WorkplaceServiceImpl() {
		this.wc = new WorkplaceControl(null);	
    }
	
	@Override
	public boolean addWorkplace(String wItemsJson, String pItemsJson) {

		ArrayList<ShopObject> wItems = new ArrayList<>();
		ArrayList<WpsdObject> pItems = new ArrayList<>();
		try {
			wItems.addAll(jsonMapper.readValue(wItemsJson,new TypeReference<List<ShopObject>>() {}));
			pItems.addAll(jsonMapper.readValue(pItemsJson,new TypeReference<List<WpsdObject>>() {}));
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.wc.addWorkplace(wItems, pItems);
	}
	
	@Override
	public boolean editWorkplace(String wItemsJson, String pItemsJson, String etJson) {
		ObjectMapper jsonMapper = new ObjectMapper();
		ArrayList<ShopObject> wItem = new ArrayList<>();
		ArrayList<WpsdObject> pItem = new ArrayList<>();
		try {
			wItem.addAll(jsonMapper.readValue(wItemsJson,new TypeReference<List<ShopObject>>() {}));
			pItem.addAll(jsonMapper.readValue(pItemsJson,new TypeReference<List<WpsdObject>>() {}));
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return this.wc.editWorkplace(wItem, pItem, SHOP_EDIT_TYPE.valueOf(etJson));
	}
	
	@Override
	public boolean delWorkplace(String wItemsJson) {
		ArrayList<ShopObject> wItem = new ArrayList<>();
		
		try {
			wItem.addAll(jsonMapper.readValue(wItemsJson,new TypeReference<List<ShopObject>>() {}));

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.wc.delWorkplace(wItem);
	}
	
	@Override
	public String getWorkplaceObject(int id) {
		try {
			return jsonMapper.writeValueAsString(this.wc.getWorkplaceObject(id));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String getWorkplaceObjects(String inforsJson){
		
		Sextet<EmployeeObject, ShopObject, Short, Byte, SHOP_SORT_TYPE, Boolean> infors;
		try {
			infors = jsonMapper.readValue(inforsJson,new TypeReference<Sextet<EmployeeObject, 
					ShopObject, 
					Short, 
					Byte ,
					SHOP_SORT_TYPE,
					Boolean>>() {});
			return jsonMapper.writeValueAsString(this.wc.getWorkplaceObjects(infors));
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String viewWorkplacesList(String inforsJson, byte isOpenModal , String url){
		
		Sextet<EmployeeObject, ShopObject, Short, Byte, SHOP_SORT_TYPE, Boolean> infors;
		try {
			infors = jsonMapper.readValue(inforsJson,new TypeReference<Sextet<EmployeeObject, 
					ShopObject, 
					Short, 
					Byte ,
					SHOP_SORT_TYPE,
					Boolean>>() {});
			
			Septet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>,
			HashMap<Integer, Pair<String,Integer>>> datas = this.wc.getWorkplaceObjects(infors);
			
			return jsonMapper.writeValueAsString(WorkplaceLibrary.viewWorkplaceList(datas, infors, isOpenModal, url));
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc Workplace
		WorkplaceServiceImpl u = new WorkplaceServiceImpl();
		
		//Them mot nguoi su dung
		ShopObject new_Workplace = new ShopObject();
		new_Workplace.setWorkplace_name("Kho hàng Nguyên");
		new_Workplace.setWorkplace_manager_id(19);
		new_Workplace.setWorkplace_address("Lâm Đồng");
		new_Workplace.setWorkplace_created_date("29/12/2003");
		
		WpsdObject wsd1 = new WpsdObject();
		wsd1.setWpsd_product_id(1);
		wsd1.setWpsd_product_quantity(12);
		WpsdObject wsd2 = new WpsdObject();
		wsd2.setWpsd_product_id(3);
		wsd2.setWpsd_product_quantity(5);
		ArrayList<WpsdObject> sdl = new ArrayList<WpsdObject>();
		sdl.add(wsd1);
		sdl.add(wsd2);
//		new_Workplace.setWorkplace_id(2);
		
		List<ShopObject> new_WorkplaceList = new ArrayList<ShopObject>();
		new_WorkplaceList.add(new_Workplace);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			System.out.println(mapper.writeValueAsString(new_WorkplaceList));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean result = false;
		try {
			result = u.addWorkplace(mapper.writeValueAsString(new_WorkplaceList),mapper.writeValueAsString(sdl));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!result) {
			System.out.print("\n---------------------Khong thanh cong---------------------\n");
		}
//		
//		Sextet<EmployeeObject, 
//		WorkplaceObject, 
//		Short, 
//		Byte ,
//		WORKPLACE_SORT_TYPE,
//		Boolean> infors = new Sextet<>(null,new_Workplace,(short) 0,(byte)25, WORKPLACE_SORT_TYPE.NAME,false);
//		//Lay tap ban ghi nguoi su dung
//		Septet<	ArrayList<WorkplaceObject>,
//		Integer, 
//		HashMap<Integer,Integer>, 
//		HashMap<Integer,Integer>, 
//		HashMap<Pair<String,Integer>,Integer> ,
//		HashMap<Pair<String,Integer>,Integer>,
//		HashMap<Integer, Pair<String,Integer>>> res = u.getWorkplaceObjects(infors);
		

		
	}
}
