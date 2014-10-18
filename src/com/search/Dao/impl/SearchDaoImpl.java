package com.search.Dao.impl;

import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

import com.search.Dao.BaseDao;
import com.search.Dao.SearchDao;
import com.search.entity.Datainfo;

public class SearchDaoImpl extends BaseDao implements SearchDao {

	public String[] getSearchList(Datainfo datainfo) {

		String sql = "select * from ? where beginnum<=? and ?<=endnum";
		String[] params = new String[3];
		params[0] = datainfo.getTablename();
		params[1] = datainfo.getSearchnum();
		params[2] = datainfo.getSearchnum();
		ResultSet rs = this.executeSQL(sql, params);
		String[] res = null;

		String table = datainfo.getTablename();
		if (rs != null) {
			if (table.equals(Datainfo.COUNTRY)) {
				res = new String[6];
				res[0] = "IP Address";
				res[1] = "Country Code";
				res[2] = "Country Name";
				res[3] = datainfo.getIPAddress();
				try {
					if (rs.next()) {
						res[4] = rs.getString(5);
						res[5] = rs.getString(6);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (table.equals(Datainfo.ORG)) {
				res = new String[4];
				res[0] = "IP Address";
				res[1] = "Org";
				res[2] = datainfo.getIPAddress();
				try {
					if (rs.next()) {
						res[3] = rs.getString(3);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (table.equals(Datainfo.ISP)) {
				res = new String[4];
				res[0] = "IP Address";
				res[1] = "Isp";
				res[2] = datainfo.getIPAddress();
				try {
					if (rs.next()) {
						res[3] = rs.getString(3);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (table.equals(Datainfo.CITY)) {
				res = new String[14];
				res[0] = "IP Address";
				res[1] = "Country";
				res[2] = "Region";
				res[3] = "City";
				res[4] = "Postal Code";
				res[5] = "Latitude";
				res[6] = "Longitude";
				res[7] = datainfo.getIPAddress();
				try {
					if (rs.next()) {
						res[8] = rs.getString(5);
						res[9] = rs.getString(6);
						res[10] = rs.getString(7);
						res[11] = rs.getString(8);
						res[12] = rs.getString(9);
						res[13] = rs.getString(10);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (table.equals(Datainfo.DOMAIN)) {
				res = new String[4];
				res[0] = "IP Address";
				res[1] = "Domain";
				res[2] = datainfo.getIPAddress();
				try {
					if (rs.next()) {
						res[3] = rs.getString(3);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (table.equals(Datainfo.QQIP)) {// for QQIP
				res = new String[6];
				res[0] = "IP Address";
				res[1] = "Area";
				res[2] = "ISP";
				res[3] = datainfo.getIPAddress();
				try {
					if (rs.next()) {
						res[4] = rs.getString(5);
						res[5] = rs.getString(6);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			res = new String[1];
			res[0] = "NULL";
		}

		this.closeResource();
		return res;
	}

	// get the title
	public String[] getTitle(Datainfo datainfo) {
		int len = Datainfo.getclonumbytablename(datainfo.getTablelist());
		int s;
		String[] res = new String[len];
		if (datainfo.isIsnmultiple() == true) {
			s = 2;
			res[0] = "Begin IP";
			res[1] = "End IP";
		} else {
			s = 1;
			res[0] = "IP Address";
		}
		String[] T = datainfo.getTablelist();
		for (int i = 0; i < T.length; i++) {
			if (Datainfo.COUNTRY.equals(T[i])) {
				res[s] = "Country Code";
				s++;
				res[s] = "Country Name";
				s++;
			} else if (Datainfo.ORG.equals(T[i])) {
				res[s] = "ORG";
				s++;
			} else if (Datainfo.ISP.equals(T[i])) {
				res[s] = "ISP";
				s++;
			} else if (Datainfo.CITY.equals(T[i])) {
				res[s] = "Country";
				s++;
				res[s] = "Region";
				s++;
				res[s] = "City";
				s++;
				res[s] = "Postal Code";
				s++;
				res[s] = "Latitude";
				s++;
				res[s] = "longitude";
				s++;
			} else if (Datainfo.DOMAIN.equals(T[i])) {
				res[s] = "Domain";
				s++;
			}
		}
		return res;
	}

	public String[] getSearchListMulti(Datainfo datainfo) {
		int len = datainfo.getColnum();
		int s;
		ResultSet rs = null;
		String[] res = new String[len];
		res[0] = datainfo.getIPAddress();
		String[] table = datainfo.getTablelist();
		String[] params = new String[3];
		params[1] = datainfo.getSearchnum();
		params[2] = datainfo.getSearchnum();
		s = 1;
		for (int i = 0; i < table.length; i++) {
			params[0] = table[i];
			rs = this.executeSQL(params);
           if (rs != null) {
				if (table[i].equals(Datainfo.COUNTRY)) {
					try {
						if (rs.next()) {
							res[s] = rs.getString(5);
							s++;
							res[s] = rs.getString(6);
							s++;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (table[i].equals(Datainfo.ORG)) {
					try {
						if (rs.next()) {
							res[s] = rs.getString(3);
							s++;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (table[i].equals(Datainfo.ISP)) {
					try {
						if (rs.next()) {
							res[s] = rs.getString(3);
							s++;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (table[i].equals(Datainfo.CITY)) {
					try {
						if (rs.next()) {
							res[s] = rs.getString(5);
							s++;
							res[s] = rs.getString(6);
							s++;
							res[s] = rs.getString(7);
							s++;
							res[s] = rs.getString(8);
							s++;
							res[s] = rs.getString(9);
							s++;
							res[s] = rs.getString(10);
							s++;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (table[i].equals(Datainfo.DOMAIN)) {
					try {
						if (rs.next()) {
							res[s] = rs.getString(3);
							s++;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (table[i].equals(Datainfo.QQIP)) {// for QQIP
					try {
						if (rs.next()) {
							res[s] = rs.getString(5);
							s++;
							res[s] = rs.getString(6);
							s++;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else {
				res = new String[1];
				res[0] = "NULL";
			}

		}
		
		this.closeResource();
		return res;
	}
}
