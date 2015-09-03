<%@page import="valuebean.RunningMovieBean"%>
<%@page import="valuebean.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@ include file="header.jsp"%>

<%
	ArrayList<RunningMovieBean> runningMovieList = (ArrayList<RunningMovieBean>) request
			.getAttribute("runningMovieList");
	for (int i = 0; i < runningMovieList.size(); i++) {
		out.print("<form action='SeatServlet?action="+ "showSeatsAvailable" + "' method='post'>");
		out.print("<input type='radio' name='Running_Movie_ID' value='"
				+ runningMovieList.get(i).getRunningMovieId() + "'>");
		out.print("影厅：" + runningMovieList.get(i).getHallId()
				+ " 号厅&nbsp&nbsp");
		out.print("时间：" + runningMovieList.get(i).getShowtime()
				+ "&nbsp&nbsp");
		out.print("价格：" + runningMovieList.get(i).getPrice()
				+ "&nbsp&nbsp");
		out.print("<br />");
	}
	out.print("<br />");
	out.print("<input type='submit' value='在线选座'>");
	out.print("</form>");
%>

<%@ include file="footer.jsp"%>
