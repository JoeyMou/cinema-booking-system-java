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
	out.print("<a href='PersonalServlet?action=showPersonalInfo'>�ҵ����� </a>");
	out.print("<a href='OrderServlet?action=showOrders'>�ҵĶ��� </a>");
	out.print("<a href='PersonalServlet?action=showPersonalComments'>�ҵ����� </a>");
%>
<%
	out.print("<div style='width:500px; height:300px; background-color:#ffff99'>");
	out.print("<h2>�ҵĶ���</h2>");
	out.print("<table border='1'>");
	out.print("<tr>");
	out.print("<th>������</th>");
	out.print("<th>��λ��</th>");
	out.print("<th>����</th>");
	out.print("<th>Ʊ��</th>");
	out.print("<th>״̬</th>");
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
			out.print("������");
		} else {
			out.print("δ����");
		}
		out.print("</td>");
		out.print("</tr>");
	}
	out.print("</table>");
%>


<%@ include file="footer.jsp"%>
