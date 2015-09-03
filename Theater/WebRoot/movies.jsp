<%@page import="valuebean.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@ include file="header.jsp"%>

<%
	ArrayList<MovieBean> movieList = (ArrayList<MovieBean>) request
	.getAttribute("movieList");
	for (int i = 0; i < movieList.size(); i++) {
		out.print("<div style='width:500px; height:250px; background-color:#ffff99'>");
		out.print("<div style='width:150px; height:250px; float:left'>");
		out.print("<img src='images/movies/" + movieList.get(i).getMovieId() + ".jpg' style='position:relative; left=30; top:20'/>");
		out.print("</div>");
		out.print("<div style='width:350px; height:250px; float:left; text-align:left'>");
		out.print("<h3>");
		out.print("<a href='MovieServlet?action=showRunningMovies&movieId=" + movieList.get(i).getMovieId() + "'>");
		out.print(movieList.get(i).getMovieName());
		out.print("</a>");
		out.print("</h3>");
		out.print("<br />类型： " + movieList.get(i).getMovieType());
		out.print("<br />导演： " + movieList.get(i).getDirector());
		out.print("<br />主演： " + movieList.get(i).getActor());
		out.print("<br />介绍： " + movieList.get(i).getMovieDescription());
		out.print("</div>");
		out.print("</div>");
	}
%>

<%@ include file="footer.jsp"%>
