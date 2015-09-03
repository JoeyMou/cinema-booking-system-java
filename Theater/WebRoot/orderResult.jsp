<%@page import="valuebean.SeatBean"%>
<%@page import="valuebean.RunningMovieBean"%>
<%@page import="valuebean.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@ include file="header.jsp"%>

<%
	if ((String) request.getAttribute("messages") == "order succeed") {
		out.print("<H2>恭喜你，预定成功</H2>");
	}
	else if ((String) request.getAttribute("messages") == "order fail") {
		out.print("<H2>很遗憾，预定失败</H2>");
	}
%>


<%@ include file="footer.jsp"%>
