package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import basic.BasicImpl;
import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import entity.PCObject;

public class PCImpl extends BasicImpl implements PC {

	public PCImpl(ConnectionPool cp) {
		super(cp, "PC");
	}
	
	public PCImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}	

	@Override
	public boolean addPC(PCObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPC(PCObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delPC(PCObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getPCById(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblpc pc WHERE pc.pc_id=?");
		return this.get(sql.toString(), id);
	}
	
	public static void main(String[] args) {
		int id = 1;
		
		ConnectionPool cp = new ConnectionPoolImpl();
		
		PC a = new PCImpl(cp);
		
		ResultSet rs = a.getPCById(id);
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					System.out.println(rs.getInt("pc_id"));
					System.out.println(rs.getString("pc_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
