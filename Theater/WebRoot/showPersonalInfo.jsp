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
	out.print("<div style='text-align:left; position:relative; left:170'>");
	out.print("<br>用户名： "
			+ ((MasterBean) session.getAttribute("loginer"))
					.getMasterName());
	out.print("<br>手&nbsp&nbsp机： "
			+ ((MasterBean) session.getAttribute("loginer"))
					.getMasterTel());
	out.print("<br>邮&nbsp&nbsp箱： "
			+ ((MasterBean) session.getAttribute("loginer"))
					.getMasterEmail());
	if (((MasterBean) session.getAttribute("loginer")).getMasterSex() == "1") {
		out.print("<br>性&nbsp&nbsp别： 男");
	} else {
		out.print("<br>性&nbsp&nbsp别： 女");
	}
	out.print("</div>");
	out.print("</div>");

%>


<%@ include file="footer.jsp"%>
