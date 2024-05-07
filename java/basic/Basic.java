package basic;

import java.sql.*;
import java.util.*;

import org.javatuples.Pair;

import connection.*;

//Thua ke tu ShareControl, thay doi ShareControl o BasicImpl
public interface Basic extends ShareControl{
	
	//PreparedStatement pre - da duoc bien dich, da truyen gia tri
	public boolean add(PreparedStatement pre);			
	public boolean edit(PreparedStatement pre);
	public boolean del(PreparedStatement pre);
	
	public ResultSet get(String sql, int id);
	public ResultSet get(ArrayList<String> sql, String name, String pass);
	public ResultSet gets(String sql);
	public ArrayList<ResultSet> getReList(String multiSelect);
	
	public ArrayList<ResultSet> getReListV1(PreparedStatement pre);
	
	public Pair<Boolean, Integer> addList(PreparedStatement pre);	
	public Pair<Boolean, Integer> editList(PreparedStatement pre);	
	public Pair<Boolean, Integer> delList(PreparedStatement pre);	
	
}
