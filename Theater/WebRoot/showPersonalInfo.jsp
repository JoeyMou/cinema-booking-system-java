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
	out.print("<div style='text-align:left; position:relative; left:170'>");
	out.print("<br>�û����� "
			+ ((MasterBean) session.getAttribute("loginer"))
					.getMasterName());
	out.print("<br>��&nbsp&nbsp���� "
			+ ((MasterBean) session.getAttribute("loginer"))
					.getMasterTel());
	out.print("<br>��&nbsp&nbsp�䣺 "
			+ ((MasterBean) session.getAttribute("loginer"))
					.getMasterEmail());
	if (((MasterBean) session.getAttribute("loginer")).getMasterSex() == "1") {
		out.print("<br>��&nbsp&nbsp�� ��");
	} else {
		out.print("<br>��&nbsp&nbsp�� Ů");
	}
	out.print("</div>");
	out.print("</div>");

%>


<%@ include file="footer.jsp"%>
