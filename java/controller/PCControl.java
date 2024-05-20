package controller;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import dto.pc.PC_DTO;
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
	
	public String viewPCDetail(int id) {
		PC_DTO  pcObject= this.md.getPC_DTOByID(id);
		return library.PCLibrary.viewPCDetail(pcObject);
	}
	
	public static void main(String[] args) {
		int id = 1;
		
		
		PCControl a = new PCControl(null);
		
		String rs = a.viewPCDetail(id);

		System.out.println(rs);
	}
}
