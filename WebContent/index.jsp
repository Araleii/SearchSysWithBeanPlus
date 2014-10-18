<?xml version="1.0" encoding="utf-8" ?>
<%@page import="com.search.taobao.dao.GetTaobaoIpResult"%>
<%@page import="com.search.Dao.impl.SearchDaoImpl"%>
<%@page import="com.search.entity.Datainfo"%>
<%@page import="javax.management.Query"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IP Search</title>
<link rel="stylesheet" type="text/css" href="index.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs
	/jquery/1.4.0/jquery.min.js"></script>
<script type="text/javascript" src="index_javascript.js"></script>
</head>
<%
	String ADDRESS = new String();
	ADDRESS = request.getParameter("address");
	String[] CHOICE = request.getParameterValues("choice");
	if (request.getParameterValues("choice") == null) {
		CHOICE = new String[1];
		CHOICE[0] = new String("");
	}
	if (request.getParameter("address") == null) {
		ADDRESS = new String("");
	}
	String temp = new String("");
	for (int i = 0; i < CHOICE.length; i++) {
		temp += (CHOICE[i] + ",");
	}
%>


<body>
	<div id="Head">
		<br />IP SEARCH SYSTEM
		<hr />
	</div>
	<div id="Textbar">
		<form action="index.jsp">
			<input type="checkbox" id="108" name="choice" value="108" />查询国家 <input
				type="checkbox" id="113" name="choice" value="113" />查询组织 <input
				type="checkbox" id="124" name="choice" value="124" />查询服务商 <input
				type="checkbox" id="139" name="choice" value="139" />查询城市 <input
				type="checkbox" id="174" name="choice" value="174" />查询域名
			<!--  <input type="radio" name="choice" value="qqip" />qqip-->
			<input id="INTEXT" type="text" checked="checked" size="45"
				name="address" /> <input id="INBTN" type="submit" value="查询"
				onclick="showloading();" />
		</form>
	</div>

	<div id="LOADING" align="center">
		<img src="searching.gif" width="30" />
	</div>
	<%
		//	String tablename = new String();
		String[] title = null;
		String[] res = null;
		String[] qq_res = null;
		Datainfo taobao_datainfo = new Datainfo();
		if (!"".equals(CHOICE[0])) {
			Datainfo datainfo = new Datainfo(CHOICE, ADDRESS);
			SearchDaoImpl sdp = new SearchDaoImpl();
			title = sdp.getTitle(datainfo);
			res = sdp.getSearchListMulti(datainfo);
			Datainfo qq_datainfo = new Datainfo(Datainfo.QQIP, ADDRESS);
			qq_res = sdp.getSearchList(qq_datainfo);
			taobao_datainfo = GetTaobaoIpResult.GetAddressInfoByIp(ADDRESS);
		} else {
			res = new String[1];
			qq_res = new String[1];
			res[0] = "";
			qq_res[0] = "";
		}
		if (!"".equals(CHOICE[0])) {
	%>
	<script type="text/javascript">
		hideloading();
	</script>
		<div id="Analysis">
		   GEOIP    : 准确<br/><br/>
		   QQIP     : 准确<br/><br/>
		   TaobaoIP : 准确<br/>
		</div>
		<p id="FLIPBTN">点击查看结果</p>
		<div id="Result">
			<hr />
			<div align="center">GEOIP database</div>
			<hr />
			<table border="2">
				<tr>
					<%
						for (int i = 0; i < title.length; i++) {
					%>
					<th width="200"><%=title[i]%></th>
					<%
						}
					%>
				</tr>

				<tr align="center">
					<%
						for (int i = 0; i < res.length; i++) {
					%>
					<td><%=res[i]%></td>
					<%
						}
					%>
				</tr>

			</table>
			<hr />
			<div align="center">QQIP database</div>
			<hr />
			<table border="2">
				<tr>
					<%
						for (int i = 0; i < qq_res.length / 2; i++) {
					%>
					<th width="200"><%=qq_res[i]%></th>
					<%
						}
					%>
				</tr>
				<tr align="center">
					<%
						for (int i = qq_res.length / 2; i < qq_res.length; i++) {
					%>
					<td><%=qq_res[i]%></td>
					<%
						}
					%>
				</tr>
			</table>
			<hr />
			<div align="center">TaobaoIP database</div>
			<hr />
			<table border="2">
				<tr>
					<th width="200"><%=ADDRESS%></th>
					<th width="200">Country</th>
					<th width="200">Area</th>
					<th width="200">City</th>
					<th width="200">ISP</th>
				</tr>
				<tr align="center">
					<td><%=taobao_datainfo.getIPAddress()%></td>
					<td><%=taobao_datainfo.getCountry()%></td>
					<td><%=taobao_datainfo.getArea()%></td>
					<td><%=taobao_datainfo.getCity()%></td>
					<td><%=taobao_datainfo.getIsp()%></td>
				</tr>
			</table>
		</div>
	<%
		}
	%>

	<script type="text/javascript">
		show_user_option("<%=temp%>","<%=ADDRESS%>");
	</script>
</body>
</html>