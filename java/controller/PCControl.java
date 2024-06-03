package controller;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Pair;
import org.javatuples.Quintet;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import dto.pc.PC_DTO;
import dto.pc.PC_viewProductDTO;
import dto.product.Product_DTO;
import dto.product.Product_manageBillDTO;
import dto.product.Product_manageProductDTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_viewBillDTO;
import dto.product.Product_viewProductDTO;
import dto.product.Product_viewShopDTO;
import dto.productAttribute.Product_AttributeDTO;
import entity.*;
public class PCControl {
	private PCModel md;
	
	public PCControl(ConnectionPool cp) {
		this.md = new PCModel(cp);		
	}
	
	public ConnectionPool getCP() {
		return this.md.getCP();
	}
	
	public void releaseCP() {
		this.md.releaseCP();
	}	

	public Map<String, String> viewSearchPC(
			Quintet<Short, Byte, Map<String, String>, Map<String, String>, Map<String, String>> infor,
			String requestURI) {
		TreeMap<PC_viewProductDTO,Integer> datas = this.md.getPC_ViewProductDTO(infor);
		return library.PCLibrary.viewSearchPC(datas, infor, requestURI);
	}
	
	public void getProductAttribute(Product_DTO<Product_AttributeDTO> product_DTO){
		try {
			md.getProductAttribute(product_DTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		int id = 1;
		
		PCControl a = new PCControl(null);
		
	}
}
