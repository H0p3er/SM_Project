package service.workplaceService;

import java.util.Scanner;

import jakarta.jws.WebMethod;
import jakarta.jws.soap.SOAPBinding;

@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WorkplaceService {
	
	@WebMethod
	public boolean addWorkplace(String wItemsJson, String pItemsJson);
	
	@WebMethod
	public boolean editWorkplace(String wItemsJson, String pItemsJson, String etJson);
	
	@WebMethod
	public boolean delWorkplace(String wItemsJson);
	
	@WebMethod
	public String getWorkplaceObject(int id);
	
	@WebMethod
	public String getWorkplaceObjects(String inforsJson);
	
	@WebMethod
	public String viewWorkplacesList(String inforsJson, byte isOpenModal , String url);
	
	Scanner a = new Scanner(System.in);
	

}
