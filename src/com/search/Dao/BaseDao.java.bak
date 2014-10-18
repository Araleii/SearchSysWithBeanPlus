package com.search.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected Statement stmt;
	protected ResultSet rs;

	public boolean getConnection() {
		String uri = "jdbc:mysql://localhost:3306/ipdatabase";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(uri, "root", "smile1314fe");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ResultSet executeSQL(String sql, String[] params) {
		getConnection();
		try {
			ps = conn.prepareStatement(sql);
//			for (int i = 0; i < params.length; i++) {
//				ps.setObject(i + 1, params[i]);
//			}
			sql = "select * from "+(String)params[0]+" where beginnum<="+(String)params[1]+" and "+(String)params[2]+"<=endnum;";
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet executeSQL(String[] params) {
		getConnection();
		try {
			String sql = "select * from "+(String)params[0]+" where beginnum<="+(String)params[1]+" and "+(String)params[2]+"<=endnum;";
			//System.out.println(sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	public ResultSet executeSQL(String start, String terminal,String table) {
		String sql = null;
		if(start!=terminal){ 
			sql=new String("select * from "+table+" where beginnum>="+start+" and "+terminal+">=beginnum");
		}else{
			sql=new String("select * from "+table+" where beginnum<="+start+" and "+terminal+"<=endnum");
		}
		getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean closeResource() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}
