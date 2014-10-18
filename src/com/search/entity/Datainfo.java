package com.search.entity;


public class Datainfo {

	public static final String COUNTRY = "country108_table";
	public static final String ORG = "org113_table";
	public static final String ISP = "isp124_table";
	public static final String CITY = "city139_table";
	public static final String DOMAIN = "domain174_table";
	public static final String QQIP = "qq_ip_table";

	private String tablename;
	private String IPAddress;
	private String searchnum;
	private String beginnum;
	private String endnum;

	private String[] tablelist;// for multiple search
	private int colnum;
	private boolean isnmultiple;
	private String maxsearchnum;
	private String minsearchnum;

	//private BigInteger begin = new BigInteger("0");
	//private BigInteger end = new BigInteger("0");

	// For Geo
	private String countrycode;
	private String countryname;
	private String org;
	private String isp;
	private String domain;
	private String country;
	private String city;
	private String region;
	private String postalCode;
	private String latitude;
	private String longtitude;
	// For QQ
	private String area;

	public Datainfo(){
		
	}
	
	public Datainfo(String ttablename, String tIPAddress) {
		if (tIPAddress == null || tIPAddress.equals(""))
			tIPAddress = new String("1.1.1.1");
		tablename = ttablename;
		IPAddress = tIPAddress;
		double target = 0;
		int basenum = 256 * 256 * 256;
		if (tIPAddress != null && tIPAddress != "") {
			String[] tstr = new String[4];
			tstr = tIPAddress.split("\\.");
			for (int i = 0; i < tstr.length; i++) {
				target += Double.parseDouble(tstr[i]) * basenum;
				basenum /= 256;
			}
		}
		searchnum = String.valueOf(target);
		String[] T = new String[1];
		T[0] = tablename;
		setColnum(getclonumbytablename(T));
	}

	// choice can't be null
	public Datainfo(String[] choice, String tIPAddress) {
		if (tIPAddress == null || tIPAddress.equals(""))
			tIPAddress = new String("1.1.1.1");

		setTablelist(new String[choice.length]);
		for (int i = 0; i < choice.length; i++) {
			if ("108".equals(choice[i])) {
				tablelist[i] = COUNTRY;
			} else if ("113".equals(choice[i])) {
				tablelist[i] = ORG;
			} else if ("124".equals(choice[i])) {
				tablelist[i] = ISP;
			} else if ("139".equals(choice[i])) {
				tablelist[i] = CITY;
			} else if ("174".equals(choice[i])) {
				tablelist[i] = DOMAIN;
			}
		}

		setColnum(getclonumbytablename(getTablelist()));

		IPAddress = tIPAddress;
		double target = 0;
		int basenum = 256 * 256 * 256;
		// System.out.println("!!!"+tIPAddress);
		if (tIPAddress != null && tIPAddress != "") {
			String[] tstr = new String[4];
			tstr = tIPAddress.split("\\.");
			for (int i = 0; i < tstr.length; i++) {
				target += Double.parseDouble(tstr[i]) * basenum;
				basenum /= 256;
			}
		}
		double terminal = target;
		while (basenum > 0) {
			terminal += 255 * basenum;
			basenum /= 256;
		}
		minsearchnum = String.valueOf(target);
		maxsearchnum = String.valueOf(terminal);
		searchnum = String.valueOf(target);
		if(minsearchnum.equals(maxsearchnum)){
			isnmultiple=false;
		}else{
			isnmultiple=true;
		}
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getIPAddress() {
		return IPAddress;
	}

	public void setIPAddress(String iPAddress) {
		if (iPAddress == null)
			iPAddress = new String("");
		IPAddress = iPAddress;
		double target = 0;
		int basenum = 256 * 256 * 256;
		if (iPAddress != null && iPAddress != "") {
			String[] tstr = new String[4];
			tstr = iPAddress.split("\\.");
			for (int i = 0; i < tstr.length; i++) {
				target += Double.parseDouble(tstr[i]) * basenum;
				basenum /= 256;
			}
		}
		searchnum = String.valueOf(target);
		// System.out.println(searchnum);
	}

	public String getBeginnum() {
		return beginnum;
	}

	public void setBeginnum(String beginnum) {
		this.beginnum = beginnum;
	}

	public String getEndnum() {
		return endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

	public String getORG() {
		return ORG;
	}

	public String getISP() {
		return ISP;
	}

	public String getCITY() {
		return CITY;
	}

	public String getDOMAIN() {
		return DOMAIN;
	}

	public String getQQIP() {
		return QQIP;
	}

	public String getSearchnum() {
		return searchnum;
	}

	public void setSearchnum(String searchnum) {
		this.searchnum = searchnum;
	}

	public static String calTablenameByChoice(String tname) {
		String res = new String();
		if (tname.equals("108")) {
			res = COUNTRY;
		} else if (tname.equals("113")) {
			res = ORG;
		} else if (tname.equals("124")) {
			res = ISP;
		} else if (tname.equals("139")) {
			res = CITY;
		} else if (tname.equals("174")) {
			res = DOMAIN;
		}
		return res;
	}

	public static int getclonumbytablename(String[] T) {
		int res = 1;
		for (int i = 0; i < T.length; i++) {
			if (COUNTRY.equals(T[i])) {
				res += 2;
			} else if (ORG.equals(T[i])) {
				res += 1;
			} else if (ISP.equals(T[i])) {
				res += 1;
			} else if (CITY.equals(T[i])) {
				res += 6;
			} else if (DOMAIN.equals(T[i])) {
				res += 1;
			} else {// for qq
				res += 2;
			}
		}
		return res;
	}

	public String[] getTablelist() {
		return tablelist;
	}

	public void setTablelist(String[] tablelist) {
		this.tablelist = tablelist;
	}

	public int getColnum() {
		return colnum;
	}

	public void setColnum(int colnum) {
		this.colnum = colnum;
	}

	public boolean isIsnmultiple() {
		return isnmultiple;
	}

	public void setIsnmultiple(boolean isnmultiple) {
		this.isnmultiple = isnmultiple;
	}

	public String getMaxsearchnum() {
		return maxsearchnum;
	}

	public void setMaxsearchnum(String maxsearchnum) {
		this.maxsearchnum = maxsearchnum;
	}

	public String getMinsearchnum() {
		return minsearchnum;
	}

	public void setMinsearchnum(String minsearchnum) {
		this.minsearchnum = minsearchnum;
	}

}
