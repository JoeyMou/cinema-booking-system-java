<%@page import="valuebean.OrderBean"%>
<%@page import="valuebean.MasterBean"%>
<%@page import="valuebean.SeatBean"%>
<%@page import="valuebean.RunningMovieBean"%>
<%@page import="valuebean.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@ include file="header.jsp"%>

<%
	out.print("<a href='PersonalServlet?action=showPersonalInfo'>我的资料 </a>");
	out.print("<a href='OrderServlet?action=showOrders'>我的订单 </a>");
	out.print("<a href='PersonalServlet?action=showPersonalComments'>我的评论 </a>");
%>
<%
	out.print("<div style='width:500px; height:300px; background-color:#ffff99'>");
	out.print("<h2>我的订单</h2>");
	out.print("<table border='1'>");
	out.print("<tr>");
	out.print("<th>订单号</th>");
	out.print("<th>座位号</th>");
	out.print("<th>日期</th>");
	out.print("<th>票价</th>");
	out.print("<th>状态</th>");
	out.print("</tr>");
	ArrayList<OrderBean> orderList = (ArrayList<OrderBean>) request
			.getAttribute("orderList");
	for (int i = 0; i < orderList.size(); i++) {
		out.print("<tr>");
		out.print("<td>" + orderList.get(i).getOrderId() + "</td>");
		out.print("<td>" + orderList.get(i).getSeatId() + "</td>");
		out.print("<td>" + orderList.get(i).getDate() + "</td>");
		out.print("<td>" + orderList.get(i).getPrice() + "</td>");
		out.print("<td>");
		if (orderList.get(i).getIsCommented() == "1") {
			out.print("已评价");
		} else {
			out.print("未评价");
		}
		out.print("</td>");
		out.print("</tr>");
	}
	out.print("</table>");
%>


<%@ include file="footer.jsp"%>
