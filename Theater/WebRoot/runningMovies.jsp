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
		out.print("Ӱ����" + runningMovieList.get(i).getHallId()
				+ " ����&nbsp&nbsp");
		out.print("ʱ�䣺" + runningMovieList.get(i).getShowtime()
				+ "&nbsp&nbsp");
		out.print("�۸�" + runningMovieList.get(i).getPrice()
				+ "&nbsp&nbsp");
		out.print("<br />");
	}
	out.print("<br />");
	out.print("<input type='submit' value='����ѡ��'>");
	out.print("</form>");
%>

<%@ include file="footer.jsp"%>
