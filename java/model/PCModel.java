package model;

import repository.PC;
import repository.PCImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import entity.PCObject;

public class PCModel {
	private PC pc; 
	
	public PCModel(ConnectionPool cp) {
		this.pc = new PCImpl(cp);
		
	}
	
	public ConnectionPool getCP() {
		return this.pc.getCP();
	}
	
	public void releaseCP() {
		this.pc.releaseCP();
	}
	
	public PCObject getPCByID(int id) {
		ResultSet rs = this.pc.getPCById(id);
		
		PCObject pcObject = null;
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					pcObject = new PCObject();
					pcObject.setPc_id(rs.getInt("pc_id"));
					pcObject.setPc_created_date("created_date");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pcObject;
	}
}
